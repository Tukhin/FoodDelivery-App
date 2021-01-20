/*
* Describes the implementation of an ascending ordered list of strings.
* This class describes the methods that are introduces in the Interface.
*
* Nasim Tukhi
*/
public class AscendinglyOrderedStringList implements AscendinglyOrderedStringListInterface

{

    private static final int MAX_LIST = 8;

    protected String[] items; // an array of list items

    protected int numItems;


    public AscendinglyOrderedStringList()

    {

        items = new String[MAX_LIST];

        numItems = 0;

    }

    public boolean isEmpty()

    {

        return (numItems == 0);

    }



    public int size()

    {

        return numItems;

    }



    //Adds an item while maintaining ascending order without repetition.
    //The determination of hierarchy is described in the search method below.
    public void add(String item) throws ListIndexOutOfBoundsException

    {

        int searchValue = search(item); //describes the position of the item

        if (numItems == items.length)

        {

            resize();

        }
        if(searchValue >= 0) {
            System.out.println("Item is already in list.");

        } else {

            int placementValue = -searchValue - 1; //prepares the index for which the item will be placed in the array.

            //places the new item into the array
            for (int pos = numItems-1; pos >= placementValue; pos--)

            {

                items[pos+1] = items[pos];

            }

            items[placementValue] = item;
            numItems++;

        }


    }



    public String get(int index) throws ListIndexOutOfBoundsException

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

    }



    public void remove(int index) throws ListIndexOutOfBoundsException

    {

        if (index >= 0 && index < numItems)

        {

            for(int pos = index+1; pos < numItems; pos++)

            {

                items[pos-1] = items[pos];

            }

            items[numItems - 1] = null;

            numItems--;

        }

        else

        {

            throw new ListIndexOutOfBoundsException(

                "ListIndexOutOfBoundsException on remove");

        }

    }


    public int search(String item) {

        int pos = 0;
        int low = 0;
        int high = numItems - 1;
        int mid = 0;

        if (numItems > 0) {

            //binary search
            while (low <= high) {
                mid = (high + low) / 2;

                if (item.compareTo(items[mid]) == 0) {

                    pos = mid;
                    return pos;
                }

                else if(item.compareTo(items[mid]) < 0)	{
                    high = mid - 1;
                }

                else
                {

                    low = mid + 1;

                }

            }

            if(item.compareTo(items[numItems - 1]) > 0) {
                return -numItems - 1;

            } else if(item.compareTo(items[numItems-1]) < 0) {

                return -low - 1;
            }


            return mid;
        }


        return -1;

    }

    public void clear()

    {

        items = new String[MAX_LIST];

        numItems = 0;

    }



    public String toString()

    {

        String itemsString = "";

        for(int i = 0; i < numItems; i++)

        {

            itemsString += items[i] + " ";

        }

        return itemsString;

    }



    private void resize()

    throws ListIndexOutOfBoundsException

    {

        String[] emptyList = new String[(2 * (numItems + 1))];

        for (int i = 0; i < numItems; i++)

        {

            emptyList[i] = items[i];

        }

        items = emptyList;

    }

}
