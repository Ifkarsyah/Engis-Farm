package entities.Cell;

import java.awt.*;

public class Barn extends Land {
    public Barn(Point point) {
        super(point, "Barn");
    }

    @Override
    public char render() {
        return (isGrassGrown ? '@' : 'x');
    }
}
