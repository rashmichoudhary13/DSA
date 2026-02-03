public class fibonacci {
    public static void main(String args[]){
        int ans = fib(4);
        System.out.println(ans);
    }

    static int fib(int n){
        if(n < 2){
            return n;
        }
        int sum1 = fib(n-1);
        int sum2 = fib(n-2);
        int answer = sum1 + sum2;
        return answer;
    }
}
