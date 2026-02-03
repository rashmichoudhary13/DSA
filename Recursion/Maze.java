import java.util.ArrayList;

public class Maze {

    //Count the total moves to reach (n,m)
    // Condition: can only move right and downward

    // (i,j) starting point (n-1,m-1) is the destination point
//    public static int count_step(int i, int j, int n, int m){
//
//        if(i==n || j == m){
//            return 0;
//        }
//        if(i==n-1 && j == m-1){
//            return 1;
//        }
//        //downward
//        int downpath = count_step(i+1,j,n,m);
//
//        //right
//        int rightpath = count_step(i,j+1,n,m);
//
//        return downpath + rightpath;
//    }

    static int count(int r, int c){
        if(r==1 || c==1){
            return 1;
        }

        int down = count(r-1,c);
        int right = count(r,c-1);
        return down + right;
    }

    // Printing path
    static void path(String p, int r, int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }

        if(r!=1){
            path(p+"D",r-1,c);
        }

        if(c!=1){
            path(p+"R",r,c-1);
        }
    }

    // Returning path in array
    static ArrayList<String> pathList(String p, int r, int c){
        // In the base condition, instead of printing store the result in list.
        if(r==1 && c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        // Store the recursion call result in list
        if(r!=1){
            list.addAll(pathList(p+"D",r-1,c));
        }

        if(c!=1){
            list.addAll(pathList(p+"R",r,c-1));
        }

        return list;
    }

    //Returning path in array taking it as parameter
    static ArrayList<String> pathReturn(String p, int r, int c, ArrayList<String> list){
        // In the base condition, instead of printing store the result in list.
        if(r==1 && c==1){
            list.add(p);
            return list;
        }

        // Store the recursion call result in list
        if(r!=1){
            pathReturn(p+"D",r-1,c,list);
        }

        if(c!=1){
            pathReturn(p+"R",r,c-1,list);
        }

        return list;
    }


    public static void main(String[] args){
        int n = 4, m = 3;
//        int Totalpath = count_step(0,0,n,m);
        int Totalpath = count(3,3);
        path("",3,3);
        System.out.println("Total Path is: "+ Totalpath);
        System.out.println(pathList("",3,3));


        System.out.println("List is: " + pathReturn("",3,3,new ArrayList<>()));
    }
}
