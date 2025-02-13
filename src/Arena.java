import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.*;
import javax.swing.*;

public class Arena extends JPanel {

    ArrayList<Ball> balls = new ArrayList<>();


    Ball me = new Ball(400,400,0,0,50,Color.BLACK);

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

//        setFocusable(true);
//
//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//                System.out.println(e.getX() + "," + e.getY());
//
//            }
//
//        });

        setFocusable(true);

        addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_W){

                    me.setY(me.getY() - 4);

                }

                else if(e.getKeyCode() == KeyEvent.VK_S){

                    me.setY(me.getY() + 4);

                }

                else if(e.getKeyCode() == KeyEvent.VK_D){

                    me.setX(me.getX() + 4);

                }

                else if(e.getKeyCode() == KeyEvent.VK_A){

                    me.setX(me.getX() - 4);

                }

                System.out.println(e.getKeyCode());

            }


        });


    }

    public void paintComponent(Graphics g) {

        // I had to add this since it
        // wasnt working on my pc properly
        super.paintComponent(g);

        me.draw(g);

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

