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
        initColorMapLands();
    }

    private void initMapEntities() {
        for (int i = 0; i < sizeRowMap; i++) {
            for (int j = 0; j < sizeColMap; j++) {
                Point currentPoint = new Point(i, j);
                if (currentPoint.equals(mapModel.playerModel.getPoint()))
                    map[i][j] = new JButton(String.valueOf(mapModel.playerModel.render()));
                else if (currentPoint.equals(mapModel.truck.getPoint()))
                    map[i][j] = new JButton(String.valueOf(mapModel.truck.render()));
                else if (currentPoint.equals(mapModel.mixer.getPoint()))
                    map[i][j] = new JButton(String.valueOf(mapModel.mixer.render()));
                else if (currentPoint.equals(mapModel.well.getPoint()))
                    map[i][j] = new JButton(String.valueOf(mapModel.well.render()));
                else if (mapModel.mapAnimals.containsKey(currentPoint))
                    map[i][j] = new JButton(String.valueOf(mapModel.mapAnimals.get(currentPoint).render()));
                else
                    map[i][j] = new JButton(String.valueOf(mapModel.mapLands.get(currentPoint).render()));
                add(map[i][j]);
            }
        }
    }
    private void initColorMapLands() {
        for (int i = 0; i < sizeRowMap; i++)
            for (int j = 0; j < sizeColMap; j++)
                map[i][j].setBackground(Color.green);
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                map[i][j].setBackground(Color.yellow);
        for (int i = 0; i < 6; i++)
            for (int j = 4; j < 8; j++)
                map[i][j].setBackground(Color.red);
    }

    public void updateMap() {
        mapModel.updateTick();
        for (int i = 0; i < sizeRowMap; i++) {
            for (int j = 0; j < sizeColMap; j++) {
                Point currentPoint = new Point(i, j);
                if (currentPoint.equals(mapModel.playerModel.getPoint())){
//                     map[i][j].setText(String.valueOf(mapModel.playerModel.render()));
                    map[i][j].setIcon(mapModel.playerModel.renderGUI());
                }
                else if (currentPoint.equals(mapModel.truck.getPoint())){
//                    map[i][j].setText(String.valueOf(mapModel.truck.render()));
                    map[i][j].setIcon(mapModel.truck.renderGUI());
                }
                else if (currentPoint.equals(mapModel.mixer.getPoint())){
//                    map[i][j].setText(String.valueOf(mapModel.mixer.render()));
                    map[i][j].setIcon(mapModel.mixer.renderGUI());

                }

                else if (currentPoint.equals(mapModel.well.getPoint())){
//                    map[i][j].setText(String.valueOf(mapModel.well.render()));
                    map[i][j].setIcon(mapModel.well.renderGUI());
                }
                else if (mapModel.mapAnimals.containsKey(currentPoint)){
//                     map[i][j].setText(String.valueOf(mapModel.mapAnimals.get(currentPoint).render()));
                    map[i][j].setIcon(mapModel.mapAnimals.get(currentPoint).renderGUI());
                }
                else{
//                     map[i][j].setText(String.valueOf(mapModel.mapLands.get(currentPoint).render()));
                    map[i][j].setIcon(mapModel.mapLands.get(currentPoint).renderGUI());
                }
            }
        }
        System.out.println(mapModel.playerModel);
    }
}
