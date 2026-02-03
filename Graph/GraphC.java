import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphC {
    //Ways of representing graph in code
    // 1.Adjacency List  2.Adjacency Matrix 3.Edge List 4.2D matrix

    //Creating a graph
    static class Edge{
        int src;
        int dest;
//        int wt;

        Edge(int s, int d){
            this.src = s;
            this.dest = d;
//            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

//        graph[0].add(new Edge(0,2,2));

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));



        graph[1].add(new Edge(1,3));
        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,4));
        graph[2].add(new Edge(2,0));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));
    }

    // Neighbour function
    static void neighbour(ArrayList<Edge> graph[], int node){
        for(int i=0; i<graph[node].size();i++){
            Edge e = graph[node].get(i);
            System.out.println(e.dest + ", ");
        }
    }

    // Graph Traversal
    // BFS
    static void BFS(ArrayList<Edge> graph[], boolean visited[], int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(visited[curr] == false){
                System.out.print(curr+" ");
                visited[curr] = true;

                for(int i=0; i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    //DFS
    static void dfs(ArrayList<Edge> graph[],boolean vis[],int curr){
        System.out.print(curr+" ");
        vis[curr] = true;
        for(int i=0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest] == false){
                dfs(graph,vis,e.dest);
            }
        }
    }

    //Print all path from a source to target
    static void PrintAllPath(ArrayList<Edge> graph[], int tar, int curr, boolean vist[], String path){
        if(curr == tar){
            System.out.println(path);
            return;
        }

        for(int i=0; i < graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vist[e.dest]){
                vist[curr] = true;
                PrintAllPath(graph,tar,e.dest,vist,path+e.dest);
                vist[curr] = false;
            }
        }
    }

    public static void main(String args[]){
        int V = 7;
        int src = 0, tar = 5;

        /*
            1 --- 3
           /      | \
          0       |  5 -- 6
          \       | /
           2 ---- 4
         */

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        neighbour(graph, 2);
        System.out.println("BFS path is: ");

        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(visited[i] == false){
                BFS(graph,visited,i);
            }
        }

        boolean vis[] = new boolean[V];
        System.out.println("\n DFS path is: ");
//        for(int i=0;i<V;i++){
//            if(vis[i] == false){
//                dfs(graph,vis,i);
//            }
//        }

        System.out.println("All path from 0 to 5 is: ");
        PrintAllPath(graph, tar, src, vis, "0");




    }
}
