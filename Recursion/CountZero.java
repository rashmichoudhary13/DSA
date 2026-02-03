public class CountZero {
    public static void main(String[] args) {
        System.out.print(number(395624, 0));
    }

    static int number(int n, int count){
        if(n == 0){
            return count;
        }
        int rem = n % 10;
        if(rem == 0){
            return number(n/10, count + 1);
        }
        return number(n/10, count);
    }
}
