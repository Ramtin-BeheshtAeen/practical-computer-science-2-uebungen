package de.uni_bremen.pi2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Iterator;

/**
 * Eine spezialisierte Testklasse für eine Menge mit naiver Selbstanordnung.
 */
public class SetNaiveTest extends SetTest
{
    /**
     * Liefert eine neue, leere Menge des getesteten Typs 
     * für Integer-Werte.
     * @return Eine neue Menge mit naiver Selbstanordnung.
     */
    Set<Integer> emptySet()
    {
        return new SetNaive<>();
    }

    // Ab hier Tests einfügen, die spezifisch NaiveSet<E> testen.
    // Hierfür können insbesondere Iteratoren genutzt werden, da diese
    // die Reihenfolge der Elemente in der Liste widerspiegeln.
}
