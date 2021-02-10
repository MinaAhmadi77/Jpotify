import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class DownFrame extends JPanel {
    private JButton btn ;
    private JButton btn1;
    private JButton btn2;
    private Global global;
    PlayIcons play;
    VolumeBar volumme=new VolumeBar(global);
    JButton infoPlayingMusic;
    ArtWork artWork=new ArtWork();
    public DownFrame(Global global) throws IOException {
        this.setLayout(new GridLayout(1,3));
        this.global = global;
        play=new PlayIcons(global);
        btn1 = new JButton();
        btn2 = new JButton();
        JPanel artWork = new JPanel();
        artWork.setLayout(new FlowLayout(FlowLayout.LEFT));
        infoPlayingMusic = new JButton("Nothing Playing");
        infoPlayingMusic.setBorder(null);
        infoPlayingMusic.setBorderPainted(false);
        infoPlayingMusic.setContentAreaFilled(false);
        artWork.add(infoPlayingMusic);
        global.setPlayingArtWork(infoPlayingMusic);
        add(artWork,0);
        add(play,1);
        JPanel rightBottom = new JPanel();
        rightBottom.setLayout(new BorderLayout());

        JPanel flowForBottom = new JPanel();
        flowForBottom.setBackground(Color.WHITE);
        rightBottom.setBackground(Color.WHITE);
        flowForBottom.setLayout(new GridBagLayout());
        rightBottom.add(flowForBottom,BorderLayout.EAST);
        flowForBottom.add(volumme);
        add(rightBottom,2);

//        btn = new JButton();
//        try {
//            Image pauseButtonImage = ImageIO.read(getClass().getResource("Icons/pauseButton.png"));
//            Image scaledPauseButtonImage = pauseButtonImage.getScaledInstance(50,50,Image.SCALE_SMOOTH);
//            btn.setIcon(new ImageIcon(scaledPauseButtonImage));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        btn.setFocusPainted(false);
//        // btn.setContentAreaFilled(false);
//        btn.setBorderPainted(false);
//        btn.setBackground(new Color(153, 153, 153));
//
//
//        add(btn,0);
//
//        this.setBackground(new Color(153, 153, 153));
//        this.setVisible(true);


    }


}
