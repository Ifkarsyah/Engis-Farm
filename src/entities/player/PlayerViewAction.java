package entities.player;

import entities.Cell.Truck;
import entities.Cell.Well;
import entities.animals.FarmAnimal;
import entities.map.MapModel;
import entities.product.Burger;
import entities.product.Keju;
import entities.product.Sate;

import javax.swing.*;
import java.awt.*;

public class PlayerViewAction extends JPanel {
    public PlayerModel playerModel;
    public MapModel mapModel;
    public JButton killButton;
    public JButton interactButton;
    public JButton mixKejuButton;
    public JButton mixSateButton;
    public JButton mixBurgerButton;
    public JButton growButton;

    public PlayerViewAction(PlayerModel playerModel, MapModel mapModel) {
        super();
        this.playerModel = playerModel;
        this.mapModel = mapModel;
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
        });
    }

    public void addListenerGrow() {
        growButton.addActionListener(actionEvent -> {
            mapModel.playerModel.grow(mapModel.mapLands.get(mapModel.playerModel.getPoint()));
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
        });
    }

    public void addListenerMixBurger() {
        Point playerPoint = mapModel.playerModel.getPoint();
        Point mixerPoint = mapModel.mixer.getPoint();

        mixBurgerButton.addActionListener(actionEvent -> {
            if ((int) playerPoint.distanceSq(mixerPoint) < 2)
                mapModel.mixer.mix(mapModel.playerModel.getInventory(), new Burger());
        });
    }

    public void addListenerMixKeju() {
        Point playerPoint = mapModel.playerModel.getPoint();
        Point mixerPoint = mapModel.mixer.getPoint();

        mixKejuButton.addActionListener(actionEvent -> {
            if ((int) playerPoint.distanceSq(mixerPoint) < 2)
                mapModel.mixer.mix(mapModel.playerModel.getInventory(), new Keju());
        });
    }

    public void addListenerMixSate() {
        Point playerPoint = mapModel.playerModel.getPoint();
        Point mixerPoint = mapModel.mixer.getPoint();

        mixSateButton.addActionListener(actionEvent -> {
            if ((int) playerPoint.distanceSq(mixerPoint) < 2)
                mapModel.mixer.mix(mapModel.playerModel.getInventory(), new Sate());
        });
    }
}