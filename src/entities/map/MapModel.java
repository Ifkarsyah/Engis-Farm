package entities.map;

import entities.Cell.*;
import entities.Player;
import entities.animals.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static meta.Constant.*;

@SuppressWarnings("ALL")
class MapModel {
    HashMap<Point, Land> mapLands = new HashMap<>();
    HashMap<Point, FarmAnimal> mapAnimals = new HashMap<>();
    Player player;
    Truck truck;
    Mixer mixer;
    Well well;

    MapModel() {
        initMapLands();
        initMapAnimals();
        this.player = new Player(new Point(6, 10));
        this.truck = new Truck(new Point(0, 10));
        this.mixer = new Mixer(new Point(1, 10));
        this.well = new Well(new Point(4, 10));
    }

    private void initMapLands() {
        for (int i = 0; i < sizeRowMap; i++)
            for (int j = 0; j < sizeColMap; j++)
                mapLands.put(new Point(i, j), new Grassland(new Point(i, j)));
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                mapLands.put(new Point(i, j), new Coop(new Point(i, j)));
        for (int i = 0; i < 6; i++)
            for (int j = 4; j < 8; j++)
                mapLands.put(new Point(i, j), new Barn(new Point(i, j)));
    }

    private void initMapAnimals() {
        mapAnimals.put(new Point(0, 0), new Ayam("gracia"));
        mapAnimals.put(new Point(0, 2), new Bebek("esmeralda"));
        mapAnimals.put(new Point(5, 5), new Domba("antonio"));
        mapAnimals.put(new Point(0, 5), new Kelinci("fernando"));
        mapAnimals.put(new Point(8, 8), new Sapi("ramos"));
        mapAnimals.put(new Point(9, 9), new Unta("andreas"));
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < sizeRowMap; i++) {
            for (int j = 0; j < sizeColMap; j++) {
                Point currentPoint = new Point(i, j);
                if (currentPoint.equals(player.getPoint()))
                    s.append(player.render());
                else if (currentPoint.equals(truck.getPoint()))
                    s.append(truck.render());
                else if (currentPoint.equals(mixer.getPoint()))
                    s.append(mixer.render());
                else if (currentPoint.equals(well.getPoint()))
                    s.append(well.render());
                else if (mapAnimals.containsKey(currentPoint))
                    s.append(mapAnimals.get(currentPoint).render());
                else
                    s.append(mapLands.get(currentPoint).render());
            }
            s.append('\n');
        }
        return s.toString();
    }

    FarmAnimal animalIsAroundPlayer() {
        for (int i = 0; i < 4; i++) {
            Point around = new Point(player.getPoint());
            around.translate(upDown[i], leftRight[i]);
            if (mapAnimals.containsKey(around))
                return mapAnimals.get(around);
        }
        return null;
    }

    void playerMove(int dx, int dy) {
        Point targetPoint = new Point(player.getPoint().x + dx, player.getPoint().y + dy);
        if (isEmptyCell(targetPoint))
            player.getPoint().translate(dx, dy);
    }

    private boolean isEmptyCell(Point point) {
        return (inRange(point) && !mapAnimals.containsKey(point) && (truck.getPoint() != point) && (mixer.getPoint() != point) && (well.getPoint() != point) && (player.getPoint() != point));
    }

    private boolean inRange(Point point) {
        return (point.x >= 0 && point.x < sizeRowMap) && (point.y >= 0 && point.y < sizeColMap);
    }

    void updateTick() {
        randomAnimalMove();
        truck.reduceCooldownTime();
        mapAnimals.entrySet().forEach(e -> {
            e.getValue().becomeHungrier();
            e.getValue().eat(mapLands.get(e.getKey()));
        });
        mapAnimals.entrySet().removeIf(e -> (e.getValue().isStarving()));
    }

    void randomAnimalMove() {
        HashMap<Point, FarmAnimal> tempAnimals = new HashMap<>();
        Iterator it = mapAnimals.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();

            Point point = (Point) e.getKey();
            FarmAnimal farmAnimal = (FarmAnimal) e.getValue();

            int r = ThreadLocalRandom.current().nextInt(4);
            int dx = upDown[r];
            int dy = leftRight[r];
            Point targetPoint = new Point(point.x + dx, point.y + dy);

            if (isEmptyCell(targetPoint)) {
                if (mapLands.get(point).type.equals(mapLands.get(targetPoint).type)) {
                    tempAnimals.put(targetPoint, farmAnimal);
                    it.remove();
                }
            }
        }
        mapAnimals.putAll(tempAnimals);
    }
}
