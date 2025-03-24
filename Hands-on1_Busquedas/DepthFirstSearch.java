import java.util.*;

class DepthFirstSearch {
    public List<String> busquedaUniversalD(Map<String, List<String>> arbol, String inicio, String objetivo) {
        Deque<String> listaAbierta = new ArrayDeque<>();
        Set<String> listaCerrada = new HashSet<>();
        Map<String, String> mapaPadres = new HashMap<>();

        listaAbierta.push(inicio);

        while (!listaAbierta.isEmpty()) {
            String nodoActual = listaAbierta.pop();

            if (!listaCerrada.contains(nodoActual)) {
                listaCerrada.add(nodoActual);
                System.out.println("Nodo actual: " + nodoActual);

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

                List<String> descendientes = arbol.getOrDefault(nodoActual, new ArrayList<>());
                for (int i = descendientes.size() - 1; i >= 0; i--) {
                    String hijo = descendientes.get(i);
                    if (!listaCerrada.contains(hijo)) {
                        listaAbierta.push(hijo);
                        mapaPadres.put(hijo, nodoActual);
                    }
                }
            }
        }

        System.out.println("No se encontró una solución.");
        return null;
    }
}