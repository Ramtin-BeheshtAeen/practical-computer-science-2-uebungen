package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * Diese Klasse definiert die Tests für die Klasse Sudoku.
 * Die Tests sind nach den Bewertungskriterien der Klausur SoSe 2023,
 * Aufgabe 2 benannt (20 Punkte).
 */
public class SudokuTest
{
    /**
     * Prüft, ob eine Lösung tatsächlich das Sudoku löst.
     * @param board Das Sudoku.
     * @param solution Die gefundene Lösung.
     */
    private void assertSolves(final Sudoku4x4 board, final Stack<Integer> solution)
    {
        assertNotNull(solution, "Es wurde keine Lösung gefunden.");
        assertEquals(board.free(), solution.size(), "Falsche Anzahl gesetzter Ziffern.");
        assertEquals(Sudoku.Result.COMPLETE, board.check(solution), "Die Lösung ist nicht gültig.");
    }

    /** Das Lösen eines Sudokus mit nur einem freien Feld ohne Weiterzählen funktioniert korrekt (3/3 P.). */
    @Test
    public void testEinFeldOhneWeiterzaehlen()
    {
        final Sudoku4x4 board = new Sudoku4x4(
                1, 2, 3, 4,
                3, 4, 1, 2,
                2, 1, 4, 3,
                4, 3, 2, 0);
        final Stack<Integer> solution = Sudoku.solve(board);
        assertSolves(board, solution);
        assertEquals(Integer.valueOf(1), solution.peek());
    }

    /** Das Lösen eines Sudokus mit nur einem freien Feld mit Weiterzählen funktioniert korrekt (3/3 P.). */
    @Test
    public void testEinFeldMitWeiterzaehlen()
    {
        final Sudoku4x4 board = new Sudoku4x4(
                1, 2, 3, 4,
                3, 4, 1, 2,
                2, 1, 4, 3,
                0, 3, 2, 1);
        final Stack<Integer> solution = Sudoku.solve(board);
        assertSolves(board, solution);
        assertEquals(Integer.valueOf(4), solution.peek());
    }

    /** Das Lösen eines Sudokus mit zwei freien Feldern ohne Weiterzählen funktioniert korrekt (3/3 P.). */
    @Test
    public void testZweiFelderOhneWeiterzaehlen()
    {
        final Sudoku4x4 board = new Sudoku4x4(
                1, 2, 3, 4,
                3, 4, 1, 2,
                2, 1, 4, 3,
                4, 3, 0, 0);
        assertSolves(board, Sudoku.solve(board));
    }

    /** Das Lösen eines Sudokus mit zwei freien Feldern mit Weiterzählen funktioniert korrekt. */
    @Test
    public void testZweiFelderMitWeiterzaehlen()
    {
        final Sudoku4x4 board = new Sudoku4x4(
                1, 2, 3, 4,
                3, 4, 1, 2,
                0, 0, 4, 3,
                4, 3, 2, 1);
        assertSolves(board, Sudoku.solve(board));
    }

    /** Das Lösen erfordert Backtracking über mehrere Felder hinweg. */
    @Test
    public void testMitBacktracking()
    {
        final Sudoku4x4 board = new Sudoku4x4(
                1, 2, 3, 4,
                3, 4, 1, 2,
                0, 0, 0, 0,
                0, 0, 0, 0);
        assertSolves(board, Sudoku.solve(board));
    }

    /** Ein vollständig leeres Sudoku wird gelöst. */
    @Test
    public void testLeeresSudoku()
    {
        final Sudoku4x4 board = new Sudoku4x4(
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0);
        assertSolves(board, Sudoku.solve(board));
    }

    /** Ein unlösbares Sudoku liefert null zurück. */
    @Test
    public void testUnloesbar()
    {
        final Sudoku4x4 board = new Sudoku4x4(
                1, 2, 3, 4,
                3, 4, 1, 2,
                2, 1, 4, 3,
                4, 3, 1, 0);
        assertNull(Sudoku.solve(board), "Ein unlösbares Sudoku muss null liefern.");
    }

    /** Ein zweites unlösbares Sudoku, bei dem erst spät ein Widerspruch auftritt. */
    @Test
    public void testUnloesbarSpaeterWiderspruch()
    {
        final Sudoku4x4 board = new Sudoku4x4(
                1, 2, 3, 4,
                3, 4, 1, 2,
                2, 1, 0, 0,
                4, 3, 0, 2);
        assertNull(Sudoku.solve(board), "Ein unlösbares Sudoku muss null liefern.");
    }
}
