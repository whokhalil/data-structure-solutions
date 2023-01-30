import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    static void addEdge(ArrayList<ArrayList<Integer>> adj , int source, int destination){
        adj.get(source).add(destination);
        adj.get(destination).add(source);
    }


    private static boolean bfs(ArrayList<ArrayList<Integer>> adj,int src, int dest, int v, int pred[],int dist[] ){
        LinkedList<Integer> queue = new LinkedList<Integer>();
        boolean visited[] = new boolean[v];
        for (int i = 0; i<v; i++){
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }

        visited[src] = true;
        dist[src] = 0;
        queue.add(src);
        while(!queue.isEmpty()){
            int cur = queue.remove();
            for (int i= 0 ; i< adj.get(cur).size();i++){
                int neighbour = adj.get(cur).get(i);
                if (visited[neighbour] == false){
                    visited[neighbour] = true;
                    dist[neighbour] = dist[cur] + 1;
                    pred[neighbour] = cur;
                    queue.add(neighbour);
                    if (neighbour == dest){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i<=6; i++){
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj,0,0);
        addEdge(adj,1,2);
        addEdge(adj,1,3);
        addEdge(adj,1,5);
        addEdge(adj,2,5);
        addEdge(adj,3,4);
        addEdge(adj,4,5);
        addEdge(adj,4,6);
        addEdge(adj,5,6);


        int v = 6;
        int e = 8;
        int pred[] = new int[v+1];
        int dist[] = new int[v+1];
        boolean isReached = bfs(adj,1,6,v,pred,dist);

    }
}
