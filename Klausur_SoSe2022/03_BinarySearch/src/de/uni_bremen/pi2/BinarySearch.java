package de.uni_bremen.pi2;

/**
 * Die Klasse implementiert die binäre Suche in einem sortierten Array.
 */
public class BinarySearch
{
    /**
     * Sucht mit dem Verfahren der binären Suche einen Schlüssel in einem
     * aufsteigend sortierten Array.
     *
     * Wird der Schlüssel gefunden, ist das Ergebnis sein Index. Wird er nicht
     * gefunden, ist das Ergebnis -1 - (Einfügeposition), also eine negative
     * Zahl, aus der sich die Position ergibt, an der der Schlüssel eingefügt
     * werden müsste, um die Sortierung zu erhalten. Für ein leeres Array ist
     * das Ergebnis -1.
     *
     * @param array Das sortierte Array, in dem gesucht wird.
     * @param key Der Schlüssel, der gesucht wird.
     * @param <E> Der Typ der Elemente des Arrays.
     * @return Der Index des Schlüssels, falls er vorhanden ist, sonst
     *         -1 - Einfügeposition.
     */
    public static <E extends Comparable<E>> int binarySearch(final E[] array, final E key)
    {
        // TODO: Aufgabe 3 (Zeilen 29-44 der Musterlösung)
        return 0;
    }
}
