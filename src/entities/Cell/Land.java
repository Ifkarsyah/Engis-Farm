package entities.Cell;

import java.awt.*;

public abstract class Land extends Cell{
    public boolean isGrassGrown;
    public final String type;

    Land(Point point, String type) {
        super(point);
        this.isGrassGrown = true;
        this.type = type;
    }


}
