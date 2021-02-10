import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class MainFrame extends JFrame {
    private Global global;
    private LeftFrame left;
    private DownFrame downFrame;
    private CentralPanel centralPanel;
    private Library library;

    public MainFrame() throws Throwable {
        super("Jpotify");

        global = new Global();
        global.setJpotifyPlayer(new JpotifyPlayer(global));
        left = global.getLeftFrame();
        downFrame = global.getDownFrame();
        centralPanel = global.getCentralPanel();
        library = global.getLibrary();
        setLayout(new BorderLayout());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        add(left, BorderLayout.WEST);
        add(new JScrollPane(downFrame), BorderLayout.PAGE_END);
        add(centralPanel, BorderLayout.CENTER);
        this.setVisible(true);
        global.setMainFrame(this);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                global.getLibrary().saveSongs();
                global.getLibrary().saveAlbums();
                global.getLibrary().SavePlayLists();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        //library.finalize();

    }

}
