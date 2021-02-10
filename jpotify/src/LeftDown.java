import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LeftDown extends JPanel {
    private JButton btn;
    private JFrame frame;
    private JTextField textField;
    private Global global;
    private static final String LABEL_TXT = " Choose the name of playlist ";
    private static final int WIDTH = 300, HEIGHT = 100;
    private DefaultListModel model = new DefaultListModel();
    private int counter=0;


    public LeftDown(Global global) {
        super();

        btn = new JButton("Add playLists");
        btn.setBorder(null);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        setSize(300, 200);


//        String categories[] = {"Household", "Office", "Extended Family",
//                "Company (US)", "Company (World)", "Team", "Will",
//                "Birthday Card List", "High School", "Country", "Continent",
//                "Planet", "d", "j", "s", "t", "i", "o", "d", "j", "s", "t", "i", "o", "d", "j", "s", "t", "i", "o"};
//      //  JList list = new JList();
        JScrollPane scrollpane = new JScrollPane(this);
        JLabel label = new JLabel("PlayLists");
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.getAllFonts();
        label.setFont(new Font("Jokerman", Font.PLAIN, 30));
        // label.setFont(new Font("Verdana",1,20));


        this.setLayout(new BoxLayout(this , BoxLayout.Y_AXIS));
        this.add(label, BorderLayout.NORTH);
        //this.add(scrollpane);
        this.setBackground(new Color(137, 201, 190));
        btn.setFocusPainted(false);
        // btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setBackground(new Color(137, 201, 190));
        btn.setFont(new Font("Jokerman", Font.PLAIN, 15));

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame = new JFrame();
                frame.setLayout(new BorderLayout());
                JLabel label = new JLabel("Choose the name of playlist");
                frame.add(label, BorderLayout.PAGE_START);
                textField = new JTextField();
                frame.add(textField, BorderLayout.CENTER);
                btn = new JButton(LABEL_TXT);
                frame.add(btn, BorderLayout.PAGE_END);
                frame.setSize(WIDTH, HEIGHT);
                frame.setLocation(550, 300);
                frame.setVisible(true);
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.setVisible(false);
                        String name = textField.getText();


                        JButton button = new JButton(name);
                        button.setFocusPainted(false);
                        button.setBorderPainted(false);
                        button.setBackground(new Color(161, 232, 221));
                        button.setSize(new Dimension(100,100));
                        global.getLeftDown().add(button);
                        global.getLeftDown().repaint();
                        global.getLeftDown().revalidate();



                    }
                });

            }
        });

        add(btn);
        this.setBorder(new LineBorder(Color.BLACK));
        this.setVisible(true);
    }
}
