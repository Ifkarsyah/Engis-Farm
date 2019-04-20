package entities.Cell;

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
}
