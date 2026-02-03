public class Advanced {
    public static void main(String[] args){
        int n=4;

        //Butterfly Pattern
        //upper part
        for(int i=1; i <= n; i++){
            //For the 1st part
            for(int j=1; j <= i; j++){
                System.out.print("*");
            }

            //for spaces
            int spaces = 2 * (n-i);
            for(int j= 1; j <= spaces; j++){
                System.out.print(" ");
            }

            //For 2nd part
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }

            System.out.println();
        }

        //Lower Part
        for(int i=n; i >= 1; i--){
            //For the 1st part
            for(int j=1; j <= i; j++){
                System.out.print("*");
            }

            //for spaces
            int spaces = 2 * (n-i);
            for(int j= 1; j <= spaces; j++){
                System.out.print(" ");
            }

            //For 2nd part
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }

            System.out.println();
        }
         System.out.println();
         System.out.println("Diamond Pattern");
        //Diamond
        //Upper part
        for(int i=1;i<=n;i++){
            //for spaces
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            int s=(i*2)-1;
            //for printing star
            for(int j=1;j<=s;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        //lower part
        for(int i=4;i>=1;i--){
            //for spaces
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            int s=(i*2)-1;
            //for printing star
            for(int j=1;j<=s;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Hollow Butterfly Pattern");

        //upper part
        for(int i=1;i<=n;i++){
            //1st part
            for(int j=1;j<=n;j++){
                if(j==1 || (i==j)){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }

            //2nd part
            for(int j=1;j<=n;j++){
                if(j==n || j == (n-i)+1){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        //lower part
        for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                if(j==1 || (i==j)){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }

            //2nd
            for(int j=1;j<=n;j++){
                if(j==n || j == (n-i)+1){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
         }

        System.out.println();
        System.out.println("Hollow Rhombus Pattern");

        for(int i=1;i<=n;i++){
            //space
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }

            for(int j=1;j<=n;j++){
                if(i==1 || i == n || j==1 || j== n){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Number Half pyramid Pattern");

        for(int i=1;i<=n;i++){
            for(int j=1; j<=i; j++){
                System.out.print(j);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Inverted Number Half pyramid Pattern");

        for(int i=1;i<=n;i++){
            for(int j=1; j<=n-i+1; j++){
                System.out.print(i);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Pascal's Triangle");

        //Pascal's triangle
        for(int i=0;i<n;i++){
            int num = 1;
            //for spaces
            for(int j=0;j<n-i;j++){
                System.out.print(" ");
            }
            //for printing number
            for(int j=0;j<=i;j++){
                System.out.print(num+" ");
                num = num * (i-j)/(j+1);
            }
            System.out.println();
        }
    }
}
