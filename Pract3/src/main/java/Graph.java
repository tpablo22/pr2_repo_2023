/*
   Copyright [2023] [Pablo Torres]
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


package Pract3.src.main.java;
*/

import java.util.*;
/**

 * Esta clase representa un grafo genérico.
 *
 * @param <V> el tipo de los vértices en el grafo.
 * @autor Pablo Torres
 * @version 12/05/2023
 * @since 11/03/2023
 */

public class Graph<V> {

    private final Map<V, Set<V>> adjacencyList = new HashMap<>();

    /**
     * Agrega un vértice al grafo.
     *
     * @param v el vértice a agregar.
     * @return true si el vértice se agregó exitosamente, false si ya existía en el grafo.
     */
    public boolean addVertex(V v) {
        return adjacencyList.putIfAbsent(v, new HashSet<>()) == null;
    }

    /**
     * Agrega una arista entre dos vértices en el grafo.
     *
     * @param v1 el primer vértice.
     * @param v2 el segundo vértice.
     * @return true si se agregó la arista exitosamente, false si la arista ya existía.
     */
    public boolean addEdge(V v1, V v2) {
        addVertex(v1);
        addVertex(v2);
        Set<V> adjacents = adjacencyList.get(v1);
        return adjacents.add(v2);
    }

    /**
     * Obtiene los vértices adyacentes a un vértice dado.
     *
     * @param v el vértice del cual se obtienen los adyacentes.
     * @return un conjunto de los vértices adyacentes a v.
     * @throws Exception si el vértice no existe en el grafo.
     */
    public Set<V> obtainAdjacents(V v) throws Exception {
        Set<V> adjacents = adjacencyList.get(v);
        if (adjacents == null) {
            throw new Exception("El vértice no existe");
        }
        return adjacents;
    }

    /**
     * Verifica si el grafo contiene un vértice dado.
     *
     * @param v el vértice a verificar.
     * @return true si el vértice está en el grafo, false de lo contrario.
     */
    public boolean containsVertex(V v) { //Si el vértice está en el conjunto de claves, está en el grafo.
        return adjacencyList.containsKey(v);
    }

    /**
     * Devuelve una representación en cadena del grafo.
     *
     * @return una cadena que muestra los vértices y las aristas del grafo.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<V, Set<V>> entry : adjacencyList.entrySet()) {
            sb.append(entry.getKey());
            sb.append(" -> ");
            sb.append(entry.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Encuentra un camino entre dos vértices en el grafo.
     *
     * @param v1 el vértice de origen.
     * @param v2 el vértice de destino.
     * @return una lista de vértices que representa el camino desde v1 hasta v2, o null si no hay camino.
     */
    public List<V> onePath(V v1, V v2) {
        List<V> camino = new ArrayList<>();
        if (!adjacencyList.containsKey(v1) || !adjacencyList.containsKey(v2)) {
            return null;
        }
        if (v1.equals(v2)) {
            camino.add(v1);
            return camino;
        }
        Set<V> adyacentes = adjacencyList.get(v1);
        for (V v : adyacentes) { //Si el destino es adyacente al origen.
            if (v.equals(v2)) {
                camino.add(v1);
                camino.add(v2);
                return camino;
            }
        }
        for (V v : adyacentes) {
            camino = onePath(v, v2);
            if (camino != null) {
                camino.add(0, v1);
                return camino;
            }
        }
        return null;
    }
}

