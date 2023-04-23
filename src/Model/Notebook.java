package Model;

public class Notebook extends Product{
    private final int pages;

    @Override
    public String toString() {
        return  String.format("%d pages notebook(%s), %s", pages, super.toString(), super.countAndDate());
    }

    public Notebook(int price, int pages, int itemCount, int productionDate) {
        super(price, itemCount, productionDate);
        this.pages = pages;
    }
}
