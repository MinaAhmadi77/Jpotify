import javax.swing.*;

public class ProgressBar extends JSlider {
    public Global global;
    public ProgressBar(Global global) {
        super();
        this.setValue(0);
        this.global=global;
        global.setProgressBar(this);
        this.setSize(400,20);
    }
}
