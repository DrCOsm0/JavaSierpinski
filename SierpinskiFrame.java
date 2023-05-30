
import javax.swing.*;
import java.awt.*;

/**
 * This class sets up the Sierpinski triangle in the graphical interface.
 */

public class SierpinskiFrame extends JFrame {

    /**
     * This method sets up the frame that the triangle will be painted to.
     */
    public SierpinskiFrame(){
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(500,500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.black);
        frame.add(new Sierpinski());
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SierpinskiFrame();
    }

}
