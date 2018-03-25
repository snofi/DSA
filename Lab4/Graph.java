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
}
