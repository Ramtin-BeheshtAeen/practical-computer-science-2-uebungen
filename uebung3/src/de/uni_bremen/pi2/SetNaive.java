package de.uni_bremen.pi2;

/**
 * Dies ist der Anfang einer Implementierung der naiven Selbstanordnungsstrategie.
 * Er muss erweitert werden. Für die anderen Strategien sollen ähnliche Klassen
 * erzeugt werden.
 */
public class SetNaive<E> extends Set<E>
{
    /**
     * Fügt der Menge ein neues Element hinzu. Die Methode wird von "add"
     * aufgerufen, wenn das Element noch nicht vorhanden ist.
     * @param element Das Element, das hinzugefügt wird.
     */
    @Override
    void addToList(final E element)
    {
        // Hier das Einfügen an den Anfang implementieren.
    }

    /**
     * Testet, ob ein bestimmtes Element in der Menge gespeichert ist.
     * @param element Das Element, das nach dem gesucht wird. Das Element darf
     *                auch "null" sein, wäre dann aber garantiert nicht enthalten.
     * @return        Ist das gesuchte Element in der Menge enthalten?
     */
    @Override
    public boolean contains(final E element)
    {
        // Hier das Suchen ohne Umordnung der Liste implementieren.
        // Hierzu darf nicht der Iterator genutzt werden.
        return false; // Ersetzen
    }
}
