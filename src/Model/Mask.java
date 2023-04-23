package Model;

public class Mask extends Equipment {
    private final int filterSize;

    @Override
    public int getProductionDate() {
        return super.getProductionDate();
    }

    @Override
    public String toString() {
        return String.format("filter %d  Mask (%s), %s", super.toString(), filterSize, super.countAndDate());
    }

    @Override
    public Object getItemType() {
        return null;
    }

    public Mask(int safetyLevel, int filterSize, int itemCount, int productionDate) {
        super(safetyLevel, itemCount, productionDate);
        this.filterSize = filterSize;
    }
}
