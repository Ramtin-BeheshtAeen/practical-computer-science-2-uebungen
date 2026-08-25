# Praktische Informatik II — Übungsklausur (nach SoSe 2023)

**Bearbeitungszeit:** 120 Minuten
**Hilfsmittel:** IntelliJ IDEA, Java-API-Dokumentation

Ergänzen Sie jeweils nur die Stellen, die mit `// TODO` markiert sind. Alle
übrigen Klassen sind bereits vollständig implementiert und dürfen nicht
verändert werden. Die Tests im Verzeichnis `test` prüfen Ihre Lösung. Sie
dürfen die Tests ausführen, so oft Sie möchten.

---

## Aufgabe 1 — Anhängen an Array dynamischer Größe (20 %)

**Projekt:** `01_DynamicArray` · **Klasse:** `DynamicArray<E>`

Die Klasse `DynamicArray<E>` implementiert ein Array, das beliebig viele
Elemente aufnehmen kann. Intern wird ein gewöhnliches Java-Array verwendet,
dessen Kapazität bei Bedarf vergrößert wird.

**a)** Ergänzen Sie die Methode `append(E element)`. Reicht die Kapazität des
internen Arrays nicht mehr aus, ist ein neues Array anzulegen und der bisherige
Inhalt dorthin zu kopieren. Für die neue Kapazität gilt:

- Ist die bisherige Kapazität 0, beträgt die neue Kapazität 1.
- Andernfalls wird die Kapazität verdoppelt.
- Kann nicht mehr verdoppelt werden, ohne den Wertebereich von `int` zu
  verlassen, wird die Kapazität auf `Integer.MAX_VALUE` gesetzt.

**b)** Ergänzen Sie die Methode `get(int index)`. Ist der Index nicht kleiner
als die Anzahl der gespeicherten Elemente, ist eine
`ArrayIndexOutOfBoundsException` zu werfen.

> **Hinweis:** Verwenden Sie zum Anlegen des neuen Arrays
> `(E[]) new Object[...]` zusammen mit `@SuppressWarnings("unchecked")`.

### Bewertungskriterien (20 Punkte)

- Die Größe verhält sich beim Hinzufügen des ersten Elements korrekt (2/2 P.)
- Die Größe verhält sich beim Hinzufügen von 4 weiteren Elementen 4-mal korrekt (4/4 P.)
- Die Kapazität verhält sich beim Hinzufügen des ersten Elements korrekt (2/2 P.)
- Die Kapazität verhält sich beim Hinzufügen von 4 weiteren Elementen 4-mal korrekt (4/4 P.)
- Das Auslesen verhält sich nach dem Hinzufügen des ersten Elements korrekt (2/2 P.)
- Das Auslesen verhält sich nach dem Hinzufügen von 4 weiteren Elementen 4-mal korrekt (4/4 P.)
- Das Auslesen jenseits der Größe wird korrekt erkannt (2/2 P.)

---

## Aufgabe 2 — Sudoku lösen mit Backtracking (20 %)

**Projekt:** `02_Sudoku` · **Klasse:** `Sudoku`

Ein 4×4-Sudoku soll mit dem Verfahren des Backtrackings gelöst werden. In jeder
Zeile, jeder Spalte und jedem der vier 2×2-Blöcke muss jede der Ziffern 1 bis 4
genau einmal vorkommen.

Die bisher gesetzten Ziffern werden auf einem `Stack<Integer>` verwaltet. Die
Ziffern beziehen sich der Reihe nach auf die freien Felder. Das oberste Element
ist die zuletzt gesetzte Ziffer. Eine 0 bedeutet, dass für dieses Feld noch
keine Ziffer probiert wurde.

Ergänzen Sie den Rumpf der `while`-Schleife in der privaten Methode
`solve(Board, Stack<Integer>)`. Ein Schleifendurchlauf soll:

1. die oberste Ziffer des Stacks um 1 erhöhen,
2. sie vom Stack entfernen, wenn sie danach größer als 4 ist (Backtracking),
3. andernfalls die Belegung mit `sudoku.check(numbers)` prüfen und
   - bei `COMPLETE` den Stack als Lösung zurückgeben,
   - bei `VALID` eine 0 auf den Stack legen (nächstes freies Feld),
   - bei `INVALID` nichts weiter tun.

Ist der Stack leer, gibt es keine Lösung; die Methode liefert dann `null`.

### Bewertungskriterien (20 Punkte)

- Das Lösen eines Sudokus mit nur einem freien Feld ohne Weiterzählen funktioniert korrekt (3/3 P.)
- Das Lösen eines Sudokus mit nur einem freien Feld mit Weiterzählen funktioniert korrekt (3/3 P.)
- Das Lösen eines Sudokus mit zwei freien Feldern ohne Weiterzählen funktioniert korrekt (3/3 P.)
- Das Lösen eines Sudokus mit zwei freien Feldern mit Weiterzählen funktioniert korrekt (3/3 P.)
- Backtracking über mehrere Felder funktioniert korrekt (4/4 P.)
- Ein unlösbares Sudoku wird korrekt erkannt (4/4 P.)

---

## Aufgabe 3 — Element in einfach verkettete Liste einfügen (20 %)

