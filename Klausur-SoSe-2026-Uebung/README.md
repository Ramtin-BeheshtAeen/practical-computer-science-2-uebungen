# PI-2 Klausur SoSe 2026 – Übungsprojekt

Gleicher Aufbau wie bei den alten Klausuren: pro Aufgabe eine Quelldatei mit `TODO` und eine JUnit-5-Testdatei, Paket `de.uni_bremen.pi2`.

```
src/de/uni_bremen/pi2/
    Array.java        Aufgabe 1 – TODO (mit Struktur-Hinweis)
    LinkedList.java   Aufgabe 2 – TODO (zum Wiederholen aus dem Kopf)
    RBTree.java       Aufgabe 4 – TODO (mit Struktur-Hinweis)
    Elem.java         Hilfsklasse Liste   (Nachbau)
    RBNode.java       Hilfsklasse RB-Baum (Nachbau)
test/de/uni_bremen/pi2/
    ArrayTest.java       12 Tests
    LinkedListTest.java   7 Tests
    RBTreeTest.java      10 Tests
```

Jede Testmethode entspricht einer Zeile der Bewertungs-E-Mail (Punkte stehen im Javadoc), plus ein paar Zusatztests.

## Benutzen

IntelliJ: `src` als Sources Root, `test` als Test Sources Root, JUnit 5 hinzufügen (Alt+Enter auf `@Test`). Dann die Testklasse starten.

## Gegenprobe mit deiner Abgabe

Mit deinen abgegebenen Dateien statt der Stubs liefern die Tests dasselbe Bild wie die Bewertung:

| Test | deine Abgabe |
|---|---|
| ArrayTest | 7/12 – alle „4 weitere“-Tests brechen mit `Index 4 out of bounds for length 4` ab |
| LinkedListTest | 7/7 |
| RBTreeTest | 3/10 – liefert für jeden Baum 0 |

## Wichtig: Annahmen

- `Elem` und `RBNode` sind **nachgebaut**. Die Originale liegen im Stud.IP – wenn dort die Farbe z.B. über `getColor()` statt `isBlack()` abgefragt wird, die Tests und den Stub entsprechend anpassen.
- Zählweise Schwarztiefe: Wurzel wird nicht mitgezählt, ein Baum aus nur einer schwarzen Wurzel hat Tiefe 0. Das ist aus dem Testfall „nur Wurzel“ abgeleitet, den deine Abgabe (die 0 liefert) bestanden hat.
- Aufgaben 3 (Pivot) und 5 (Dijkstra) fehlen noch – dafür brauche ich die Aufgabenstellungen.
