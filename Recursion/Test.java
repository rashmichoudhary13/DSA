import java.util.*;
 class Test {
    static int isMagic(int n){
        int sum = 0;

        while(n != 0){
            int rem = n % 10;
            sum += rem;
            n = n/10;
        }

        if( sum > 9){
            return isMagic(sum);
        }

        return sum;
    }

    public static void main(String args[]){
        Scanner s1 = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = s1.nextInt();
        int ans = isMagic(num);
        if ( ans == 1){
            System.out.println(num + " is a magic number");
        }else{
            System.out.println(num + " is not a magic number");

        }
    }
}
