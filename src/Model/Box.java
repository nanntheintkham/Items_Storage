package Model;

public interface Box {
    int itemCount = 0;
    int productionDate = 0;

    public void setItemCount(int itemCount);

    public default int getProductionDate() {
        return productionDate;
    }

    public default int getItemCount() {
        return itemCount;
    }

    @Override
    public String toString();
    
    String countAndDate();

    Object getItemType();
}
