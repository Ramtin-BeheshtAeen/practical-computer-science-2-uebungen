package de.uni_bremen.pi2;

import javax.swing.*;
import java.security.Key;
import java.util.Comparator;

/**
 * Aufgabe 3: Implementierung der binären Suche (20 %).
 * Klausur WiSe 2023/24 (Variante mit Comparator, -1 bei Misserfolg).
 *
 * Außer dem Comparator dürfen keine Klassen der Laufzeitbibliothek verwendet
 * werden.
 */
public class BinarySearch
{
    /**
     * Implementiert eine binäre Suche in einem Array. Die Anzahl der Vergleiche
     * zwischen Objekten der Klasse T darf log_2(array.length) + 1 nicht
     * überschreiten.
     * @param array Das Array, in dem gesucht wird. Es ist entsprechend der
     *              Ordnungsrelation aufsteigend sortiert und wird nicht null
     *              sein und seine Elemente ebenfalls nicht.
     * @param key Der Wert, nach dem gesucht wird. Wird nicht null sein.
     * @param order Die Ordnungsrelation, nach der das Array sortiert ist.
     * @param <T> Der Typ der Elemente.
     * @return Der Index der Fundstelle. Ist der gesuchte Wert nicht enthalten,
     *         wird -1 zurückgegeben.
     */
    public static <T> int binarySearch(final T[] array, final T key, final Comparator<T> order)
    {
        // TODO: Aufgabe 3 (Musterlösung: 12 Zeilen)
        int left  = 0;
        int right = array.length - 1 ;

        while(left <= right){
            int mid = (left + right) / 2;
            int c = order.compare(array[mid], key);
            if (c == 0 ){
                return mid;
            } else if (c < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
