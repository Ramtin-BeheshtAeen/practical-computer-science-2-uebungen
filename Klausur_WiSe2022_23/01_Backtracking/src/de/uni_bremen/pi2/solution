package de.uni_bremen.pi2;

import java.util.Stack;

/**
 * Die Klasse sucht mit dem Verfahren des Backtrackings einen Pfad durch ein
 * Labyrinth. Ein Pfad ist eine Folge von Richtungen. In jedem Feld gibt es die
 * vier Richtungen 0, 1, 2 und 3 (z.B. Norden, Osten, Süden, Westen). Der Pfad
 * wird auf einem Stack verwaltet. Das oberste Element ist die zuletzt gewählte
 * Richtung. Eine -1 auf dem Stack bedeutet, dass für den aktuellen Schritt noch
 * keine Richtung probiert wurde.
 */
public class Maze
{
    /**
     * Die Schnittstelle eines Labyrinths.
     */
    public interface Labyrinth
    {
        /**
         * Prüft, ob der durch den Pfad beschriebene Weg begehbar ist, d.h. ob
         * er nicht durch eine Wand oder aus dem Labyrinth hinausführt.
         * @param path Die bisher gewählten Richtungen.
         * @return true, wenn der Weg begehbar ist, sonst false.
         */
        boolean isValid(Stack<Integer> path);

        /**
         * Prüft, ob der durch den Pfad beschriebene Weg das Ziel erreicht.
         * @param path Die bisher gewählten Richtungen.
         * @return true, wenn das Ziel erreicht ist, sonst false.
         */
        boolean targetReached(Stack<Integer> path);
    }

    /**
     * Sucht einen Pfad durch ein Labyrinth.
     * @param maze Das Labyrinth.
     * @return Ein Stack mit den Richtungen des Pfads oder null, wenn es keinen
     *         Pfad zum Ziel gibt.
     */
    public static Stack<Integer> solve(final Maze.Labyrinth maze)
    {
        final Stack<Integer> path = new Stack<>();
        path.push(-1);
        return solve(maze, path);
    }

    /**
     * Sucht mit dem Verfahren des Backtrackings einen Pfad durch ein
     * Labyrinth, ausgehend von einem bereits begonnenen Pfad.
     *
     * In jedem Schleifendurchlauf wird zunächst so lange die oberste Richtung
     * um 1 erhöht (beginnend bei -1, also zuerst 0), bis entweder eine
     * begehbare Richtung gefunden wurde oder alle vier Richtungen (0..3)
     * ausprobiert sind. Ist die oberste Richtung danach größer als 3, gibt es
     * an dieser Stelle keine Möglichkeit mehr und der Schritt wird vom Stack
     * entfernt (Backtracking). Ist das Ziel erreicht, wird der Pfad
     * zurückgegeben. Andernfalls wird ein neuer Schritt begonnen, indem eine
     * -1 auf den Stack gelegt wird.
     *
     * @param maze Das Labyrinth.
     * @param path Der bisher gewählte Pfad. Der Stack ist nicht leer.
     * @return Ein Stack mit den Richtungen des Pfads oder null, wenn es von
     *         diesem Pfad aus keinen Weg zum Ziel gibt.
     */
    private static Stack<Integer> solve(final Maze.Labyrinth maze, final Stack<Integer> path)
    {
        while (!path.isEmpty()) {

            do {
                path.set(path.size() - 1 , path.peek() + 1);
            } while (path.peek() <= 3 && !(maze.isValid(path)) );

            //check if it is the target:
            if ((maze.targetReached(path))){
                return path;
            }
            //check if top is bigger than 3:
            else if (path.peek() > 3) {
                path.pop();

            } else {path.push(-1);}


        }
        return null;
    }
}
