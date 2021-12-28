import java.util.LinkedList;

public class mergableHeap {
    
    //members
    private LinkedList<Integer> l1;
    private LinkedList<Integer> l2;
    private int flag;

    //constructor
    public mergableHeap() {
        // initalize two empty linked lists, and flag represents the list we insert the element to it
        l1 = new LinkedList<Integer>();
        l2 = new LinkedList<Integer>();
        flag = 1;
    }

    public void insertToSorted(int x) {
        if (flag == 1) {
            if (l1.isEmpty()) {
                l1.add(x);
            }
            else {
            //this boolean variable is used to know if the element that is biggest, and we didn't add its to the list in the loop
            boolean is_add = false;
            for (int i = 0; i < l1.size(); i++) {
                //insert the element to its right place in the list, in order to save the sort
                if (l1.get(i) > x) {
                    l1.add(i, x);
                    is_add = true;
                    break;
                }
            }
            //if the biggest element has not been added, we insert it to the end of the list
            if (!is_add) {
                l1.add(x);
            }
        }
        }
        if (flag == 2) {
            if (l2.isEmpty()) {
                l2.add(x);
            }
            else {
            boolean is_add = false;
            for (int i = 0; i < l2.size(); i++) {
                if (l2.get(i) > x) {
                    l2.add(i, x);
                    is_add = true;
                    break;
                }
            }
            if (!is_add) {
                l2.add(x);
            }
        }
        }
        

    }

    //get the first linked list
    public LinkedList<Integer> get_l1() {
        return this.l1;
    }

    //get the second linked list
    public LinkedList<Integer> get_l2() {
        return this.l2;
    }
    
    //get the flag of the heap
    public int get_flag() {
        return this.flag;
    }

    //se tthe flag of the heap
    public void set_flag(int tmp) {
        this.flag = tmp;
        return;
    }


}
