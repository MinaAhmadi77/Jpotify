import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;

public class LeftFrame extends JPanel {
    private LeftUp leftUp;
    private LeftDown leftDown;
    private Global global;


    public LeftFrame(Global global) throws IOException {
        this.global = global;
        leftUp = global.getLeftUp();
        leftDown = global.getLeftDown();
        this.setLayout(new BorderLayout());
        add(leftUp, BorderLayout.NORTH);
        add(new JScrollPane(leftDown), BorderLayout.CENTER);
        this.setVisible(true);

    }

}
