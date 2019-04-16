import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
import java.util.*;

public class Menu extends JPanel {

    private final String GAME_TITLE = "TETRIS";
    private final String BUTTON_LABEL = "START GAME";

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

        // DRAW MENU ELEMENTS (title text and start button)

        // determine the title text height and set font accordingly
        double title_pixel_size = box_size * 0.1;
        double title_font_size = title_pixel_size * Toolkit.getDefaultToolkit().getScreenResolution() / 72.0;
        Font title_font = new Font(Font.SERIF, Font.BOLD, (int) title_font_size);

        // determine button height and font details
        double btn_pixel_size = title_pixel_size * 0.25;
        double btn_font_size = btn_pixel_size * Toolkit.getDefaultToolkit().getScreenResolution() / 72.0;
        Font btn_font = new Font(Font.SANS_SERIF, Font.PLAIN, (int) btn_font_size);
        double button_height = 2 * btn_pixel_size;

        // determine total height for title and start button (top of text to bottom of button)
        double total_height = title_pixel_size + (0.5 * title_pixel_size) + button_height;

        // determine title width
        g2d.setFont(title_font);
        int title_text_width = g2d.getFontMetrics().stringWidth(GAME_TITLE);

        // calc title x,y
        float title_x = (float) (((box_size - title_text_width) / 2.0) + box_x);
        float title_y = (float) (((box_size - total_height) / 2.0) + box_y) + (float) title_pixel_size;

        // draw title
        g2d.setColor(Color.white);
        g2d.drawString(GAME_TITLE, title_x, title_y);

        // draw button
        float btn_y = (float) (title_y + (0.5 * title_pixel_size));
        Rectangle2D.Double start_btn = new Rectangle2D.Double(title_x, btn_y, title_text_width, button_height);
        g2d.draw(start_btn);

        // draw button's text
        g2d.setFont(btn_font);
        int btn_text_width = g2d.getFontMetrics().stringWidth(BUTTON_LABEL);
        g2d.drawString(BUTTON_LABEL, (float) (title_x + ((title_text_width - btn_text_width) / 2.0)), (float) (btn_y + btn_pixel_size + (0.25 * button_height)));

    }
}
