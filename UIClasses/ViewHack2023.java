import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public final class ViewHack2023 extends JFrame {

    // Controller component
    private ControllerHack2023 controller;

    // Image objects to display camera frames
    private BufferedImage img;
    private BufferedImage previousImg;

    // Icon allows image fiies to be displayed
    private ImageIcon icon;

    // Frame stores and displays components
    private JFrame frame;

    // Labesl store displayable icons
    private JLabel imageLabel;

    public ViewHack2023() throws IOException {
        // call JFrame
        super("people cam");

        img = ImageIO.read(new File("UIClasses/image.jpg"));
        previousImg = ImageIO.read(new File("UIClasses/yuh.jpg"));

        icon = new ImageIcon(img);

        frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(640, 480);

        imageLabel = new JLabel();
        imageLabel.setIcon(icon);

        // this.add(layeredVideoPanel);
        frame.add(imageLabel);

        /*
         * Make sure the main window is appropriately sized, exits this program
         * on close, and becomes visible to the user
         */
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // lets the controller change
    public void registerObserver(ControllerHack2023 controller) {

        this.controller = controller;

    }

    // this will "update" the current image from controller
    public void updateVideo(List<Integer> x, List<Integer> y, List<Double> d) throws IOException, InterruptedException {
        File f = new File("UIClasses/image.jpg");
        while (this.img == null) {
            this.img = ImageIO.read(f);
            if (this.img == null) {
                this.img = this.previousImg;
            } else {
                this.previousImg = this.img;
            }

        }
        this.icon = new ImageIcon(img);
        this.imageLabel.setIcon(icon);
        this.frame.add(this.imageLabel);
        this.controller.processNewImage(this.controller.xCoordinate(), this.controller.yCoordinate(),
                this.controller.distancesArray());
    }

    //

    public Image viewImage() {
        return this.img;
    }

    // places label where it goes over image
    public void updateUI(int x, int y, double distance, Image img) {
        Graphics g = img.getGraphics();
        g.setColor(Color.PINK);
        g.drawString(distance + " m", x, y);
    }

}