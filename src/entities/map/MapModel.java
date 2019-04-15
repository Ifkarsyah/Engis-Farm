package entities.map;

import entities.Cell.*;
import entities.Player;
import entities.animals.*;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static meta.Constant.*;

class MapModel {
    HashMap<Point, FarmAnimal> mapAnimals = new HashMap<>();
    final HashMap<Point, Land> mapLands = new HashMap<>();
    Player player; Truck truck;Mixer mixer; Well well;

    MapModel() {
        initMapLands();
        initMapAnimals();
        this.player = new Player(new Point(6, 10), 20, 0);
        this.truck = new Truck(new Point(0, 10));
        this.mixer = new Mixer(new Point(1, 10));
        this.well = new Well(new Point(4, 10));
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i=0; i<sizeRowMap; i++){
            for (int j=0; j<sizeColMap; j++){
                Point currentPoint = new Point(i,j);
                if (currentPoint.equals(player.getPoint())) s.append(player.render());
                else if (currentPoint.equals(truck.getPoint())) s.append(truck.render());
                else if (currentPoint.equals(mixer.getPoint())) s.append(mixer.render());
                else if (currentPoint.equals(well.getPoint())) s.append(well.render());
                else if (mapAnimals.containsKey(currentPoint)) s.append(mapAnimals.get(currentPoint).render());
                else s.append(mapLands.get(currentPoint).render());
            }
            s.append('\n');
        }
        return s.toString();
    }

    private void initMapAnimals() {
        mapAnimals.put(new Point(0,0), new Ayam("gracia"));
        mapAnimals.put(new Point(0, 2), new Bebek("esmeralda"));
        mapAnimals.put(new Point(5, 5), new Domba("antonio"));
        mapAnimals.put(new Point(0, 5), new Kelinci("fernando"));
        mapAnimals.put(new Point(8, 8), new Sapi("ramos"));
        mapAnimals.put(new Point(9, 9), new Unta("andreas"));
    }

    private void initMapLands() {
        for (int i = 0; i < sizeRowMap; i++) for (int j = 0; j < sizeColMap; j++)
            mapLands.put(new Point(i, j), new Grassland(new Point(i, j)));
        for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++)
            mapLands.put(new Point(i, j), new Coop(new Point(i, j)));
        for (int i = 0; i < 6; i++) for (int j = 4; j < 8; j++)
            mapLands.put(new Point(i, j), new Barn(new Point(i, j)));
    }

    FarmAnimal animalIsAroundPlayer() {
        for (int i=0; i<4; i++) {
            Point around = new Point(player.getPoint());
            around.translate(upDown[i], leftRight[i]);
            if (mapAnimals.containsKey(around)) return mapAnimals.get(around);
        }
        return null;
    }

    private boolean inRange(Point point){
        return (point.x >= 0 && point.x < sizeRowMap) && (point.y >= 0 && point.y < sizeColMap);
    }

    private boolean isEmptyCell(Point point){
        return (inRange(point)
                && !mapAnimals.containsKey(point)
                && (truck.getPoint() != point)
                && (mixer.getPoint() != point)
                && (well.getPoint() != point)
                && (player.getPoint() != point));
    }
    void playerMove(int dx, int dy){
        Point targetPoint = new Point(player.getPoint().x + dx, player.getPoint().y + dy);
            if (isEmptyCell(targetPoint)) player.getPoint().translate(dx, dy);
    }

    void randomMoveAnimal(){
        HashSet<Point> hasMove = new HashSet<>();
        for (int i=0; i<sizeRowMap; i++){
            for (int j=0; j<sizeColMap; j++){
                int r = ThreadLocalRandom.current().nextInt(4 );
                int dx = upDown[r]; int dy = leftRight[r];

                if (!hasMove.contains(new Point(i,j))){
                    if (mapAnimals.containsKey(new Point(i,j))){

                        System.out.println("halo");
                        FarmAnimal farmAnimal = mapAnimals.remove(new Point(i,j));

                        Point currentPoint = farmAnimal.getPoint();
                        Point targetPoint = new Point(currentPoint.x + dx, currentPoint.y + dy);

                        if (isEmptyCell(targetPoint)){

                            if (mapLands.get(currentPoint).type.equals(mapLands.get(targetPoint).type)){
                                mapAnimals.put(targetPoint, farmAnimal);
                                hasMove.add(targetPoint);
                            }

                        }

                    }
                }
            }
        }
    }

    void updateTick(){
        randomMoveAnimal();
        for(Map.Entry<Point, FarmAnimal> e : mapAnimals.entrySet()) e.getValue().becomeHungrier();
    }
}
