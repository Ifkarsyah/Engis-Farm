package entities.Cell;

import javax.swing.*;
import java.awt.*;

public class Well extends Cell {

    public final int waterCapacity = 30;

    /**
     * 
     * Konstruktor Well
     * @param point
     */
    public Well(Point point) {
        super(point);
    }

    /**
     * 
     * Override fungsi render()
     * @return char
     */
    @Override
    public char render() {
        return 'W';
    }

    /**
     *
     * Menghasilkan filename gambar well
     * @return ImageIcon
     */
    @Override
    public ImageIcon renderGUI(){
        return new ImageIcon(Well.class.getResource("/img/Well.png"));
    }
}
