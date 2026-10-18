package de.uni_bremen.pi2;

/**
 * Aufgabe 5: Forrest (Große Klausur, 30 %).
 * Wiederholungsklausur WiSe 2019/20 – nur einmal vorgekommen, niedrige Priorität.
 *
 * Um einen Wald soll ein Zaun gebaut werden, der alle Bäume umschließt und
 * dabei möglichst kurz ist (konvexe Hülle, Graham-Scan).
 */
public class Forrest
{
    /** Die Zaunpfähle, d.h. die Bäume auf dem Zaun. */
    private static Tree[] fence;

    /** Die Anzahl der gültigen Einträge in fence. */
    private static int fencePosts;

    /**
     * Bestimmt den Zaun um einen Wald (gegeben, nicht verändern).
     * @param trees Die Bäume. Mindestens 3, keine drei auf einer Geraden.
     * @return Die Bäume auf dem Zaun, beginnend mit dem südlichsten,
     *         gegen den Uhrzeigersinn.
     */
    public static Tree[] fence(final Tree[] trees)
    {
        fence = new Tree[trees.length];
        fencePosts = 0;
        createFence(trees.clone());
        final Tree[] result = new Tree[fencePosts];
        for (int i = 0; i < fencePosts; ++i) {
            result[i] = fence[i];
        }
        return result;
    }

    /**
     * Erzeugt den Zaun in fence/fencePosts in drei Schritten:
     * 1. Den südlichsten Baum (kleinstes y) an Index 0 tauschen.
     * 2. Die übrigen Bäume nach dem Winkel sortieren, unter dem sie vom
     *    südlichsten Baum aus gesehen werden (aufsteigend).
     * 3. Die Bäume der Reihe nach als Zaunpfähle anhängen. Liegt der neue Baum
     *    rechts der Geraden durch die letzten beiden Pfähle, wird vorher der
     *    letzte Pfahl entfernt – so oft wie nötig.
     * @param trees Die Bäume. Das Array darf verändert werden.
     */
    private static void createFence(final Tree[] trees)
    {
        // TODO: Aufgabe 5 (Musterlösung: 24 Zeilen)
    }
}
