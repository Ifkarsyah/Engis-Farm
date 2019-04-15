package entities.Cell;

import java.awt.*;

public class Grassland extends Land {
    public Grassland(Point point) {
        super(point, "Grassland");
    }

    @Override
    public char render() {
        return (isGrassGrown ? '#' : '-');
    }
}
