package game;


import entities.map.MapModel;
import entities.map.MapView;
import entities.player.PlayerViewAction;


public class Game {
    public MapModel mapModel;
    public MapView mapView;
    public PlayerViewAction playerViewAction;

    public Game() {
        mapModel = new MapModel();
        mapView = new MapView(this.mapModel);
        playerViewAction = new PlayerViewAction(this.mapModel.playerModel, this.mapModel, this.mapView);

    }
}
