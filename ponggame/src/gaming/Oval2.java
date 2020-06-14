package gaming;


import java.awt.*;

public class Oval2 extends Shapes { //extends abstract class of shape



    public Oval2() { super(80,0,1,1,20,20); //values of oval

    }

    public void updatePosition() {  //positioning of the oval that will be on the frame
        setX(getX() + getX1());
        setY(getY() + getY1());

    }


    public void paint(Graphics g) {
        g.fillOval(getX(), getY(), getWidth(), getHeight());
    }
}
