// Check if the given string contains the smaller string.

public class Checksubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("ab", ""));
    }

    static boolean isSubsequence(String small, String large){
        if(small.isEmpty()){
            return true;
        } else if(large.isEmpty()){
            return false;
        }

        if(small.charAt(0) != large.charAt(0)){
            return isSubsequence(small, large.substring(1));
        } else {
            return isSubsequence(small.substring(1), large.substring(1));
        }
    }
}
