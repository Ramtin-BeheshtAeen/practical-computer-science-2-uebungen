package de.uni_bremen.pi2;

import java.util.Stack;

/**
 * Die Klasse löst ein Sudoku mit dem Verfahren des Backtrackings. Es handelt
 * sich um ein 4×4-Sudoku, d.h. in jeder Zeile, jeder Spalte und jedem der vier
 * 2×2-Blöcke müssen die Ziffern 1 bis 4 jeweils genau einmal vorkommen.
 *
 * Die bereits gesetzten Ziffern werden auf einem Stack verwaltet. Die Ziffern
 * beziehen sich der Reihe nach auf die freien Felder des Sudokus. Das oberste
 * Element des Stacks ist die zuletzt gesetzte Ziffer. Eine 0 auf dem Stack
 * bedeutet, dass für das entsprechende Feld noch keine Ziffer probiert wurde.
 */
public class Sudoku
{
    /**
     * Das Ergebnis der Prüfung einer Belegung durch {@link Board#check(Stack)}.
     */
    public enum Result
    {
        /** Die Belegung ist gültig und vollständig, das Sudoku ist gelöst. */
        COMPLETE,

        /** Die Belegung ist gültig, aber noch nicht vollständig. */
        VALID,

        /** Die Belegung verletzt die Regeln des Sudokus. */
        INVALID
    }

    /**
     * Die Schnittstelle eines Sudoku-Spielfelds.
     */
    public interface Board
    {
        /**
         * Prüft eine Belegung der freien Felder.
         * @param numbers Die Ziffern, die der Reihe nach in die freien Felder
         *         eingetragen werden. Der Stack darf nicht mehr Einträge
         *         haben, als es freie Felder gibt.
         * @return COMPLETE, wenn alle freien Felder regelkonform belegt sind,
         *         VALID, wenn die bisherige Belegung regelkonform, aber noch
         *         nicht vollständig ist, sonst INVALID.
         */
        Result check(Stack<Integer> numbers);
    }

    /**
     * Löst ein Sudoku mit dem Verfahren des Backtrackings.
     * @param sudoku Das Sudoku, das gelöst werden soll.
     * @return Ein Stack mit den Ziffern für die freien Felder oder null, wenn
     *         das Sudoku nicht lösbar ist.
     */
    public static Stack<Integer> solve(final Sudoku.Board sudoku)
    {
        final Stack<Integer> numbers = new Stack<>();
        numbers.push(0);
        return solve(sudoku, numbers);
    }

    /**
     * Löst ein Sudoku mit dem Verfahren des Backtrackings, ausgehend von einer
     * bereits begonnenen Belegung.
     *
     * In jedem Schleifendurchlauf wird die oberste Ziffer des Stacks um 1
     * erhöht. Ist sie danach größer als 4, gibt es für dieses Feld keine
     * Möglichkeit mehr und die Ziffer wird vom Stack entfernt (Backtracking).
     * Andernfalls wird die Belegung geprüft: Ist sie COMPLETE, ist das Sudoku
     * gelöst. Ist sie VALID, wird mit dem nächsten freien Feld begonnen, indem
     * eine 0 auf den Stack gelegt wird. Ist sie INVALID, wird im nächsten
     * Durchlauf die nächste Ziffer für dasselbe Feld probiert.
     *
     * @param sudoku Das Sudoku, das gelöst werden soll.
     * @param numbers Die bisher gesetzten Ziffern. Der Stack ist nicht leer.
     * @return Ein Stack mit den Ziffern für die freien Felder oder null, wenn
     *         das Sudoku von dieser Belegung aus nicht lösbar ist.
     */
    private static Stack<Integer> solve(final Sudoku.Board sudoku, final Stack<Integer> numbers)
    {
        while (!numbers.isEmpty()) {
            // TODO: Aufgabe 2 (Zeilen 53-62 der Musterlösung)
        }
        return null;
    }
}
