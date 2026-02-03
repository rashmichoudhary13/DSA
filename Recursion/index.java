import java.util.*;

public class index {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,8};
//        ArrayList ans = findallIndex(arr, 0, 4, new ArrayList<>());
        ArrayList ans = findallIndex2(arr, 0, 4);
        System.out.println(ans);
    }

    static ArrayList findallIndex(int[] arr, int ind, int tar, ArrayList<Integer> list){
        if(ind == arr.length){
            return list;
        }

        if(arr[ind] == tar){
            list.add(ind);
        }

        return findallIndex(arr, ind+1, tar, list);
    }

    static ArrayList findallIndex2(int[] arr, int ind, int tar){
        ArrayList<Integer> list = new ArrayList<>();

        if(ind == arr.length){
            return list;
        }

        if(arr[ind] == tar){
            list.add(ind);
        }

        ArrayList ansall =  findallIndex2(arr, ind+1, tar);

        list.addAll(ansall);

        return list;
    }
}
