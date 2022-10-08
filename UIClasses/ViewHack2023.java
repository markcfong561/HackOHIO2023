import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public final class ViewHack2023 extends JFrame {

    private ControllerHack2023 controller;

    // private Overlay overlay;

    private enum State {
        PERSON_SEEN, PERSON_LOST
    }

    // default constructor
    private State currentState;

    private JLayeredPane layeredPane;

    public ViewHack2023() {
        // call JFrame
        super("people cam");

        // set up initial state of GUI as if it has seen nobody
        this.currentState = State.PERSON_LOST;

        // JLabel rectangle = new JLabel();

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1200, 500);

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

    public void updateVideo() {

    }

    public void updateUI(int x, int y, double distance) {
        JLabel label1 = new JLabel(distance + " m");
        label1.setHorizontalTextPosition(x);
        label1.setVerticalTextPosition(y);
        this.layeredPane.add(label1);
    }

    public void frameUpdated(ActionEvent event) {
        Object source = event.getSource();
        this.controller.draw();

        if ( )
    }

}