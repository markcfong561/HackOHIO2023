import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import co.sun.jna.

public final class ViewHack2023 extends JFrame {

    private ControllerHack2023 controller;

    // private Overlay overlay;

    private enum State {
        PERSON_SEEN, PERSON_LOST
    }

    // default constructor
    private State currentState;

    private JLayeredPane layeredPane;

    private JLayeredPane layeredVideoPanel;

    private JLabel imageLabel;

    public ViewHack2023() {
        // call JFrame
        super("people cam");

        // set up initial state of GUI as if it has seen nobody
        this.currentState = State.PERSON_LOST;

        // JLabel rectangle = new JLabel();
        layeredVideoPanel.setBounds(0, 0, 1200, 500);
        // imageLabel.setBounds(0,0,1200,500);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1200, 500);

        this.add(layeredVideoPanel);
        this.add(layeredPane);
        this.setSize(1200, 500);
        this.setLayout(null);

        // label1 = new JLabel(this.controller.distance());

        /*
         * Make sure the main window is appropriately sized, exits this program
         * on close, and becomes visible to the user
         */

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // lets the controller change
    public void registerObserver(ControllerHack2023 controller) {

        this.controller = controller;

    }

    // this will "update" the current image from controller
    public void updateVideo() {
        BufferedImage img = ImageIO.read(new File("UIClasses/image.jpg"));
        ImageIcon icon = new ImageIcon(img);
        this.imageLabel.setIcon(icon);
        this.layeredVideoPanel.add(this.imageLabel);
        this.controller.processNewImage();

    }

    // places label where it goes over image
    public void updateUI(int x, int y, double distance) {
        JLabel label1 = new JLabel(distance + " m");
        label1.setHorizontalTextPosition(x);
        label1.setVerticalTextPosition(y);
        this.layeredPane.add(label1);
    }

}