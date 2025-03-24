import java.util.List;

class WumpusWorld {
  private char[][] grid;
  private int[] agentPos;
  private int[] treasurePos;

  public WumpusWorld(char[][] grid, int[] agentPos, int[] treasurePos) {
    this.grid = grid;
    this.agentPos = agentPos;
    this.treasurePos = treasurePos;
  }

  public boolean searchTreasure() {
    State start = new State(agentPos[0], agentPos[1], false, grid);
    State goal = new State(treasurePos[0], treasurePos[1], false, grid);

    List<State> path = SearchAlgorithm.search(start, goal, grid);
    if (!path.isEmpty()) {
      System.out.println("Ruta encontrada: " + path);
      return true;
    } else {
      System.out.println("No hay ruta segura.");
      return false;
    }
  }

  public void printStateSpace(List<State> path) {
    System.out.println("Escenario: 1");
    for (int fila = 0; fila < grid.length; fila++) {
      for (int col = 0; col < grid[fila].length; col++) {
        String contenido = "";

        
        if (agentPos[0] == fila && agentPos[1] == col) {
          contenido = "A"; 
        } else if (treasurePos[0] == fila && treasurePos[1] == col) {
          contenido = "T"; 
        } else {
          
          char cell = grid[fila][col];
          switch (cell) {
            case 'W':
              contenido = "W";
              break; 
            case 'P':
              contenido = "P";
              break; 
            case 'B':
              contenido = "B";
              break; 
            case 'S':
              contenido = "S";
              break; 
            default:
              contenido = " "; 
          }
        }

        
        contenido = String.format("%-3s", contenido);
        System.out.print(contenido);
      }
      System.out.println(""); 
  }

}
