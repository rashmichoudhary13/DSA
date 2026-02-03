import java.util.ArrayList;

public class MazeRestriction {

    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, false, true},
                {true, true, true},
        };

        System.out.println(pathReturn("",0,0,board,new ArrayList<>()));
    }

    //Returning path in array taking it as parameter
    static ArrayList<String> pathReturn(String p, int r, int c, boolean[][] maze, ArrayList<String> list){
        // In the base condition, instead of printing store the result in list.
        if(r==maze.length-1 && c==maze[0].length-1){
            list.add(p);
            return list;
        }

        if(!maze[r][c]){
            return list;
        }
        // Store the recursion call result in list
        if(r < maze.length-1){
            pathReturn(p+"D",r+1,c,maze,list);
        }

        if(c < maze[0].length - 1){
            pathReturn(p+"R",r,c+1,maze,list);
        }

        return list;
    }
}
