package entities.Cell;

import javax.swing.*;
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
     * @return int sisa waktu cooldown dari Truck
     * */
    public int getCoolDownTime() {return cooldownTime;}

    /**
     * Override fungsi render
     * @return char
     */
    @Override
    public char render() {
        return 'T';
    }

    /**
     * Menghasilkan filename gambar truck
     * @return ImageIcon
     *
     */
    @Override
    public ImageIcon renderGUI(){
        return new ImageIcon(Truck.class.getResource("/img/Truck.png"));
    }
}
