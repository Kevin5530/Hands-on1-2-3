import java.util.ArrayList;
import java.util.List;

class Maze extends State {
  private static final int[][] MAZE = {
      { 0, 1, 0 },
      { 0, 1, 0 },
      { 0, 0, 0 }
  };

  public Maze(int x, int y) {
    super(x, y);
  }

  @Override
  public List<State> getNeighbors() {
    List<State> neighbors = new ArrayList<>();
    int[] dx = { 0, 1, 0, -1 };
    int[] dy = { 1, 0, -1, 0 };

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i], ny = y + dy[i];
      if (nx >= 0 && nx < MAZE.length && ny >= 0 && ny < MAZE[0].length && MAZE[nx][ny] == 0) {
        neighbors.add(new Maze(nx, ny));
      }
    }
    return neighbors;
  }

  public int getCost(State neighbor) {
    return 1;
  }

  @Override
  public boolean isGoal(State goal) {
    return x == goal.x && y == goal.y;
  }
}