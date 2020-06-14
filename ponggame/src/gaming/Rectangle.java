package gaming;

import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Timer;

public class Rectangle extends Shapes{
    private final Pong gaming;

    public Rectangle(Pong gaming, int y) {
        super((gaming.getWidth() - 60) / 2, y, 0,0,200,10);

        this.gaming = gaming;
    }
    // Paint Rectangle
    public void paint(Graphics g) {
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }


    public void pressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT)
            setX1(-1);                   //movement in the right direction
        else if (key == KeyEvent.VK_RIGHT)
            setX1(1);

    }

    public void released(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT)
            setX1(0); //follow the instruction of the keyboard
    }

    public void updatePosition() {  //update each movement
        if (getX() + getX1() >= 0 && getX() + getX1() < gaming.getWidth() - getWidth())
            setX(getX() + getX1());

    }

}
