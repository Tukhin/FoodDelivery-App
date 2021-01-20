
//Driver testing the ListArrayBasedPlus class.
import java.io.*;
public class P1Driver
{
    static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    static ListArrayBasedPlus list = new ListArrayBasedPlus();

    public static void main(String args[]) throws IOException
    {
        boolean done = false;

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

            int size = list.items.length;

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
                Object item = br.readLine().trim();
                System.out.println(item + "");

                System.out.print("\tEnter position to insert item in : ");
                int index = Integer.parseInt(br.readLine().trim());
                System.out.println(index);

                if(index < size) {
                    System.out.println("Item " + item + " inserted in position " + index + " in the list.\n");
                    list.add(index, item);
                }
                else
                {
                    System.out.println("Position specified is out of range!");
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
                    for(Object o: list.items)
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

    private static int search(Object searchedItem) {
        boolean found = false;
        int index1 = 0;
        for(int i = 0; i < list.numItems; i++) {
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
