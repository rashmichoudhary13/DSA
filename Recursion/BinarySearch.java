public class BinarySearch {

    public static int search(int[] arr, int s, int e, int tar){

        if( s > e){
            return -1;
        }

        int mid = s + (e - s) / 2;

        if(arr[mid] == tar){
            return mid;
        }

        if(tar > arr[mid]){
            return search(arr, mid + 1, e, tar);
        }

     return  search(arr,s,mid-1,tar);
        
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8};
        int target = 5;
        System.out.println(search(arr, 0, arr.length - 1, target));
    }
}
