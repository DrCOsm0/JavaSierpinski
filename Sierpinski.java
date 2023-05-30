
import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * <p> This class creates a Sierpinski triangle.  It contains a single constructor aswell as methods that
 * calculate color and paints the triangle to a graphical interface
 * </p>
 */

import oop.jbhullar.hw7.one.DrawShape;
import oop.jbhullar.hw7.one.Point;

public class Sierpinski extends JPanel {

    /**
     * This contractor initializes the triangle and frame size.
     * @return firstName
     */
    public Sierpinski() {
        setPreferredSize(new Dimension(500,500));
        setBackground(Color.black);
    }

    /**
     * This method calculates the color of a point inside the triangle using 3 corner points and an interior point.
     * @param r Red Point
     * @param g Green Point
     * @param b Blue Point
     * @param x interior point
     * @return color
     */
    public Color triangleColor(Point r, Point g, Point b, Point x){

        int L;

        int distance_RG = (int) Math.round(r.distance(g));
        int distance_GB = (int) Math.round(g.distance(b));
        int distance_BR = (int) Math.round(b.distance(r));

        if(distance_RG > distance_GB && distance_RG > distance_BR) {
            L = distance_RG;
        }else if(distance_GB > distance_RG && distance_GB > distance_BR) {
            L = distance_GB;
        }else{
            L = distance_BR;
        }

        int r_val = (int) (255 * ((L - r.distance(x)) / L));
        int g_val = (int) (255 * ((L - g.distance(x)) / L));
        int b_val = (int) (255 * ((L - b.distance(x)) / L));

        return new Color(r_val,g_val,b_val);
    }

    /**
     * This method paints the triangle to a graphical interface
     * @param g graphics interface
     */
    public void paintComponent(Graphics g) {

        Point R = new Point(250,77);
        Point G = new Point(50,423);
        Point B = new Point(450,423);//450 423

        Point[] array = {R, G, B};

        Point x = new Point((int)R.getX(),(int)R.getY());

        for(int i = 0; i < 50000; i++) {
            Point target_point = array[new Random().nextInt(3)];

            int mid_x = (int) Math.round((x.getX() + target_point.getX()) / 2);
            int mid_y = (int) Math.round((x.getY() + target_point.getY()) / 2);
            x.setX(mid_x);
            x.setY(mid_y);

            Graphics2D g2 = (Graphics2D) g;
            DrawShape.drawPoint(g2,x, triangleColor(R, G, B ,x));
        }
    }
}
