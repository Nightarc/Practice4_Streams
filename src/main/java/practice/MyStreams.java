package practice;

import lombok.experimental.UtilityClass;
import practice.structure.SpellBookXML;
import practice.structure.SpellXML;

import java.util.Comparator;
import java.util.List;

@UtilityClass
public class MyStreams {
    public void writeNames(SpellBookXML spells)
    {
        spells.getSpells()
                .forEach(s -> System.out.println(s.getName()));
    }

    public List<SpellXML> displayTopDamage(SpellBookXML spells)
    {
        spells.getSpells().forEach(System.out::println);
        Comparator<SpellXML> byDamage = Comparator.comparing(
                SpellXML::getDamage,
                Integer::compare);

        List<SpellXML> damageSorted = spells.getSpells().stream().sorted(byDamage).toList();
        damageSorted.forEach(System.out::println);
        return damageSorted;

    }
}
