package gaming;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Panel extends JPanel {

    private Rectangle movement; //Shape rectangle with variable (the paddle)
    private Oval ball;          //Shape oval with variable ball
    private JLabel scoreName;
    public  int score = 0; //Score variable begins at zero - changed to static
    private Oval2 ball2;  // second shape oval with variable ball2

    public static boolean leaderBoard = false;
    //private HighScores highScores;

    public Panel(Pong game) {

        movement = new Rectangle(game, game.getHeight() - 100); //increase positioning of rectangle on frame
        ball = new Oval();
        ball2 = new Oval2();
        scoreName = new JLabel(Integer.toString(score));
        scoreName.setFont(new Font("Scores", Font.PLAIN, 40));
        add(scoreName); //add score to the game frame



//How fast the rectangle and oval move together

        Timer timer = new Timer(2, new TimerHandler());
        timer.start();

        addKeyListener(new KeyHandler());
        setFocusable(true);
    }
    //updates for method names
    private void update() {

        movement.updatePosition();
        ball.updatePosition();
        ball2.updatePosition();
        checkCollisionBallFrame();
        checkCollisionBallFrame1();
        checkCollisionBallMove1();
        checkCollisionBallMove();
        repaint();

    }


    //Collision between rectangle and ball, when the ball bounces of the rectangle (collision) scores will be added.)

    private void checkCollisionBallMove() {
        if (movement.getBounds().y == ball.getHeight() + ball.getBounds().y && //getBounds returns a new rectangle equal to the bounding rectangle

                ball.getBounds().x + ball.getWidth() > movement.getBounds().x &&

                movement.getBounds().x + movement.getWidth() > ball.getBounds().x)
        {
            ball.setY1(-ball.getY1());

            score++; //increase scores

            scoreName.setText(Integer.toString(score));
        }
    }
    private void checkCollisionBallMove1() {
        if (ball2.getBounds().y + ball2.getHeight() == movement.getBounds().y &&

                ball2.getBounds().x + ball2.getWidth() > movement.getBounds().x &&

                movement.getBounds().x + movement.getWidth() > ball2.getBounds().x)

        {
            ball2.setY1(-ball2.getY1());

            score++;

            scoreName.setText(Integer.toString(score));
        }
    }


    //Collision between frame and ball, when the hits the top of the frame it bounces off but when the ball touches the bottom of the frame it is game over.

    private void checkCollisionBallFrame() {

        if (ball.getX() < 0 || ball.getX() > getWidth() - ball.getWidth() - (getInsets().right + getInsets().right))

            ball.setX1(-ball.getX1());

        else if (ball.getY() < 0)

            ball.setY1(-ball.getY1());

        else if (ball.getY() > getHeight() - ball.getHeight()) { //if ball hits the bottom the frame

            JOptionPane.showMessageDialog(null, "Game Over. Your Score is " + score + ".", "Pong", JOptionPane.INFORMATION_MESSAGE);
            HighScores highScores = new HighScores();
            highScores.addScore(score); //gets score once game is over



            System.exit(ABORT);



        }

    }
//same method for ball2
    private void checkCollisionBallFrame1() {
        if (ball2.getX() < 0 || ball2.getX() > getWidth() - ball2.getWidth() - (getInsets().left + getInsets().left))

            ball2.setX1(-ball2.getX1());

        else if (ball2.getY() < 0)

            ball2.setY1(-ball2.getY1());

        else if (ball2.getY() > getHeight() - ball2.getHeight()) { //if ball hits the bottom the frame

            JOptionPane.showMessageDialog(null, "Game Over. You scored " + score + ".", "Pong", JOptionPane.INFORMATION_MESSAGE);
            System.exit(ABORT);

        }
    }



//Paint rectangle and ovals

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        movement.paint(g);
        ball.paint(g);
        ball2.paint(g);
        if (Pong.leaderBoard) {
            int drawY = 250;

        }
    }
    //Time delay


//Key Handler
    private class KeyHandler implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            movement.pressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            movement.released(e);
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }
    }
    //timehandler
    public class TimerHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            update();
        }

    }
    }
