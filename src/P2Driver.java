
//Driver testing the ListArrayBasedPlus class as a generic.
import java.io.*;
public class P2Driver
{
    static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    static ListArrayBasedPlus<String> list = new ListArrayBasedPlus<String>();

    public static void main(String args[]) throws IOException
    {
        boolean done = false;

        int size;

        System.out.println("Select from the following menu: ");
        System.out.println("1. Insert item to list.");
        System.out.println("2. Remove item from list.");
        System.out.println("3. Get item from list.");
        System.out.println("4. Search for a specified item in the list.");
        System.out.println("5. Clear list.");
        System.out.println("6. Print size and content of list.");
        System.out.println("7. Exit program.");

        do
        {
            System.out.println();
            System.out.println("Make your menu selection now: ");

            int menuChoice = Integer.parseInt(br.readLine().trim());
            System.out.print(menuChoice);
            System.out.println();

            size = list.size();

            switch(menuChoice)
            {
            case 7:
                System.out.println();
                System.out.println("Exiting program...Good bye");
                done = true;
                break;

            case 1:
                System.out.println("You are now inserting an item into the list.");
                System.out.print("\tEnter item: ");
                String item = br.readLine().trim();
                System.out.println(item + "");


                if(search(item) != -1) {
                    System.out.println("This is a duplicate item");
                } else {
                    boolean found = false;
                    int index1 = 0;
                    ListArrayBasedPlus<String> newList = new ListArrayBasedPlus<String>();
                    for(int i = 0; i < list.numItems; i++) {
                        if(item.compareTo(list.get(i)) > 0) {
                            index1 = i + 1;
                        }
                    }
                    if(!found == true) {
                        list.add(index1, item);
                    }

                }


                break;
            case 2:

                if(size != 0) {
                    System.out.println("\tEnter position to remove item from");
                    int indexRemove = Integer.parseInt(br.readLine().trim());
                    System.out.print(indexRemove);

                    if(indexRemove < size) {
                        list.remove(indexRemove);
                    }
                }
                else
                {
                    System.out.println("Position specified is out of range!");
                }

                break;
            case 3:
                if(size != 0) {
                    System.out.println("\tEnter position to retrieve item from :");
                    int getIndex = Integer.parseInt(br.readLine().trim());
                    System.out.print(list.get(getIndex));
                    System.out.println("Item " + list.get(getIndex) + " has been retrieved from position " + getIndex + " in the list.");
                }
                else
                {
                    System.out.println("List is empty");
                }

                break;

            case 4:

                System.out.println("Enter the item to be searched for: ");
                Object searchedItem = br.readLine().trim();
                System.out.print(searchedItem);

                System.out.println(search(searchedItem));




                break;


            case 5:
                if(size != 0) {
                    list.removeAll();
                }
                else
                {
                    System.out.println("List is empty.");
                }
                break;
            case 6:
                if(!(size == 0))
                {
                    System.out.println("List of size " + size + " has the following items : ");
                    for(String o: list.items)
                    {
                        if(!(o == null)) {
                            System.out.print(o + " ");
                        }
                    }
                }
                else
                {
                    System.out.println("List is empty.");
                }
                break;
            }

        }

        while(!done);
        br.close();
    }






    private static int search(Object searchedItem) { // modified seq search I
        boolean found = false;
        int index1 = 0;
        for(int i = 0; i < list.size(); i++) {
            if(searchedItem.equals(list.get(i))) {
                found = true;
                index1 = i;
            }
        }

        if(found == true) {
            return index1;
        } else {
            return -1;
        }

    }
}
