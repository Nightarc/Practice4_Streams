package practice;

import lombok.experimental.UtilityClass;
import practice.structure.SpellBookXML;
import practice.structure.SpellXML;

import java.util.*;
import java.util.stream.Collectors;

@UtilityClass
public class MyStreams {
    public void writeNames(SpellBookXML spells) {
        spells.getSpells()
                .forEach(s -> System.out.println(s.getName()));
    }

    public List<SpellXML> sortByDamage(SpellBookXML spells) {
        Comparator<SpellXML> byDamage = Comparator.comparing(
                SpellXML::getDamage,
                Integer::compare);

        List<SpellXML> damageSorted = spells.getSpells().stream().sorted(byDamage).toList();
        damageSorted.forEach(System.out::println);
        return damageSorted;

    }

    public void filterByType(SpellBookXML spells, String type) {
        spells.getSpells().stream()
                .filter(s -> Objects.equals(s.getType(), type))
                .toList()
                .forEach(System.out::println);
    }


    public void generateHash(SpellBookXML spells) {
        Map<String, Integer> hash = spells.getSpells().stream()
                .collect(Collectors.toMap(SpellXML::getName, s -> s.getName().length() * s.getId()));

        hash.forEach((key, value) -> System.out.println(key + " " + value.toString()));
    }


    public void calculateAverageDamage(SpellBookXML spells) {
        System.out.println(
                spells.getSpells().stream()
                        .filter(s -> s.getDamage() > 0)
                        .mapToInt(SpellXML::getDamage)
                        .average()
        );
    }
}
