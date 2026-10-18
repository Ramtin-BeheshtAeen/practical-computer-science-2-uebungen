package de.uni_bremen.pi2;

/**
 * Aufgabe 3 (SoSe 2019) / Aufgabe 2a (SoSe 2021): Merge.
 * Klausur SoSe 2019 und SoSe 2021.
 *
 * Außer dem Comparable dürfen keine Klassen der Laufzeitbibliothek verwendet
 * werden (die Zeile, die das Ergebnis-Array anlegt, ist vorgegeben).
 */
public class Merge
{
    /**
     * Verschmilzt zwei aufsteigend sortierte Arrays zu einem neuen,
     * aufsteigend sortierten Array. Bei gleichen Elementen kommen die aus
     * array1 zuerst.
     * @param array1 Das erste sortierte Array. Wird nicht null sein.
     * @param array2 Das zweite sortierte Array. Wird nicht null sein.
     * @param <T> Der Typ der Elemente.
     * @return Ein neues Array mit allen Elementen beider Arrays, sortiert.
     */
    public static <T extends Comparable<T>> T[] merge(final T[] array1, final T[] array2)
    {
        @SuppressWarnings("unchecked")
        final T[] result = (T[]) java.lang.reflect.Array.newInstance(
                array1.getClass().getComponentType(), array1.length + array2.length);

        // TODO: Aufgabe (Musterlösung SoSe 2021: 10 Zeilen, SoSe 2019: 3 Zeilen)

        return result;
    }
}
