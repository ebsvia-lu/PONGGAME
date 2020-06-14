package gaming;

import javax.swing.*;
import java.awt.*;


    public class Pong extends JFrame {
        public static final int HEIGHT = 500, WIDTH = 900;
        private JPanel jPanelComponent;
        public static boolean leaderBoard = false;

//panel for the background colour
        private Pong setJPanelComponent(JPanel jPanelComponent){  //return panel
            this.jPanelComponent = jPanelComponent;
            return this;}
  //Frame
        public Pong() {

            super("1706629");

            setSize(WIDTH, HEIGHT);
            setResizable(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            jPanelComponent = new Panel(this);
            jPanelComponent.setBackground(Color.ORANGE);
            add(jPanelComponent);


            setVisible(true);

        }


  //Print Menu first
        public static void main(String[] args) {
            new Menu();





        }



    }



