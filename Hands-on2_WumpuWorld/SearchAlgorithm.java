import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SearchAlgorithm {
  public static List<State> search(State start, State goal, char[][] grid) {
    Deque<State> stack = new ArrayDeque<>();
    Set<State> visited = new HashSet<>();
    Map<State, State> parentMap = new HashMap<>();

    stack.push(start);

    while (!stack.isEmpty()) {
      State currentState = stack.pop();

      if (!visited.contains(currentState)) {
        visited.add(currentState);
        System.out.println("Explorando: " + currentState);

        if (currentState.isGoal(goal)) {
          System.out.println("¡Objetivo encontrado!");
          return reconstructPath(parentMap, currentState);
        }

        for (State neighbor : currentState.getNeighbors()) {
          char cell = grid[neighbor.getX()][neighbor.getY()];
          if (!visited.contains(neighbor) && !neighbor.isTrap() &&
              (cell == ' ' || cell == 'B' || cell == 'S' || cell == 'T')) {
            stack.push(neighbor);
            parentMap.put(neighbor, currentState);

          }
        }
      }
    }
    System.out.println("No se encontró una ruta segura.");
    return Collections.emptyList();
  }

  private static List<State> reconstructPath(Map<State, State> parentMap, State current) {
    List<State> path = new ArrayList<>();
    while (current != null) {
      path.add(current);
      current = parentMap.get(current);
    }
    Collections.reverse(path);
    System.out.println("Ruta seguida: " + path);
    return path;
  }
}
