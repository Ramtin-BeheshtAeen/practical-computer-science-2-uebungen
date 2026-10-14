package de.uni_bremen.pi2;

/**
 * Aufgabe 4: Schwarztiefe der Blätter eines Rot-Schwarz-Baums (20 %).
 *
 * Es dürfen keine Methoden der Laufzeitbibliothek verwendet werden.
 */
public class RBTree
{
    /**
     * Berechnet die Schwarztiefe aller Blätter und überprüft dabei,
     * ob sie tatsächlich immer gleich ist.
     * @param root Die Wurzel des Rot-Schwarz-Baums. Kann null sein
     *             (also ein Blatt).
     * @return Die Schwarztiefe aller Blätter oder -1, wenn sie nicht
     *         überall gleich ist.
     */
    public static int blackDepthOfLeafs(final RBNode root)
    {
        // TODO: Aufgabe 4
        // Deine Struktur aus der Klausur war richtig – behalte sie:
        //   Basisfall null, beide Teilbäume rekursiv, links mit rechts vergleichen.
        // Es fehlten zwei Dinge:
        //   (1) Fehler durchreichen: ist left oder right schon -1, ist das Ergebnis ___.
        //   (2) Zählen: was ein Kind beiträgt, hängt von seiner FARBE ab (isBlack()).
        // Vorher in Worten beantworten: welchen Wert soll ein Baum aus nur
        // einer schwarzen Wurzel liefern? (Siehe testNurWurzel.)
        return -2; // Platzhalter, damit vor deiner Lösung kein Test zufällig grün ist
    }
}
