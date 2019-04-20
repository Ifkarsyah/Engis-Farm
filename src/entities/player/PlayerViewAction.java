package entities.player;

import entities.map.MapModel;
import entities.map.MapView;

import javax.swing.*;

public class PlayerViewAction extends JPanel {
    final JButton talkButton = new JButton("TALK");
    final JButton killButton = new JButton("KILL");
    final JButton interactButton = new JButton("INTERACT");
    final JButton mixKejuButton = new JButton("MIX KEJU");
    final JButton mixSateButton = new JButton("MIX SATE");
    final JButton mixBurgerButton = new JButton("MIX BURGER");
    final JButton growButton = new JButton("GROW");
    private final MapView mapView;
    private final MapModel mapModel;

    /**
     * Konstuktor PlayerViewAction
     * @param mapModel
     * @param mapView
     */
    public PlayerViewAction(MapModel mapModel, MapView mapView) {
        super();
        this.mapModel = mapModel;
        this.mapView = mapView;

        add(talkButton);
        add(killButton);
        add(interactButton);
        add(mixKejuButton);
        add(mixSateButton);
        add(mixBurgerButton);
        add(growButton);
    }
}