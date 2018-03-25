import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class Dijkstra{

  private final List<Vertex> vertexes;
  private final List<Edge> edges;
  private List<Vertex> visitedNodes;
  private List<Vertex> unvisitedNodes;
  private Map<Vertex, Integer> distance;
  private Map<Vertex, Vertex> predecessors;

  public Dijkstra(Graph graph){
    this.vertexes = new ArrayList<>(graph.getVertexes());
    this.edges = new ArrayList<>(graph.getEdges());
    this.visitedNodes = new ArrayList<>();
    this.unvisitedNodes = new ArrayList<>();
    this.predecessors = new HashMap<>();
    this.distance = new HashMap<>();
  }

  public void setStartingPoint(Vertex source){
    distance.put(source, 0);
    unvisitedNodes.add(source);

    while(unvisitedNodes.size()>0){
      Vertex vertex = getNextVertex(unvisitedNodes);
      exploreVertex(vertex);
      visitedNodes.add(vertex);
      unvisitedNodes.remove(vertex);
    }
  }

  public void exploreVertex(Vertex source){
    List<Vertex> neighbours = getNeighbours(source);
    for(Vertex neighbour: neighbours){
      int newDistance = distance.get(source) + getNeighbourDistance(source, neighbour);
      if(distance.get(neighbour)==null || distance.get(neighbour) > newDistance){
        distance.put(neighbour, newDistance); // update distance
        predecessors.put(neighbour, source);
        unvisitedNodes.add(neighbour);
      }
    }
  }

  public List<Vertex> getPath(Vertex target){
    List<Vertex> path = new ArrayList<>();
    Vertex tmp = target;
    if(predecessors.get(target)==null) return null;
    path.add(target);
    while(predecessors.get(tmp)!=null){
      tmp = predecessors.get(tmp);
      path.add(tmp);
    }
    Collections.reverse(path);
    return path;
  }

  public List<Vertex> getNeighbours(Vertex vertex) {
    List<Vertex> neighbours = new ArrayList<>();
    for(Edge e: edges){
      if(e.getSource().equals(vertex))
        neighbours.add(e.getDestination());
    }
    return neighbours;
  }

  // get the next vertex to explore (which is the smallest one)
  public Vertex getNextVertex(List<Vertex> unvisitedNodes){
    Vertex smallest = null;
    for(Vertex vertex: unvisitedNodes){
      if(smallest==null)
        smallest = vertex;
      else if(distance.get(vertex)< distance.get(smallest))
        smallest = vertex;
    }
    return smallest;
  }
  // get the distance (weight) of two connected vertexes
  public int getNeighbourDistance(Vertex v1, Vertex v2){
    for(Edge edge: edges){
      if(v1 == edge.getSource() && v2 == edge.getDestination())
        return edge.getWeight();
      if(v1 == edge.getDestination() && v2 == edge.getSource())
        return edge.getWeight();
    }
    return -1;
  }

  public static void main(String[] args){
    List<Vertex> v = new ArrayList<>();
    List<Edge> ed = new ArrayList<>();
    Vertex a = new Vertex("a","");
    Vertex b = new Vertex("b",""); // vertex b has been compromised
    Vertex c = new Vertex("c","");
    Vertex d = new Vertex("d","");
    Vertex e = new Vertex("e","");
    v.add(a); v.add(b); v.add(c); v.add(d); v.add(e);
    ed.add(new Edge("ab", a, b, 6));
    ed.add(new Edge("ac", a, c, 1));
    ed.add(new Edge("bc", b, c, 3));
    ed.add(new Edge("bd", b, d, 4));
    ed.add(new Edge("be", b, e, 5));
    ed.add(new Edge("cd", c, d, 1));
    ed.add(new Edge("de", d, e, 2));
    Graph control = new Graph(v, ed);
    Dijkstra dij = new Dijkstra(control);
    dij.setStartingPoint(a);
    List<Vertex> path = dij.getPath(e);
    System.out.print("Best path");
    for(Vertex vertex: path)
      System.out.print(" -> " + vertex.getId());
    System.out.println();
  }
}
