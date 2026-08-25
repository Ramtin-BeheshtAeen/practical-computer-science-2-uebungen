package de.uni_bremen.pi2;

/**
 * Die Klasse enthält Operationen auf Rot-Schwarz-balancierten Binärbäumen.
 */
public class RBTree
{
    /**
     * Bestimmt die Schwarztiefe der Blätter eines Rot-Schwarz-Baums, d.h. die
     * Anzahl der schwarzen Knoten auf dem Weg von der Wurzel zu einem Blatt.
     * Blätter sind hier die null-Verweise unterhalb der untersten Knoten. Sie
     * werden selbst nicht mitgezählt.
     *
     * Ist die Schwarztiefe nicht für alle Blätter gleich, ist der Baum kein
     * gültiger Rot-Schwarz-Baum. In diesem Fall wird -1 zurückgeliefert.
     *
     * @param root Die Wurzel des Baums. Ist null, wenn der Baum leer ist.
     * @param <E> Der Typ der in den Knoten gespeicherten Daten.
     * @return Die Schwarztiefe der Blätter oder -1, wenn sie nicht für alle
     *         Blätter gleich ist.
     */
    public static <E> int blackDepthOfLeafs(final RBNode<E> root)
    {
        // TODO: Aufgabe 5 (Zeilen 20-25 der Musterlösung)
        return 0;
    }
}
