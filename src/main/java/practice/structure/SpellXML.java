package practice.structure;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Представляет класс заклинания с его характеристиками в формате XML.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpellXML {
    @JacksonXmlProperty(isAttribute = true)
    int id;
    @JacksonXmlProperty(isAttribute = true)
    String name;
    String type; //Тип заклинания
    int uses; // Количество использований
    int manacost; // Количество потребляемой маны
    int damage; // Урон наносимый
    int radius; // Радиус действия
    int speed; // Скорость полёта снаряда (если заклинание типа Снаряд)
    int lifetime; // Длительность полёта снаряда
    double castDelay; //Задержка перед использованием следующего
    double cooldown; // Перезарядка
    RarityXML rarity; // Шансы нахождения на определённых локациях


}
