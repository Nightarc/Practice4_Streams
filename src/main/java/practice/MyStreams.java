package practice;

import com.ctc.wstx.exc.WstxOutputException;
import lombok.experimental.UtilityClass;
import practice.structure.SpellBookXML;
import practice.structure.SpellXML;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public void filterByType(SpellBookXML spells, String type)
    {
        spells.getSpells().stream().filter(s -> Objects.equals(s.getType(), type)).toList().forEach(System.out::println);
    }


    public void generateHash(SpellBookXML spells)
    {
        Map<String, Integer> hash = spells.getSpells().stream()
                .collect(Collectors.toMap(SpellXML::getName, s -> s.getName().length()*s.getId()));

        hash.entrySet().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue().toString()));


    }
}
