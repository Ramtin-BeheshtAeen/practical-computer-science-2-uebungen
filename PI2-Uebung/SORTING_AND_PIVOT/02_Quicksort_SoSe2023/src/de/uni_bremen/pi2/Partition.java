package de.uni_bremen.pi2;

/**
 * Gegebene Hilfsklasse für Aufgabe 4 (nicht verändern).
 * Nachbau – das Original liegt im Stud.IP.
 */
public class Partition
{
    /**
     * Teilt den Bereich [bottom, top) eines Arrays anhand eines Pivot-Elements
     * auf. Danach steht das Pivot-Element an seiner endgültigen Position p.
     * Alle Elemente in [bottom, p) sind kleiner, alle in (p, top) größer oder
     * gleich.
     * @param array Das Array.
     * @param bottom Der erste Index des Bereichs.
     * @param top Der Index hinter dem letzten Element des Bereichs.
     *            Es gilt bottom &lt; top.
     * @param <E> Der Typ der Elemente.
     * @return Die Position p des Pivot-Elements.
     */
    public static <E extends Comparable<E>> int partition(final E[] array, final int bottom, final int top)
    {
        final E pivot = array[top - 1];
        int i = bottom;
        for (int j = bottom; j < top - 1; ++j) {
            if (array[j].compareTo(pivot) < 0) {
                swap(array, i++, j);
            }
        }
        swap(array, i, top - 1);
        return i;
    }

    /**
     * Vertauscht zwei Elemente.
     * @param array Das Array.
     * @param i Der eine Index.
     * @param j Der andere Index.
     * @param <E> Der Typ der Elemente.
     */
    private static <E> void swap(final E[] array, final int i, final int j)
    {
        final E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
