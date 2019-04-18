package entities.Cell;

import java.awt.*;

public class Truck extends Cell {
    private int cooldownTime = 30;

    public Truck(Point point) {
        super(point);
    }

    public void resetCooldownTime() {
        cooldownTime = 30;
    }

    public void reduceCooldownTime() {
        if (cooldownTime > 0)
            this.cooldownTime--;
    }

    @Override
    public char render() {
        return 'T';
    }
}
