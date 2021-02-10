import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlbumsButton extends JButton implements ActionListener {
    Global global;
    private String name;
    //  private transient BufferedReader br;
    //  private transient BufferedWriter bw;
    private boolean showed;
    public AlbumsButton(Global global, String name) {
        super(name);
        this.global = global;
        this.addActionListener(this);
        this.setBorder(null);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        setFocusable(false);
    }
    public String getName() {
        return name;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        global.getAddMusicButton().setVisible(false);
        for (SongButton songButton:global.getSongs()){
            songButton.setVisible(false);
        }

        for(AlbumButton albumButton:global.getAlbums()){
            albumButton.setVisible(true);
        }

    }
}
