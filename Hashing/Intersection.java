import java.util.HashSet;

public class Intersection {

    static int inter(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();
        int count = 0;

        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }

        for(int num : arr2){
                if(set.contains(num)){
                    count++;
                    System.out.println(num);
                    set.remove(num);
                }
        }
        return count;
    }

    public static void main(String args[]){
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};
        System.out.println("Total count is: " + inter(arr1,arr2));

    }
}
