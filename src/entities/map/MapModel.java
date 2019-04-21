package entities.map;

import entities.Cell.*;
import entities.animals.*;
import entities.player.PlayerModel;

import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static meta.Constant.*;

@SuppressWarnings("ALL")
public class MapModel {
    public HashMap<Point, Land> mapLands = new HashMap<>();
    public HashMap<Point, FarmAnimal> mapAnimals = new HashMap<>();
    public PlayerModel playerModel;
    public Truck truck;
    public Mixer mixer;
    public Well well;

    /**
     * 
     * Konstruktor dari Kelas MapModel
     * 
     */
    public MapModel() {
        initMapLands();
        initMapAnimals();
        this.playerModel = new PlayerModel(new Point(6, 10));
        this.truck = new Truck(new Point(0, 10));
        this.mixer = new Mixer(new Point(1, 10));
        this.well = new Well(new Point(4, 10));
    }

    /**
     *
     * Inisialisasi cells pada map
     * 
     */
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

    /**
     * 
     * Inisialisasi hewan-hewan pada map
     *
     */
    private void initMapAnimals() {
        mapAnimals.put(new Point(0, 0), new Ayam("gracia"));
        mapAnimals.put(new Point(0, 1), new Ayam("pablo"));
        mapAnimals.put(new Point(0, 2), new Bebek("esmeralda"));
        mapAnimals.put(new Point(5, 5), new Domba("antonio"));
        mapAnimals.put(new Point(0, 5), new Kelinci("fernando"));
        mapAnimals.put(new Point(2, 5), new Kelinci("dolores"));
        mapAnimals.put(new Point(8, 8), new Sapi("ramos"));
        mapAnimals.put(new Point(8, 3), new Sapi("hernanes"));
        mapAnimals.put(new Point(9, 9), new Unta("andreas"));
        mapAnimals.put(new Point(7, 5), new Unta("dominique"));
    }

    /**
     *
     * Methode untuk mencetak map
     * @return representaasi dari map
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < sizeRowMap; i++) {
            for (int j = 0; j < sizeColMap; j++) {
                Point currentPoint = new Point(i, j);
                if (currentPoint.equals(playerModel.getPoint()))
                    s.append(playerModel.render());
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

    /**
     *
     * Methode untuk mencetak map
     * @return Hewan yang di dekat player atau null
     */
    public FarmAnimal animalIsAroundPlayer() {
        for (int i = 0; i < 4; i++) {
            Point around = new Point(playerModel.getPoint());
            around.translate(upDown[i], leftRight[i]);
            if (mapAnimals.containsKey(around))
                return mapAnimals.get(around);
        }
        return null;
    }

    /**
     * Mengelola pergerakan pemain
     * @param dx
     * @param dy
     */
    public void playerMove(int dx, int dy) {
        Point targetPoint = new Point(playerModel.getPoint().x + dx, playerModel.getPoint().y + dy);
        if (isEmptyCell(targetPoint))
            playerModel.getPoint().translate(dx, dy);
    }

    /**
     * Mengecek apakah di cell dengan koordinat tertentu kosong atau tidak
     * @param point
     * @return boolean
     */
    private boolean isEmptyCell(Point point) {
        return (inRange(point)
                && !mapAnimals.containsKey(point)
                && (truck.getPoint() != point)
                && (mixer.getPoint() != point)
                && (well.getPoint() != point)
                && (playerModel.getPoint() != point));
    }

    /**
     * Mengecek apakah suatu koordinat masih ada di dalam batas map atau tidak
     * @param point
     * @return boolean
     */
    private boolean inRange(Point point) {
        return (point.x >= 0 && point.x < sizeRowMap) && (point.y >= 0 && point.y < sizeColMap);
    }

    /**
     *
     * Mengupdate semua barang yang ada di map setiap tick-nya
     *
     */
    void updateTick() {
        randomAnimalMove();
        truck.reduceCooldownTime();
        mapAnimals.entrySet().forEach(e -> {
            e.getValue().becomeHungrier();
            e.getValue().eat(mapLands.get(e.getKey()));
        });
        mapAnimals.entrySet().removeIf(e -> (e.getValue().isDeath()));
    }

    /**
     *
     * Mengupdate pergerakan semua hewan yang tersisa
     *
     */
    void randomAnimalMove() {
        int awalnya = mapAnimals.size();
        HashMap<Point, FarmAnimal> tempAnimals = new HashMap<>();
        Iterator it = mapAnimals.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            Point point = (Point) e.getKey();
            Point playerPoint = new Point(playerModel.getPoint());
            FarmAnimal farmAnimal = (FarmAnimal) e.getValue();

            int r = ThreadLocalRandom.current().nextInt(4);
            Point targetPoint = new Point(point.x + upDown[r], point.y + leftRight[r]);

            if (isEmptyCell(targetPoint)
                    && !tempAnimals.containsKey(targetPoint)
                    && playerPoint.x != targetPoint.x && playerPoint.y != targetPoint.y
                    && mapAnimals.get(point).isHabitat(mapLands.get(targetPoint).render())) {
                tempAnimals.put(targetPoint, farmAnimal);
                it.remove();
            }
        }
        mapAnimals.putAll(tempAnimals);
        assert(mapAnimals.size() == awalnya);
    }
}
