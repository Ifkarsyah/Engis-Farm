package entities.product;


class Sate extends SideProduct {
    public Sate() {
        super(45000, "Sate");
        ingredients.add(new DagingAyam());
        ingredients.add(new DagingBebek());
        ingredients.add(new DagingDomba());
        ingredients.add(new DagingKelinci());
        ingredients.add(new DagingSapi());
        ingredients.add(new DagingUnta());
        ingredients.add(new TelurBebek());
    }
}
