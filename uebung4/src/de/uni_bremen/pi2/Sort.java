package de.uni_bremen.pi2;

/** Alternative Implementierung zweier Sortierverfahren. */
public class Sort
{
    /**
     * Sortieren durch Einfügen entsprechend der natürlichen Ordnung der
     * Elemente eines Arrays.
     * Das Suchen nach der Einfügestelle hat hier nur den Aufwand O(log N).
     * Das Verschieben hat aber weiterhin den Aufwand O(N).
     * @param a Das Array, das sortiert wird.
     * @param <T> Der Typ der Elemente des Arrays.
     */
    public static <T extends Comparable<T>> void insertionSort(final T[] a)
    {
        // Implementierung hier einfügen
    }

    private static <T extends Comparable<T>> int findInsertionPoint(/* Parameter */)
    {
        return -1; // Ersetzen
    }

    /**
     * QuickSort entsprechend der natürlichen Ordnung der Elemente eines
     * Arrays.
     * @param a Das Array, das sortiert wird.
     * @param <T> Der Typ der Elemente des Arrays.
     */
    public static <T extends Comparable<T>> void quickSort(final T[] a)
    {
        // Implementierung u.a. hier einfügen
    }

    private static <T extends Comparable<T>> T selectPivot(/* Parameter */)
    {
        return null; // Ersetzen
    }

    /**
     * Tauscht zwei Elemente eines Arrays aus.
     * @param a Das Array, in dem die beiden Elemente getauscht werden.
     * @param i Der Index des einen Elements.
     * @param j Der Index des anderen Elements.
     */
    private static void swap(final Object[] a, final int i, final int j)
    {
        final Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
