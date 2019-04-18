package entities.map;

import entities.animals.FarmAnimal;
import entities.product.Burger;
import entities.product.Keju;
import entities.product.Sate;

import java.awt.*;
import java.util.Scanner;

public class MapControllerCLI {
    private static final MapModel mapModel = new MapModel();
    private static final Point truckPoint = mapModel.truck.getPoint();
    private static final Point mixerPoint = mapModel.mixer.getPoint();
    private static final Point wellPoint = mapModel.well.getPoint();

    public static void main(String[] args) {
        while (!mapModel.mapAnimals.isEmpty()) {
            System.out.println(mapModel);
            Scanner sc = new Scanner(System.in);
            System.out.print("Command: ");
            String cmd = sc.nextLine();

            FarmAnimal targetAnimal = mapModel.animalIsAroundPlayer();
            Point playerPoint = mapModel.playerModel.getPoint();

            switch (cmd) {
                case "talk":
                    if (targetAnimal != null)
                        mapModel.playerModel.talk(targetAnimal);
                    break;
                //                case "interact":
                //                    if (targetAnimal != null) {
                //                        try {
                //                            mapModel.playerModel.interact(targetAnimal);
                //                        } catch (Exception e) {
                //                            System.out.println(e.getMessage());
                //                        }
                //                    } else if ((int) playerPoint.distanceSq(truckPoint) < 2)
                //                        mapModel.playerModel.interact(mapModel.truck);
                //                    else if ((int) playerPoint.distanceSq(wellPoint) < 2)
                //                        mapModel.playerModel.interact(mapModel.well);
                //                    break;
                case "kill":
                    if (targetAnimal != null) {
                        if (targetAnimal.isProductReady) {
                            mapModel.playerModel.kill(targetAnimal);
                            mapModel.mapAnimals.values().remove(targetAnimal);
                        }
                    }
                    break;
                case "grow":
                    mapModel.playerModel.grow(mapModel.mapLands.get(playerPoint));
                    break;
                case "mix":
                    if ((int) playerPoint.distanceSq(mixerPoint) < 2) {
                        System.out.println("Insert your desired sideProduct?");
                        cmd = sc.nextLine();
                        switch (cmd) {
                            case "burger":
                                mapModel.mixer.mix(mapModel.playerModel.getInventory(), new Burger());
                                break;
                            case "sate":
                                mapModel.mixer.mix(mapModel.playerModel.getInventory(), new Sate());
                                break;
                            case "keju":
                                mapModel.mixer.mix(mapModel.playerModel.getInventory(), new Keju());
                                break;
                            default:
                                System.out.println("typo");
                                break;
                        }
                    }

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
            System.out.println(mapModel.playerModel);
        }
    }
}
