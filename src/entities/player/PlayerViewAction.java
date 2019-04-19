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
    public MapView mapView;
    public PlayerModel playerModel;
    public MapModel mapModel;
    public JButton killButton;
    public JButton interactButton;
    public JButton mixKejuButton;
    public JButton mixSateButton;
    public JButton mixBurgerButton;
    public JButton growButton;

    public PlayerViewAction(PlayerModel playerModel, MapModel mapModel, MapView mapView) {
        super();
        this.playerModel = playerModel;
        this.mapModel = mapModel;
        this.mapView = mapView;
        killButton = new JButton("KILL");
        interactButton = new JButton("INTERACT");
        mixKejuButton = new JButton("MIX KEJU");
        mixSateButton = new JButton("MIX SATE");
        mixBurgerButton = new JButton("MIX BURGER");
        growButton = new JButton("GROW");
        add(killButton);
        add(interactButton);
        add(mixKejuButton);
        add(mixSateButton);
        add(mixBurgerButton);
        add(growButton);

        addListenerKill();
        addListenerGrow();
        addListenerInteract();
        addListenerMixBurger();
        addListenerMixKeju();
        addListenerMixSate();
    }

    public void addListenerKill() {
        FarmAnimal targetAnimal = mapModel.animalIsAroundPlayer();
        killButton.addActionListener(actionEvent -> {
            if (targetAnimal != null) {
                if (targetAnimal.isProductReady) {
                    mapModel.playerModel.kill(targetAnimal);
                    mapModel.mapAnimals.values().remove(targetAnimal);
                }
            }
            System.out.println("killButton pressed");
            mapView.updateMap();
        });

    }

    public void addListenerGrow() {
        growButton.addActionListener(actionEvent -> {
            mapModel.playerModel.grow(mapModel.mapLands.get(mapModel.playerModel.getPoint()));
            System.out.println("growButton pressed");
            mapView.updateMap();
        });

    }

    public void addListenerInteract() {
        FarmAnimal targetAnimal = mapModel.animalIsAroundPlayer();
        Point playerPoint = mapModel.playerModel.getPoint();
        Point truckPoint = mapModel.truck.getPoint();
        Point wellPoint = mapModel.well.getPoint();
        PlayerModel playerModel = mapModel.playerModel;
        Truck truck = mapModel.truck;
        Well well = mapModel.well;


        interactButton.addActionListener(actionEvent -> {
            if (targetAnimal != null) {
                try {
                    playerModel.interact(targetAnimal);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if ((int) playerPoint.distanceSq(truckPoint) < 2)
                playerModel.interact(truck);
            else if ((int) playerPoint.distanceSq(wellPoint) < 2)
                playerModel.interact(well);
            System.out.println("interactButton pressed");
            mapView.updateMap();
        });
    }

    public void addListenerMixBurger() {
        Point playerPoint = mapModel.playerModel.getPoint();
        Point mixerPoint = mapModel.mixer.getPoint();

        mixBurgerButton.addActionListener(actionEvent -> {
            if ((int) playerPoint.distanceSq(mixerPoint) < 2)
                mapModel.mixer.mix(mapModel.playerModel.getInventory(), new Burger());
            System.out.println("mixBurgerButton pressed");
            mapView.updateMap();
        });
    }

    public void addListenerMixKeju() {
        Point playerPoint = mapModel.playerModel.getPoint();
        Point mixerPoint = mapModel.mixer.getPoint();

        mixKejuButton.addActionListener(actionEvent -> {
            if ((int) playerPoint.distanceSq(mixerPoint) < 2)
                mapModel.mixer.mix(mapModel.playerModel.getInventory(), new Keju());
            System.out.println("mixBurgerButton pressed");
            mapView.updateMap();
        });
    }

    public void addListenerMixSate() {
        Point playerPoint = mapModel.playerModel.getPoint();
        Point mixerPoint = mapModel.mixer.getPoint();

        mixSateButton.addActionListener(actionEvent -> {
            if ((int) playerPoint.distanceSq(mixerPoint) < 2)
                mapModel.mixer.mix(mapModel.playerModel.getInventory(), new Sate());
            System.out.println("mixBurgerButton pressed");
            mapView.updateMap();
        });
    }
}