import java.util.HashSet;
import java.util.Iterator;


//Implementing HashSet using collection framework
// Hashset Insertion, deletion and search has O(1) time.

public class hashset {
    public static void main(String args[]){
        HashSet<Integer> set = new HashSet<>();

        //Insert
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(4);
        set.add(5);

        //Search - contains
        if(set.contains(1)){
            System.out.println("set contains 1");
        }
        if(!set.contains(7)){
            System.out.println("set does not contains 7");
        }

        //Delete
        set.remove(1);
        if(!set.contains(1)){
            System.out.println("set does not contains 1");
        }

        //Size
        System.out.println("size of set is: " + set.size());

        //Print all elements
        System.out.println(set);

        //Iterator
        Iterator it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
