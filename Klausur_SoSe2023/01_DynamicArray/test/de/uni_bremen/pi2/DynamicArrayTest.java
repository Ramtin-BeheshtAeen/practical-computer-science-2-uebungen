package de.uni_bremen.pi2;

// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Diese Klasse definiert die Tests für die Klasse DynamicArray.
 * Die Tests sind nach den Bewertungskriterien der Klausur SoSe 2023,
 * Aufgabe 1 benannt (20 Punkte).
 */
public class DynamicArrayTest
{
    /** Die Größe verhält sich beim Hinzufügen des ersten Elements korrekt (2/2 Punkte). */
    @Test
    public void testSizeErstesElement()
    {
        final DynamicArray<String> array = new DynamicArray<>();
        assertEquals(0, array.size());
        array.append("a");
        assertEquals(1, array.size());
    }

    /** Die Größe verhält sich beim Hinzufügen von 4 weiteren Elementen 4-mal korrekt (4/4 Punkte). */
    @Test
    public void testSizeWeitereElemente()
    {
        final DynamicArray<String> array = new DynamicArray<>();
        array.append("a");
        for (int i = 1; i <= 4; ++i) {
            array.append("e" + i);
            assertEquals(i + 1, array.size());
        }
    }

    /** Die Kapazität verhält sich beim Hinzufügen des ersten Elements korrekt (2/2 Punkte). */
    @Test
    public void testCapacityErstesElement()
    {
        final DynamicArray<String> array = new DynamicArray<>();
        assertEquals(0, array.capacity());
        array.append("a");
        assertEquals(1, array.capacity());
    }

    /** Die Kapazität verhält sich beim Hinzufügen von 4 weiteren Elementen 4-mal korrekt (4/4 P.). */
    @Test
    public void testCapacityWeitereElemente()
    {
        final DynamicArray<String> array = new DynamicArray<>();
        array.append("a");
        final int[] erwartet = {2, 4, 4, 8};
        for (int i = 0; i < 4; ++i) {
            array.append("e" + i);
            assertEquals(erwartet[i], array.capacity());
        }
    }

    /** Das Auslesen verhält sich nach dem Hinzufügen des ersten Elements korrekt (2/2 Punkte). */
    @Test
    public void testGetErstesElement()
    {
        final DynamicArray<String> array = new DynamicArray<>();
        array.append("a");
        assertEquals("a", array.get(0));
    }

    /** Das Auslesen verhält sich nach dem Hinzufügen von 4 weiteren Elementen 4-mal korrekt (4/4 P.). */
    @Test
    public void testGetWeitereElemente()
    {
        final DynamicArray<String> array = new DynamicArray<>();
        array.append("e0");
        for (int i = 1; i <= 4; ++i) {
            array.append("e" + i);
            for (int j = 0; j <= i; ++j) {
                assertEquals("e" + j, array.get(j));
            }
        }
    }

    /** Das Auslesen jenseits der Größe wird korrekt erkannt (2/2 Punkte). */
    @Test
    public void testGetJenseitsDerGroesse()
    {
        final DynamicArray<String> array = new DynamicArray<>();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.get(0));
        array.append("a");
        array.append("b");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.get(2));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.get(100));
    }

    /** Das Verhalten bei sehr vielen Elementen ist korrekt. */
    @Test
    public void testVieleElemente()
    {
        final DynamicArray<Integer> array = new DynamicArray<>();
        for (int i = 0; i < 1000; ++i) {
            array.append(i);
        }
        assertEquals(1000, array.size());
        assertEquals(1024, array.capacity());
        for (int i = 0; i < 1000; ++i) {
            assertEquals(Integer.valueOf(i), array.get(i));
        }
    }

    /** null darf als Element gespeichert werden. */
    @Test
    public void testNullElement()
    {
        final DynamicArray<String> array = new DynamicArray<>();
        array.append(null);
        assertEquals(1, array.size());
        assertNull(array.get(0));
    }
}
