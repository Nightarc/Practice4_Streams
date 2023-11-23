package practice;

import practice.structure.SpellBookXML;
import practice.structure.XML;

import java.io.File;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        File inputFile = new File("src/test/resources/SpellXML.xml");
        XML xmlHelper = new XML();
        SpellBookXML spells = new SpellBookXML();
        try {
            spells = xmlHelper.read(inputFile);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        //MyStreams.writeNames(spells);
        MyStreams.displayTopDamage(spells);
    }
}
