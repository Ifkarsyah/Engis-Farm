package entities.Cell;

import java.awt.*;

public class Coop extends Land {
    public Coop(Point point) {
        super(point, "Coop");
    }

    @Override
    public char render() {
        return (isGrassGrown ? '*' : 'o');
    }
}
