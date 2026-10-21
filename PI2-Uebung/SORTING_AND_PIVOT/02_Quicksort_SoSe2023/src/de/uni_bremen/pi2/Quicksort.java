package de.uni_bremen.pi2;

/**
 * Aufgabe 4: Sortieren eines Arrays mit Quicksort (20 %).
 * Klausur SoSe 2023.
 *
 * Außer dem Comparable dürfen keine Klassen der Laufzeitbibliothek verwendet
 * werden. Beachtet, dass ihr für diese Aufgabe eine Hilfsmethode
 * implementieren müsst.
 */
public class Quicksort
{
    /**
     * Sortieren eines Arrays mit dem Quicksort-Algorithmus.
     * Nutzt hierbei die Methode Partition.partition zum Aufteilen des zu
     * sortierenden Bereichs in die Folgen der kleineren und der größeren
     * Elemente.
     * @param array Das Array, das aufsteigend sortiert wird. Wird nicht null sein.
     * @param <E> Der Typ der Elemente des Arrays.
     */
    public static <E extends Comparable<E>> void quicksort(final E[] array)
    {
        // TODO: Aufgabe 4 (Musterlösung: 1 Zeile hier + Hilfsmethode mit 7 Zeilen)
        quicksort2(array, 0, array.length);

    }

    private static <E extends Comparable<E>> void quicksort2(final E[] array, final int low, final int high){
        if(low >= high){
            return;
        }
        int pivot =  Partition.partition(array, low, high);
        quicksort2(array, low, pivot);
        quicksort2(array, pivot + 1, high);
    }

}
