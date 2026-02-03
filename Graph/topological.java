import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class topological {
    // It works on DAG (Directed Acyclic Graph)
    // For every directed edge u --> v the vertex u comes before v in the order.

    static class Edge{
        int src;
        int dest;

        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }

    static void topoSortUtil(ArrayList<Edge> graph[], boolean vis[], int curr, Stack<Integer> s){
        vis[curr] = true;

        for(int i=0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);

            if(!vis[e.dest]){
                topoSortUtil(graph,vis,e.dest,s);
            }
        }

        s.push(curr);
    }

    static void topsort(ArrayList<Edge> graph[], int v){
        boolean vis[] = new boolean[v];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<v; i++){
            if(!vis[i]){
                topoSortUtil(graph,vis,i,s);
            }
        }

        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }

    public static void main(String args[]){
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        Stack<Integer> s = new Stack<>();
        createGraph(graph);
        topsort(graph,v);
    }
}
