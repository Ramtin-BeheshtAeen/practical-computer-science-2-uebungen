package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * Diese Klasse definiert die Tests für die Klasse Maze (Pfadsuche mit
 * Backtracking), Klausur WiSe 2022/23, Aufgabe 1 (20 Punkte).
 */
public class MazeTest
{
    /**
     * Prüft, dass ein gefundener Pfad tatsächlich das Ziel erreicht.
     * @param grid Das Labyrinth.
     * @param path Der gefundene Pfad.
     */
    private void assertReaches(final Grid grid, final Stack<Integer> path)
    {
        assertNotNull(path, "Es wurde kein Pfad gefunden.");
        assertTrue(grid.targetReached(path), "Der gefundene Pfad erreicht das Ziel nicht.");
    }

    /** Das Ziel liegt direkt neben dem Start. */
    @Test
    public void testEinSchritt()
    {
        final Grid grid = new Grid(
                "SZ");
        assertReaches(grid, Maze.solve(grid));
    }

    /** Ein gerader Gang muss durchlaufen werden. */
    @Test
    public void testGeraderGang()
    {
        final Grid grid = new Grid(
                "S  Z");
        assertReaches(grid, Maze.solve(grid));
    }

    /** Der Weg führt um eine Ecke. */
    @Test
    public void testEcke()
    {
        final Grid grid = new Grid(
                "S#",
                " #",
                " Z");
        assertReaches(grid, Maze.solve(grid));
    }

    /** Eine Sackgasse muss durch Backtracking wieder verlassen werden. */
    @Test
    public void testSackgasse()
    {
        final Grid grid = new Grid(
                "S    ",
                "###  ",
                "Z #  ",
                "# ## ",
                "     ");
        assertReaches(grid, Maze.solve(grid));
    }

    /** Ein größeres Labyrinth mit mehreren Sackgassen. */
    @Test
    public void testGroesseresLabyrinth()
    {
        final Grid grid = new Grid(
                "S    ",
                "#### ",
                "   # ",
                " # # ",
                " #  Z");
        assertReaches(grid, Maze.solve(grid));
    }

    /** Gibt es keinen Weg zum Ziel, wird null zurückgegeben. */
    @Test
    public void testKeinWeg()
    {
        final Grid grid = new Grid(
                "S#Z");
        assertNull(Maze.solve(grid), "Ohne Weg muss null geliefert werden.");
    }

    /** Ein durch Wände vollständig abgetrenntes Ziel ist nicht erreichbar. */
    @Test
    public void testAbgetrenntesZiel()
    {
        final Grid grid = new Grid(
                "S #Z",
                "  ##",
                "####",
                "    ");
        assertNull(Maze.solve(grid), "Ohne Weg muss null geliefert werden.");
    }
}
