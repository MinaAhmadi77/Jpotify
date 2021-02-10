import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ArtWork extends JPanel {
    private JButton btn;
    private JButton btn1 = new JButton();
    private JButton btn2 = new JButton();

    public ArtWork() {
        this.setLayout(new GridBagLayout());



        this.setBackground(new Color(255, 255, 255));
        this.setVisible(true);

    }

}
