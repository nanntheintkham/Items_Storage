package Model;

public class Gloves extends Equipment {
    private final int size;

    @Override
    public int getProductionDate() {
        return super.getProductionDate();
    }

    @Override
    public String toString() {
        return String.format("size %d Gloves (%s), %s", super.toString(), size, super.countAndDate());
    }

    @Override
    public Object getItemType() {
        return null;
    }

    public Gloves(int safetyLevel, int size, int itemCount, int productionDate) {
        super(safetyLevel, itemCount, productionDate);
        this.size = size;
    }
}
