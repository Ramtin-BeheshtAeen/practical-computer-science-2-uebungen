package de.uni_bremen.pi2;

import java.util.Stack;

/**
 * Ein 4×4-Sudoku-Spielfeld für die Tests. Diese Klasse ist bereits vollständig
 * implementiert und muss nicht verändert werden.
 */
public class Sudoku4x4 implements Sudoku.Board
{
    /** Die Vorgabe. 0 bedeutet, dass das Feld frei ist. Zeilenweise angeordnet. */
    private final int[] given;

    /**
     * Erzeugt ein Sudoku-Spielfeld.
     * @param given Die 16 Felder des Sudokus zeilenweise. 0 bedeutet frei.
     */
    public Sudoku4x4(final int... given)
    {
        this.given = given;
    }

    /**
     * Liefert die Anzahl der freien Felder zurück.
     * @return Die Anzahl der Felder, die belegt werden müssen.
     */
    public int free()
    {
        int count = 0;
        for (final int value : given) {
            if (value == 0) {
                ++count;
            }
        }
        return count;
    }

    @Override
    public Sudoku.Result check(final Stack<Integer> numbers)
    {
        // Belegung in das Spielfeld eintragen.
        final int[] field = given.clone();
        int index = 0;
        for (final int number : numbers) {
            while (index < field.length && field[index] != 0) {
                ++index;
            }
            field[index++] = number;
        }

        // Regeln prüfen.
        for (int i = 0; i < field.length; ++i) {
            if (field[i] == 0) {
                continue;
            }
            for (int j = i + 1; j < field.length; ++j) {
                if (field[j] == 0) {
                    continue;
                }
                final boolean sameRow = i / 4 == j / 4;
                final boolean sameColumn = i % 4 == j % 4;
                final boolean sameBlock = i / 8 == j / 8 && i % 4 / 2 == j % 4 / 2;
                if ((sameRow || sameColumn || sameBlock) && field[i] == field[j]) {
                    return Sudoku.Result.INVALID;
                }
            }
        }

        // Vollständig?
        for (final int value : field) {
            if (value == 0) {
                return Sudoku.Result.VALID;
            }
        }
        return Sudoku.Result.COMPLETE;
    }
}
