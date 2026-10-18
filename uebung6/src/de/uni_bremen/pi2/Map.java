package de.uni_bremen.pi2;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;

/**
 * Die Klasse liest die Karte aus Knoten und Kanten ein und
 * repräsentiert diese. Die Daten stammen ursprünglich aus
 * OpenStreetMap (OSM). Dabei werden für jede eingelesene Kante
 * zwei gerichtete Kanten in die Karte eingetragen. Die Klasse
 * stellt eine Methode zur Verfügung, um die Karte zu zeichnen,
 * sowie eine, die zu einem Punkt den dichtesten Knoten ermittelt.
 */
class Map
{
    private final java.util.Map<Integer, Node> nodes = new HashMap<>();
    /**
     * Konstruktor. Liest die Karte ein.
     * @throws FileNotFoundException Entweder die Datei "nodes.txt" oder die
     *         Datei "edges.txt" wurden nicht gefunden.
     * @throws IOException Ein Lesefehler ist aufgetreten.
     */
    Map() throws FileNotFoundException, IOException
    {
        // Lest hier die beiden Dateien nodes.txt und edges.txt ein
        // und erzeugt daraus eine Karte aus Node- und Edge-Objekten
        // Verbindungen sollen immer in beide Richtungen gehen, d.h.
        // ihr braucht zwei Edges pro Zeile aus der edges.txt.


        File myObj = new File("uebung6/nodes.txt");
        // try-with-resources: Scanner will be closed automatically
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splitStr = data.split(" ");
                final int id = Integer.parseInt(splitStr[0]);
                final double x = Double.parseDouble(splitStr[1]);
                final double y = Double.parseDouble(splitStr[2]);
                final Node node = new Node(id, x, y);
                nodes.put(id, node);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        File myObj2 = new File("uebung6/edges.txt");
        // try-with-resources: Scanner will be closed automatically
        try (Scanner myReader = new Scanner(myObj2)) {
            while (myReader.hasNextLine()) {
                final String data = myReader.nextLine();
                if(data.isBlank()){
                    continue;
                }
                String[] splitStr = data.split(" ");
                final int from = Integer.parseInt(splitStr[0]);
                final int to = Integer.parseInt(splitStr[1]);

                //node objekt from hash map:
                final Node fromNode = nodes.get(from);
                final Node toNode   = nodes.get(to);

                final double cost = fromNode.distance(toNode);

                fromNode.getEdges().add(new Edge(toNode, cost));
                toNode.getEdges().add(new Edge(fromNode, cost));


            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /** Zeichnen der Karte. */
    void draw()
    {
        // Zeichnet hier alle Kanten der Karte. Hierzu sollte Node.draw benutzt werden.
        // Es können die Original-Koordinaten aus den Knoten benutzt werden. Diese werden
        // automatisch geeignet skaliert.
        for (final Node node : nodes.values() ){
            for (final Edge edge : node.getEdges()){
                node.draw(edge.getTarget() , Color.BLACK);
            }
        }

    }

    /**
     * Findet den dichtesten Knoten zu einer gegebenen Position.
     * @param x Die x-Koordinate.
     * @param y Die y-Koordinate.
     * @return Der Knoten, der der Position am nächsten ist. null,
     *         falls es einen solchen nicht gibt.
     */
    Node getClosest(final double x, final double y) {
        // Nutzt Node.reachedFromAtCosts für jeden Knoten.
        final Node click = new Node(0, x, y);
        Node best = null;
        double bestDistance = Double.POSITIVE_INFINITY;   // "infinitely far"
        for (final Node node : nodes.values()) {
            final double d = node.distance(click);
            if (d < bestDistance) {
                best = node;
                bestDistance = d;     // remember the new record
            }
        }
        return best;

    }


    /** Löschen aller Vorgängereinträge und Setzen aller Kosten auf unendlich. */
    void reset() {
        for (Node node : nodes.values() ) {
            node.reachedFromAtCosts( null , Double.POSITIVE_INFINITY);
        }
    }
}
