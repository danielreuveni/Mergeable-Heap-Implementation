import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.lang.String;
import java.util.*;


public class ex1 {

    public static void main(String[] args) {
        //print the menus to the screen
        int option1 = printFirstMenu();
        printSecondMenu();
        //read the commands from txt file and insert the commands to list
        String commands[] = readFile();

        if (option1 == 1) {
            int j = -1;
            //initialize an empty list of mergable heaps
            List<mergableHeap> mergableHeaps = new ArrayList<mergableHeap>();

        for (int i = 0; i < commands.length; i++) {
            
            //create an empty heap in O(1)
            if (commands[i].equals("MakeHeap")) {
                j++;
                //call to the constructor of the mergable heap and add it to the list
                mergableHeap mh = new mergableHeap();
                mergableHeaps.add(mh);
            }
            //insert the element to the heap (one of two linked lists) in O(n) 
            if (commands[i].split(" ")[0].equals("Insert")) {
                int x = Integer.parseInt(commands[i].split(" ")[1]);
                mergableHeaps.get(j).insertToSorted(x);     
                if (mergableHeaps.get(j).get_flag() == 1) 
                    mergableHeaps.get(j).set_flag(2);
                else if (mergableHeaps.get(j).get_flag() == 2)
                    mergableHeaps.get(j).set_flag(1);

            }
            //get the minimum in O(1)
            if (commands[i].equals("Minimum")) {
                System.out.println("Minimum: " + mergableHeaps.get(j).getMinimum());
            }
            //extract the minimum in the heap in O(1)
            if (commands[i].equals("ExtractMin")) {
                System.out.println("ExtractMin: " + mergableHeaps.get(j).extractMinimum());
            }
            //union the two heaps
            if (commands[i].equals("Union")) {
                union(mergableHeaps.get(j-1), mergableHeaps.get(j));
                mergableHeaps.remove(j);
                j--;
            }

            //print the heaps
            for (int k = 1; k <mergableHeaps.size() + 1; k++) {
            System.out.println("The " + k + " mergable heap:");
            mergableHeaps.get(k-1).printMergableHeap();
            }
        }
    }

        else if (option1 == 2) {
        int j = -1;
        //initialize an empty list of mergable heaps
        List<mergableHeap> mergableHeaps = new ArrayList<mergableHeap>();

        for (int i = 0; i < commands.length; i++) {
             //create an empty heap in O(1)
            if (commands[i].equals("MakeHeap")) {
                j++;
                //call to the constructor of the mergable heap and add it to the list
                mergableHeap mh = new mergableHeap();
                mergableHeaps.add(mh);
            }
            
            //insert the element to the heap (one of two linked lists) in O(n) 
            if (commands[i].split(" ")[0].equals("Insert")) {
                int x = Integer.parseInt(commands[i].split(" ")[1]);
                //mergableHeaps.get(j).insertToNotSorted(x);     
                if (mergableHeaps.get(j).get_flag() == 1) 
                    mergableHeaps.get(j).set_flag(2);
                else if (mergableHeaps.get(j).get_flag() == 2)
                    mergableHeaps.get(j).set_flag(1);

            }
            //print the heaps
            for (int k = 1; k <mergableHeaps.size() + 1; k++) {
                System.out.println("The " + k + " mergable heap:");
                mergableHeaps.get(k-1).printMergableHeap();
                }
        }

    }


    }


    public static mergableHeap union(mergableHeap mh1, mergableHeap mh2) {
        for (int i = 0; i < mh2.get_l1().size(); i++) {
            //insert all the elements from the first list in the second heap to the first list in the first heap
            mh1.set_flag(1);
            //make sure there is no repetition of the same element twice
            if (!mh1.get_l1().contains(mh2.get_l1().get(i)))
            mh1.insertToSorted(mh2.get_l1().get(i));
        }
        for (int i = 0; i < mh2.get_l2().size(); i++) {
            //insert all the elements from the second list in the second heap to the second list in the first heap
            mh1.set_flag(2);
            //make sure there is no repetition of the same element twice
            if (!mh1.get_l2().contains(mh2.get_l2().get(i)))
            mh1.insertToSorted(mh2.get_l2().get(i));
        }
        return mh1;
    }

    public static int printFirstMenu() {
        try (Scanner sc1 = new Scanner(System.in)) {
            System.out.println("Choose an option:");
            System.out.println("1. Mergeable heaps using sorted linked lists.");
            System.out.println("2. Mergeable heaps using not sorted linked lists.");
            System.out.println("3. Mergeable heaps using not sorted linked lists and dynamic sets to be merged are disjoint.");
            int option1 = sc1.nextInt();
            return option1;
        }
    }
    
    public static void printSecondMenu() {
        try (Scanner sc2 = new Scanner(System.in)) {
            System.out.println("Choose an option:");
            System.out.println("1. MakeHeap()");
            System.out.println("2. Insert(x)");
            System.out.println("3. Minimum()");
            System.out.println("4. ExtractMin()");
            System.out.println("5. Union()");
            return;
        }
    }
    
    public static String[] readFile() 
    {        
        String separated;
        List<String> lines = new ArrayList<String>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("/home/danielr/ds/commands.txt"));

            while((separated = br.readLine()) != null) {
                lines.add(separated);
            }
            br.close();

            
        }
    catch (Exception e) {
        System.out.println(e.getClass());
      }
      String[] data = lines.toArray(new String[]{});
      return data;

}
}

