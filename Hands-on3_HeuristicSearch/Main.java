import java.util.List;

public class Main {
  public static void main(String[] args) {

    State startCity = CityMap.GRAPH.keySet().stream().filter(c -> c.x == 0).findFirst().orElse(null);
    State goalCity = CityMap.GRAPH.keySet().stream().filter(c -> c.x == 5).findFirst().orElse(null);
    List<State> path = UniversalSearch.search(startCity, goalCity);
    System.out.println(" Buscando en vialidades: Map Of Romania");
    System.out.println(path);

    int totalCost = CostCalculator.calculateTotalCost(path);
    System.out.println("Costo total del recorrido: " + totalCost);

    System.out.println("\n Buscando en laberinto: States Spaces ||");
    State startMaze = new Maze(0, 0);
    State goalMaze = new Maze(0, 2);
    System.out.println(UniversalSearch.search(startMaze, goalMaze));

  }
}
