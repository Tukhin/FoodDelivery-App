/*
*Driver testing the AscendinglyOrderedStringList class.
*/

import java.io.*;


public class P3Driver {



    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

        AscendinglyOrderedStringList newList = new AscendinglyOrderedStringList();



        boolean done = false;



        System.out.println("Menu");

        System.out.println("1. Insert item to list.");

        System.out.println("2. Remove item from list.");

        System.out.println("3. Search for a specified item in the list.");

        System.out.println("4. Clear list.");

        System.out.println("5. Print size and content of list.");

        System.out.println("6. Exit program.");



        do

        {

            System.out.println();

            System.out.print("Make your menu selection now: ");



            int menuChoice = Integer.parseInt(br.readLine());

            System.out.print(menuChoice);



            System.out.println();

            switch(menuChoice)

            {

            case 6:

                System.out.println();

                System.out.println("Exiting program...Good bye");

                done = true;

                break;



            case 1:

                System.out.println("You are now inserting an item into the list.");

                System.out.print("\tEnter item: ");

                String item = br.readLine();

                System.out.print(item.toString());

                System.out.println();




                newList.add(item);

                break;

            case 2:

                if(newList.size() == 0)

                {

                    System.out.println();

                    System.out.println("List is empty.");

                }

                else

                {

                    System.out.print("\tEnter position to remove item from : ");

                    int indexRemove = Integer.parseInt(br.readLine());

                    System.out.print(indexRemove);

                    if(indexRemove >= 0 && indexRemove < newList.numItems)

                    {

                        System.out.println();

                        System.out.println("Item " + newList.get(indexRemove) + " removed from position " + indexRemove

                                           + " in the list.");

                        newList.remove(indexRemove);

                    }

                    else

                    {

                        System.out.println("Position specified is out of range!");

                    }

                }

                break;

            case 3:

                if(newList.size() == 0)

                {

                    System.out.println("List is empty.");

                }

                else

                {

                    System.out.println("Please enter the item you would like to search for: ");

                    String key = br.readLine();

                    System.out.print(key);



                    System.out.println(newList.search(key));

                }

                break;

            case 4:

                if(newList.size() == 0)

                {

                    System.out.println("List is empty.");

                }

                else

                {

                    newList.clear();

                }

                break;

            case 5:

                if(newList.size() == 0)

                {

                    System.out.println("List is empty.");

                }

                else

                {

                    System.out.println("List of size " + newList.size() + " has the following items : " + newList.toString());

                }

                break;

            }



        }



        while(!done);

        br.close();



    }

}
