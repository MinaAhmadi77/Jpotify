import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SongsButton extends JButton implements ActionListener {
    Global global;
    JpotifyPlayer player;

    public SongsButton(Global global,String name) {
        super(name);
        this.global = global;
        this.addActionListener(this);
        this.setBorder(null);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println("Clicled");
        global.getAddMusicButton().setVisible(true);

        for (SongButton button : global.getSongs()) {

            button.setVisible(true);
        }
        for(AlbumButton b : global.getAlbums())
        {
            b.setVisible(false);
        }
    }
}
