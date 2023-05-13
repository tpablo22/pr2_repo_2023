

public class Main {
    public static void main(String []args){
    Graph<Integer> g = new Graph<>();
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(1, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 4);
        System.out.println(g.onePath(1, 4));

    }

}
