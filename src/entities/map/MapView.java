package entities.map;


import meta.Assets;

import javax.swing.*;
import java.awt.*;

import static meta.Constant.sizeColMap;
import static meta.Constant.sizeRowMap;

public class MapView extends JPanel {
    public final JButton[][] map = new JButton[sizeRowMap][sizeColMap];
    private final MapModel mapModel;

    /**
     * Konstruktor kelas MapView
     * 
     * @param mapModel
     */
    public MapView(MapModel mapModel) {
        super(new GridLayout(sizeRowMap, sizeColMap));

        this.mapModel = mapModel;

        initMapEntities();
        mapModel.updateTick();
    }

    private void initMapEntities() {
        for (int i = 0; i < sizeRowMap; i++) {
            for (int j = 0; j < sizeColMap; j++) {
                Point currentPoint = new Point(i, j);
                map[i][j] = new JButton();
                setIconCurrentPoint(i, j, currentPoint);

                add(map[i][j]);
            }
        }
    }

    private void setIconCurrentPoint(int i, int j, Point currentPoint) {
        if (currentPoint.equals(mapModel.playerModel.getPoint()))
            map[i][j].setIcon(mapModel.playerModel.renderGUI());
        else if (currentPoint.equals(mapModel.truck.getPoint()))
            map[i][j].setIcon(mapModel.truck.renderGUI());
        else if (currentPoint.equals(mapModel.mixer.getPoint()))
            map[i][j].setIcon(mapModel.mixer.renderGUI());
        else if (currentPoint.equals(mapModel.well.getPoint()))
            map[i][j].setIcon(mapModel.well.renderGUI());
        else if (mapModel.mapAnimals.containsKey(currentPoint))
            map[i][j].setIcon(mapModel.mapAnimals.get(currentPoint).renderGUI());
        else
            map[i][j].setIcon(mapModel.mapLands.get(currentPoint).renderGUI());
    }

    public void updateMap() {
        mapModel.updateTick();
        for (int i = 0; i < sizeRowMap; i++) {
            for (int j = 0; j < sizeColMap; j++) {
                Point currentPoint = new Point(i, j);
                setIconCurrentPoint(i, j, currentPoint);
            }
        }
        System.out.println(mapModel.playerModel);
    }
}
