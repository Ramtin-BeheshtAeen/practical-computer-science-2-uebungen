package de.uni_bremen.pi2;

/**
 * Die Klasse teilt ein Array anhand eines Pivot-Elements auf.
 */
public class Partition
{
    /**
     * Teilt ein Array so um ein Pivot-Element herum auf, dass am Ende alle
     * Elemente links der Rückgabeposition kleiner als das Pivot-Element sind
     * und alle Elemente ab der Rückgabeposition größer oder gleich dem
     * Pivot-Element sind.
     *
     * Es werden von unten und von oben Elemente gesucht, die auf der falschen
     * Seite stehen, und diese vertauscht, bis sich die Indizes treffen.
     *
     * @param array Das Array, das aufgeteilt wird.
     * @param pivot Das Pivot-Element, anhand dessen aufgeteilt wird.
     * @param <E> Der Typ der Elemente des Arrays.
     * @return Der Index der ersten Position, an der ein Element steht, das
     *         größer oder gleich dem Pivot-Element ist.
     */
    public static <E extends Comparable<E>> int partition(final E[] array, final E pivot)
    {
        // TODO: Aufgabe 3 (Zeilen 30-39 der Musterlösung)
        return 0;
    }

    /**
     * Tauscht zwei Elemente eines Arrays aus. Bereits implementiert.
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
