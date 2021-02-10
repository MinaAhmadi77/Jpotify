import com.mpatric.mp3agic.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SongButton extends JButton implements ActionListener {
    Global global;
    JpotifyPlayer player;
    private String path;
    private transient Mp3File mp3file;
    private transient ID3v2 id3v2Tag;
    private transient long time;
    private transient String album;
    private transient String artist;
    private transient String title;
    private transient String year;
    private ImageIcon imageIcon;

    public SongButton(Global global, String path) {
        this.global = global;
        this.setBorder(null);
        global.addSongButton(this);
        this.addActionListener(this);
        boolean firstInAlbum = true;

        this.path = path;
        try {
            mp3file = new Mp3File(path);
        } catch (IOException | InvalidDataException | UnsupportedTagException e) {
            e.printStackTrace();
        }
        if (mp3file.hasId3v2Tag()) {

            id3v2Tag = mp3file.getId3v2Tag();
            time = mp3file.getLengthInSeconds();
            album = id3v2Tag.getAlbum();
            artist = id3v2Tag.getArtist();
            title = id3v2Tag.getTitle();
            year = id3v2Tag.getYear();
            byte[] imageData = id3v2Tag.getAlbumImage();
            if (imageData != null) {
                BufferedImage artWork = null;
                try
                {
                    artWork = ImageIO.read(new ByteArrayInputStream(imageData));
                    ImageIcon cover = new ImageIcon(artWork);
                    Image image = cover.getImage();
                    Image ScaledImage = image.getScaledInstance(100 , 100 , java.awt.Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(ScaledImage);
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
                    Image ScaledImage =coverImage.getScaledInstance(100 , 100 , java.awt.Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(ScaledImage);
                    this.setIcon(imageIcon);
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
//                imageIcon = new ImageIcon(ScaledImage);
//                this.setIcon(imageIcon);
            }
        }
            else {
                time = 0;
                album = "not set";
                artist = "not set";
                title = "not set";
                year = "not set";
                Image coverImage = null;
                try {
                    coverImage = ImageIO.read(getClass().getResource("Icons\\defult.png"));
                    Image ScaledImage =coverImage.getScaledInstance(100 , 100 , java.awt.Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(ScaledImage);
                    this.setIcon(imageIcon);
                    } catch (IOException e)
                {
                    e.printStackTrace();
                }
//                imageIcon = new ImageIcon(coverImage);
//                this.setIcon(imageIcon);
                System.out.println("it doesnt hava id3v1tag");
            }
        for (AlbumButton a : global.getAlbums()) {
            try {
                if (a.getAlbumName().equals(getAlbum())) {
                    firstInAlbum = false;
                    break;
                }
            }
            catch (NullPointerException n)
            {
                firstInAlbum = false;
            }
        }
        if (firstInAlbum) {
            AlbumButton a = new AlbumButton(global , getAlbum(), path);
            global.getCentralPanel().add(a);
            global.addAlbumButton(a);
            a.setVisible(false);
        }

        global.addSongButton(this);
        this.setVisible(true);
    }
    public void play(){
        global.setPlayingButton(this);
        global.getInfoPlayingMusic().setIcon(imageIcon);
        global.getInfoPlayingMusic().setText("<html>Title: " + title + "<br>Artist: " + artist + "<br>Year: " + year+"</html>");
        global.setPlayingMp3(mp3file);
        global.getJpotifyPlayer().playMusic(path);
        global.getMainFrame().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        global.setPlayingButton(this);
        global.getInfoPlayingMusic().setIcon(imageIcon);
        global.getInfoPlayingMusic().setText("<html>Title: " + title + "<br>Artist: " + artist + "<br>Year: " + year+"</html>");
        global.setPlayingMp3(mp3file);
        global.getJpotifyPlayer().playMusic(path);
        global.getMainFrame().setVisible(true);

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Mp3File getMp3file() {
        return mp3file;
    }

    public void setMp3file(Mp3File mp3file) {
        this.mp3file = mp3file;
    }



    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
