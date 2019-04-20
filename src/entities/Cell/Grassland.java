package entities.Cell;

import javax.swing.*;
import java.awt.*;

public class Grassland extends Land {

    /**
     * Konstruktor dari Grassland
     * 
     * @param point
     */
    public Grassland(Point point) {
        super(point, "Grassland");
    }

    @Override
    public char render() {
        return (isGrassGrown ? '#' : '-');
    }


    @Override
    public ImageIcon renderGUI() {
        return (isGrassGrown ? new ImageIcon("img/Grassland-grass.png") :
                new ImageIcon("img/Grassland.png"));
    }
}
