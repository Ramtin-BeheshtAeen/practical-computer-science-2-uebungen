package de.uni_bremen.pi2;

/**
 * Die Klasse enthält Operationen auf einfach verketteten Listen.
 * Jede Operation gibt es zweimal: einmal iterativ, einmal rekursiv.
 */
public class List
{
    // ------------------------------------------------------------------
    // concat: zweite Liste an das Ende der ersten Liste anhängen
    // ------------------------------------------------------------------

    /**
     * Hängt zwei einfach verkettete Listen aneinander. Iterative Lösung.
     *
     * Die zweite Liste wird direkt angehängt, nicht kopiert.
     *
     * @param first Das erste Element der ersten Liste. Darf null sein.
     *              should return the second
     * @param second Das erste Element der zweiten Liste. Darf null sein.
     * @param <E> Der Typ der Werte in den Listen.
     * @return Das erste Element der zusammengehängten Liste.
     */
    public static <E> Elem<E> concatIterative(final Elem<E> first, final Elem<E> second)
    {
      if (first == null){
          return second;
      }
      Elem<E> last = first;
      for(; last.getNext() != null; last = last.getNext());
      last.setNext(second);
      return first;
    }

    /**
     * Hängt zwei einfach verkettete Listen aneinander. Rekursive Lösung.
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
        // TODO: Basisfall hast du schon: erste Liste leer -> zweite Liste zurück.
        // TODO: Sonst: first.setNext(concatRecursive(?, ?)); return ?;
        //       Kein Schleife, keine Hilfsvariable. 5 Zeilen insgesamt.
        if (first == null) {return second;}
        first.setNext(concatRecursive(first.getNext(), second));
        return first;
    }

    // ------------------------------------------------------------------
    // insert: Wert sortiert in eine aufsteigend sortierte Liste einfügen
    // ------------------------------------------------------------------

    /**
     * Fügt einen Wert an der richtigen Stelle in eine aufsteigend sortierte
     * Liste ein. Iterative Lösung.
     *
     * Ist die Liste leer oder ist der neue Wert kleiner oder gleich dem ersten
     * Wert, entsteht ein neuer Listenkopf. Bei gleichen Werten wird vor dem
     * bereits vorhandenen Wert eingefügt.
     *
     * @param first Das erste Element der Liste. Darf null sein.
     * @param value Der einzufügende Wert.
     * @param <E> Der Typ der Werte in der Liste.
     * @return Das erste Element der Liste nach dem Einfügen.
     */
    public static <E extends Comparable<E>> Elem<E> insertIterative(final Elem<E> first,
                                                                    final E value)
    {
        // TODO: Sonderfall: vorne einfügen (Liste leer oder value <= first.getValue()).
        // TODO: Sonst: mit einer Schleife das Element davor suchen und dahinter einhängen.
        Elem<E> newValue = new Elem<>(value, null);

        if(value == first.getValue() || first == null){
            first.setNext(newValue);
        }
        Elem<E> current = first;
        while(current.getNext() != null){
            if (current.getValue().compareTo(value) <= 0){
               newValue.setNext(current.getNext());
               current.setNext(newValue);
            }
            current = current.getNext();
        }
        return first;

    }

    /**
     * Fügt einen Wert an der richtigen Stelle in eine aufsteigend sortierte
     * Liste ein. Rekursive Lösung.
     *
     * Ist die Liste leer oder ist der neue Wert kleiner oder gleich dem ersten
     * Wert, entsteht ein neuer Listenkopf. Andernfalls wird der Wert rekursiv
     * in den Rest der Liste eingefügt.
     *
     * @param first Das erste Element der Liste. Darf null sein.
     * @param value Der einzufügende Wert.
     * @param <E> Der Typ der Werte in der Liste.
     * @return Das erste Element der Liste nach dem Einfügen.
     */
    public static <E extends Comparable<E>> Elem<E> insertRecursive(final Elem<E> first,
                                                                    final E value)
    {
        // TODO: Basisfall: first == null oder value <= first.getValue()
        //       -> new Elem<>(value, first)
        // TODO: Sonst: first.setNext(insertRecursive(?, ?)); return ?;
        return null;
    }
}