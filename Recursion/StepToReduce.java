//Return the number of steps to reduce a number to zero
// If it is even, divide by 2 otherwise subtract from 1

public class StepToReduce {
    public static void main(String[] args) {
        System.out.print(reduce(14));
    }

    static int reduce(int n){
       return helper(n,0);
    }

    static int helper(int n, int step){
        if(n == 0){
            return step;
        }

        if(n%2 == 0){
            return helper(n/2, step + 1);
        }
        return helper(n-1, step+1);
    }
}
