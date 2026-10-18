# PI-2 Übung – Graphen, Bäume, Suchen, Sortieren

Alle Programmieraufgaben dieser Themen aus den alten Klausuren (Musterlösungen-PDF), jeweils mit Stub (`TODO`) und JUnit-5-Test. Paket `de.uni_bremen.pi2`, wie in der Klausur.

## Namensschema

```
<PRIORITÄT>_<Aufgabe>_<Semester+Jahr, in denen sie vorkam>
```

- **`00_`** = kam in der Winterklausur 2024 (WiSe 2023/24) vor → steht ganz oben.
- **`01_`, `02_` …** = danach nach Aktualität: 01 ist die neueste.
- **Jahr am Ende:** SoSe = Jahr des Sommersemesters, WiSe = Jahr, in dem die Klausur geschrieben wurde (WiSe 2023/24 → `WiSe2024`, WiSe 2022/23 → `WiSe2023`, WiSe 2019/20 → `WiSe2020`).

Jede Aufgabe ist ein eigener Ordner (nicht nur eine Datei), weil Java-Klassen nicht mit einer Zahl anfangen dürfen und mehrere Varianten denselben Klassennamen haben (z.B. drei Mal `BinarySearch`).

## Überblick

| Ordner | Aufgabe | Klausuren |
|---|---|---|
| **SEARCHING** | | |
| `00_01_BinarySearch_Comparator_WiSe2024` | Binäre Suche, `Comparator`, -1 bei Misserfolg | WiSe 23/24 |
| `01_BinarySearch_Einfuegeposition_SoSe2022` | Binäre Suche, `-1 - Einfügeposition` | SoSe 22 |
| `02_BinarySearch_SoSe2019` | Binäre Suche, `Comparable`, -1 | SoSe 19 |
| **GRAPHS** | | |
| `00_01_Dijkstra_SoSe2022_WiSe2024_SoSe2026` | Dijkstra mit `frontier` | SoSe 22, WiSe 23/24, SoSe 26 |
| `01_MinimalAufspannenderBaum_WiSe2023` | Jarnik/Prim/Dijkstra (MST) | WiSe 22/23 |
| `02_ShortestPath_ClosedNodes_WiSe2020` | Dijkstra alt (`closedNodes`/`openNodes`) | WiSe 19/20 |
| **TREES** | | |
| `00_01_TreeHeight_SoSe2019_SoSe2022_WiSe2024` | Höhe eines Binärbaums | SoSe 19, SoSe 22, WiSe 23/24 |
| `01_RBTree_Schwarztiefe_SoSe2023_SoSe2026` | Schwarztiefe Rot-Schwarz-Baum | SoSe 23, SoSe 26 |
| `02_NodeCount_NullZaehlt_WiSe2023` | Knoten zählen, **null zählt 1** | WiSe 22/23 |
| `03_Mengenvereinigung_SoSe2021` | Union-Find (Wurzel suchen, umhängen) | SoSe 21 |
| `04_NodeCount_WiSe2020` | Knoten zählen, null zählt 0 | WiSe 19/20 |
| **SORTING_AND_PIVOT** | | |
| `01_Partition_Pivot_WiSe2023_SoSe2026` | Array am Pivot aufteilen | WiSe 22/23, SoSe 26 |
| `02_Quicksort_SoSe2023` | Quicksort mit `Partition.partition` | SoSe 23 |
| `03_MergeSort_WiSe2020_SoSe2021` | MergeSort mit `Merge.merge` | WiSe 19/20, SoSe 21 |
| `04_Merge_SoSe2019_SoSe2021` | Zwei sortierte Arrays verschmelzen | SoSe 19, SoSe 21 |
| `05_ConvexHull_Forrest_WiSe2020` | Zaun um den Wald (Graham-Scan), 30 % | WiSe 19/20 |

## Benutzen (IntelliJ)

1. Einen Aufgabenordner öffnen (z.B. `TREES/01_RBTree_...`).
2. `src` als **Sources Root**, `test` als **Test Sources Root** markieren (Rechtsklick → Mark Directory as).
3. JUnit 5 hinzufügen: Alt+Enter auf `@Test` → "Add JUnit 5 to classpath".
4. `TODO` lösen, Testklasse starten.

Alle Tests wurden gegen die Musterlösungen aus dem PDF geprüft: die Musterlösung besteht 100 %. Der Stub besteht nur triviale Fälle (z.B. leeres Array).

## Achtung bei Varianten

- **Binäre Suche:** Gleiche Schleife, aber andere Vergleichsmethode (`compareTo` vs. `order.compare`) und anderer Rückgabewert bei Misserfolg.
- **NodeCount:** einziger Unterschied ist der Basisfall (`null` → 1 oder 0). Javadoc lesen!
- **Rot-Schwarz-Baum:** Laut Musterlösung SoSe 2023 zählt der Knoten **selbst**, wenn er schwarz ist (auch die Wurzel). `null` zählt 0.
- **Quicksort vs. MergeSort:** Quicksort teilt *vor* der Rekursion und rekursiert mit `middle + 1`, MergeSort verschmilzt *nach* der Rekursion und benutzt `middle`.
