public class HalfPyr {
    public static void main(String[] args){
        int n=5;
        int number=1;
//  *********** Type1: Half Pyramid Pattern ****************
        //Outer loop
        for(int i=1;i<=n;i++){
            //Inner loop
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Inverted Half Pyramid");

//  *********** Type2: Inverted Half Pyramid Pattern ****************
        //Outer loop
        for(int i=n;i>=1;i--){
            //Inner loop
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Half Pyramid (Rotated by 180 deg)");

//  *********** Type3: Half Pyramid (rotated by 180 deg) ****************
        //outer loop
        for(int i=1;i<=n;i++){
            //Loop to print space
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }

            //Loop to print Star
            for(int j=1;j<=i;j++){
                System.out.print('*');
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Half Pyramid with Numbers");

//        *********** Type4: Half Pyramid with numbers ****************
        //outer loop
        for(int i=1;i<=n;i++){
            //Inner loop
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Inverted Half Pyramid With Numbers");

//         *********** Type5: Inverted Half Pyramid With Numbers ****************
        //Outer loop
        for(int i=1;i<=n;i++){
            //Inner loop
            for(int j=1;j<=n-i+1;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Floyd's Triangle");
//         *********** Type6: Floyd's Triangle ****************
        //outer loop
        for(int i=1;i<=n;i++){
            //inner loop
            for(int j=1;j<=i;j++){
                System.out.print(number+" ");
                number++;
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("0-1 Triangle");
//         *********** Type7: 0-1 Triangle ****************
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if((i+j)%2 == 0){
                    System.out.print("1"+" ");
                }else{
                    System.out.print("0"+" ");
                }
            }
            System.out.println();
        }


    }
}
