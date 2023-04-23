package Model;

public abstract class Product implements Comparable<Product>, Box {
    private final int price;
    private int itemCount;
    private final int productionDate;


    @Override
    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    @Override
    public Object getItemType() {
        return null;
    }

    @Override
    public int getProductionDate() {
        return Box.super.getProductionDate();
    }

    @Override
    public int getItemCount() {
        return Box.super.getItemCount();
    }

    @Override
    public int compareTo(Product o) {
        return price - o.price;
    }

    @Override
    public String toString() {
        return String.format("(%d)", price);
    }

    @Override
    public String countAndDate(){ return String.format("%d, %d", itemCount, productionDate); }

    public Product(int price, int itemCount, int productionDate) {
        this.price = price;
        this.itemCount = itemCount;
        this.productionDate = productionDate;
    }

}
