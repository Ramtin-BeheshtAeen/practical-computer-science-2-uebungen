package de.uni_bremen.pi2;

import java.util.Comparator;

/**
 * Die Klasse implementiert die binäre Suche in einem sortierten Array mit Hilfe
 * eines Comparators.
 */
public class BinarySearch
{
    /**
     * Sucht mit dem Verfahren der binären Suche einen Schlüssel in einem Array,
     * das gemäß der übergebenen Ordnung aufsteigend sortiert ist.
     *
     * Wird der Schlüssel gefunden, ist das Ergebnis sein Index. Wird er nicht
     * gefunden, ist das Ergebnis -1. Für ein leeres Array ist das Ergebnis
     * ebenfalls -1.
     *
     * @param array Das sortierte Array, in dem gesucht wird.
     * @param key Der Schlüssel, der gesucht wird.
     * @param order Die Ordnung, gemäß der das Array sortiert ist.
     * @param <E> Der Typ der Elemente des Arrays.
     * @return Der Index des Schlüssels, falls er vorhanden ist, sonst -1.
     */
    public static <E> int binarySearch(final E[] array, final E key, final Comparator<E> order)
    {
        // TODO: Aufgabe 3 (Zeilen 27-38 der Musterlösung)
        return 0;
    }
}
