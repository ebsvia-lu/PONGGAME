package gaming;

import java.awt.Rectangle;


//Shape abstract class, where move and oval classes extend from.
public abstract class Shapes  {
    private int x, y, x1, y1, width, height;

    public Shapes(int x, int y, int x1, int y1, int width, int height) {
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
        this.width = width;
        this.height = height;
    }
//get variables

    public int getX() {      //This will return the X coordinate of a bounding rectangle with double precision
        return x;             //This will apply to all get variables.
    }

    public int getY() {
        return y;
    } //

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }


    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    // set variables

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }


}