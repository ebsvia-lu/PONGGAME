package gaming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame {


    JPanel menupanel = new JPanel();
    JLabel menulabel = new JLabel();
    JPopupMenu menu = new JPopupMenu();
//Frame for menu

    public Menu() {

        setSize(900, 500);
        setTitle("1706629");//1706629
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        menulabel.setFont(new Font("Pong", Font.PLAIN, 40));
        add(menulabel);
        add(menu);
//Start game label that is added to the panel and then the mouselistener picks it up

        JMenuItem start_game = new JMenuItem("CLICK TO START GAME");

        menupanel.add(menulabel);
        menupanel.add(start_game);
        add(menupanel);
        setVisible(true);

//Mouse listener action, clicking mouse
        menupanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menu.show(menupanel, e.getX(),e.getY());
            }

        });
    start_game.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            new Pong(); //Start game

        }
    });
    }


}
