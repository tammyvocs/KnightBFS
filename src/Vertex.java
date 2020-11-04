// vertex (or node) to use in queue
// x and y represent the board coordinates
public class Vertex{
    int x;
    int y;
    int N = 8;

    public Vertex (int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getVal(){
        int positionX = x * N;
        int positionY = y;
        int val = positionX + positionY;
        return val;
    }

    @Override
    public String toString(){
        return "("+ x +","+ y +")";
    }
}