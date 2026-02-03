import java.util.ArrayList;

public class Bridge {

    // Find the bridge in graph
    // Use Tarjan's algorithm for this

    static class Edge{
        int src;
        int dest;

        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
    }

    static void dfs(ArrayList<Edge> graph[],int curr, int dt[], int low[], boolean vis[],int time, int par){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for(int i=0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(e.dest == par){
                continue;
            }else if(!vis[e.dest]){
                dfs(graph,e.dest,dt,low,vis,time,curr);
                low[curr] = Math.min(low[curr],low[e.dest]);
                if(dt[curr] < low[e.dest]){
                    System.out.print("Bridge is: "+ curr + "-->" + e.dest);
                }
            }else{
                low[curr] = Math.min(low[curr],dt[e.dest]);
            }
        }
    }

    static void tarjans(ArrayList<Edge> graph[], int v){
        int dt[] = new int[v];
        int low[] = new int[v];
        boolean vis[] = new boolean[v];
        int time = 0;

        for(int i=0; i<v; i++){
            if(!vis[i]){
                dfs(graph,i,dt,low,vis,time,-1);
            }
        }
    }

    public static void main(String args[]){
        int v = 6   ;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        tarjans(graph,v);
    }
}
