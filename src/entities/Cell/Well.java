package entities.Cell;

import java.awt.*;

public class Well extends Cell {
    public int waterCapacity;

    public Well(Point point) {
        super(point);
        this.waterCapacity = 30;
    }

    @Override
    public char render() {
        return 'W';
    }
}
