package entities.Cell;

import javax.swing.*;
import java.awt.*;

public class Coop extends Land {

    /**
     * Konstruktor kelas Coop
     * 
     * @param point
     */
    public Coop(Point point) {
        super(point, "Coop");
    }

    /**
     * Override fungsi render
     * @return char
     */
    @Override
    public char render() {
        return (isGrassGrown ? '*' : 'o');
    }

    /**
     * Menghasilkan filename gambar Coop
     * @return ImageIcon
     *
     */
    @Override
    public ImageIcon renderGUI() {
        return (isGrassGrown ? new ImageIcon(Coop.class.getResource("/img/Coop-grass.png")) :
                new ImageIcon(Coop.class.getResource("/img/Coop.png")));
    }
}
