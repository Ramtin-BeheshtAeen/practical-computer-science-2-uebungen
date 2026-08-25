# Praktische Informatik II — Übungsklausur (nach WiSe 2023/24)

**Bearbeitungszeit:** 120 Minuten
**Hilfsmittel:** IntelliJ IDEA, Java-API-Dokumentation

Ergänzen Sie jeweils nur die mit `// TODO` markierten Stellen. Alle übrigen
Klassen sind bereits vollständig implementiert und dürfen nicht verändert
werden. Die Skelette compilieren; vor Ihrer Lösung schlagen die Tests fehl.

> **Hinweis:** Diese Klausur ähnelt SoSe 2022, unterscheidet sich aber in zwei
> Aufgaben: das Verketten der Listen (Aufgabe 2) ist hier **iterativ** zu lösen,
> und die binäre Suche (Aufgabe 3) verwendet einen **Comparator** und liefert
> bei Nichtfinden **-1** (nicht die Einfügeposition).

---

## Aufgabe 1 — Vergrößern der Kapazität eines Arrays dynamischer Größe (20 %)

**Projekt:** `01_Capacity` · **Klasse:** `Capacity`

Ergänzen Sie `grow(int currentCapacity, int indexThatMustFit)`. Verdoppeln Sie
ausgehend von der aktuellen Kapazität so lange, bis der Index hineinpasst (die
Kapazität muss echt größer als der Index sein). Ist die aktuelle Kapazität 0,
beginnen Sie mit 1. Kann nicht mehr verdoppelt werden, ohne den Wertebereich von
`int` zu verlassen, setzen Sie die Kapazität auf `Integer.MAX_VALUE`.

---

## Aufgabe 2 — Aneinanderhängen zweier verketteter Listen (20 %)

**Projekt:** `02_Concat` · **Klasse:** `List`

Ergänzen Sie `concat(Elem<E> first, Elem<E> second)` **iterativ** (ohne
Rekursion). Ist die erste Liste leer, ist das Ergebnis die zweite Liste.
Andernfalls suchen Sie mit einer Schleife das letzte Element der ersten Liste
und hängen die zweite Liste dahinter. Die zweite Liste wird direkt angehängt,
nicht kopiert.

> **Hinweis:** Die Musterlösung verwendet `Elem<E> prev = first;` und eine
> `for`-Schleife, die bis zum letzten Element läuft.

---

## Aufgabe 3 — Implementierung der binären Suche (20 %)

**Projekt:** `03_BinarySearch` · **Klasse:** `BinarySearch`

Ergänzen Sie `binarySearch(E[] array, E key, Comparator<E> order)`. Das Array
ist gemäß der übergebenen Ordnung `order` aufsteigend sortiert. Wird der
Schlüssel gefunden, ist das Ergebnis sein Index; sonst -1 (auch bei leerem
Array).

Verwenden Sie die `bottom`/`top`/`middle`-Schleife mit der Invariante
`bottom + 1 < top`. Vergleichen Sie mit `order.compare(key, array[middle])` und
grenzen Sie den Suchbereich entsprechend ein. Prüfen Sie am Ende, ob an Position
`bottom` tatsächlich der Schlüssel steht.

> **Hinweis:** Der letzte Ausdruck der Musterlösung lautet sinngemäß
> `array.length == 0 || order.compare(key, array[bottom]) != 0 ? -1 : bottom`.

---

## Aufgabe 4 — Höhe eines Binärbaums (20 %)

**Projekt:** `04_TreeHeight` · **Klasse:** `Tree`

Ergänzen Sie `treeHeight(Node<E> root)`. Die Höhe ist die Anzahl der Knoten auf
dem längsten Weg von der Wurzel zu einem Blatt. Ein leerer Baum hat die Höhe 0.
Die Lösung besteht aus einer einzigen rekursiven Zeile mit `Math.max`.

---

## Aufgabe 5 — Kürzeste Wege nach Dijkstra (20 %)

**Projekt:** `05_Dijkstra` · **Klasse:** `Dijkstra`

Ergänzen Sie den Rumpf der `while`-Schleife in `shortestDistances`. Für den aus
der `frontier` entnommenen Knoten `node` relaxieren Sie alle Nachbarn: für jeden
Nachbarn mit einer Kante prüfen Sie, ob der Weg über `node` kürzer ist als die
bisher bekannte Distanz. Wenn ja, aktualisieren Sie die Distanz und fügen den
Nachbarn (neu) in die `frontier` ein.

Nicht erreichbare Knoten behalten `Integer.MAX_VALUE`.

---

## Steigerungsstufen (freiwillig)

| Aufgabe | Stufe 1 | Stufe 2 |
|---|---|---|
| 1 | `grow` in eine echte `DynamicArray`-Klasse einbauen | Verkleinerung bei Unterfüllung |
| 2 | `concat` auch rekursiv schreiben und vergleichen | Drei Listen auf einmal verketten |
| 3 | Erste Fundstelle bei Duplikaten liefern | Statt -1 die Einfügeposition liefern (wie SoSe 2022) |
| 4 | Anzahl der Knoten berechnen | Prüfen, ob der Baum balanciert ist |
| 5 | Zusätzlich den Weg (Vorgänger) zurückgeben | A* mit Heuristik |
