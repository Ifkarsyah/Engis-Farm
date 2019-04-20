package entities.map;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static meta.Constant.sizeColMap;
import static meta.Constant.sizeRowMap;

public class MapController {
    public final MapModel mapModel;
    public final MapView mapView;

    /**
     * Konstruktor dari kelas MapController
     * 
     * @param mapModel
     * @param mapView
     */

    public MapController(MapModel mapModel, MapView mapView) {
        this.mapModel = mapModel;
        this.mapView = mapView;

        addKeyListenerPlayerMove();
    }

    private void addKeyListenerPlayerMove() {
        for (int i = 0; i < sizeRowMap; i++)
            for (int j = 0; j < sizeColMap; j++) {
                mapView.map[i][j].addKeyListener(new KeyListener() {
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
                        mapView.updateMap();
                    }

                    @Override
                    public void keyReleased(KeyEvent keyEvent) {
                    }
                });
            }
    }
}
