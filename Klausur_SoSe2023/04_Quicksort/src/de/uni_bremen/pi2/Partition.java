package de.uni_bremen.pi2;

/**
 * Die Klasse teilt einen Teilbereich eines Arrays anhand eines Pivot-Elements
 * auf. Diese Klasse ist bereits vollständig implementiert und muss nicht
 * verändert werden.
 */
public class Partition
{
    /**
     * Teilt einen Teilbereich eines Arrays anhand eines Pivot-Elements so auf,
     * dass alle Elemente links des Pivot-Elements kleiner als dieses sind und
     * alle Elemente rechts davon größer oder gleich diesem sind.
     * @param array Das Array, in dem aufgeteilt wird.
     * @param bottom Die Untergrenze des Teilbereichs (inklusiv).
     * @param top Die Obergrenze des Teilbereichs (exklusiv). Muss größer als
     *         bottom sein.
     * @param <E> Der Typ der Elemente des Arrays.
     * @return Der Index, an dem das Pivot-Element nach dem Aufteilen steht.
     */
    public static <E extends Comparable<E>> int partition(final E[] array,
            final int bottom, final int top)
    {
        final E pivot = array[bottom];
        int i = bottom + 1;
        int j = top - 1;
        while (true) {
            // Von unten Element suchen, das größer-gleich Pivot ist.
            for (; i < top && array[i].compareTo(pivot) < 0; ++i);

            // Von oben Element suchen, das kleiner als Pivot ist.
            for (; j > bottom && array[j].compareTo(pivot) >= 0; --j);

            // Fertig, wenn Indizes aneinander vorbeigelaufen sind.
            if (i >= j) {
                break;
            }

            // Ansonsten vertauschen und weitersuchen.
            swap(array, i, j);
        }

        // Pivot an die Nahtstelle tauschen (steht nun richtig).
        swap(array, i - 1, bottom);
        return i - 1;
    }

    /**
     * Tauscht zwei Elemente eines Arrays aus.
     * @param array Das Array, in dem getauscht wird.
     * @param i Der Index des einen Elements.
     * @param j Der Index des anderen Elements.
     * @param <E> Der Typ der Elemente des Arrays.
     */
    private static <E> void swap(final E[] array, final int i, final int j)
    {
        final E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
