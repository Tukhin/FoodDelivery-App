
public class Item<T, KT extends
    Comparable<? super KT>> extends KeyedItem<KT> {

    private T item;


    public Item(T item, KT key) {
        super(key);
        this.item = item;

        // TODO Auto-generated constructor stub
    }

    public T getItem() {
        return item;
    }
    public String toString() {
        return getKey() + " # " + item;
    }

}

