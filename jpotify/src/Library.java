import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Library implements Serializable {
    private String songsPath;
    private String albumesPath;
    private String playListsPath;
    private transient File songsFile;
    private transient File albumesFile;
    private transient File playListsFile;
    private transient Global global;
    private transient FileOutputStream fos;
    private transient FileInputStream fis;
    private transient ObjectOutputStream oos;
    private transient ObjectInputStream ois;



    /*  private FileReader fr;
          private FileWriter fw;
          private BufferedReader br;
          private BufferedWriter bw;
          private PrintWriter    pw;
          */
    private String adrs;



    public Library(Global global) throws IOException {
        this.global = global;
        songsPath = "D:\\Songs.txt";
        albumesPath = "D:\\Albums.txt";
        playListsPath = "D:\\PlayLists.txt";
       /* songsFile = new File(songsPath);
        if (!songsFile.exists()){
            songsFile.createNewFile();
        }
        playListsFile = new File(playListsPath);
        if (!playListsFile.exists()){
            playListsFile.createNewFile();
        }
        albumesFile = new File(albumesPath);
        if (!albumesFile.exists()){
            albumesFile.createNewFile();
        }
       */ //playListsFile = new File(albumesPath);
        //fos = new FileOutputStream(songsPath);
        //oos = new ObjectOutputStream(fos);
        //fis = new FileInputStream(songsPath);
        //ois = new ObjectInputStream(fis);

    }





    /*public void showAlbumes() throws InvalidDataException, IOException, UnsupportedTagException {
        for (Album album : albums) {
            String sig = album.getSignatures().get(0);
            Song song = getSongBySignature(sig);
             //ImageIcon imageIcon = song.showArtWork();
            try {
                Image imageIcon = song.showArtWork().getImage();
                JButton button = new JButton();
                button.setIcon(new ImageIcon(imageIcon.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                button.setFocusPainted(false);
                button.setBorderPainted(false);
                button.setBackground(new Color(58, 58, 58));
                button.setBounds(50, 100, 60, 30);
               *//* button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        try {
                            player.stop();
                        } catch (Exception q) {
                            System.out.println(q);
                        }
                        player = new JpotifyPlayer();

                        player.playMusic(song.getPath());

                    }
                });*//*

                global.getCentralPanel().add(button);
                global.getCentralPanel().addSong(button);

                //  System.out.println("DD");
            } catch (InvalidDataException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (UnsupportedTagException ex) {
                ex.printStackTrace();
            }
        }
    }*/


    /*public void reloadSongs() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(songsPath)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            Song song = (Song) ois.readObject();
            System.out.println("**********" + song.getSignature());
            Song song1 = (Song) ois.readObject();
            System.out.println("**********" + song1.getSignature());
            while ((song != null)) {
                songs.add(song);
                System.out.println("**********" + song.getSignature());
                song = (Song) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }

        Song song = (Song) ois.readObject();

        while (song != null) {
            songs.add(song);
            System.out.println(song.getSignature());
            song = (Song) ois.readObject();
        }
    }
*/
    public void saveSongs() {
        try (FileOutputStream fos = new FileOutputStream(songsPath)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveAlbums() {
        try (FileOutputStream fos = new FileOutputStream(albumesPath)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SavePlayLists() {
        try (FileOutputStream fos = new FileOutputStream(playListsPath)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
