# Übungsklausur PI2 — Einrichtung

Die Struktur entspricht der aus `practical_computer_science_2`: pro Aufgabe ein
IntelliJ-Projekt mit `src` (Quelltext) und `test` (JUnit-Tests), Package
`de.uni_bremen.pi2`.

## In IntelliJ öffnen

1. **File → Open** und *eines* der Aufgabenverzeichnisse wählen
   (z.B. `01_...`), nicht das übergeordnete Jahr-Verzeichnis.
2. Falls `test` nicht als Testquelle markiert ist: Rechtsklick auf `test` →
   **Mark Directory as → Test Sources Root**.
3. Beim ersten roten `org.junit`: Cursor darauf, `Alt`+`Enter` →
   **Add 'JUnit5' to classpath**. IntelliJ lädt JUnit selbst herunter.
4. Rechtsklick auf die Testklasse → **Run**.

Alle Skelette compilieren so, wie sie sind. Vor Ihrer Lösung schlagen die Tests
fehl (rot) — das ist der Ausgangszustand, kein Einrichtungsfehler.

## Auf der Kommandozeile (ohne IntelliJ)

JUnit-Konsolen-JAR einmalig herunterladen:

```bash
curl -L -o junit.jar \
  https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.2/junit-platform-console-standalone-1.10.2.jar
```

Dann pro Aufgabe:

```bash
cd 01_...
javac -cp ../junit.jar -d out $(find src test -name "*.java")
java -jar ../junit.jar execute --class-path out --scan-class-path
```

## Vorgehen

Bearbeiten Sie nur die mit `// TODO` markierten Stellen. Die Javadoc-Kommentare
über den Methoden enthalten die vollständige Spezifikation — lesen Sie sie
zuerst. Nehmen Sie sich pro Aufgabe etwa 20 Minuten.

Die Details der einzelnen Aufgaben stehen in `AUFGABEN.md`.
