package entities.Cell;

import javax.swing.*;
import java.awt.*;

public class Barn extends Land {

    /**
     * Konstruktor kelas Barn
     * @param point
     */
    public Barn(Point point) {
        super(point, "Barn");
    }
    
    /**
     * 
     * Override fungsi render()
     * @return char
     * 
     */
    @Override
    public char render() {
        return (isGrassGrown ? '@' : 'x');
    }

    @Override
    public ImageIcon renderGUI(){
        return new ImageIcon("img/Barn.png");
    }
}
