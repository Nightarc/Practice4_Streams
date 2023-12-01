package practice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.structure.SpellBookXML;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class MyStreamsTest {

    private final PrintStream systemOut = System.out;
    private final InputStream systemIn = System.in;

    private ByteArrayOutputStream out;
    private ByteArrayInputStream in;
    static SpellBookXML spells;
    static MyStreams spellHelper;
    @BeforeAll
    public static void setupSpells()
    {
        try{
            spells = SpellReader.readFile("src/test/resources/SpellXML.xml");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        spellHelper = new MyStreams(spells);
    }
    @BeforeEach
    public void setupStreams() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(systemOut);
        System.setIn(systemIn);
    }




    @Test
    void names() {
        spellHelper.names();
        assertEquals("""
                nuke\r
                circle_of_acid\r
                tuple_scatter\r
                thundercloud\r
                energy_shield\r
                omniscient_eye\r
                death_cross\r
                glowing_lance\r
                magic_cloud\r
                luminous_drill""", out.toString().trim());
    }

    @Test
    void sortedByDamage() {
        spellHelper.sortedByDamage();
        assertEquals("""
                circle_of_acid, damage: 0\r
                thundercloud, damage: 0\r
                energy_shield, damage: 0\r
                omniscient_eye, damage: 0\r
                luminous_drill, damage: 10\r
                death_cross, damage: 30\r
                glowing_lance, damage: 35\r
                nuke, damage: 1000\r
                tuple_scatter, damage: 1000\r
                magic_cloud, damage: 1000""", out.toString().trim());
    }

    @Test
    void filterByType() {
        in = new ByteArrayInputStream("projectile".getBytes());
        System.setIn(in);
        spellHelper.filterByType();

        assertTrue(out.toString().contains("name=nuke, type=projectile"));
        assertFalse(out.toString().contains("name=energy_shield, type=passive"));
    }

    @Test
    void generateHash() {
        spellHelper.generateHash();
        assertEquals("""
                magic_cloud 99\r
                nuke 0\r
                circle_of_acid 14\r
                energy_shield 52\r
                tuple_scatter 26\r
                glowing_lance 91\r
                death_cross 66\r
                luminous_drill 140\r
                thundercloud 36\r
                omniscient_eye 70\r
                """, out.toString());
    }

    @Test
    void calculateAverageDamage() {
        spellHelper.calculateAverageDamage();
        assertEquals("512.5", out.toString().trim());
    }

}