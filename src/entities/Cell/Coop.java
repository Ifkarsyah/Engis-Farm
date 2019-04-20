package entities.Cell;

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
}
