// vertex (or node) to use in queue
// x and y represent the board coordinates
public class Vertex{
    int x;
    int y;
    int dist = Integer.MAX_VALUE;

    public Vertex (int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    public int getDist(int dist){
        return dist;
    }

    @Override
    public String toString(){
        return "("+ x +","+ y +")";
    }
}