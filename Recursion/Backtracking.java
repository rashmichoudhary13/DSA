import java.util.ArrayList;

public class Backtracking {

    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true},
        };

    AllPath("",0,0,board);
    }

    // Can move up, right, down, left
    static void AllPath(String p, int r, int c, boolean[][] maze){
        if(r == 1 && c == 1){
            System.out.println(p);
            return;
        }

        if(!maze[r][c]){
            return;
        }

        // Considering this cell as visited
        maze[r][c] = false;

        //Condition for down path
        if(r < maze.length - 1){
            AllPath(p+"D", r+1,c,maze);
        }

        //Condition for right path
        if( c < maze[0].length - 1){
            AllPath(p+"R",r,c+1,maze);
        }

        //Condition for up path
        if(r > 0){
            AllPath(p+"U",r-1,c,maze);
        }

        //Condition for left path
        if( c > 0){
            AllPath(p+"L",r,c-1,maze);
        }

        //removing the path while returning
        maze[r][c] = true;
    }
}
