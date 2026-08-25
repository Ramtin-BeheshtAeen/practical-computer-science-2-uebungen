package de.uni_bremen.pi2;


import java.util.Arrays;

/**
 * Debug-Hilfe: dieselben Methoden wie in Sort, aber mit Ausgaben bei jedem
 * Schritt. NICHT abgeben — nur zum Anschauen, was zur Laufzeit passiert.
 * Starten mit: java de.uni_bremen.pi2.SortTrace
 */
public class TestClass
{
    /** Zählt die compareTo-Aufrufe, um den Aufwand sichtbar zu machen. */
    private static int comparisons = 0;

    /**
     * Wie findInsertionPoint, gibt aber jeden Schleifendurchlauf aus.
     * @param a Das Array.
     * @param element Das einzusortierende Element.
     * @param size Die Anzahl der bereits sortierten Elemente am Anfang.
     * @param <T> Der Typ der Elemente.
     * @return Die Einfügestelle.
     */
    private static <T extends Comparable<T>> int findInsertionPoint(final T[] a, final T element,
                                                                    final int size)
    {
        int high = size;
        int low = 0;
        System.out.println("    findInsertionPoint(element=" + element + ", size=" + size
                + ") im sortierten Teil " + Arrays.toString(Arrays.copyOf(a, size)));

        while (low < high) {
            final int mid = (low + high) / 2;
            ++comparisons;
            final int cmp = a[mid].compareTo(element);
            System.out.printf("      low=%d high=%d -> mid=%d, a[%d]=%s  %s %s  ==> ",
                    low, high, mid, mid, a[mid], cmp <= 0 ? "<=" : ">", element);
            if (cmp <= 0) {
                low = mid + 1;
                System.out.println("low = " + low + "   (untere Hälfte weg)");
            }
            else {
                high = mid;
                System.out.println("high = " + high + "  (obere Hälfte weg)");
            }
        }
        System.out.println("      low == high == " + low + "  ==> Einfügestelle " + low);
        return low;
    }

    /**
     * Wie insertionSort, gibt aber das Array nach jedem Teilschritt aus.
     * @param a Das Array, das sortiert wird.
     * @param <T> Der Typ der Elemente.
     */
    public static <T extends Comparable<T>> void insertionSort(final T[] a)
    {
        System.out.println("Start: " + Arrays.toString(a));
        for (int i = 1; i < a.length; ++i) {
            System.out.println("\n--- i = " + i + " ---");
            final T temp = a[i];
            System.out.println("  1. gerettet: temp = " + temp);

            final int point = findInsertionPoint(a, temp, i);

            System.out.println("  3. arraycopy(a, " + point + ", a, " + (point + 1) + ", "
                    + (i - point) + ")"
                    + (i - point == 0 ? "   -> Länge 0, es passiert nichts" : ""));
            System.arraycopy(a, point, a, point + 1, i - point);
            System.out.println("     danach: " + Arrays.toString(a)
                    + "   <- an Index " + point + " steht jetzt ein Duplikat (das Loch)");

            a[point] = temp;
            System.out.println("  4. a[" + point + "] = " + temp
                    + "  ==> " + Arrays.toString(a));
        }
        System.out.println("\nFertig: " + Arrays.toString(a));
    }

    /**
     * Startet die Beispielläufe.
     * @param args Wird nicht benutzt.
     */
    public static void main(final String[] args)
    {
        System.out.println("==================================================");
        System.out.println(" LAUF 1: normaler Ablauf");
        System.out.println("==================================================");
        comparisons = 0;
        insertionSort(new Integer[]{5, 2, 4, 6, 1, 3});
        System.out.println("compareTo-Aufrufe: " + comparisons);

        System.out.println("\n==================================================");
        System.out.println(" LAUF 2: Stabilität (Schlüssel/Kennung, verglichen");
        System.out.println("         wird nur der Schlüssel)");
        System.out.println("==================================================");
        comparisons = 0;
        final Item[] items = {
                new Item(2, 'a'), new Item(1, 'b'), new Item(2, 'c'),
                new Item(1, 'd'), new Item(2, 'e')
        };
        insertionSort(items);
        System.out.println("Gleiche Schlüssel in ursprünglicher Reihenfolge? "
                + (istStabil(items) ? "JA - stabil" : "NEIN - nicht stabil"));

        System.out.println("\n==================================================");
        System.out.println(" LAUF 3: der Bug - size = a.length statt i");
        System.out.println("==================================================");
        kaputt(new Integer[]{5, 2, 4});

        System.out.println("\n==================================================");
        System.out.println(" LAUF 4: Aufwand, N = 1000");
        System.out.println("==================================================");
        vergleicheAufwand();
    }

