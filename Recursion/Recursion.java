public class Recursion{
    //recursion here

    public static void printNumbers(int n){
        //Base case is imp to stop the recursion
        if (n == 0){
            return;
        }
        System.out.println(n);
        printNumbers(n-1); // After the base condition is met, the control returns to this line.
        System.out.println("This line is executed for n value call return: "+n);
    }

    public static void printFactorial(int n, int fact) {
        if (n == 0) {
            System.out.println(fact);
            return;
        }
        fact *= n;
        printFactorial(n - 1, fact);
    }

    public static void main(String[] args){
        printNumbers(5);
        System.out.println("Factorial is: ");
        printFactorial(5,1);

    }

}
