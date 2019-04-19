package entities.player;

import entities.Cell.Truck;
import entities.Cell.Well;
import entities.animals.FarmAnimal;
import entities.map.MapModel;
import entities.map.MapView;
import entities.product.Burger;
import entities.product.Keju;
import entities.product.Sate;

import javax.swing.*;
import java.awt.*;

public class PlayerViewAction extends JPanel {
    MapView mapView;
    PlayerViewInfo playerViewInfo;
    MapModel mapModel;

    JButton talkButton = new JButton("TALK");
    JButton killButton = new JButton("KILL");
    JButton interactButton = new JButton("INTERACT");
    JButton mixKejuButton = new JButton("MIX KEJU");
    JButton mixSateButton = new JButton("MIX SATE");
    JButton mixBurgerButton = new JButton("MIX BURGER");
    JButton growButton = new JButton("GROW");

    public PlayerViewAction(MapModel mapModel, MapView mapView, PlayerViewInfo playerViewInfo) {
        super();
        this.mapModel = mapModel;
        this.mapView = mapView;
        this.playerViewInfo = playerViewInfo;

        add(talkButton);
        add(killButton);
        add(interactButton);
        add(mixKejuButton);
        add(mixSateButton);
        add(mixBurgerButton);
        add(growButton);

        addListenerTalk();
        addListenerKill();
        addListenerGrow();
        addListenerInteract();
        addListenerMixBurger();
        addListenerMixKeju();
        addListenerMixSate();
    }

    public void addListenerTalk() {
        talkButton.addActionListener(actionEvent -> {
            FarmAnimal targetAnimal = mapModel.animalIsAroundPlayer();
            if (targetAnimal != null) {
                if (targetAnimal.isProductReady) {
                    mapModel.playerModel.talk(targetAnimal);
                }
            }
        });
    }
    public void addListenerKill() {
        killButton.addActionListener(actionEvent -> {
            FarmAnimal targetAnimal = mapModel.animalIsAroundPlayer();
            if (targetAnimal != null) {
                if (targetAnimal.isProductReady) {
                    mapModel.playerModel.kill(targetAnimal);
                    mapModel.mapAnimals.values().remove(targetAnimal);
                }
            }
            mapView.updateMap();
            playerViewInfo.updatePlayerInfoView(mapModel.playerModel);
        });

    }

    public void addListenerGrow() {
        growButton.addActionListener(actionEvent -> {
            mapModel.playerModel.grow(mapModel.mapLands.get(mapModel.playerModel.getPoint()));
            mapView.updateMap();
            playerViewInfo.updatePlayerInfoView(mapModel.playerModel);
        });
    }

    public void addListenerInteract() {
        interactButton.addActionListener(actionEvent -> {
            FarmAnimal targetAnimal = mapModel.animalIsAroundPlayer();
            Point playerPoint = mapModel.playerModel.getPoint();
            Point truckPoint = mapModel.truck.getPoint();
            Point wellPoint = mapModel.well.getPoint();
            PlayerModel playerModel = mapModel.playerModel;
            Truck truck = mapModel.truck;
            Well well = mapModel.well;
            if (targetAnimal != null) {
                try {
                    playerModel.interact(targetAnimal);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if ((int) playerPoint.distanceSq(truckPoint) < 2) {
                playerModel.interact(truck);
            } else if ((int) playerPoint.distanceSq(wellPoint) < 2) {
                playerModel.interact(well);
            }
            mapView.updateMap();
            playerViewInfo.updatePlayerInfoView(mapModel.playerModel);
        });
    }

    public void addListenerMixBurger() {
        mixBurgerButton.addActionListener(actionEvent -> {
            Point playerPoint = mapModel.playerModel.getPoint();
            Point mixerPoint = mapModel.mixer.getPoint();
            if ((int) playerPoint.distanceSq(mixerPoint) < 2)
                mapModel.mixer.mix(mapModel.playerModel.getInventory(), new Burger());
            mapView.updateMap();
            playerViewInfo.updatePlayerInfoView(mapModel.playerModel);
        });
    }

    public void addListenerMixKeju() {
        mixKejuButton.addActionListener(actionEvent -> {
            Point playerPoint = mapModel.playerModel.getPoint();
            Point mixerPoint = mapModel.mixer.getPoint();
            if ((int) playerPoint.distanceSq(mixerPoint) < 2)
                mapModel.mixer.mix(mapModel.playerModel.getInventory(), new Keju());
            mapView.updateMap();
            playerViewInfo.updatePlayerInfoView(mapModel.playerModel);
        });
    }

    public void addListenerMixSate() {
        mixSateButton.addActionListener(actionEvent -> {
            Point playerPoint = mapModel.playerModel.getPoint();
            Point mixerPoint = mapModel.mixer.getPoint();
            if ((int) playerPoint.distanceSq(mixerPoint) < 2)
                mapModel.mixer.mix(mapModel.playerModel.getInventory(), new Sate());
            mapView.updateMap();
            playerViewInfo.updatePlayerInfoView(mapModel.playerModel);
        });
    }
}