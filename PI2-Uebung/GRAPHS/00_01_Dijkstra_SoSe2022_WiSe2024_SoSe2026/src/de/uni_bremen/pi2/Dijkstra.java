package de.uni_bremen.pi2;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Aufgabe 5: Kürzeste Wege nach Dijkstra (20 %).
 * Klausur SoSe 2022, WiSe 2023/24 und SoSe 2026 (dort Aufgabe 5, nicht bearbeitet).
 *
 * Es dürfen keine Klassen der Laufzeitbibliothek außer den hier sowieso
 * schon genutzten verwendet werden.
 */
public class Dijkstra
{
    /**
     * Die Methode bestimmt mit dem Verfahren von Dijkstra für jeden Knoten in
     * einem Graphen die Mindestentfernung, in der dieser vom Startknoten aus
     * erreicht werden kann. Es wird nicht nach dem Weg zu einem bestimmten
     * Knoten gesucht.
     * @param adjacencyMatrix Die Nachbarschaftsmatrix. Sie ist quadratisch und
     *         nicht null. Wenn adjacencyMatrix[i][j] ungleich null ist, gibt es
     *         eine Kante von Knoten i zu Knoten j. Der Matrixeintrag selbst gibt
     *         dann die Distanz zwischen beiden an. Ist adjacencyMatrix[i][j]
     *         null, gibt es keine Kante.
     * @param start Der Startknoten. Ist auf jeden Fall ein gültiger Index für
     *         adjacencyMatrix.
     * @return Ein Array, das für jeden Knoten die kürzeste Distanz vom
     *         Startknoten enthält. Die Distanzen sind am Index der jeweiligen
     *         Knotennummern eingetragen. Nicht erreichbare Knoten behalten
     *         Integer.MAX_VALUE.
     */
    public static int[] shortestDistances(final Integer[][] adjacencyMatrix, final int start)
    {
        // Alle Distanzen sind zunächst unendlich, nur der Start hat 0.
        final int[] shortestDistances = new int[adjacencyMatrix.length];
        Arrays.fill(shortestDistances, Integer.MAX_VALUE);
        shortestDistances[start] = 0;

        // Die Front ist nach der bisher bekannten Distanz sortiert.
        final PriorityQueue<Integer> frontier = new PriorityQueue<>(
                (a, b) -> Integer.compare(shortestDistances[a], shortestDistances[b]));
        frontier.add(start);

        while (!frontier.isEmpty()) {
            final int node = frontier.poll();

            // TODO: Aufgabe 5 (Musterlösung: 8 Zeilen)
            // Alle Nachbarn von node durchgehen. Ist der Weg über node kürzer
            // als die bisher bekannte Distanz, diese aktualisieren und den
            // Nachbarn (neu) in die Front einsortieren.
        }
        return shortestDistances;
    }
}
