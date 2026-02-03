public class Hanoi {
//    //Tower of Hanoi problem
//    public static void towerOfHanoi(int n, String src, String help, String dest){
//        if(n==1){
//            System.out.println("3.Moving disk "+n+" from "+src+ " to "+ dest);
//            return;
//        }
//        towerOfHanoi(n-1,src,dest,help);
//        System.out.println("1.Moving disk "+ n + " from "+ src+ " to "+dest);
//
//        towerOfHanoi(n-1,help,src,dest);
//    }
//
//    //Print a string in reverse
//    public static String revString(String str) {
//        if(str.length() == 1) {
//            return str;
//        }
//        char currChar = str.charAt(0);
//        String nextString = revString(str.substring(1));
//        return nextString + currChar;
//    }

    //Check if array is strictly increasing
    public static boolean increment(int arr[],int idx){
       if(idx == arr.length-1) {
           return true;
       }

        int max = arr[idx];
        if(arr[idx+1] <= max) {
            return false;
        }

        return increment(arr,idx+1);

    }

    // Remove duplicates in a string

    public static String rmvduplicate(String str, int idx, boolean[] present){
        if(idx == str.length()){
            return "";
        }

        char Curr = str.charAt(idx);
        if(present[Curr-'a']){
             return rmvduplicate(str,idx+1,present);
        }else{
            present[Curr-'a'] = true;
            return Curr + rmvduplicate(str,idx+1,present);
        }

    }

    public static void main(String[] args) {
//        towerOfHanoi(3,"S","H","D");
//        String reversed = revString("hello");
//        System.out.println(reversed);
//        int[] arr = {1, 2, 3, 3, 5};
//        boolean val = increment(arr, 0);
//        if (val) {
//            System.out.println("Strictly Increasing");
//        } else{
//            System.out.println("Strictly not Increasing");
//        }
        String str = "abcadbcefghabi";
        boolean[] present = new boolean[str.length()];
        String new_str = rmvduplicate(str,0,present);
        System.out.println(new_str);
    }



}
