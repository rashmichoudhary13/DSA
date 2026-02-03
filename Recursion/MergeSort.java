import java.util.Arrays;

// Merge sort in place
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        divide(arr,0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void divide(int[] arr, int s, int e){
        if(e-s == 1){
            return;
        }

        int mid = (s+e) / 2;

        divide(arr,s,mid);
        divide(arr,mid,e);

        merge(arr,s,mid,e);
    }

    static int[] merge(int[] arr, int s, int m, int e){
        int[] mix = new int[e-s];

        int i = s;
        int j = m;
        int k = 0;

        while(i < m && j < e){
            if(arr[i] < arr[j]){
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i < m){
            mix[k] = arr[i];
            i++;
            k++;
        }

        while(j < e){
            mix[k++] = arr[j++];
        }

        for(int l=0; l < k; l++){
            arr[s+l] = mix[l];
        }

        return mix;
    }
}
