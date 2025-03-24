import java.util.*;

public class BreadthFirstsearch {
  public List<String> busquedaUniversalB(Map<String, List<Pair<String, Integer>>> grafo, String inicio,
      String objetivo) {
    PriorityQueue<Pair<String, Integer>> listaAbierta = new PriorityQueue<>(
        Comparator.comparingInt(pair -> pair.second));
    List<String> listaCerrada = new ArrayList<>();
    Map<String, String> mapaPadres = new HashMap<>();
    Map<String, Integer> costos = new HashMap<>();

    listaAbierta.add(new Pair<>(inicio, 0));
    costos.put(inicio, 0);

    while (!listaAbierta.isEmpty()) {
      Pair<String, Integer> actual = listaAbierta.poll();
      String nodoActual = actual.first;
      int costoActual = actual.second;

      listaCerrada.add(nodoActual);
      System.out.println("Nodo actual: " + nodoActual + " con costo acumulado: " + costoActual);

      if (nodoActual.equals(objetivo)) {
        System.out.println("¡Objetivo encontrado!");
        List<String> camino = new ArrayList<>();
        while (nodoActual != null) {
          camino.add(nodoActual);
          nodoActual = mapaPadres.get(nodoActual);
        }
        Collections.reverse(camino);
        System.out.println("Camino hacia el objetivo: " + camino);
        return camino;
      }

      for (Pair<String, Integer> vecino : grafo.getOrDefault(nodoActual, new ArrayList<>())) {
        String nodoVecino = vecino.first;
        int costoVecino = vecino.second;
        int nuevoCosto = costoActual + costoVecino;

        if (!listaCerrada.contains(nodoVecino)
            && (!costos.containsKey(nodoVecino) || nuevoCosto < costos.get(nodoVecino))) {
          costos.put(nodoVecino, nuevoCosto);
          listaAbierta.add(new Pair<>(nodoVecino, nuevoCosto));
          mapaPadres.put(nodoVecino, nodoActual);
        }
      }
    }

    System.out.println("No se encontró una solución.");
    return null;
  }
}