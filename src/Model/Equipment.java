package Model;

public abstract class Equipment implements Comparable<Equipment>, Box {
    private final int safetyLevel;
    private final int productionDate;
    private int itemCount;

    @Override
    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    @Override
    public int getItemCount() {
        return Box.super.getItemCount();
    }

    @Override
    public int compareTo(Equipment o) {
        return safetyLevel - o.safetyLevel;
    }

    @Override
    public String toString() {
        return String.format("safetyLevel_%d", safetyLevel);
    }

    @Override
    public String countAndDate(){ return String.format("%d, %d", itemCount, productionDate); }

    public Equipment(int safetyLevel, int itemCount, int productionDate) {
        this.safetyLevel = safetyLevel;
        this.itemCount = itemCount;
        this.productionDate = productionDate;
    }
}

