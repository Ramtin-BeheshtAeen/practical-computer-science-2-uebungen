package de.uni_bremen.pi2;

/**
 * Die Klasse enthält Operationen auf einfach verketteten Listen.
 */
public class List
{
    // ==================================================================
    // Klausur SoSe 2022, Aufgabe 2  Aneinanderhängen zweier Listen (20 %)
    // Bereits gelöst - dient als Vergleich für die anderen Aufgaben.
    // ==================================================================

    /**
     * Hängt zwei einfach verkettete Listen aneinander. Die zweite Liste wird an
     * das Ende der ersten Liste angehängt. Iterative Lösung.
     *
     * Ist die erste Liste leer, ist das Ergebnis die zweite Liste. Andernfalls
     * wird das letzte Element der ersten Liste gesucht und die zweite Liste
     * dahinter gehängt.
     *
     * @param first Das erste Element der ersten Liste. Darf null sein.
     * @param second Das erste Element der zweiten Liste. Darf null sein.
     * @param <E> Der Typ der Werte in den Listen.
     * @return Das erste Element der zusammengehängten Liste.
     */
    public static <E> Elem<E> concatIterative(final Elem<E> first, final Elem<E> second)
    {
        if (first == null) {
            return second;
        }
        Elem<E> last = first;
        for (; last.getNext() != null; last = last.getNext()) ;
        last.setNext(second);
        return first;
    }

    /**
     * Hängt zwei einfach verkettete Listen aneinander. Die zweite Liste wird an
     * das Ende der ersten Liste angehängt. Rekursive Lösung.
     *
     * Ist die erste Liste leer, ist das Ergebnis die zweite Liste. Andernfalls
     * wird der Rest der ersten Liste rekursiv mit der zweiten Liste verkettet.
     *
     * @param first Das erste Element der ersten Liste. Darf null sein.
     * @param second Das erste Element der zweiten Liste. Darf null sein.
     * @param <E> Der Typ der Werte in den Listen.
     * @return Das erste Element der zusammengehängten Liste.
     */
    public static <E> Elem<E> concatRecursive(final Elem<E> first, final Elem<E> second)
    {
        if(first==null){
            return second;
        }
        first.setNext(concatRecursive(first.getNext(), second));
        return first;
    }

    // ==================================================================
    // Aufgabe 3  Einfügen in eine einfach verkettete Liste (20 %)
    // ==================================================================

    /**
     * Fügt einen Wert an einer bestimmten Position in eine einfach verkettete
     * Liste ein. Iterative Lösung.
     *
     * Ist der Index 0, wird ein neues erstes Element erzeugt. Ansonsten wird
     * das Element vor der Einfügeposition gesucht und dahinter eingehängt.
     *
     * @param first Das erste Element der Liste. Darf null sein.
     * @param index Die Position, an der eingefügt wird. Ist mindestens 0 und
     *         höchstens so groß wie die Länge der Liste.
     * @param value Der Wert, der eingefügt wird. Darf null sein.
     * @param <E> Der Typ der Werte in der Liste.
     * @return Das erste Element der Liste nach dem Einfügen.
     */
    public static <E> Elem<E> insertIterative(final Elem<E> first, final int index, final E value)
    {
        if (index == 0) {
            return new Elem<>(value, first);
        }
        else {
            int currentIndex = 0;
            Elem<E> currentElement = first;
            while (currentIndex < index - 1) {
                currentElement = currentElement.getNext();
                ++currentIndex;
            }
            currentElement.setNext(new Elem<>(value, currentElement.getNext()));
            return first;
        }
    }

    /**
     * Fügt einen Wert an einer bestimmten Position in eine einfach verkettete
     * Liste ein. Rekursive Lösung.
     *
     * Ist der Index 0, wird ein neues erstes Element erzeugt. Ist die Liste
     * leer, gibt es nichts, wohinter eingefügt werden könnte. Ansonsten wird
     * rekursiv in den Rest der Liste eingefügt.
     *
     * @param first Das erste Element der Liste. Darf null sein.
     * @param index Die Position, an der eingefügt wird. Ist mindestens 0 und
     *         höchstens so groß wie die Länge der Liste.
     * @param value Der Wert, der eingefügt wird. Darf null sein.
     * @param <E> Der Typ der Werte in der Liste.
     * @return Das erste Element der Liste nach dem Einfügen.
     */
    public static <E> Elem<E> insertRecursive(final Elem<E> first, final int index, final E value)
    {
        // TODO: Aufgabe 3b (rechte Spalte der Musterlösung, 4 Zeilen)
        // Basisfall: index == 0  ->  new Elem<>(value, first)
        // Sonst:     first.setNext(insertRecursive(?, ?, value));  return ?;
        //            Beachte: der Index muss in jedem Aufruf kleiner werden.

       if(index == 0){
           return new Elem<E>(value, first);
       }
       first.setNext(insertRecursive(first.getNext(), index-1, value));
       return first;
    }

