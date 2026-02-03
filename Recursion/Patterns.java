import java.util.Arrays;

public class Patterns {
    public static void main(String[] args) {
//        triangle2(4,0);
        int[] arr = {3,4,2,1};
//        bubble(arr, arr.length -1, 0);
//        selection(arr, arr.length-1,0, 0);
        selection2(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void triangle(int r, int c){
        if(r == 0 ){
            return;
        }

        if(c < r){
            System.out.print("* ");
            triangle(r, c+1);
        }else{
            System.out.println();
            triangle(r-1,0);
        }
    }

    static void triangle2(int r, int c){
        if(r == 0 ){
            return;
        }

        if(c < r){
            triangle2(r, c+1);
            System.out.print("* ");
        }else{
            triangle2(r-1,0);
            System.out.println();
        }
    }

    static void bubble(int[] arr, int r, int c){
        if(r == 0){
            return;
        }

        if( c < r){
            if(arr[c] > arr[c+1]){
                int temp = arr[c];
                arr[c] = arr[c+1];
                arr[c+1] = temp;
            }
            bubble(arr, r, c+1);
        }

        bubble(arr, r-1, 0);
    }

    static void selection(int[] arr, int r, int c, int max){
        if(r == 0){
            return;
        }

        if(c < r){
            if(arr[c + 1] > arr[max]){
                selection(arr, r, c+1, c+1);
            }else{
                selection(arr, r, c+1, max);
            }
        }else{
            int temp = arr[max];
            arr[max] = arr[r];
            arr[r] = temp;

            selection(arr, r-1, 0, 0);
        }
    }

    static void selection2(int[] arr){

        for(int i = arr.length-1; i > 0; i--){
            int max = 0;
            for(int j = 0; j <= i; j++){
                if(arr[j] > arr[max]){
                    max = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
        }
    }
}
