import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static java.lang.Thread.sleep;

public class JpotifyPlayer implements Runnable {
    AdvancedPlayer player;
    Thread t1;
    Global global;
    double percent;
    public JpotifyPlayer(Global global)
    {
        this.global = global;
    }
    public void playMusic(String filePath)
    {
        try {
            player.close();
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }

        InputStream in = null;
        try {
            in = new FileInputStream(filePath);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        try {
            player=new AdvancedPlayer(in);
        } catch (JavaLayerException ex) {
            ex.printStackTrace();
        }
         t1 = new Thread(this);
        t1.start();
    }

    @Override
    public void run() {

        try {
            while (player.play(1))
            {
                percent=(double) (player.getPosition()/1000)/global.getPlayingMp3().getLengthInSeconds() * 100;
                global.getProgressBar().setValue((int)percent);
                while(!global.isPlaying())
                {
                    System.out.println("pause");
                }
            }

        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }
}
