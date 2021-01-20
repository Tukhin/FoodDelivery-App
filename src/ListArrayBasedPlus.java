/*
Adds the ability to reverse and resize to the List
 */
public class ListArrayBasedPlus<T> extends ListArrayBased<T> {



    public ListArrayBasedPlus() {

    }

    public void add(int index, T item)
    throws ListIndexOutOfBoundsException
    {
        //checks to see if array needs to be extended
        if((index + 1) == items.length)
        {
            resize();
        }

        super.add(index, item);
    }

    public void removeAll() {

        super.removeAll();
    }

    public void resize() throws ListIndexOutOfBoundsException
    {
        T []extendedArray =(T[]) new Object[items.length * 2];
        for(int i = 0; i < items.length; i++) {
            extendedArray[i] = items[i];

        }

        items = extendedArray;
    }

    //reverses the array of items through the use of an intermediate array
    public void reverse()
    throws ListIndexOutOfBoundsException
    {
        int counter = items.length - 1;
        int index = 0;
        T []revItems = (T[])new Object[items.length];
        while(0 <= counter) {
            revItems[counter] = items[index];
            index++;
            counter--;
        }

        items = revItems;
    }


}
