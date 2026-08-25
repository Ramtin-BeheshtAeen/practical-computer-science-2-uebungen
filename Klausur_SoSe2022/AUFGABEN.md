# Praktische Informatik II — Übungsklausur (nach SoSe 2022)

**Bearbeitungszeit:** 120 Minuten
**Hilfsmittel:** IntelliJ IDEA, Java-API-Dokumentation

Ergänzen Sie jeweils nur die mit `// TODO` markierten Stellen. Alle übrigen
Klassen sind bereits vollständig implementiert und dürfen nicht verändert
werden. Die Skelette compilieren; vor Ihrer Lösung schlagen die Tests fehl.

---

## Aufgabe 1 — Vergrößern der Kapazität eines Arrays dynamischer Größe (20 %)

**Projekt:** `01_Capacity` · **Klasse:** `Capacity`

Ergänzen Sie `grow(int currentCapacity, int indexThatMustFit)`. Die Methode
berechnet die neue Kapazität eines dynamischen Arrays, sodass der Index
`indexThatMustFit` hineinpasst (die Kapazität muss also echt größer als dieser
Index sein).

Verdoppeln Sie ausgehend von der aktuellen Kapazität so lange, bis der Index
hineinpasst. Ist die aktuelle Kapazität 0, beginnen Sie mit 1. Kann nicht mehr
verdoppelt werden, ohne den Wertebereich von `int` zu verlassen, setzen Sie die
Kapazität auf `Integer.MAX_VALUE`.

### Bewertungskriterien (20 Punkte)

- Die Größe bleibt gleich, wenn gerade keine Vergrößerung notwendig ist (4/4 P.)
- Die Größe verändert sich um eine Stufe, wenn dies gerade notwendig ist (4/4 P.)
- Eine Anfangskapazität von 0 funktioniert (4/4 P.)
- Das Erreichen der Maximalkapazität funktioniert (4/4 P.)

---

## Aufgabe 2 — Aneinanderhängen zweier verketteter Listen (20 %)

**Projekt:** `02_Concat` · **Klasse:** `List`

Ergänzen Sie `concat(Elem<E> first, Elem<E> second)` **rekursiv**. Die zweite
Liste wird an das Ende der ersten angehängt. Ist die erste Liste leer, ist das
Ergebnis die zweite Liste. Die zweite Liste wird direkt angehängt, nicht kopiert.

### Bewertungskriterien (20 Punkte)

- Das Ergebnis ist richtig, wenn die erste Liste leer ist (5/5 P.)
- Das Ergebnis ist richtig, wenn die zweite Liste leer ist (5/5 P.)
- Das Ergebnis ist richtig, wenn keine der beiden Listen leer ist (10/10 P.)

---

## Aufgabe 3 — Implementierung der binären Suche (20 %)

**Projekt:** `03_BinarySearch` · **Klasse:** `BinarySearch`

Ergänzen Sie `binarySearch(E[] array, E key)`. Wird der Schlüssel gefunden, ist
das Ergebnis sein Index. Wird er nicht gefunden, ist das Ergebnis
`-1 - Einfügeposition`, also eine negative Zahl, aus der sich die Position
ergibt, an der der Schlüssel eingefügt werden müsste. Für ein leeres Array ist
das Ergebnis -1.

Verwenden Sie die klassische `bottom`/`top`/`middle`-Schleife mit der Invariante
`bottom + 1 < top` und bestimmen Sie am Ende mit einem Vergleich, ob der
Schlüssel gefunden wurde.

> **Hinweis:** Der letzte Ausdruck der Musterlösung lautet sinngemäß
> `comp == 0 ? bottom : -1 - (comp < 0 ? bottom : top)`.

---

## Aufgabe 4 — Höhe eines Binärbaums (20 %)

**Projekt:** `04_TreeHeight` · **Klasse:** `Tree`

Ergänzen Sie `treeHeight(Node<E> root)`. Die Höhe ist die Anzahl der Knoten auf
dem längsten Weg von der Wurzel zu einem Blatt. Ein leerer Baum hat die Höhe 0,
ein Baum aus nur einer Wurzel die Höhe 1. Die Lösung besteht aus einer einzigen
rekursiven Zeile mit `Math.max`.

---

## Aufgabe 5 — Kürzeste Wege nach Dijkstra (20 %)

**Projekt:** `05_Dijkstra` · **Klasse:** `Dijkstra`

Ergänzen Sie den Rumpf der `while`-Schleife in `shortestDistances`. Für den aus
der `frontier` entnommenen Knoten `node` sollen alle Nachbarn relaxiert werden:

Für jeden Nachbarn mit `adjacencyMatrix[node][neighbor] != null` prüfen Sie, ob
der Weg über `node` kürzer ist als die bisher bekannte Distanz
(`shortestDistances[node] + distance < shortestDistances[neighbor]`). Wenn ja,
aktualisieren Sie `shortestDistances[neighbor]` und fügen den Nachbarn (neu) in
die `frontier` ein.

Das Ergebnis ist ein Array mit der kürzesten Distanz jedes Knotens vom
Startknoten; nicht erreichbare Knoten behalten `Integer.MAX_VALUE`.

---

## Steigerungsstufen (freiwillig)

| Aufgabe | Stufe 1 | Stufe 2 |
|---|---|---|
| 1 | `grow` in eine echte `DynamicArray`-Klasse einbauen | Verkleinerung bei Unterfüllung |
| 2 | `concat` iterativ statt rekursiv | Drei Listen auf einmal verketten |
| 3 | Erste Fundstelle bei Duplikaten liefern | Interpolationssuche |
| 4 | Anzahl der Knoten berechnen | Prüfen, ob der Baum balanciert ist |
| 5 | Zusätzlich den Weg (Vorgänger) zurückgeben | A* mit Heuristik |
