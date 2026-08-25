package de.uni_bremen.pi2;

/**
 * Ein Element einer einfach verketteten Liste. Diese Klasse ist bereits
 * vollständig implementiert und muss nicht verändert werden.
 * @param <E> Der Typ des Werts, der im Element gespeichert wird.
 */
public class Elem<E>
{
    /** Der im Element gespeicherte Wert. */
    private final E value;

    /** Das nachfolgende Element. Ist null, wenn es keines gibt. */
    private Elem<E> next;

    /**
     * Erzeugt ein Element einer einfach verketteten Liste.
     * @param value Der Wert, der im Element gespeichert wird.
     * @param next Das nachfolgende Element. Ist null, wenn es keines gibt.
     */
    public Elem(final E value, final Elem<E> next)
    {
        this.value = value;
        this.next = next;
    }

    /**
     * Liefert den im Element gespeicherten Wert.
     * @return Der gespeicherte Wert.
     */
    public E getValue()
    {
        return value;
    }

    /**
     * Liefert das nachfolgende Element.
     * @return Das nachfolgende Element oder null, wenn es keines gibt.
     */
    public Elem<E> getNext()
    {
        return next;
    }

    /**
     * Setzt das nachfolgende Element.
     * @param next Das neue nachfolgende Element. Darf null sein.
     */
    public void setNext(final Elem<E> next)
    {
        this.next = next;
    }

    /**
     * Erzeugt eine Liste aus einer Folge von Werten.
     * @param values Die Werte, die in die Liste eingetragen werden.
     * @param <E> Der Typ der Werte.
     * @return Das erste Element der Liste oder null, wenn keine Werte
     *         übergeben wurden.
     */
    @SafeVarargs
    public static <E> Elem<E> of(final E... values)
    {
        Elem<E> first = null;
        for (int i = values.length - 1; i >= 0; --i) {
            first = new Elem<>(values[i], first);
        }
        return first;
    }

    /**
     * Liefert eine Darstellung einer Liste als Zeichenkette.
     * @param first Das erste Element der Liste. Darf null sein.
     * @param <E> Der Typ der Werte in der Liste.
     * @return Die Werte der Liste in eckigen Klammern, durch Kommata getrennt.
     */
    public static <E> String toString(Elem<E> first)
    {
        final StringBuilder result = new StringBuilder("[");
        for (; first != null; first = first.getNext()) {
            result.append(first.getValue());
            if (first.getNext() != null) {
                result.append(", ");
            }
        }
        return result.append("]").toString();
    }
}
