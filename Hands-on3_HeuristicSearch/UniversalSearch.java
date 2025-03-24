import java.util.*;

class UniversalSearch {
    public static List<State> search(State start, State goal) {
        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        Map<State, Integer> costMap = new HashMap<>();
        Map<State, State> parentMap = new HashMap<>();

        openList.add(new Node(start, 0));
        costMap.put(start, 0);

        while (!openList.isEmpty()) {
            Node currentNode = openList.poll();
            State currentState = currentNode.state;

            if (currentState.isGoal(goal)) {
                return reconstructPath(parentMap, currentState);
            }

            for (State neighbor : currentState.getNeighbors()) {
                int newCost = currentNode.cost + currentState.getCost(neighbor);

                if (!costMap.containsKey(neighbor) || newCost < costMap.get(neighbor)) {
                    costMap.put(neighbor, newCost);
                    openList.add(new Node(neighbor, newCost));
                    parentMap.put(neighbor, currentState);
                }
            }
        }
        return Collections.emptyList(); // No se encontró solución
    }

    private static List<State> reconstructPath(Map<State, State> parentMap, State current) {
        List<State> path = new ArrayList<>();
        while (current != null) {
            path.add(current);
            current = parentMap.get(current);
        }
        Collections.reverse(path);
        return path;
    }
}

class Node {
    State state;
    int cost;

    public Node(State state, int cost) {
        this.state = state;
        this.cost = cost;
    }
}
