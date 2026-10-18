package de.uni_bremen.pi2;

/**
 * Gegebene Hilfsklasse für MergeSort (nicht verändern).
 * Nachbau – das Original liegt im Stud.IP.
 */
public class Merge
{
    /**
     * Verschmilzt zwei benachbarte, jeweils sortierte Bereiche
     * [bottom, middle) und [middle, top) eines Arrays zu einem sortierten
     * Bereich [bottom, top).
     * @param array Das Array.
     * @param bottom Der Anfang des ersten Bereichs.
     * @param middle Der Anfang des zweiten Bereichs.
     * @param top Der Index hinter dem Ende des zweiten Bereichs.
     * @param <T> Der Typ der Elemente.
     */
    public static <T extends Comparable<T>> void merge(final T[] array,
            final int bottom, final int middle, final int top)
    {
        final Object[] temp = new Object[top - bottom];
        int i = bottom;
        int j = middle;
        int k = 0;
        while (i < middle && j < top) {
            temp[k++] = array[i].compareTo(array[j]) <= 0 ? array[i++] : array[j++];
        }
        while (i < middle) {
            temp[k++] = array[i++];
        }
        while (j < top) {
            temp[k++] = array[j++];
        }
        for (k = 0; k < temp.length; ++k) {
            @SuppressWarnings("unchecked")
            final T t = (T) temp[k];
            array[bottom + k] = t;
        }
    }
}
