import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class State {
  private int x, y;
  private boolean isTrap;
  private char[][] grid;

  public State(int x, int y, boolean isTrap, char[][] grid) {
    this.x = x;
    this.y = y;
    this.isTrap = isTrap;
    this.grid = grid;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public boolean isGoal(State goal) {
    return this.x == goal.x && this.y == goal.y;
  }

  public boolean isTrap() {
    return isTrap;
  }

  public List<State> getNeighbors() {
    List<State> neighbors = new ArrayList<>();
    int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    for (int[] direction : directions) {
      int newX = this.x + direction[0];
      int newY = this.y + direction[1];

      if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) { // Verificar límites
        char cell = grid[newX][newY];
        boolean isTrap = (cell == 'P' || cell == 'W'); // Detectar trampas o Wumpus
        neighbors.add(new State(newX, newY, isTrap, grid));
      }
    }
    return neighbors;
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    State state = (State) obj;
    return x == state.x && y == state.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
