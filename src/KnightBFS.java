import java.util.*;

public class KnightBFS {
    // all possible ways to move a knight
    static int [] row = {2, 2, -2, -2, 1, 1, -1, -1};
    static int [] col = {1, -1, 1, -1, 2, -2, 2, -2};

    // max index
    static final int N = 8;
    static final int ROWS = 8;
    static final int COLS = 8;
    static boolean exists = false;

    public static void main(String []args){
        int src = 0;
        int dest = 1;
        System.out.println(solution(src, dest));
    }

    // converts position to points
    public static Vertex convertToPoint(int position){
        int x = position / ROWS;
        int y = position % COLS;
        return new Vertex(x, y);
    }

    // checks if the current position is valid within board
    public static boolean isValid (int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= N){
            return false;
        }
        return true;
    }

    // bfs
    public static int solution(int src, int dest) {
        // store the states of the knight
        Queue<Vertex> q = new LinkedList<Vertex>();
        // store visited vertices
        Set <Integer> visited = new HashSet <Integer>();
        // store distance array
        int [] dist = new int [ROWS * COLS];
        int [] parent = new int [ROWS * COLS];
        // initialize all distance to infinity and parent values to -1
        for(int i = 0; i < ROWS*COLS; i++){
            dist[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }
        // initialize root to zero
        dist[src] = 0;
        q.add(convertToPoint(src));
        // bfs, add neighbors to queue
        while(!q.isEmpty()){
            Vertex curr = q.poll();
            // checks if vertex hasn't been visited
            if(!visited.contains(curr.getVal())){
                visited.add(curr.getVal());
                // check for valid neighbors
                for(int i = 0; i < N; i++){
                    int x = curr.x + row[i];
                    int y = curr.y + col[i];
                    // create new nodes for neighbors if conditions are met
                    if(isValid(x,y) && !visited.contains(x * ROWS + y)){
                        Vertex neighbors = new Vertex(x,y);
                        dist[neighbors.getVal()] = dist[curr.getVal()] + 1;
                        parent[neighbors.getVal()] = curr.getVal();
                        q.add(neighbors);
                        // check if dest exists
                        if(neighbors.getVal() == dest){
                            exists = true;
                        }
                    }
                }
            }
        }
        // if the dest exists
        if(exists == true){
            return getLength(parent, dist, dest);
        }

        return 0;
    }

    public static int getLength(int [] parent, int [] dist, int dest){
        // list to store path
        List <Integer> list = new ArrayList<>();
        int length = -1;
        int path = dest;
        list.add(path);

        while(parent[path] != -1){
            list.add(parent[path]);
            path = parent[path];
        }
            length = dist[dest];

        return length;
    }
}
