package game;


import entities.map.MapModel;
import entities.map.MapView;
import entities.player.PlayerViewAction;
import entities.player.PlayerViewInfo;


public class Game {
    public MapModel mapModel;
    public MapView mapView;
    public PlayerViewAction playerViewAction;
    public PlayerViewInfo playerViewInfo;

    public Game() {
        mapModel = new MapModel();
        mapView = new MapView(this.mapModel);
        playerViewInfo = new PlayerViewInfo(this.mapModel.playerModel);
        playerViewAction = new PlayerViewAction(this.mapModel, this.mapView, this.playerViewInfo);
    }
}
