public class Tiles {

    public static int arrange_tiles(int n, int m){
        if(n == m){
            return 2;
        }

        if(n < m){
            return 1;
        }

        //horizontally
        int horizontal_tiles =  arrange_tiles(n-1,m);

        //Vertical
        int vertical_tiles = arrange_tiles(n-m,m);

        return horizontal_tiles + vertical_tiles;

    }

    public static void main(String[] args) {
      int n = 4, m = 2;
      System.out.println(arrange_tiles(n,m));
    }
}
