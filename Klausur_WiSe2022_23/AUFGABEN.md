# Praktische Informatik II — Übungsklausur (nach WiSe 2022/23)

**Bearbeitungszeit:** 120 Minuten
**Hilfsmittel:** IntelliJ IDEA, Java-API-Dokumentation

Ergänzen Sie jeweils nur die mit `// TODO` markierten Stellen. Alle übrigen
Klassen sind bereits vollständig implementiert und dürfen nicht verändert
werden. Die Skelette compilieren; vor Ihrer Lösung schlagen die Tests fehl.

---

## Aufgabe 1 — Pfadsuche mit Backtracking (20 %)

**Projekt:** `01_Backtracking` · **Klasse:** `Maze`

In einem Labyrinth soll mit dem Verfahren des Backtrackings ein Pfad vom Start
zum Ziel gefunden werden. Ein Pfad ist eine Folge von Richtungen (0, 1, 2, 3).
Der Pfad wird auf einem `Stack<Integer>` verwaltet; eine -1 bedeutet, dass für
den aktuellen Schritt noch keine Richtung probiert wurde.

Ergänzen Sie den Rumpf der `while`-Schleife in `solve(Labyrinth, Stack<Integer>)`:

1. Erhöhen Sie in einer `do-while`-Schleife die oberste Richtung so lange um 1,
   bis sie begehbar ist (`maze.isValid(path)`) oder alle vier Richtungen (0..3)
   ausprobiert wurden.
2. Ist die oberste Richtung danach größer als 3, entfernen Sie den Schritt vom
   Stack (Backtracking).
3. Ist das Ziel erreicht (`maze.targetReached(path)`), geben Sie den Pfad zurück.
4. Andernfalls beginnen Sie einen neuen Schritt, indem Sie -1 auf den Stack legen.

Gibt es keinen Weg, liefert die Methode `null`.

---

## Aufgabe 2 — Entfernen aus einer einfach verketteten Liste (20 %)

**Projekt:** `02_ListRemove` · **Klasse:** `List`

Ergänzen Sie `remove(Elem<E> first, int index)` **rekursiv**. Ist der Index 0,
wird das erste Element entfernt (sein Nachfolger wird zum neuen Kopf).
Andernfalls wird rekursiv aus dem Rest der Liste entfernt. Die Methode liefert
das erste Element der Liste nach dem Entfernen zurück.

---

## Aufgabe 3 — Array aufteilen anhand eines Pivot-Elements (20 %)

**Projekt:** `03_Partition` · **Klasse:** `Partition`

Ergänzen Sie `partition(E[] array, E pivot)`. Das Array soll so umgeordnet
werden, dass links des zurückgegebenen Index nur Elemente stehen, die kleiner
als das Pivot-Element sind, und ab dem zurückgegebenen Index nur Elemente, die
größer oder gleich dem Pivot-Element sind.

Suchen Sie dazu mit zwei Indizes von unten bzw. von oben jeweils Elemente, die
auf der falschen Seite stehen, und vertauschen Sie diese, bis sich die Indizes
treffen. Rückgabe ist der Index der ersten Position auf der „größer-gleich"-Seite.

---

## Aufgabe 4 — Anzahl der Knoten in einem Binärbaum (20 %)

**Projekt:** `04_NodeCount` · **Klasse:** `Tree`

Ergänzen Sie `nodeCount(Node<E> root)`. Die Methode liefert die Anzahl der
Knoten im Baum. Ein leerer Baum (`null`) hat 0 Knoten. Die Lösung besteht aus
einer einzigen rekursiven Zeile.

---

## Aufgabe 5 — Minimal aufspannende Bäume nach Jarnik, Prim und Dijkstra (20 %)

**Projekt:** `05_MST` · **Klasse:** `MST`

Ergänzen Sie den Rumpf der `while`-Schleife in `minimumSpanningTree`. Aus der
`frontier` (einer Prioritätswarteschlange, die Kanten `{von, nach}` nach
aufsteigendem Gewicht liefert) wird die leichteste Kante `edge` entnommen.

Ist der Zielknoten `edge[1]` noch nicht im Baum (`edges[edge[1]] == -1`), fügen
Sie ihn hinzu, indem Sie `edges[edge[1]] = edge[0]` setzen und anschließend alle
ausgehenden Kanten von `edge[1]` in die `frontier` einfügen (`{edge[1], neighbor}`
für jeden Nachbarn mit `adjacencyMatrix[edge[1]][neighbor] != null`).

Das Ergebnis ist ein Array mit dem Vorgänger jedes Knotens im aufspannenden Baum.

---

## Steigerungsstufen (freiwillig)

| Aufgabe | Stufe 1 | Stufe 2 |
|---|---|---|
| 1 | Kürzesten Pfad statt irgendeines finden | Alle Pfade zählen |
| 2 | `remove` iterativ statt rekursiv | Ein Element per Wert (statt Index) entfernen |
| 3 | Vollständiges Quicksort auf `partition` aufbauen | Drei-Wege-Partitionierung (Duplikate in die Mitte) |
| 4 | Höhe des Baums berechnen | Anzahl der Blätter berechnen |
| 5 | Gesamtgewicht des MST zurückgeben | Kruskal mit Union-Find statt Prim |
