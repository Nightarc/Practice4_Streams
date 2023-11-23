package practice.structure;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public final class XML{
    XmlMapper xmlMapper = new XmlMapper();


    public SpellBookXML read(File inputFile) throws IOException {
        return xmlMapper.readValue(inputFile, SpellBookXML.class);
    }

    public void write(SpellBookXML spells, File outputFile) throws IOException {
        xmlMapper.writerWithDefaultPrettyPrinter().writeValue(outputFile, spells);
    }

}
