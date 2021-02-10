import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class AlbumButton extends JButton implements ActionListener {
    private Global global;
    private String albumName;
    public AlbumButton(Global global,String name , String path)
    {
        this.global = global;
        this.albumName = name;
        try {
            Mp3File mp3File = new Mp3File(path);
            ID3v2 id3v2 = mp3File.getId3v2Tag();
            byte[] imageData = id3v2.getAlbumImage();
                if (imageData != null) {
                    BufferedImage artWork = null;
                    try
                    {
                        this.setBorder(null);
                        this.setBorderPainted(false);
                        this.setContentAreaFilled(false);
                        artWork = ImageIO.read(new ByteArrayInputStream(imageData));
                        ImageIcon cover = new ImageIcon(artWork);
                        Image image = cover.getImage();
                        Image ScaledImage = image.getScaledInstance(100 , 100 , java.awt.Image.SCALE_SMOOTH);
                        ImageIcon imageIcon = new ImageIcon(ScaledImage);
                        this.setIcon(imageIcon);
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                else
                {
                    Image coverImage = null;
                    try {
                        coverImage = ImageIO.read(getClass().getResource("Icons\\defult.png"));
                        Image ScaledImage = coverImage.getScaledInstance(100 , 100 , java.awt.Image.SCALE_SMOOTH);
                        ImageIcon imageIcon = new ImageIcon(ScaledImage);
                        this.setIcon(imageIcon);
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                    }
//                    ImageIcon imageIcon = new ImageIcon(coverImage);

                }
        } catch (IOException | UnsupportedTagException | InvalidDataException e) {
            e.printStackTrace();
        }
        this.addActionListener(this);

    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(AlbumButton albumButton : global.getAlbums())
        {
            System.out.println(albumButton.albumName);
            albumButton.setVisible(false);
        }
        for(SongButton s: global.getSongs())
        {

                if (s.getAlbum().equals(albumName)) {

                    s.setVisible(true);
                } else {
                    System.out.println(s.getAlbum());
                    System.out.println(albumName);
                    s.setVisible(false);
                }

        }
    }

    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }




}
