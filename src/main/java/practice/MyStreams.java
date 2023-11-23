package practice;

import lombok.experimental.UtilityClass;
import practice.structure.SpellBookXML;

@UtilityClass
public class MyStreams {
    public void writeNames(SpellBookXML spells)
    {
        spells.getSpells()
                .forEach(s -> System.out.println(s.getName()));
    }
}
