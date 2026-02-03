public class Main {
    public static void main(String[] args) {
        int n = 4;
        int m = 5;

        //Solid Rectangle
        //Outer loop
        for (int i = 1; i <= n; i++) {
            //Inner loop
            for (int j = 1; j <= m; j++) {
                System.out.print('*');
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Hollow Rectangle Pattern");
//  *********** Hollow Rectangle ************

        //Outer loop
        for(int i=1;i<=n;i++){
            //Inner loop
            for(int j=1;j<=m;j++){
                //Cell(i,j)
                if(i==1 || j==1 || i==n || j==m){
                    System.out.print('*');
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}