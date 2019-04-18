package entities.Cell;

import java.awt.*;

public class Well extends Cell {
    public final int waterCapacity = 30;

    public Well(Point point) {
        super(point);
    }

    @Override
    public char render() {
        return 'W';
    }
}
