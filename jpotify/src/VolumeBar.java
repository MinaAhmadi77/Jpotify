import javazoom.jl.player.JavaSoundAudioDevice;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import javax.sound.sampled.*;

public class VolumeBar extends JSlider {
    VolumeBar volumeBar;
    public VolumeBar(Global global){
        super();
        this.volumeBar = this;
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(200,20));
        Port.Info source = Port.Info.SPEAKER;
        if (AudioSystem.isLineSupported(source))
        {
            try
            {
                Port outline = (Port) AudioSystem.getLine(source);
                outline.open();
                FloatControl volumeControl = (FloatControl) outline.getControl(FloatControl.Type.VOLUME);
                this.setValue((int)volumeControl.getValue()*100);
            }
            catch (LineUnavailableException ignored)
            {
            }
        }
        addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent arg0) {

                if (AudioSystem.isLineSupported(source))
                {
                    try
                    {
                        Port outline = (Port) AudioSystem.getLine(source);
                        outline.open();
                        FloatControl volumeControl = (FloatControl) outline.getControl(FloatControl.Type.VOLUME);
                        volumeControl.setValue(volumeBar.getValue()/100f);
                    }
                    catch (LineUnavailableException ignored)
                    {
                    }
                }
            }
        });
        this.setFocusable(false);
    }

}
