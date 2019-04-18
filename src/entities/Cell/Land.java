package entities.Cell;

import java.awt.*;

public abstract class Land extends Cell {
    public final String type;
    public boolean isGrassGrown;

    Land(Point point, String type) {
        super(point);
        this.isGrassGrown = Math.random() < 0.5;
        this.type = type;
    }


}
