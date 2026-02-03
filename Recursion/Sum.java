// Reverse and get the sum of digit
public class Sum {
    static int sum = 0;
    public static void main(String[] args) {
        reverse(12345);
        System.out.println(sum);
//        if(palindrome(12345)){
//            System.out.println("It is palindrome");
//        } else {
//            System.out.println("It is not palindrome");
//        }
    }

//    static int sum(int n){
//        if(n==0){
//            return 0;
//        }
//
//        return  (n % 10) + sum(n / 10);
//    }

    static int reverse(int n){
        if(n==0){
            return 0;
        }
        int rem = n % 10;
        sum = sum * 10 + rem;
        reverse(n/10);
        return sum;
    }

    static boolean palindrome(int n){
        return n == reverse(n);
    }
}
