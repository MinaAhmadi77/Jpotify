import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class CentralPanel extends JPanel {
    private AddMusicButton btn;
    private Global global;
    private boolean flag=false;
    private JpotifyPlayer player;
    public CentralPanel(Global global)  {

        this.global = global;
        btn = new AddMusicButton(global);
        global.setCentralPanel(this);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(new Color(58, 58, 58));
        try {
            Image pauseButtonImage = ImageIO.read(getClass().getResource("Icons/add.png"));
            Image scaledPauseButtonImage = pauseButtonImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            btn.setIcon(new ImageIcon(scaledPauseButtonImage));

        } catch (IOException e) {
            e.printStackTrace();
        }

        btn.setFocusPainted(false);
        // btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setBackground(new Color(58, 58, 58));
        add(btn);
       // btn.setLocation(-3, 0);
        this.setVisible(true);

    }



}
