import java.util.ArrayList;

public class subset {

    public static void findSubset(int n,ArrayList<Integer> set){

        if(n == 0){
            System.out.println(set);
            return;
        }
        //add hoga
        set.add(n);
        findSubset(n-1,set);

        //add nahi hoga
        set.removeLast();
        findSubset(n-1,set);
    }

    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<>();
        findSubset(3,set);
    }
}
