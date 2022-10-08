import java.awt.Window;
import com.sun.jna.platform.WindowsUtils;

class Overlay extends Window {
    public Overlay(Window owner) {
        super(owner, WindowUtils.getAlphaCompatibleGraphicsConfiguration());
        setBackground(new Color(0, 0, 0, 0));
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(
            180.0f, 280.0f,
            new Color(255, 255, 255, 255),
            250.0f,
            380.0f,
            new Color(255, 255, 0, 0)
        );
        g2.setPaint(gp);
        for (int i = 0; i &lt; 3; i ++ ) {
            g2.drawOval(150, 280, 100, 100);
            g2.fillOval(150, 280, 100, 100);
            g2.translate(120, 20);
        }
    }
}