    /**
     * Zeigt, was passiert, wenn size falsch gewählt wird.
     * @param a Das Array.
     */
    private static void kaputt(final Integer[] a)
    {
        System.out.println("Array: " + Arrays.toString(a) + "  (nur a[0] ist sortiert bei i=1)");
        try {
            final int i = 1;
            final Integer temp = a[i];
            System.out.println("findInsertionPoint mit size = a.length = " + a.length
                    + " statt i = " + i + ":");
            final int point = findInsertionPoint(a, temp, a.length);
            System.out.println("  ==> point = " + point + ", aber gültig wären nur 0 oder 1!");
            System.out.println("  ==> arraycopy-Länge = i - point = " + (i - point));
            System.arraycopy(a, point, a, point + 1, i - point);
        }
        catch (final Exception e) {
            System.out.println("  ==> " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }

    /**
     * Vergleicht die Anzahl der Vergleiche von binärer und linearer Suche.
     */
    private static void vergleicheAufwand()
    {
        final int n = 1000;
        final Integer[] a = new Integer[n];
        for (int i = 0; i < n; ++i) {
            a[i] = n - i; // absteigend = schlechtester Fall
        }

        comparisons = 0;
        final Integer[] binaer = Arrays.copyOf(a, n);
        stillInsertionSort(binaer);
        final int binaereVergleiche = comparisons;

        comparisons = 0;
        final Integer[] linear = Arrays.copyOf(a, n);
        klassischerInsertionSort(linear);
        final int lineareVergleiche = comparisons;

        System.out.println("binäre Suche + arraycopy : " + binaereVergleiche + " Vergleiche");
        System.out.println("klassisch (Vorlesung)    : " + lineareVergleiche + " Vergleiche");
        System.out.println("Faktor                   : "
                + (lineareVergleiche / Math.max(1, binaereVergleiche)) + "x weniger");
        System.out.println("beide Ergebnisse gleich? " + Arrays.equals(binaer, linear));
    }

    /** Ohne Ausgabe, nur zum Zählen. */
    private static <T extends Comparable<T>> void stillInsertionSort(final T[] a)
    {
        for (int i = 1; i < a.length; ++i) {
            final T temp = a[i];
            int low = 0;
            int high = i;
            while (low < high) {
                final int mid = (low + high) / 2;
                ++comparisons;
                if (a[mid].compareTo(temp) <= 0) {
                    low = mid + 1;
                }
                else {
                    high = mid;
                }
            }
            System.arraycopy(a, low, a, low + 1, i - low);
            a[low] = temp;
        }
    }

    /** Die Variante aus der Vorlesung, nur zum Zählen. */
    private static <T extends Comparable<T>> void klassischerInsertionSort(final T[] a)
    {
        for (int i = 1; i < a.length; ++i) {
            final T temp = a[i];
            int j = i - 1;
            while (j >= 0) {
                ++comparisons;
                if (a[j].compareTo(temp) <= 0) {
                    break;
                }
                a[j + 1] = a[j];
                --j;
            }
            a[j + 1] = temp;
        }
    }

    /**
     * Prüft, ob gleiche Schlüssel noch in ursprünglicher Reihenfolge stehen.
     * @param items Das sortierte Array.
     * @return true, wenn stabil sortiert wurde.
     */
    private static boolean istStabil(final Item[] items)
    {
        for (int i = 1; i < items.length; ++i) {
            if (items[i - 1].key == items[i].key && items[i - 1].tag > items[i].tag) {
                return false;
            }
        }
        return true;
    }

    /** Element mit Schlüssel und Kennung. Verglichen wird nur der Schlüssel. */
    private static final class Item implements Comparable<Item>
    {
        final int key;
        final char tag;

        Item(final int key, final char tag)
        {
            this.key = key;
            this.tag = tag;
        }

        @Override
        public int compareTo(final Item other)
        {
            return Integer.compare(key, other.key);
        }

        @Override
        public String toString()
        {
            return "" + key + tag;
        }
    }
}
