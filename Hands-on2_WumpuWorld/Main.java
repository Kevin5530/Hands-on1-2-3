import java.util.List;

public class Main {
  public static void main(String[] args) {
    
    char[][] grid = {
        { 'T', 'B', 'S', 'W' }, // B: Brisa, P: Trampa
        { ' ', ' ', 'P', ' ' }, // W: Wumpus, T: Tesoro
        { ' ', ' ', ' ', ' ' }, // S: Hedor
        { ' ', ' ', ' ', ' ' } // Espacios vacíos: ' '
    };

    // Posición inicial del agente
    int[] agentStart = { 2, 1 }; 

    // Posición del tesoro
    int[] treasurePos = { 0, 0 }; 

    // Crear los estados inicial y objetivo
    State startState = new State(agentStart[0], agentStart[1], false, grid);
    State goalState = new State(treasurePos[0], treasurePos[1], false, grid);

    
    WumpusWorld wumpusw = new WumpusWorld(grid, agentStart, treasurePos);

   
    List<State> path = SearchAlgorithm.search(startState, goalState, grid);
    wumpusw.printStateSpace(path);

  }
}