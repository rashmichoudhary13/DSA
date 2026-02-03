// Check if element exist
// Also find all the index of the target element

import java.util.ArrayList;
public class SearchElement {
    public static void main(String[] args) {
        int[] arr = {2,6,5,6,7,4};
        System.out.println(find(arr,6,0));

        System.out.println(findAllIndex(arr,6,0, new ArrayList<>()));
    }

    static boolean find(int[] arr, int target, int index){
        if(index == arr.length){
            return false;
        }

        return arr[index] == target || find(arr, target, index+1);
    }


    static ArrayList<Integer> findAllIndex(int[] arr, int tar, int index, ArrayList<Integer> list){
        if(index == arr.length){
            return list;
        }

        if(arr[index] == tar){
            list.add(index);
        }
        return findAllIndex(arr,tar,index+1, list);
    }
}