**Projekt:** `03_List` · **Klasse:** `List`

Ein Wert soll an einer bestimmten Position in eine einfach verkettete Liste
eingefügt werden. Der Index ist mindestens 0 und höchstens so groß wie die
Länge der Liste.

**a)** Ergänzen Sie `insertIterative(Elem<E> first, int index, E value)`.
Ist der Index 0, entsteht ein neuer Listenkopf. Andernfalls wird das Element
vor der Einfügeposition gesucht und der neue Knoten dahinter eingehängt.

**b)** Ergänzen Sie `insertRecursive(Elem<E> first, int index, E value)`.
Lösen Sie die Aufgabe rekursiv, ohne Schleife.

> **Hinweis:** Beide Methoden liefern das erste Element der Liste nach dem
> Einfügen zurück. Bei Index 0 ist das ein anderes Element als vorher.

### Bewertungskriterien (20 Punkte)

- Das Einfügen in eine leere Liste funktioniert korrekt (3/3 P.)
- Das Einfügen am Anfang der Liste funktioniert korrekt (4/4 P.)
- Das Einfügen in der Mitte der Liste funktioniert korrekt (4/4 P.)
- Das Einfügen am Ende der Liste funktioniert korrekt (4/4 P.)
- Die rekursive Lösung ist tatsächlich rekursiv (5/5 P.)

---

## Aufgabe 4 — Sortieren eines Arrays mit Quicksort (20 %)

**Projekt:** `04_Quicksort` · **Klasse:** `Quicksort`

Ein Array soll mit dem Verfahren Quicksort aufsteigend sortiert werden. Das
Aufteilen eines Teilbereichs anhand eines Pivot-Elements übernimmt die bereits
implementierte Klasse `Partition`. Die Methode
`Partition.partition(array, bottom, top)` liefert den Index zurück, an dem das
Pivot-Element nach dem Aufteilen steht. Dieses Element steht damit bereits an
seiner endgültigen Position.

**a)** Ergänzen Sie die öffentliche Methode `quicksort(E[] array)`, die das
gesamte Array sortiert.

**b)** Ergänzen Sie die private Methode `quicksort(E[] array, int bottom, int top)`.
Der Teilbereich reicht von `bottom` (inklusiv) bis `top` (exklusiv). Enthält er
höchstens ein Element, ist nichts zu tun.

### Bewertungskriterien (20 Punkte)

- Ein leeres Array und ein Array mit einem Element werden korrekt behandelt (4/4 P.)
- Ein Array mit zwei Elementen wird korrekt sortiert (4/4 P.)
- Ein bereits sortiertes und ein absteigend sortiertes Array werden korrekt sortiert (4/4 P.)
- Ein Array mit Duplikaten wird korrekt sortiert (4/4 P.)
- Das Pivot-Element wird nicht erneut in die Rekursion einbezogen (4/4 P.)

---

## Aufgabe 5 — Blatt-Schwarztiefe im Rot-Schwarz-Baum (20 %)

**Projekt:** `05_RedBlackTree` · **Klasse:** `RBTree`

Ergänzen Sie die Methode `blackDepthOfLeafs(RBNode<E> root)`. Sie bestimmt die
Anzahl der schwarzen Knoten auf dem Weg von der Wurzel zu den Blättern. Blätter
sind hier die `null`-Verweise unterhalb der untersten Knoten; sie werden selbst
nicht mitgezählt.

Ist die Schwarztiefe nicht für alle Blätter gleich, ist der Baum kein gültiger
Rot-Schwarz-Baum. In diesem Fall liefert die Methode `-1`. Ein Teilbaum, der
bereits `-1` liefert, macht auch den gesamten Baum ungültig.

> **Hinweis:** Ein leerer Baum (`null`) hat die Schwarztiefe 0. Die Lösung
> lässt sich in wenigen Zeilen rekursiv formulieren.

### Bewertungskriterien (20 Punkte)

- Der leere Baum wird korrekt behandelt (3/3 P.)
- Eine einzelne schwarze bzw. rote Wurzel liefert 1 bzw. 0 (4/4 P.)
- Ein gültiger Baum mit mehreren Ebenen liefert die richtige Schwarztiefe (5/5 P.)
- Unterschiedliche Schwarztiefen werden mit -1 erkannt (4/4 P.)
- Ein -1 aus einem Teilbaum wird nach oben weitergereicht (4/4 P.)

---

## Steigerungsstufen (freiwillig, nach der Klausur)

| Aufgabe | Stufe 1 | Stufe 2 |
|---|---|---|
| 1 | `insert(index, element)` mit Nachrücken | `remove(index)` mit Halbierung der Kapazität bei Unterfüllung |
| 2 | Alle Lösungen zählen statt bei der ersten abbrechen | 9×9-Sudoku mit derselben Stack-Struktur |
| 3 | `insertSorted` in eine sortierte Liste | `insertAll(first, index, other)` — ganze Liste einfügen |
| 4 | `Partition.partition` selbst implementieren | Median-of-Three plus Insertionsort für kleine Teilbereiche |
| 5 | Zusätzlich prüfen, dass kein roter Knoten ein rotes Kind hat | `insert` mit Rotationen und Umfärben |
