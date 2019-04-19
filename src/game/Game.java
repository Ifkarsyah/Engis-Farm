package game;


import entities.map.MapController;
import entities.map.MapModel;
import entities.map.MapView;
import entities.player.PlayerController;
import entities.player.PlayerViewAction;
import entities.player.PlayerViewInfo;


public class Game {
    public final MapController mapController;
    public final PlayerController playerController;

    public Game() {
        MapModel mapModel = new MapModel();
        mapController = new MapController(mapModel, new MapView(mapModel));
        playerController = new PlayerController(mapController.mapModel.playerModel, mapController, new PlayerViewInfo(mapController.mapModel.playerModel), new PlayerViewAction(mapController.mapModel, mapController.mapView));
    }
}
