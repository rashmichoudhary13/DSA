import java.util.HashMap;

public class sum {
    //Subarray sum equal to K
    public static void main(String args[]){
        int arr[] = {10, 2, -2, -20, 10};
        int sum_arr[] = new int[arr.length + 1];
        sum_arr[0] = 0;
        int k = -10;
        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0,1);

        int ans = 0; // No. of subarray that has a sum equal to k
        int sum = 0;

        for(int j=0; j<arr.length;j++){
            sum += arr[j];
            sum_arr[j+1] = sum;

            int val = sum-k;

            if(map.containsKey(val)){
                ans += map.get(val);

                //Print the subarray that has the sum equal to k
                for(int i=0; i<sum_arr.length;i++){
                    if(sum_arr[i] == val){
                        for(int x=i; x<=j;x++){
                            System.out.print(arr[x] + " ");
                        }
                        System.out.println();
                    }
                }
            }

            if(map.containsKey(sum)){
                map.put(sum, map.get(sum) + 1);
            } else{
                map.put(sum,1);
            }
        }

        System.out.println("Total Subarray is: " + ans);
    }
}
