package entities.map;

import entities.animals.FarmAnimal;
import entities.product.Burger;

import java.awt.*;
import java.util.Scanner;

public class MapController {
    private static MapModel mapModel = new MapModel();
    private static Point truckPoint = mapModel.truck.getPoint();
    private static Point mixerPoint = mapModel.mixer.getPoint();
    private static Point wellPoint = mapModel.well.getPoint();

    public static void main(String[] args) {
        while (!mapModel.mapAnimals.isEmpty()) {
            System.out.println(mapModel);
            Scanner sc = new Scanner(System.in);
            System.out.print("Command: ");
            String cmd = sc.nextLine();

            FarmAnimal targetAnimal = mapModel.animalIsAroundPlayer();
            Point playerPoint = mapModel.player.getPoint();

            switch (cmd) {
                case "talk":
                    if (targetAnimal != null)
                        mapModel.player.talk(targetAnimal);
                    break;
                case "interact":
                    if (targetAnimal != null) {
                        try {
                            mapModel.player.interact(targetAnimal);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else if ((int) playerPoint.distanceSq(truckPoint) < 2)
                        mapModel.player.interact(mapModel.truck);
                    else if ((int) playerPoint.distanceSq(wellPoint) < 2)
                        mapModel.player.interact(mapModel.well);
                    break;
                case "kill":
                    if (targetAnimal != null) {
                        if (targetAnimal.isProductReady) {
                            mapModel.player.kill(targetAnimal);
                            mapModel.mapAnimals.values().remove(targetAnimal);
                        }
                    }
                    break;
                case "grow":
                    mapModel.player.grow(mapModel.mapLands.get(playerPoint));
                    break;
                case "mix":
                    if ((int) playerPoint.distanceSq(mixerPoint) < 2)
                        mapModel.mixer.mix(mapModel.player.getInventory(), new Burger());
                    break;
                case "a":
                    mapModel.playerMove(0, -1);
                    break;
                case "s":
                    mapModel.playerMove(1, 0);
                    break;
                case "d":
                    mapModel.playerMove(0, 1);
                    break;
                case "w":
                    mapModel.playerMove(-1, 0);
                    break;
                default:
                    System.out.println("typo");
            }

            mapModel.updateTick();
            System.out.println("NumOfAnimals:" + mapModel.mapAnimals.size());
            System.out.println(mapModel.player);
        }
    }
}
