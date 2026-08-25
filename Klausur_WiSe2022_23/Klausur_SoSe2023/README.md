# Übungsklausur PI2 — Einrichtung

Die Struktur entspricht der aus `practical_computer_science_2`: pro Aufgabe ein
IntelliJ-Projekt mit `src` (Quelltext) und `test` (JUnit-Tests), Package
`de.uni_bremen.pi2`.

```
Klausur_SoSe2023/
├── AUFGABEN.md              ← die Aufgabenstellungen
├── 01_DynamicArray/
│   ├── DynamicArray.iml
│   ├── src/de/uni_bremen/pi2/DynamicArray.java     ← hier arbeiten Sie
│   └── test/de/uni_bremen/pi2/DynamicArrayTest.java
├── 02_Sudoku/
│   ├── src/de/uni_bremen/pi2/Sudoku.java           ← hier arbeiten Sie
│   └── test/de/uni_bremen/pi2/Sudoku4x4.java, SudokuTest.java
├── 03_List/
│   ├── src/de/uni_bremen/pi2/Elem.java, List.java  ← List.java bearbeiten
│   └── test/de/uni_bremen/pi2/ListTest.java
├── 04_Quicksort/
│   ├── src/de/uni_bremen/pi2/Partition.java, Quicksort.java
│   └── test/de/uni_bremen/pi2/QuicksortTest.java
└── 05_RedBlackTree/
    ├── src/de/uni_bremen/pi2/RBNode.java, RBTree.java
    └── test/de/uni_bremen/pi2/RBTreeTest.java
```

## In IntelliJ öffnen

1. **File → Open** und *eines* der Aufgabenverzeichnisse wählen
   (z.B. `01_DynamicArray`), nicht das übergeordnete Verzeichnis.
2. Falls `test` nicht grün markiert ist: Rechtsklick auf `test` →
   **Mark Directory as → Test Sources Root**.
3. Beim ersten roten `org.junit` : Cursor darauf, `Alt`+`Enter` →
   **Add 'JUnit5' to classpath**. IntelliJ lädt JUnit selbst herunter.
4. Rechtsklick auf die Testklasse → **Run**.

Alle Skelette compilieren so, wie sie sind. Vor Ihrer Lösung schlagen die Tests
fehl (rot) — das ist der Ausgangszustand, kein Fehler in der Einrichtung.

## Auf der Kommandozeile (ohne IntelliJ)

JUnit-Konsolen-JAR einmalig herunterladen:

```bash
curl -L -o junit.jar \
  https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.2/junit-platform-console-standalone-1.10.2.jar
```

Dann pro Aufgabe:

```bash
cd 01_DynamicArray
javac -cp ../junit.jar -d out $(find src test -name "*.java")
java -jar ../junit.jar execute --class-path out --scan-class-path
```

## Vorgehen

Bearbeiten Sie nur die mit `// TODO` markierten Stellen. Die Javadoc-Kommentare
über den Methoden enthalten die vollständige Spezifikation — lesen Sie sie
zuerst, so wie Sie es in der Klausur auch tun müssten.

Nehmen Sie sich pro Aufgabe etwa 20 Minuten. Wenn eine Aufgabe deutlich länger
dauert, notieren Sie sich, an welcher Stelle Sie hängen geblieben sind.
