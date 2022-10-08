import java.awt.*;

import javax.swing.JFrame;

public final class ViewHack2023 extends JFrame {

    private ControllerHack2023 controller;

    private Overlay overlay;

    private enum State {
        PERSON_SEEN, PERSON_LOST
    }

    // default constructor
    private State currentState;

    public ViewHack2023() {
        //call JFrame
        super("rectangles");

        //set up initial state of GUI as if it has seen nobody
        this.currentState = State.PERSON_LOST;

        JFrame frame = new JFrame


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

}