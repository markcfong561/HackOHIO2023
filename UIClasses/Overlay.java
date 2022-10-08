imoprt java.awt.Window; 
import java.awt.WindowsUtils;

public class Overlay extends Window {
    public Overlay(Window owner) {
        super(owner, WindowsUtils.getAlphaCompatibleGraphicsConfiguration()):
        setBackground(new Color(0, 0, 0, 0));
    }
}