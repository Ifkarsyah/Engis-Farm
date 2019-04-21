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
        if (currentPoint.equals(mapModel.playerModel.getPoint())){
            map[i][j].setIcon(mapModel.playerModel.renderGUI());
            map[i][j].setBackground(Color.white);
        }
        else if (currentPoint.equals(mapModel.truck.getPoint())){
            map[i][j].setIcon(mapModel.truck.renderGUI());
            map[i][j].setBackground(Color.white);
        }
        else if (currentPoint.equals(mapModel.mixer.getPoint())){
            map[i][j].setIcon(mapModel.mixer.renderGUI());
            map[i][j].setBackground(Color.white);
        }
        else if (currentPoint.equals(mapModel.well.getPoint())){
            map[i][j].setIcon(mapModel.well.renderGUI());
            map[i][j].setBackground(Color.white);
        }
        else if (mapModel.mapAnimals.containsKey(currentPoint)){
            map[i][j].setIcon(mapModel.mapAnimals.get(currentPoint).renderGUI());
            if (mapModel.mapAnimals.get(currentPoint).getHungryPoint() > 5)
                map[i][j].setBackground(Color.white);
            else
                map[i][j].setBackground(Color.black);
        }
        else{
            map[i][j].setIcon(mapModel.mapLands.get(currentPoint).renderGUI());
            map[i][j].setBackground(Color.white);
        }
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
        System.out.println("Animal left:" + mapModel.mapAnimals.size());
        if (mapModel.mapAnimals.isEmpty()){
            JDialog jDialog = new JDialog();
            jDialog.setTitle("Game Over");
            JButton gameOver = new JButton();
            gameOver.setIcon(new ImageIcon("img/GameOver.png"));
            jDialog.add(gameOver);
            jDialog.setSize(500, 500);
            jDialog.setLocationRelativeTo(null);
            jDialog.setVisible(true);
            gameOver.addActionListener(actionEvent -> {
                System.exit(0);
            });
        }
    }
}
