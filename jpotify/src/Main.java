import com.mpatric.mp3agic.Mp3File;
import javazoom.jl.player.Player;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Throwable {
        /*JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         frame.add(label , BorderLayout.CENTER);
        frame.setVisible(true);*/
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e) {
//            e.printStackTrace();
             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            MainFrame mainFrame=new MainFrame();

//        try{
//
//            FileInputStream fis = new FileInputStream("D:/jpotify2/Enrique Iglesias Ft. Pitbull - Freak [128].mp3");
//            Player playMP3 = new Player(fis);
//
//            playMP3.play();
//
//        }  catch(Exception e){
//            System.out.println(e);
//        }
    }
}
