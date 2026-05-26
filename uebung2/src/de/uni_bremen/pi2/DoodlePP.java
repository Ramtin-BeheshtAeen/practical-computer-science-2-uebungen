package de.uni_bremen.pi2;

import java.util.Arrays

public class DoodlePP
{
    /**
     * Die Methode berechnet für eine Menge von Studierenden eine Zuordnung zu einer Menge von Tutorien.
     * Jede Studierende kann nur genau einem Tutorium zugewiesen werden. Studierende geben an, welche
     * Tutorien für sie überhaupt infrage kommen und können nur diesen Tutorien zugewiesen werden.
     * Studierende werden anhand ihres Indexes im ersten Parameter der Methode identifiziert und Tutorien
     * anhand ihres Indexes im zweiten Parameter identifiziert, d.h. beides sind eigentlich nur Zahlen.
     * @param studentAvailabilities Das zweidimensionale Array enthält für jede Studierende (1. Dimension),
     *         an welchen Tutorien sie teilnehmen könnte (2. Dimension). Die Reihenfolge der zweiten
     *         Dimension entspricht der Reihenfolge im nächsten Parameter.
     * @param tutorialCapacities Enthält für jedes Tutorium, wie viele Plätze es gibt. Die Methode
     *         aktualisiert die Einträge, so dass auch nach dem Aufruf noch vermerkt, wie viele Plätze
     *         dann noch pro Tutorium verfügbar sind.
     * @return Ein Array, in dem für jede Studierende steht, welchem Tutorium sie zugeordnet wurde. Gab
     *         es keine Lösung, wird null zurückgegeben.
     */
    public static int[] distribute()
    {
    final boolean[][] studentAvailabilities = {
            {false, true, true, true, true},
            {true, true, true, false, true},
            {false, true, true, true, true},
            {true, true, true, false, true},
            {true, true, true, true, true},
            {false, true, true, false, true},
            {false, false, false, false, true},
            {false, true, false, true, false},
            {true, true, true, true, false},
            {false, false, false, false, true},
            {false, false, false, true, true},
            {true, true, false, false, true},
            {true, true, true, true, true},
            {false, true, true, true, false},
            {false, true, true, false, true},
            {true, true, false, true, false},
            {true, true, true, true, true},
            {false, true, false, false, true},
            {false, false, true, true, true},
            {false, true, true, true, false},
            {true, false, true, true, true},
            {true, false, true, false, true},
            {true, false, true, true, true},
            {true, false, false, true, false},
            {true, true, true, false, false},
            {false, true, true, false, true},
            {false, true, true, false, false},
            {true, true, true, true, true},
            {true, false, true, true, true},
            {false, true, false, true, false},
            {true, false, true, true, false},
            {true, false, true, true, true},
            {false, true, false, true, false},
            {false, false, true, true, true},
            {false, true, false, true, true},
            {false, true, true, false, true},
            {false, true, true, true, true},
            {true, true, true, true, true},
            {true, true, false, true, true},
            {true, true, true, true, true},
            {true, false, false, true, true},
            {true, true, false, true, false},
            {false, true, true, true, false},
            {true, false, true, true, true},
            {true, true, true, false, true},
            {false, true, false, true, false},
            {false, true, false, true, true},
            {false, true, true, false, false},
            {true, true, false, true, false},
            {true, true, false, false, true},
    };

    final int[] tutorialCapacities = {10, 10, 10, 10, 10};
    int[] tuturialCaps       = tutorialCapacities.clone();
    int studentPointer = 0;

        int[] assignments = new int[studentAvailabilities.length];
        Arrays.fill(assignments, -1);

        while(studentPointer < studentAvailabilities.length) {

            boolean found = false;
            boolean[] currentStudentAvailability =  studentAvailabilities[studentPointer];
            // 1. Get the tutorial number we want to try for student 's'
            /*
            The Trap: If Student 0 starts searching from index 0 again,
            they will see Tutorial 0 is available, pick it again, and you'll
            be right back where you started. You would be stuck in an infinite loop.
            // Search starts AFTER their last recorded assignment
            */
            int searchStart = assignments[studentPointer] + 1;
            for(int tutIndex = 0; tutIndex < currentStudentAvailability.length; tutIndex++){
                //Student chose it AND there is space
                if(currentStudentAvailability[tutIndex] && tutorialCapacities[tutIndex] > 0){
                    tutorialCapacities[tutIndex]--; // Occupy seat
                    // 2. If it's valid, update capacity and s++
                    assignments[studentPointer] = tutIndex; // Record the seat in the Array
                    found = true;
                    break;
                }
                if(found){
                    studentPointer++;
                } else {
                    //BackTracking:
                    assignments[studentPointer] = -1; // Reset their search for next time
                    studentPointer--; //goingback
                }

            }

            // 3. If we checked all tutorials, s-- (Backtrack)
        }

        return null;
    }
}