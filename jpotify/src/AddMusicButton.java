import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class AddMusicButton extends JButton implements ActionListener {
    Global global;
   // private JpotifyPlayer player;

    public AddMusicButton(Global global) {
        this.global = global;
        this.addActionListener(this);
        global.setAddMusicButton(this);
        this.setBorder(null);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser chooser = new JFileChooser();

        chooser.setMultiSelectionEnabled(true);

        chooser.setFileFilter(new FileNameExtensionFilter("mp3 & wav Files", "wav", "mp3"));
        int returnValue = chooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File[] files = chooser.getSelectedFiles();
            for(File file : files)
            {
                boolean duplicate = false;
                for(SongButton song : global.getSongs())
                {
                    if (song.getPath().equals(file.getAbsolutePath()))
                    {
                        duplicate = true;
                        break;
                    }
                }
                if(!duplicate)
                {
                    SongButton s = new SongButton(global , file.getAbsolutePath());
                    global.getCentralPanel().add(s);
                    global.addSongButton(s);
                }
            }


        }
        global.getMainFrame().setVisible(true);
    }

}
