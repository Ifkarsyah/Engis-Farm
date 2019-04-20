package entities.Cell;

import java.awt.*;

public abstract class Land extends Cell {
    public final String type;
    public boolean isGrassGrown;

    /**
     * Konstruktor kelas abstrak Land
     * 
     * @param point
     * @param type
     */
    Land(Point point, String type) {
        super(point);
        this.isGrassGrown = Math.random() < 0.5;
        this.type = type;
    }


}
