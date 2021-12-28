import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collectors;
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
            
            if (commands[i].equals("MakeHeap")) {
                j++;
                //call to the constructor of the mergable heap and add it to the list
                mergableHeap mh = new mergableHeap();
                mergableHeaps.add(mh);
            }
            //insert the element to the heap (one of two linked lists)
            if (commands[i].split(" ")[0].equals("Insert")) {
                int x = Integer.parseInt(commands[i].split(" ")[1]);
                mergableHeaps.get(j).insertToSorted(x);     
                if (mergableHeaps.get(j).get_flag() == 1) 
                    mergableHeaps.get(j).set_flag(2);
                else if (mergableHeaps.get(j).get_flag() == 2)
                    mergableHeaps.get(j).set_flag(1);

            }

        }
    }


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

