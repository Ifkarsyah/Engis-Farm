package entities.map;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static meta.Constant.sizeColMap;
import static meta.Constant.sizeRowMap;

public class MapView extends JPanel {
    public final MapModel mapModel;

    public JButton[][] map = new JButton[sizeRowMap][sizeColMap];

    public MapView(MapModel mapModel) {
        super(new GridLayout(sizeRowMap, sizeColMap));

        this.mapModel = mapModel;

        initMapEntities();
        initColorMapLands();
        addKeyListenerPlayerMove();


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

    public void addKeyListenerPlayerMove() {
        for (int i = 0; i < sizeRowMap; i++)
            for (int j = 0; j < sizeColMap; j++) {
                map[i][j].addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent keyEvent) {
                    }

                    @Override
                    public void keyPressed(KeyEvent keyEvent) {
                        int keyCode = keyEvent.getKeyCode();
                        switch (keyCode) {
                            case KeyEvent.VK_LEFT:
                                mapModel.playerMove(0, -1);
                                break;
                            case KeyEvent.VK_DOWN:
                                mapModel.playerMove(1, 0);
                                break;
                            case KeyEvent.VK_RIGHT:
                                mapModel.playerMove(0, 1);
                                break;
                            case KeyEvent.VK_UP:
                                mapModel.playerMove(-1, 0);
                                break;
                        }
                        updateMap();
                    }

                    @Override
                    public void keyReleased(KeyEvent keyEvent) {
                    }
                });
            }
    }

    public void updateMap() {
        mapModel.updateTick();
        for (int i = 0; i < sizeRowMap; i++) {
            for (int j = 0; j < sizeColMap; j++) {
                Point currentPoint = new Point(i, j);
                if (currentPoint.equals(mapModel.playerModel.getPoint()))
                    map[i][j].setText(String.valueOf(mapModel.playerModel.render()));
                else if (currentPoint.equals(mapModel.truck.getPoint()))
                    map[i][j].setText(String.valueOf(mapModel.truck.render()));
                else if (currentPoint.equals(mapModel.mixer.getPoint()))
                    map[i][j].setText(String.valueOf(mapModel.mixer.render()));
                else if (currentPoint.equals(mapModel.well.getPoint()))
                    map[i][j].setText(String.valueOf(mapModel.well.render()));
                else if (mapModel.mapAnimals.containsKey(currentPoint))
                    map[i][j].setText(String.valueOf(mapModel.mapAnimals.get(currentPoint).render()));
                else
                    map[i][j].setText(String.valueOf(mapModel.mapLands.get(currentPoint).render()));
            }
        }
    }
}
