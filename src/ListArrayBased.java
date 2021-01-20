/*
Describes the methods in the ListInterface
 */
import java.util.*;
public class ListArrayBased<T> implements ListInterface<T>
{

    protected T []items;  // an array of list items
    protected int numItems;  // number of items in list

    public ListArrayBased()
    {
        items = (T[])new Object[1];
        numItems = 0;
    }  // end default constructor

    public boolean isEmpty()
    {
        return (numItems == 0);
    } // end isEmpty

    public int size()
    {
        return numItems;
    }  // end size

    public void removeAll()
    {
        // Creates a new array; marks old array for
        // garbage collection.
        items = (T[])new Object[1];
        numItems = 0;
    } // end removeAll

    public void add(int index, T item)
    throws  ListIndexOutOfBoundsException
    {
        if (numItems > items.length)  //fixes implementation errors
        {
            throw new ListException("ListException on add");
        }  // end if
        if (index >= 0 && index <= numItems)
        {
            // make room for new element by shifting all items at
            // positions >= index toward the end of the
            // list (no shift if index == numItems+1)
            for (int pos = numItems-1; pos >= index; pos--)  //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException
            {
                items[pos+1] = items[pos];
            }

            // insert new item
            items[index] = item;
            numItems++;
        }
        else
        {

            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on add");
        }
    } //end add

    public T get(int index)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            return items[index];
        }
        else
        {
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on get");
        }
    } // end get

    public void remove(int index)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            // delete item by shifting all items at
            // positions > index toward the beginning of the list
            // (no shift if index == size)
            for (int pos = index+1; pos < numItems; pos++) //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException

            {
                items[pos-1] = items[pos];
            }  // end for

            List<Object> newItems = new ArrayList<Object>();
            for(Object o : items) {
                if(o != null) {
                    newItems.add(o);
                }
            }
            numItems--;
            items = newItems.toArray((T[])new Object[numItems]);    //fixes memory leak
        }
        else
        {
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on remove");
        }
    } //end remove
}
