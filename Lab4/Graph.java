import java.util.List;
import java.util.ArrayList;

public class Graph {
    private final List<Vertex> vertexes;
    private final List<Edge> edges;

    public Graph(List<Vertex> vertexes, List<Edge> edges) {
        this.vertexes = vertexes;
        this.edges = edges;
    }

    public List<Vertex> getVertexes() {
        return vertexes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public boolean adjacent(String x, String y)	{
        // Returns true when there’s an edge from x to y
        // TODO: Implement this method
        Vertex v1 = null;
        Vertex v2 = null;

        for(Vertex v: vertexes){
          if(v.getId().equals(x)){
            v1 = v;
          }
          if(v.getId().equals(y)){
            v2 = v;
          }
        }
        for(Edge e: edges){
          if(e.getSource()==v1 && e.getDestination()==v2)
            return true;
        }

        return false;
    }

    public List<Vertex> getNeighbours(String vertex) {
        // Returns all neighbours of a given vertex
        // TODO: Implement this method
        List<Vertex> neighbours = new ArrayList<>();
        Vertex theVertex = null;

        for(Vertex v: vertexes){
          if(v.getId().equals(vertex))
            theVertex = v;
        }

        for(Edge e: edges){
          if(e.getSource()==theVertex)
            neighbours.add(e.getDestination());
          if(e.getDestination()==theVertex)
            neighbours.add(e.getSource());
        }

        return neighbours;
    }

    public static void main(String[] args){

      Vertex v2 = new Vertex("2","");
      Vertex v3 = new Vertex("3","");
      Vertex v6 = new Vertex("6","");
      Vertex v9  = new Vertex("9","");
      Vertex v7  = new Vertex("7","");
      Vertex v8  = new Vertex("8","");
      Edge e1 = new Edge("1", v2, v3, 1);
      Edge e2 = new Edge("2", v3, v6, 1);
      Edge e3 = new Edge("3", v3, v7, 1);
      Edge e4 = new Edge("4", v9, v7, 1);
      Edge e5 = new Edge("5", v7, v8, 1);
      List<Vertex> v = new ArrayList<>();
      List<Edge> e = new ArrayList<>();
      v.add(v2);
      v.add(v3);
      v.add(v6);
      v.add(v9);
      v.add(v7);
      v.add(v8);
      e.add(e1);
      e.add(e2);
      e.add(e3);
      e.add(e4);
      e.add(e5);
      Graph g = new Graph(v,e);
      System.out.println(g.adjacent("2","3"));
      System.out.println(g.adjacent("2","7"));
      List<Vertex> n = new ArrayList<>();
      n = g.getNeighbours("7");
      for(int i = 0; i<n.size(); i++)
      System.out.println(n.get(i).getId());



    }

}
