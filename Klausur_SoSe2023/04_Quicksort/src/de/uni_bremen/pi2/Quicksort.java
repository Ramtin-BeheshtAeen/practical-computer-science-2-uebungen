package de.uni_bremen.pi2;

/**
 * Die Klasse sortiert ein Array mit dem Verfahren Quicksort. Das Aufteilen
 * eines Teilbereichs anhand eines Pivot-Elements übernimmt die Klasse
 * {@link Partition}.
 */
public class Quicksort
{
    /**
     * Sortiert ein Array entsprechend der natürlichen Ordnung seiner Elemente
     * aufsteigend.
     * @param array Das Array, das sortiert wird.
     * @param <E> Der Typ der Elemente des Arrays.
     */
    public static <E extends Comparable<E>> void quicksort(final E[] array)
    {
        // TODO: Aufgabe 4a (Zeile 27 der Musterlösung)
    }

    /**
     * Sortiert einen Teilbereich eines Arrays entsprechend der natürlichen
     * Ordnung seiner Elemente aufsteigend. Der Teilbereich wird anhand eines
     * Pivot-Elements aufgeteilt. Anschließend werden die beiden Teilbereiche
     * links und rechts des Pivot-Elements rekursiv sortiert. Das Pivot-Element
     * selbst steht bereits an seiner endgültigen Position und muss nicht
     * erneut betrachtet werden.
     * @param array Das Array, das sortiert wird.
     * @param bottom Die Untergrenze des zu sortierenden Teilbereichs (inklusiv).
     * @param top Die Obergrenze des zu sortierenden Teilbereichs (exklusiv).
     * @param <E> Der Typ der Elemente des Arrays.
     */
    private static <E extends Comparable<E>> void quicksort(final E[] array,
            final int bottom, final int top)
    {
        // TODO: Aufgabe 4b (Zeilen 33-37 der Musterlösung)
    }
}
