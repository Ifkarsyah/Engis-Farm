package entities.product;

public class Keju extends SideProduct {
    public Keju() {
        super(100000, "Keju");
        ingredients.add(new SusuSapi());
        ingredients.add(new SusuUnta());
    }
}
