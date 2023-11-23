package practice.structure;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SpellBookXML {
    @JacksonXmlProperty(localName = "spell")
    @JacksonXmlElementWrapper(useWrapping = false)
    List<SpellXML> spells;

    public SpellBookXML()
    {
        spells = new ArrayList<>();
    }
    public SpellBookXML(List<SpellXML> spells)
    {
        this.spells = spells;
    }
}
