package gaming;

import java.awt.*;

public class Oval extends Shapes{
    private Color color;
    public Oval() {
        super(0, 10, 1, 1, 20, 20); //values of shape

    }

    public void updatePosition() {  //updating method for the moving ball.
        setX(getX() + getX1());
        setY(getY() + getY1());
    }

    public void paint(Graphics g) {
        g.fillOval(getX(), getY(), getWidth(), getHeight());
    }
}
