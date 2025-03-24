import java.util.List;

abstract class State {
  protected int x, y;

  public State(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public abstract List<State> getNeighbors();

  public abstract boolean isGoal(State goal);

  public abstract int getCost(State neighbor);

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}
