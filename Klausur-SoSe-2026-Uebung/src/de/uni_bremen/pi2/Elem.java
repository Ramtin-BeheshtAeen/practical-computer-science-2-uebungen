package de.uni_bremen.pi2;

/**
 * Ein Element einer einfach verketteten Liste.
 *
 * Nachbau der Hilfsklasse aus der Klausur (die Originaldatei liegt im
 * Stud.IP). Nur Konstruktor, Getter und setNext werden von den Aufgaben
 * benutzt.
 *
 * @param <E> Der Typ des gespeicherten Werts.
 */
public class Elem<E>
{
    /** Der Wert dieses Elements. */
    private final E value;

    /** Das nächste Element oder null, wenn dies das letzte ist. */
    private Elem<E> next;

    /**
     * Konstruktor.
     * @param value Der Wert dieses Elements.
     * @param next Das nächste Element oder null.
     */
    public Elem(final E value, final Elem<E> next)
    {
        this.value = value;
        this.next = next;
    }

    /**
     * Liefert den Wert dieses Elements.
     * @return Der Wert.
     */
    public E getValue()
    {
        return value;
    }

    /**
     * Liefert das nächste Element.
     * @return Das nächste Element oder null.
     */
    public Elem<E> getNext()
    {
        return next;
    }

    /**
     * Setzt das nächste Element.
     * @param next Das neue nächste Element oder null.
     */
    public void setNext(final Elem<E> next)
    {
        this.next = next;
    }
}
