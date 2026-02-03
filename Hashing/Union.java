import java.util.HashSet;

//Union of 2 array
public class Union {

    static void unionOfArray(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        }
        System.out.println(set);
        System.out.println(set.size());
    }

    public static void main(String args[]){
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};
        unionOfArray(arr1,arr2);
    }
}
