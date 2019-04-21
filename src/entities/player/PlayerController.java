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

    /**
     * Konstruktor kelas PlayerController
     * @param mapController
     * @param playerModel
     * @param playerViewAction
     * @param playerViewInfo
     */
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

    /**
     * Methode yang mengelola ketika player berbicara dengan animal
     * I.S. Button Talk ditekan
     * F.S. Muncul dialog
     */
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

    /**
     * Methode yang mengelola ketika player membunuh animal
     * I.S. Button Kill ditekan
     * F.S. Jika terdapat animal, maka akan didapat meat-nya di inventory
     */
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

    /**
     * Methode yang mengelola ketika player melakukan "interact" dengan animal
     * I.S. Button Interact ditekan
     * F.S. Jika hewan tersebut memiliki product, maka akan disimpan di inventory
     */
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

    /**
     * Methode yang mengelola ketika player ingin menanam cell
     * I.S. Button Grow ditekan
     * F.S. Jumlah air berkurang dan tumbuh rumput
     */
    private void addListenerGrow() {
        playerViewAction.growButton.addActionListener(actionEvent -> {
            mapController.mapModel.playerModel.grow(mapController.mapModel.mapLands.get(mapController.mapModel.playerModel.getPoint()));
            mapController.mapView.updateMap();
            playerViewInfo.updatePlayerInfoView(mapController.mapModel.playerModel);
        });
    }

    /**
     * Methode yang mengelola ketika player ingin membuat keju
     * I.S. Button MixKeju ditekan
     * F.S. Jika disekitar ada Mixer dan bahan pembuat keju ada di inventory, maka akan terbentuk Keju
     */
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

    /**
     * Methode yang mengelola ketika player ingin membuat burger
     * I.S. Button MixBurger ditekan
     * F.S. Jika disekitar ada Mixer dan bahan pembuat burger ada di inventory, maka akan terbentuk Burger
     */
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

    /**
     * Methode yang mengelola ketika player ingin membuat sate
     * I.S. Button MixSate ditekan
     * F.S. Jika disekitar ada Mixer dan bahan pembuat sate ada di inventory, maka akan terbentuk Sate
     */
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
