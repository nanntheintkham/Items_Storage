package Model;

public class Pencil extends Product{
    private final String color;

    @Override
    public String toString() {
        return String.format("%s pencil%s, %s", color, super.toString(), super.countAndDate());
    }

    public Pencil(int price, String color, int itemCount, int productionDate) {
        super(price, itemCount, productionDate);
        this.color = color;
    }
}
