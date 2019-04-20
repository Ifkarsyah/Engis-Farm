package entities.Cell;

import java.awt.*;

public class Truck extends Cell {
    private int cooldownTime = 30;

    /**
     * Konstruktor dari Truk
     * @param point
     */

    public Truck(Point point) {
        super(point);
    }

    /**
     * 
     * Mengembalikan waktu cooldown truk ke nilai awal (30)
     * 
     */
    public void resetCooldownTime() {
        cooldownTime = 30;
    }

    /**
     * 
     * Mengurangi waktu cooldown sebanyak 1 unit
     * 
     */

    public void reduceCooldownTime() {
        if (cooldownTime > 0)
            this.cooldownTime--;
    }

    /**
     * Override fungsi render
     * @return char
     */

    @Override
    public char render() {
        return 'T';
    }
}