    // ==================================================================
    // Aufgabe 1  LinkedList (20 %)
    // Entfernen des ersten Elements mit einem bestimmten Wert.
    // Im Original heißt die Methode remove; hier removeKey, damit sie sich
    // nicht mit dem Entfernen per Index überlädt.
    // ==================================================================

    /**
     * Entfernt das erste Element mit dem angegebenen Wert aus einer einfach
     * verketteten Liste. Rekursive Lösung.
     *
     * Ist die Liste leer, ist das Ergebnis die leere Liste. Enthält das erste
     * Element den gesuchten Wert, ist das Ergebnis der Rest der Liste.
     * Andernfalls wird ein neues Element mit dem Wert des ersten Elements
     * erzeugt, dessen Rest sich aus dem rekursiven Entfernen aus dem Rest der
     * Liste ergibt.
     *
     * Die übergebene Liste wird dabei nicht verändert. Die Elemente vor dem
     * entfernten Element werden neu erzeugt, die Elemente dahinter werden
     * weiterverwendet.
     *
     * @param first Das erste Element der Liste. Darf null sein.
     * @param key Der Wert, dessen erstes Vorkommen entfernt wird.
     * @param <T> Der Typ der Werte in der Liste.
     * @return Das erste Element der Liste nach dem Entfernen.
     */
    public static <T> Elem<T> removeKey(final Elem<T> first, final T key)
    {
        // TODO: Aufgabe 1 (Zeilen 3-11 der Musterlösung)
        // Drei Fälle: Liste leer / erstes Element passt / sonst rekursiv.
        // Der dritte Fall erzeugt ein neues Elem, es wird nichts umgehängt.
        if (first == null || first==key){
            return first.getNext();
        } else {
            first.setNext(removeKey(first.getNext(), key));
        }

        return first;
    }

    // ==================================================================
    // Aufgabe 2  Entfernen aus einer einfach verketteten Liste (20 %)
    // Entfernen des Elements an einer bestimmten Position.
    // ==================================================================

    /**
     * Entfernt das Element an einer bestimmten Position aus einer einfach
     * verketteten Liste. Iterative Lösung.
     *
     * Ist der Index 0, ist das Ergebnis der Rest der Liste. Ansonsten wird das
     * Element vor der zu entfernenden Position gesucht und das nachfolgende
     * Element ausgehängt.
     *
     * @param first Das erste Element der Liste. Darf nicht null sein.
     * @param index Die Position des Elements, das entfernt wird. Ist mindestens
     *         0 und kleiner als die Länge der Liste.
     * @param <E> Der Typ der Werte in der Liste.
     * @return Das erste Element der Liste nach dem Entfernen.
     */
    public static <E> Elem<E> removeIterative(final Elem<E> first, final int index)
    {
        // TODO: Aufgabe 2, iterative Variante.
        // Gleiche Struktur wie insertIterative: Sonderfall index == 0,
        // sonst mit einer Schleife zum Element davor laufen und aushängen.
        if (index==0){
            return first.getNext();
        }

        Elem<E> currentElement = first;
        for (int i = 0; i < index - 1; i++){
            currentElement = currentElement.getNext();
        }
        currentElement.setNext(currentElement.getNext().getNext());
        return first;
    }

    /**
     * Entfernt das Element an einer bestimmten Position aus einer einfach
     * verketteten Liste. Rekursive Lösung.
     *
     * Ist der Index 0, ist das Ergebnis der Rest der Liste. Andernfalls wird
     * rekursiv aus dem Rest der Liste entfernt und das Ergebnis wieder an das
     * erste Element angehängt.
     *
     * @param first Das erste Element der Liste. Darf nicht null sein.
     * @param index Die Position des Elements, das entfernt wird. Ist mindestens
     *         0 und kleiner als die Länge der Liste.
     * @param <E> Der Typ der Werte in der Liste.
     * @return Das erste Element der Liste nach dem Entfernen.
     */
    public static <E> Elem<E> removeRecursive(final Elem<E> first, final int index)
    {
        // TODO: Aufgabe 2 (Zeilen 25-29 der Musterlösung)
        // Basisfall: index == 0  ->  den Rest der Liste zurückgeben.
        // Sonst:     first.setNext(removeRecursive(?, ?));  return ?;
        if(index == 0){
            return first.getNext();
        }
        first.setNext(removeRecursive(first.getNext(), index -1));
        return first;
    }
}











