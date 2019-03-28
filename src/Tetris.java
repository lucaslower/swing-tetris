import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Tetris extends JFrame {

    // FRAME CONSTRUCTOR
    public Tetris(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);

        // add menu panel
        Menu menu_panel = new Menu();
        add(menu_panel);
    }

    public static void main(String[] args) {
        // build app and run
	    Tetris app = new Tetris();
	    java.awt.EventQueue.invokeLater(() -> {
	        app.setVisible(true);
        });
    }
}
