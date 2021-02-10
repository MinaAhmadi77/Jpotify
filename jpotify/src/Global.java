import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Global implements Serializable {
    private Library library;

    private LeftFrame leftFrame;
    private DownFrame downFrame;
    private CentralPanel centralPanel;
    private LeftDown leftDown;
    private LeftUp leftUp;
    private MainFrame mainFrame;
    private boolean isPlaying = true;
    private ProgressBar progressBar;
    private Mp3File playingMp3;
    private JPanel currentPanel;
    private ArrayList<SongButton> songs;
    private ArrayList<AlbumButton> albums;
    private AddMusicButton addMusicButton;
    private JpotifyPlayer jpotifyPlayer;
    private JButton infoPlayingMusic;
    private SongButton playingButton;

    public SongButton getPlayingButton() {
        return playingButton;
    }

    public void setPlayingButton(SongButton playingButton) {
        this.playingButton = playingButton;
    }

    public JButton getInfoPlayingMusic() {
        return infoPlayingMusic;
    }

    public JpotifyPlayer getJpotifyPlayer() {
        return jpotifyPlayer;
    }

    public void setJpotifyPlayer(JpotifyPlayer jpotifyPlayer) {
        this.jpotifyPlayer = jpotifyPlayer;
    }

    public AddMusicButton getAddMusicButton() {
        return addMusicButton;
    }

    public void setAddMusicButton(AddMusicButton addMusicButton) {
        this.addMusicButton = addMusicButton;
    }

    public ArrayList<SongButton> getSongs() {
        return songs;
    }

    public ArrayList<AlbumButton> getAlbums() {
        return albums;
    }

    public void addSongButton(SongButton song) {
        this.songs.add(song);
    }

    public void addAlbumButton(AlbumButton album) {
        this.albums.add(album);
    }

    public JPanel getCurrentPanel() {
        return currentPanel;
    }

    public void setCurrentPanel(JPanel currentPanel) {
        this.currentPanel = currentPanel;
    }

    public Global() throws IOException, ClassNotFoundException, InvalidDataException, UnsupportedTagException {
        library = new Library(this);
        leftDown = new LeftDown(this);
        leftUp = new LeftUp(this);
        leftFrame = new LeftFrame(this);
        downFrame = new DownFrame(this);
        songs=new ArrayList<>();
        albums=new ArrayList<>();
        centralPanel = new CentralPanel(this);


    }



    public Mp3File getPlayingMp3() {
        return playingMp3;
    }

    public void setPlayingMp3(Mp3File playingMp3) {
        this.playingMp3 = playingMp3;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }


    public MainFrame getMainFrame() {
        return mainFrame;
    }



    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void setLeftFrame(LeftFrame leftFrame) {
        this.leftFrame = leftFrame;
    }

    public void setDownFrame(DownFrame downFrame) {
        this.downFrame = downFrame;
    }

    public void setCentralPanel(CentralPanel centralPanel) {
        this.centralPanel = centralPanel;
    }

    public void setLeftDown(LeftDown leftDown) {
        this.leftDown = leftDown;
    }

    public void setLeftUp(LeftUp leftUp) {
        this.leftUp = leftUp;
    }

    public LeftFrame getLeftFrame() {
        return leftFrame;
    }

    public DownFrame getDownFrame() {
        return downFrame;
    }

    public CentralPanel getCentralPanel() {
        return centralPanel;
    }

    public LeftDown getLeftDown() {
        return leftDown;
    }

    public LeftUp getLeftUp() {
        return leftUp;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Library getLibrary() {
        return library;
    }

    public void setPlayingArtWork(JButton infoPlayingMusic) {
        this.infoPlayingMusic = infoPlayingMusic;
    }
}
