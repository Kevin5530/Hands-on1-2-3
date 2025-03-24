import java.util.*;

public class Main {
  public static void main(String[] args) {
    DepthFirstSearch DFS = new DepthFirstSearch();
    BreadthFirstsearch BFS = new BreadthFirstsearch();
    Map<String, List<String>> arbol = new HashMap<>();
    arbol.put("NY", Arrays.asList("CHI", "DEN", "TOR"));
    arbol.put("CHI", Arrays.asList("DEN"));
    arbol.put("DEN", Arrays.asList("HOU", "LA"));
    arbol.put("HOU", Arrays.asList("URB", "LA"));
    arbol.put("TOR", Arrays.asList("LA", "CAL"));

    Map<String, List<Pair<String, Integer>>> arbolBFS = new HashMap<>();
    arbolBFS.put("NY", Arrays.asList(new Pair<>("CHI", 3), new Pair<>("DEN", 2), new Pair<>("TOR", 5)));
    arbolBFS.put("CHI", Arrays.asList(new Pair<>("DEN", 4)));
    arbolBFS.put("DEN", Arrays.asList(new Pair<>("HOU", 6), new Pair<>("LA", 8)));
    arbolBFS.put("HOU", Arrays.asList(new Pair<>("URB", 2), new Pair<>("LA", 3)));
    arbolBFS.put("TOR", Arrays.asList(new Pair<>("LA", 7), new Pair<>("CAL", 6)));

    System.out.println("Depth First Search");
    DFS.busquedaUniversalD(arbol, "NY", "LA");
    System.out.println("\n");
    System.out.println("Breadth First search");
    BFS.busquedaUniversalB(arbolBFS, "NY", "LA");

  }
}