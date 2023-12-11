package practice;

import lombok.*;
import practice.structure.SpellBookXML;
import practice.structure.SpellXML;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter(value = AccessLevel.PRIVATE)
@AllArgsConstructor
public class MyStreams {

    SpellBookXML spells;


    /**
     * <p>Возвращает список названий определенных в классе методов. Исключает методы с модификатором private. </p>
     *
     * @return список названий методов
     */
    public static List<Method> getMethods() {
        return Arrays.stream(MyStreams.class.getDeclaredMethods())
                .filter(method -> Modifier.isPublic(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .toList();
    }

    /**
     * Выводит список названий заклинаний
     */
    public void names() {
        spells.getSpells()
                .forEach(s -> System.out.println(s.getName()));
    }

    /**
     * Возвращает отсортированный по урону в порядке возрастания список заклинаний
     */
    public void sortedByDamage() {
        val byDamage = Comparator.comparing(
                SpellXML::getDamage,
                Integer::compare);

        List<SpellXML> damageSorted = spells.getSpells().stream().sorted(byDamage).toList();
        damageSorted.forEach(s -> System.out.printf("%s, damage: %d%n", s.getName(), s.getDamage()));
    }

    /**
     * Выводит в System.out выборку заклинаний по типу type, вводимому пользователем.
     */
    public void filterByType() {
        System.out.println("Доступные типы: ");
        spells.getSpells().stream()
                .map(SpellXML::getType)
                .collect(Collectors.toSet()).forEach(System.out::println);

        System.out.println("Введите тип, по которому будет производиться выборка");
        String type = new Scanner(System.in).nextLine();

        spells.getSpells().stream()
                .filter(s -> Objects.equals(s.getType(), type))
                .toList()
                .forEach(System.out::println);
    }

    /**
     * Генерирует и выводит хэш к каждому заклинанию из списка. Хэш генерируется как произведение длины названия и идентификатора.
     */
    public void generateHash() {
        spells.getSpells().stream()
                .collect(Collectors.toMap(SpellXML::getName, s -> s.getName().length() * s.getId()))
                .forEach((key, value) -> System.out.println(key + " " + value.toString()));
    }

    /**
     * Вычисляет и выводит средний урон заклинаний, у которых урон есть(т.е., damage > 0)
     */
    public void calculateAverageDamage() {
        System.out.println(
                spells.getSpells().stream()
                        .filter(s -> s.getDamage() > 0)
                        .mapToInt(SpellXML::getDamage)
                        .average()
                        .orElse(Double.NaN)
        );
    }
}
