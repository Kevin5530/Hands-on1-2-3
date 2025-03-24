import java.util.List;

public class CostCalculator {
  public static int calculateTotalCost(List<State> path) {
    int totalCost = 0;
    for (int i = 0; i < path.size() - 1; i++) {
      int cost = path.get(i).getCost(path.get(i + 1));
      totalCost += cost;
    }
    return totalCost;

  }
}
