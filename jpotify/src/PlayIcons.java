import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PlayIcons extends JPanel {
    private JButton btn ;
    private JButton btn1 = new JButton();
    private JButton btn2 = new JButton();
    private JButton btn3=new JButton();
    public PlayIcons(Global global) throws IOException {
        this.setLayout(new GridBagLayout());

        btn = new JButton();
        try {
            Image pauseButtonImage = ImageIO.read(getClass().getResource("Icons/pervButton.png"));
            Image scaledPauseButtonImage = pauseButtonImage.getScaledInstance(50,50,Image.SCALE_SMOOTH);
            btn.setIcon(new ImageIcon(scaledPauseButtonImage));
            btn.setBorder(null);
            btn.setBorderPainted(false);
            btn.setContentAreaFilled(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
        final Image[] pauseButtonImage = {null};
        try {
            pauseButtonImage[0] = ImageIO.read(getClass().getResource("Icons/pauseButton.png"));
            Image scaledPauseButtonImage = pauseButtonImage[0].getScaledInstance(50,50,Image.SCALE_SMOOTH);
            btn1.setIcon(new ImageIcon(scaledPauseButtonImage));
            btn1.setBorder(null);
            btn1.setBorderPainted(false);
            btn1.setContentAreaFilled(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            pauseButtonImage[0] = ImageIO.read(getClass().getResource("Icons/nextButton.png"));
            Image scaledPauseButtonImage = pauseButtonImage[0].getScaledInstance(50,50,Image.SCALE_SMOOTH);
            btn2.setIcon(new ImageIcon(scaledPauseButtonImage));
            btn2.setBorder(null);
            btn2.setBorderPainted(false);
            btn2.setContentAreaFilled(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println("test");
                SongButton nowplaying = global.getPlayingButton();
                SongButton[] songButtons = new SongButton[global.getSongs().size()];
                songButtons = global.getSongs().toArray(songButtons);
                boolean found = false;
                int len = global.getSongs().size();
                int j = 0;
                for(int i = 0; i < len;i++)
                {
                    System.out.println(nowplaying.getPath());
                    System.out.println(songButtons[i].getPath());
                    if(nowplaying.getPath().equals(songButtons[i].getPath()))
                    {
                        j = i+1;
                        break;
                    }
                }
                for(;j<len;j++)
                {
                    if(!nowplaying.getPath().equals(songButtons[j].getPath()))
                    {
                        songButtons[j].play();
                        break;
                    }
                }
            }
        });
        ProgressBar aJSlider = new ProgressBar(global);
        aJSlider.setOrientation(JSlider.HORIZONTAL);
        global.setProgressBar(aJSlider);
//        aJSlider.setPaintTrack(true);
//        aJSlider.setPaintTicks(true);
//        aJSlider.setPaintLabels(true);
        // set orientation of slider7
        // set spacing
        //aJSlider.setMajorTickSpacing(50);
//        aJSlider.setMinorTickSpacing(5);

        // setChangeListener
      //  aJSlider.addChangeListener(s);


        btn.setFocusPainted(false);
        // btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setBackground(new Color(255, 255, 255));

        btn1.setFocusPainted(false);
        // btn.setContentAreaFilled(false);
        btn1.setBorderPainted(false);
        btn1.setBackground(new Color(255, 255, 255));

        btn2.setFocusPainted(false);
        // btn.setContentAreaFilled(false);
        btn2.setBorderPainted(false);
        btn2.setBackground(new Color(255, 255, 255));

        btn3.setFocusPainted(false);
        // btn.setContentAreaFilled(false);
        btn3.setBorderPainted(false);
        btn3.setBackground(new Color(255, 255, 255));


        GridBagConstraints c = new GridBagConstraints();

        c.gridx = -1;
        c.gridy = 0;
        GridBagConstraints c1 = new GridBagConstraints();

        c1.gridx = 1;
        c1.gridy = 0;
        GridBagConstraints c2 = new GridBagConstraints();

        c2.gridx = 3;
        c2.gridy = 0;
        GridBagConstraints c3 = new GridBagConstraints();

        c3.gridx =1 ;
        c3.gridy =-2 ;

        add(btn,c);
        add(btn1,c1);
        add(btn2,c2);
        add(aJSlider,c3);

        final Image[] image = new Image[1];

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(global.isPlaying()) {
                    global.setPlaying(false);
                    try {
                        pauseButtonImage[0] = ImageIO.read(getClass().getResource("Icons/playButton.png"));
                        Image scaledPauseButtonImage = pauseButtonImage[0].getScaledInstance(50,50,Image.SCALE_SMOOTH);
                        btn1.setIcon(new ImageIcon(scaledPauseButtonImage));
                    } catch (IOException t) {
                        t.printStackTrace();
                    }
                }
                else {
                    global.setPlaying(true);
                    try {
                        image[0] = ImageIO.read(getClass().getResource("Icons/pauseButton.png"));
                        Image scaledPauseButtonImage = image[0].getScaledInstance(50,50,Image.SCALE_SMOOTH);
                        btn1.setIcon(new ImageIcon(scaledPauseButtonImage));
                    } catch (IOException t) {
                        t.printStackTrace();
                    }
                }

            }
        });

        this.setBackground(new Color(254, 254, 254));
        this.setVisible(true);


    }
}
