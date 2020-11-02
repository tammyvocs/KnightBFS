import java.util.LinkedList;
import java.util.Queue;

public class KnightBFS {
    // all possible ways to move a knight
    static int [] row = {2, 2, -2, -2, 1, 1, -1, -1};
    static int [] col = {1, -1, 1, -1, 2, -2, 2, -2};

    // max index
    static final int N = 8;
    static final int ROWS = 8;
    static final int COLS = 8;

    public static void main(String []args){
        System.out.println("Hello World");
        int src = 0;
        int dest = 1;
        System.out.println(solution(src, dest));
    }

    // converts position to points
    public static Vertex convertToPoint(int position){
        int x = position / ROWS;
        int y = position % COLS;
        return new Vertex(x, y, dist);
    }

    // checks if the current position is valid within board
    public static boolean isValid (int x, int y, int N){
        if(x < 0 || x >= N || y < 0 || y >= N){
            return false;
        }
        return true;
    }

    // bfs
    public static int solution(int src, int dest) {
        // store the states of the knight
        Queue<Vertex> q = new LinkedList<Vertex>();
        q.add(convertToPoint(src));

        // store visited vertices
        boolean [][] visited = new boolean[ROWS][COLS];

        // store distance
        int [] distance = new int [];

        // bfs, add neighbors to queue
        while(!q.isEmpty()){
            Vertex curr = q.poll();
            // checks if vertex hasn't been visited
            if(!visited[curr.x][curr.y]){
                visited[curr.x][curr.y] = true;
                // check for valid neighbors
                for(int i = 0; i < N; i++){
                    int x = curr.x + row[i];
                    int y = curr.y + col[i];
                    // create new nodes for neighbors if conditions are met
                    if(isValid(x,y,N) && !visited[x][y]){
                        int minDist = minDist(curr.x, curr.y, x, y);
                        Vertex neighbors = new Vertex(x,y, minDist);
                        q.add(neighbors);
                    }
                }
            }
        }
        return 0;
    }

    // calculate the dist from the two vertex
    public static int minDist (int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static void updateDist(){

    }

}
