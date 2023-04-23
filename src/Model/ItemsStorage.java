package Model;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class ItemsStorage<T extends Comparable<? super T>>{
    private ArrayList<T> items;
    private Scanner scanner;

    @Override
    public String toString() {
        return String.format(String.valueOf(items));
    }

    public void add(T item) {
        items.add(item);
    }

    public void list() {
        for (T t : items) {
            System.out.println(t);
        }
    }

    public String getClassName() {
        return ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();
    }

    public int getProductionDate() {
        return Box.productionDate;
    }

    public ItemsStorage() {
        this.scanner = new Scanner(System.in);
        this.items = new ArrayList<>();
    }

}


