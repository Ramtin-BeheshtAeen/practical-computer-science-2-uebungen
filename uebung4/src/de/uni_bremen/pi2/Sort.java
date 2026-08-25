package de.uni_bremen.pi2;

/** Alternative Implementierung zweier Sortierverfahren. */
public class Sort
{
    /**
     * Sortieren durch Einfügen entsprechend der natürlichen Ordnung der
     * Elemente eines Arrays.
     * Das Suchen nach der Einfügestelle hat hier nur den Aufwand O(log N).
     * Das Verschieben hat aber weiterhin den Aufwand O(N).
     * @param a Das Array, das sortiert wird.
     * @param <T> Der Typ der Elemente des Arrays.**/

    public static <T extends Comparable<T>> void insertionSort(final T[] a)
    {

        // Implementierung hier einfügen
        int i = 1;
        while (i < a.length){
           final T temp = a[i];
           final int point = findInsertionPoint(a, a[i], i);
           System.arraycopy(a, point, a, point + 1, i - point );
           a[point] = temp;
           i += 1;
        }

    }

    private static <T extends Comparable<T>> int findInsertionPoint(final T[] a, final T element, final int size)
    {
        int high = size;
        int low  = 0;
        while(low < high){
            int mid = ((low + high) / 2);
            if (a[mid].compareTo(element) <= 0){ //element was bigger -> cut low
                low = mid + 1;
            } else  { //element is smaller -> cut upper
                high = mid;
            }
        }
        return low;
    }

    /**
     * QuickSort entsprechend der natürlichen Ordnung der Elemente eines
     * Arrays.
     * @param a Das Array, das sortiert wird.
     * @param <T> Der Typ der Elemente des Arrays.
     */
    public static <T extends Comparable<T>> void quickSort(final T[] a)
    {
        quickSort(a, 0, a.length - 1);
    }
    private static <T extends Comparable<T>> void quickSort(final T[] a, final int bottom, final int top){
        final T pivot = selectPivot(a, bottom, top);
        if (pivot == null){return;}

        int i = bottom;
        int j = top;

        while (i <= j){
            for(; a[i].compareTo(pivot) < 0; i++);
            for(; a[j].compareTo(pivot) > 0; j--);
            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }

        }
        quickSort(a, bottom, j);
        quickSort(a,i, top);

    }

    private static <T extends Comparable<T>> T selectPivot( final T[] a, final int bottom, final int top)
    {
       //int i = 0; // fasle
       int i = bottom + 1;
       while(i <= top){
           final int cmp = a[i].compareTo(a[bottom]);
           if( cmp != 0 ){
               return cmp > 0 ? a[i] : a[bottom];
           }
           i += 1;
       }
       return null;
    }

    /**
     * Tauscht zwei Elemente eines Arrays aus.
     * @param a Das Array, in dem die beiden Elemente getauscht werden.
     * @param i Der Index des einen Elements.
     * @param j Der Index des anderen Elements.
     */
    private static void swap(final Object[] a, final int i, final int j)
    {
        final Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
