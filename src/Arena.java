import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Arena extends JPanel {

    ArrayList<Ball> balls = new ArrayList<>();


    public Arena() {
        setBackground(Color.BLUE);

        for (int i = 0; i < 20; i++) {

            int x = (int) (Math.random() * getWidth());
            int y = (int) (Math.random() * getHeight());
            int xSpeed = (int) (Math.random() * 10) + 1;
            int ySpeed = (int) (Math.random() * 10) + 1;
            int size = (int) (Math.random() * 30) + 20;
            Color color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));

            balls.add(new Ball(x, y, xSpeed, ySpeed, size, color));

        }
    }

    public void paintComponent(Graphics g) {

        // I had to add this since it
        // wasnt working on my pc properly
        super.paintComponent(g);

        for (Ball ball: balls) {

            ball.draw(g);
            ball.move();
            ball.bounce(this);

        }

        // Delay and repaint
        try {

            Thread.sleep(10);

        }

        catch(Exception e) {


        }

        repaint();

    }

}

