/*import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;*/

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class LeftUp extends JPanel {
    private SongsButton songsButton;
    private AlbumsButton albumsButton;
    private Global global;
    private JpotifyPlayer player;
    private Border empty;

    public LeftUp(Global global) {
        this.global = global;
        empty = BorderFactory.createEmptyBorder();
        albumsButton = new AlbumsButton(global,"Albums");
        songsButton = new SongsButton(global,"Songs");
        //this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setLayout(new GridLayout(6, 1));
        JLabel label = new JLabel("   Library");
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.getAllFonts();
        label.setFont(new Font("Jokerman", Font.PLAIN, 30));
        songsButton.setFont(new Font("Jokerman", Font.PLAIN, 20));
        albumsButton.setFont(new Font("Jokerman", Font.PLAIN, 20));
        JButton search = new JButton("Search");
        search.setFont(new Font("Jokerman", Font.PLAIN, 20));
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String search = JOptionPane.showInputDialog("Search for: ");
                for(SongButton s: global.getSongs())
                {
                    if(s.getTitle().toLowerCase().contains(search.toLowerCase()))
                    {
                        s.setVisible(true);
                    }
                    else
                    {
                        s.setVisible(false);
                    }
                }
                for(AlbumButton a : global.getAlbums())
                {
                    a.setVisible(false);
                }
            }
        });

        try {
            Image pauseButtonImage = ImageIO.read(getClass().getResource("Icons/clef.png"));
            Image scaledPauseButtonImage = pauseButtonImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            songsButton.setIcon(new ImageIcon(scaledPauseButtonImage));

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Image pauseButtonImage = ImageIO.read(getClass().getResource("Icons/thumbnails.png"));
            Image scaledPauseButtonImage = pauseButtonImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            albumsButton.setIcon(new ImageIcon(scaledPauseButtonImage));

        } catch (IOException e) {
            e.printStackTrace();
        }
        this.add(label);
        // songsButton.setBorder(empty);
        songsButton.setFocusPainted(false);
        // songsButton.setContentAreaFilled(false);
        songsButton.setBorderPainted(false);
        songsButton.setBackground(new Color(255, 114, 152, 253));
        songsButton.setBounds(50, 100, 60, 30);

        add(songsButton);

        add(albumsButton);

        add(search);
        search.setBorder(null);
        search.setBorderPainted(false);
        search.setContentAreaFilled(false);
        search.setFocusable(false);

//        label.setFont(new Font("Verdana",1,20));
        this.setBackground(new Color(246, 51, 121));
        this.setVisible(true);
    }
}
