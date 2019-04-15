package entities.product;


public class Burger extends SideProduct {
    public Burger() {
        super(20000, "Burger");
        ingredients.add(new DagingUnta());
        ingredients.add(new DagingKelinci());
        ingredients.add(new TelurAyam());
        ingredients.add(new SusuSapi());
        ingredients.add(new Keju());
    }
}
