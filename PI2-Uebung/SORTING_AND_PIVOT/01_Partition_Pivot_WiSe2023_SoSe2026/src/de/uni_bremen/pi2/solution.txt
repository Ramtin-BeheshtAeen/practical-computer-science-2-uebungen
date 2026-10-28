package de.uni_bremen.pi2;

/**
 * Aufgabe 3: Array aufteilen anhand eines Pivot-Elements (20 %).
 * Klausur WiSe 2022/23 und SoSe 2026 (dort Aufgabe 3, nicht bearbeitet).
 *
 * Außer dem Comparable dürfen keine Klassen der Laufzeitbibliothek
 * verwendet werden.
 */
public class Partition
{
    /**
     * Teilt ein Array so auf, dass vorne alle Elemente stehen, die kleiner als
     * das Pivot-Element sind, und dahinter alle, die größer oder gleich sind.
     * Die Reihenfolge innerhalb der beiden Teile ist egal. Es dürfen nur
     * Elemente vertauscht werden (Methode swap).
     * @param array Das Array, das aufgeteilt wird. Wird nicht null sein, seine
     *              Elemente auch nicht.
     * @param pivot Das Pivot-Element. Muss nicht im Array vorkommen.
     * @param <E> Der Typ der Elemente.
     * @return Der Index des ersten Elements, das größer oder gleich dem
     *         Pivot-Element ist, d.h. die Anzahl der kleineren Elemente.
     */
    public static <E extends Comparable<E>> int partition(final E[] array, final E pivot)
    {
        int i = 0;
        for (int j = 0; j <= array.length - 1; j++){
            if(array[j].compareTo(pivot) < 0){
                swap(array, i, j);
                i++;
            }
        }
        return i;
    }

    /**
     * Vertauscht zwei Elemente eines Arrays.
     * @param array Das Array.
     * @param i Der Index des einen Elements.
     * @param j Der Index des anderen Elements.
     * @param <E> Der Typ der Elemente.
     */
    private static <E> void swap(final E[] array, final int i, final int j)
    {
        final E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
