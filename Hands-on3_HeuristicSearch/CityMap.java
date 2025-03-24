import java.util.*;
import java.util.stream.Collectors;

class CityMap extends State {
  public static final Map<CityMap, List<Pair<CityMap, Integer>>> GRAPH = new HashMap<>();

  static {
    CityMap Oradea = new CityMap(0, 71);
    CityMap Zerind = new CityMap(1, 75);
    CityMap Arad = new CityMap(2, 118);
    CityMap Timisoara = new CityMap(3, 111);
    CityMap Lugoj = new CityMap(4, 70);
    CityMap Mehadia = new CityMap(5, 75);
    CityMap Drobeta = new CityMap(6, 120);
    CityMap Craiova = new CityMap(7, 146);
    CityMap Sibiu = new CityMap(8, 151);
    CityMap RimnicuVilcea = new CityMap(9, 80);
    CityMap Fagaras = new CityMap(10, 211);
    CityMap Pitesti = new CityMap(11, 101);
    CityMap Bucharest = new CityMap(12, 85);
    CityMap Giurgiu = new CityMap(13, 90);
    CityMap Urziceni = new CityMap(14, 98);
    CityMap Hirsova = new CityMap(15, 86);
    CityMap Eforie = new CityMap(16, 0);
    CityMap Vaslui = new CityMap(17, 92);
    CityMap Iasi = new CityMap(18, 87);
    CityMap Neamt = new CityMap(19, 0);

    GRAPH.put(Oradea, Arrays.asList(
        new Pair<>(Zerind, 71),
        new Pair<>(Sibiu, 151)));
    GRAPH.put(Zerind, Arrays.asList(
        new Pair<>(Oradea, 71),
        new Pair<>(Arad, 75)));
    GRAPH.put(Arad, Arrays.asList(
        new Pair<>(Zerind, 75),
        new Pair<>(Sibiu, 140),
        new Pair<>(Timisoara, 118)));
    GRAPH.put(Timisoara, Arrays.asList(
        new Pair<>(Arad, 118),
        new Pair<>(Lugoj, 111)));
    GRAPH.put(Lugoj, Arrays.asList(
        new Pair<>(Timisoara, 111),
        new Pair<>(Mehadia, 70)));
    GRAPH.put(Mehadia, Arrays.asList(
        new Pair<>(Lugoj, 70),
        new Pair<>(Drobeta, 75)));
    GRAPH.put(Drobeta, Arrays.asList(
        new Pair<>(Mehadia, 75),
        new Pair<>(Craiova, 120)));
    GRAPH.put(Craiova, Arrays.asList(
        new Pair<>(Drobeta, 120),
        new Pair<>(Pitesti, 138),
        new Pair<>(RimnicuVilcea, 146)));
    GRAPH.put(Sibiu, Arrays.asList(
        new Pair<>(Oradea, 151),
        new Pair<>(Arad, 140),
        new Pair<>(RimnicuVilcea, 80),
        new Pair<>(Fagaras, 99)));
    GRAPH.put(RimnicuVilcea, Arrays.asList(
        new Pair<>(Sibiu, 80),
        new Pair<>(Craiova, 146),
        new Pair<>(Pitesti, 97)));
    GRAPH.put(Fagaras, Arrays.asList(
        new Pair<>(Sibiu, 99),
        new Pair<>(Bucharest, 211)));
    GRAPH.put(Pitesti, Arrays.asList(
        new Pair<>(RimnicuVilcea, 97),
        new Pair<>(Craiova, 138),
        new Pair<>(Bucharest, 101)));
    GRAPH.put(Bucharest, Arrays.asList(
        new Pair<>(Fagaras, 211),
        new Pair<>(Pitesti, 101),
        new Pair<>(Giurgiu, 90),
        new Pair<>(Urziceni, 85)));
    GRAPH.put(Giurgiu, Arrays.asList(
        new Pair<>(Bucharest, 90)));
    GRAPH.put(Urziceni, Arrays.asList(
        new Pair<>(Bucharest, 85),
        new Pair<>(Hirsova, 98),
        new Pair<>(Vaslui, 142)));
    GRAPH.put(Hirsova, Arrays.asList(
        new Pair<>(Urziceni, 98),
        new Pair<>(Eforie, 86)));
    GRAPH.put(Eforie, Arrays.asList(
        new Pair<>(Hirsova, 86)));
    GRAPH.put(Vaslui, Arrays.asList(
        new Pair<>(Urziceni, 142),
        new Pair<>(Iasi, 92)));
    GRAPH.put(Iasi, Arrays.asList(
        new Pair<>(Vaslui, 92),
        new Pair<>(Neamt, 87)));
    GRAPH.put(Neamt, Arrays.asList(
        new Pair<>(Iasi, 87)));

  }

  public CityMap(int x, int cost) {
    super(x, cost);
  }

  @Override
  public List<State> getNeighbors() {
    return GRAPH.getOrDefault(this, Collections.emptyList()).stream()
        .map(pair -> pair.first)
        .collect(Collectors.toList());
  }

  @Override
  public int getCost(State neighbor) {
    return GRAPH.getOrDefault(this, Collections.emptyList()).stream()
        .filter(pair -> pair.first.equals(neighbor))
        .map(pair -> pair.second)
        .findFirst()
        .orElse(Integer.MAX_VALUE);

  }

  @Override
  public boolean isGoal(State goal) {
    return this.equals(goal);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    CityMap city = (CityMap) obj;
    return this.x == city.x;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x);
  }
}

class Pair<T, U> {
  public final T first;
  public final U second;

  public Pair(T first, U second) {
    this.first = first;
    this.second = second;
  }
}
