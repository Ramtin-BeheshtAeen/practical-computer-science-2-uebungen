package de.uni_bremen.pi2;

import java.util.Stack;

/**
 * Ein rechteckiges Labyrinth für die Tests. '#' ist eine Wand, ' ' ist frei,
 * 'S' ist der Start, 'Z' ist das Ziel. Die Richtungen sind 0 = oben,
 * 1 = rechts, 2 = unten, 3 = links. Diese Klasse ist bereits vollständig
 * implementiert und muss nicht verändert werden.
 */
public class Grid implements Maze.Labyrinth
{
    /** Die Zeilen des Labyrinths. */
    private final String[] rows;

    /** Die Zeile des Startfelds. */
    private final int startRow;

    /** Die Spalte des Startfelds. */
    private final int startColumn;

    /**
     * Erzeugt ein Labyrinth aus einer Zeichenkette.
     * @param rows Die Zeilen des Labyrinths, jeweils gleich lang.
     */
    public Grid(final String... rows)
    {
        this.rows = rows;
        int row = 0;
        int column = 0;
        for (int r = 0; r < rows.length; ++r) {
            final int c = rows[r].indexOf('S');
            if (c >= 0) {
                row = r;
                column = c;
            }
        }
        startRow = row;
        startColumn = column;
    }

    /**
     * Verfolgt einen Pfad und liefert das erreichte Feld zurück.
     * @param path Die Richtungen. -1-Einträge werden ignoriert.
     * @return Ein Array aus Zeile und Spalte oder null, wenn der Pfad in eine
     *         Wand oder aus dem Labyrinth führt.
     */
    private int[] follow(final Stack<Integer> path)
    {
        int row = startRow;
        int column = startColumn;
        for (final int direction : path) {
            if (direction < 0) {
                continue;
            }
            switch (direction) {
                case 0 -> --row;
                case 1 -> ++column;
                case 2 -> ++row;
                case 3 -> --column;
                default -> { return null; }
            }
            if (row < 0 || row >= rows.length || column < 0 || column >= rows[row].length()
                    || rows[row].charAt(column) == '#') {
                return null;
            }
        }
        return new int[] {row, column};
    }

    @Override
    public boolean isValid(final Stack<Integer> path)
    {
        // Der Weg muss begehbar sein ...
        if (follow(path) == null) {
            return false;
        }

        // ... und darf kein Feld zweimal betreten (kein Zyklus).
        final java.util.Set<Long> visited = new java.util.HashSet<>();
        int row = startRow;
        int column = startColumn;
        visited.add((long) row << 32 | (column & 0xffffffffL));
        for (final int direction : path) {
            if (direction < 0) {
                continue;
            }
            switch (direction) {
                case 0 -> --row;
                case 1 -> ++column;
                case 2 -> ++row;
                case 3 -> --column;
            }
            if (!visited.add((long) row << 32 | (column & 0xffffffffL))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean targetReached(final Stack<Integer> path)
    {
        final int[] position = follow(path);
        return position != null && rows[position[0]].charAt(position[1]) == 'Z';
    }
}
