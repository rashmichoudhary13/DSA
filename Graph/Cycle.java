import java.lang.reflect.Array;
import java.util.ArrayList;

public class Cycle {

    static class Edge{
        int src;
        int dest;

        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        // Undirected graph
//        graph[0].add(new Edge(0,1));
//        graph[0].add(new Edge(0,4));
//
//        graph[1].add(new Edge(1,0));
//        graph[1].add(new Edge(1,2));
////        graph[1].add(new Edge(1,4));
//
//        graph[2].add(new Edge(2,1));
//        graph[2].add(new Edge(2,3));
//
//        graph[3].add(new Edge(3,2));
//
//        graph[4].add(new Edge(4,0));
////        graph[4].add(new Edge(4,1));
//        graph[4].add(new Edge(4,5));
//
//        graph[5].add(new Edge(5,4));

        // Directed graph
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,3));

//        graph[3].add(new Edge(3,0));
    }

    // Cycle in Undirected graph
    static boolean iscycleUndirected(ArrayList<Edge> graph[], int curr, int par, boolean vis[]){
        vis[curr] = true;

        for(int i=0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest] == true && par != e.dest){
                return true;
            }
            else if(!vis[e.dest]){
               if(iscycleUndirected(graph,e.dest,curr,vis)){
                   return true;
               }
            }
        }
        return false;
    }

    // Cycle in directed graph
    static boolean iscycleDirected(ArrayList<Edge> graph[], boolean vis[], boolean rec[], int curr){
        vis[curr] = true;
        rec[curr] = true;

        for(int i=0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(rec[e.dest]){
                return true;
            }else if(!vis[e.dest]){
                if(iscycleDirected(graph,vis,rec,e.dest)){
                    return true;
                }
            }
        }

        rec[curr] = false;
        return false;
    }
    public static void main(String args[]){
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        boolean vis[] = new boolean[v];
//        System.out.println(iscycleUndirected(graph,0,-1,vis));
        System.out.println(iscycleDirected(graph,vis,new boolean[v],0));

    }
}
