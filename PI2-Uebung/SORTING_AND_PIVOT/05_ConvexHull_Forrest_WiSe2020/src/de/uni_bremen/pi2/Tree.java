package de.uni_bremen.pi2;

/**
 * Ein Baum im Wald, d.h. ein Punkt in der Ebene (gegebene Hilfsklasse,
 * Nachbau – das Original liegt im Stud.IP).
 */
public class Tree
{
    /** Die x-Koordinate (Osten). */
    private final double x;

    /** Die y-Koordinate (Norden). */
    private final double y;

    /**
     * Konstruktor.
     * @param x Die x-Koordinate.
     * @param y Die y-Koordinate.
     */
    public Tree(final double x, final double y)
    {
        this.x = x;
        this.y = y;
    }

    /** @return Die x-Koordinate. */
    public double getX()
    {
        return x;
    }

    /** @return Die y-Koordinate (größer = weiter nördlich). */
    public double getY()
    {
        return y;
    }

    /**
     * Der Winkel der Richtung von diesem Baum zu einem anderen, gemessen
     * gegen den Uhrzeigersinn ab Osten.
     * @param other Der andere Baum.
     * @return Der Winkel im Bogenmaß.
     */
    public double angleTo(final Tree other)
    {
        return Math.atan2(other.y - y, other.x - x);
    }

    /**
     * Liegt dieser Baum rechts der Geraden, die von a nach b läuft?
     * @param a Der Anfang der Geraden.
     * @param b Ein weiterer Punkt auf der Geraden.
     * @return true, wenn dieser Baum echt rechts davon liegt.
     */
    public boolean isRightOf(final Tree a, final Tree b)
    {
        return (b.x - a.x) * (y - a.y) - (b.y - a.y) * (x - a.x) < 0;
    }

    @Override
    public String toString()
    {
        return "(" + (int) x + "," + (int) y + ")";
    }
}
