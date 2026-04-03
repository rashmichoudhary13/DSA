// Problem: Find the count of numbers greater than H and upto H from 1;  
// T.C: O(nlogn)

import java.util.*;

public class CountofNumber{
    public static void main(String args[]){
        int[] arr = {4,5,2,0,8,3,7};
        int h = 3;

        Arrays.sort(arr); // O(nlogn)
        int n = arr.length;
        int j = n - 1;

        for(int i=h; i > 0; i--){  // O(h)
            while(j >= 0 && arr[j] >= i){  // O(n)
                j--;
            }

            System.out.println("Count >= " + i + " is " + (n-j-1));
        }
    }
}