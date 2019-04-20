package entities.player;

import entities.Cell.Truck;
import entities.Cell.Well;
import entities.animals.FarmAnimal;
import entities.map.MapController;
import entities.product.Burger;
import entities.product.Keju;
import entities.product.Sate;

import javax.swing.*;
import java.awt.*;

public class PlayerController {
    public final PlayerViewInfo playerViewInfo;
    public final PlayerViewAction playerViewAction;
    private final PlayerModel playerModel;
    private final MapController mapController;


    public PlayerController(PlayerModel playerModel, MapController mapController, PlayerViewInfo playerViewInfo, PlayerViewAction playerViewAction) {
        this.playerModel = playerModel;
        this.mapController = mapController;
        this.playerViewInfo = playerViewInfo;
        this.playerViewAction = playerViewAction;

        addListenerTalk();
        addListenerKill();
        addListenerInteract();
        addListenerGrow();
        addListenerMixKeju();
        addListenerMixBurger();
        addListenerMixSate();
    }

    private void addListenerTalk() {
        playerViewAction.talkButton.addActionListener(actionEvent -> {
            FarmAnimal targetAnimal = mapController.mapModel.animalIsAroundPlayer();
            if (targetAnimal != null) {
                if (targetAnimal.isProductReady) {
                    mapController.mapModel.playerModel.talk(targetAnimal);
                    JDialog jDialog = new JDialog();
                    jDialog.setTitle(targetAnimal.getName());
                    JLabel text = new JLabel(targetAnimal.getSound());
                    text.setIcon(targetAnimal.renderGUI());
                    jDialog.add(text);
                    jDialog.setSize(200, 200);
                    jDialog.setLocationRelativeTo(null);
                    jDialog.setVisible(true);
                }
            }
        });
    }

    private void addListenerKill() {
        playerViewAction.killButton.addActionListener(actionEvent -> {
            FarmAnimal targetAnimal = mapController.mapModel.animalIsAroundPlayer();
            if (targetAnimal != null) {
                if (targetAnimal.isProductReady) {
                    mapController.mapModel.playerModel.kill(targetAnimal);
                    mapController.mapModel.mapAnimals.values().remove(targetAnimal);
                }
            }
            mapController.mapView.updateMap();
            playerViewInfo.updatePlayerInfoView(mapController.mapModel.playerModel);
        });

    }

    private void addListenerInteract() {
        playerViewAction.interactButton.addActionListener(actionEvent -> {
            FarmAnimal targetAnimal = mapController.mapModel.animalIsAroundPlayer();
            Point playerPoint = mapController.mapModel.playerModel.getPoint();
            Point truckPoint = mapController.mapModel.truck.getPoint();
            Point wellPoint = mapController.mapModel.well.getPoint();
            PlayerModel playerModel = mapController.mapModel.playerModel;
            Truck truck = mapController.mapModel.truck;
            Well well = mapController.mapModel.well;
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
            mapController.mapView.updateMap();
            playerViewInfo.updatePlayerInfoView(mapController.mapModel.playerModel);
        });
    }

    private void addListenerGrow() {
        playerViewAction.growButton.addActionListener(actionEvent -> {
            mapController.mapModel.playerModel.grow(mapController.mapModel.mapLands.get(mapController.mapModel.playerModel.getPoint()));
            mapController.mapView.updateMap();
            playerViewInfo.updatePlayerInfoView(mapController.mapModel.playerModel);
        });
    }

    private void addListenerMixKeju() {
        playerViewAction.mixKejuButton.addActionListener(actionEvent -> {
            Point playerPoint = mapController.mapModel.playerModel.getPoint();
            Point mixerPoint = mapController.mapModel.mixer.getPoint();
            if ((int) playerPoint.distanceSq(mixerPoint) < 2)
                mapController.mapModel.mixer.mix(mapController.mapModel.playerModel.getInventory(), new Keju());
            mapController.mapView.updateMap();
            playerViewInfo.updatePlayerInfoView(mapController.mapModel.playerModel);
        });
    }

    private void addListenerMixBurger() {
        playerViewAction.mixBurgerButton.addActionListener(actionEvent -> {
            Point playerPoint = mapController.mapModel.playerModel.getPoint();
            Point mixerPoint = mapController.mapModel.mixer.getPoint();
            if ((int) playerPoint.distanceSq(mixerPoint) < 2)
                mapController.mapModel.mixer.mix(mapController.mapModel.playerModel.getInventory(), new Burger());
            mapController.mapView.updateMap();
            playerViewInfo.updatePlayerInfoView(mapController.mapModel.playerModel);
        });
    }

    private void addListenerMixSate() {
        playerViewAction.mixSateButton.addActionListener(actionEvent -> {
            Point playerPoint = mapController.mapModel.playerModel.getPoint();
            Point mixerPoint = mapController.mapModel.mixer.getPoint();
            if ((int) playerPoint.distanceSq(mixerPoint) < 2)
                mapController.mapModel.mixer.mix(mapController.mapModel.playerModel.getInventory(), new Sate());
            mapController.mapView.updateMap();
            playerViewInfo.updatePlayerInfoView(mapController.mapModel.playerModel);
        });
    }
}
