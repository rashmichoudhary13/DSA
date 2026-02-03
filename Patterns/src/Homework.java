public class Homework {
    public static void main(String[] args){
        int n=5;

//  *********** Solid Rhombus ***********
        for(int i=1;i<=n;i++){
            //Print Space
            for(int j=1;j<=n-i;j++) {
                System.out.print(" ");
            }

            //Print Star
            for(int j=1;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Number Pyramid");
//  *********** Number Pyramid ***********
        for(int i=1;i<=n;i++){
            //Print Space
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }

            //Print Star
            for(int j=1;j<=i;j++){
                System.out.print(i + " ");
            }

            System.out.println();
        }

        System.out.println();
        System.out.println("Palindromic Number Pyramid");
//  *********** Palindromic Number Pyramid ***********
        for(int i=1;i<=n;i++){
            //Print Space
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }

            //1st Part
            for(int j=i;j>=1;j--){
                System.out.print(j);
            }

            //2nd Part
            for(int j=2;j<=i;j++){
                System.out.print(j);
            }

            System.out.println();
        }
    }
}
