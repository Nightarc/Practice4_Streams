package practice.structure;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;

/**
 * Представляет класс-контейнер для хранения шансов появления заклинания в конкретной локации
 */
//@Builder
@Data
public class TierXML
{
    @JacksonXmlProperty(isAttribute = true)
    int id;
    @JacksonXmlText
    double chanceValue;
}
