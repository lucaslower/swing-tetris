import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
import java.util.*;

public class Menu extends JPanel {

    private final String GAME_TITLE = "TETRIS";

    // MENU PANEL CONSTRUCTOR
    public Menu(){
        setBackground(Color.white);
        setForeground(Color.black);
    }

    @Override
    protected void paintComponent(Graphics g){

        // run super and get a g2d
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // DRAW BOUNDING BOX (largest square within window, centered in larger dimension)
        int win_w = getWidth();
        int win_h = getHeight();
        int box_size;
        double box_x;
        double box_y;

        // determine offset direction
        if(win_w <= win_h){
            box_size = win_w;
            box_x = 0.0;
            box_y = (win_h-win_w) / 2.0;
        }
        else{
            box_size = win_h;
            box_x = (win_w-win_h) / 2.0;
            box_y = 0.0;
        }

        // draw the box
        g2d.setColor(Color.black);
        g2d.fill(new Rectangle2D.Double(box_x, box_y, box_size, box_size));

        // DRAW TITLE TEXT

        // determine the font size in points from pixels (pixel size is 60% of the bounding box size)
        double pixel_size = box_size * 0.4;
        double font_size = 100 * Toolkit.getDefaultToolkit().getScreenResolution() / 72.0;
        Font title_font = new Font(Font.SERIF, Font.BOLD, (int) font_size);
        g2d.setFont(title_font);

        // determine title width
        int text_width = g2d.getFontMetrics().charsWidth(GAME_TITLE.toCharArray(), 0, GAME_TITLE.toCharArray().length);

        // draw title
        g2d.setColor(Color.white);
        g2d.drawString(GAME_TITLE, ((float) box_size - text_width) / 2, 100);
    }
}
