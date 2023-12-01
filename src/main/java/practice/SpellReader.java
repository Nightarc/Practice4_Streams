package practice;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import lombok.experimental.UtilityClass;
import practice.structure.SpellBookXML;
import practice.structure.XML;

import java.io.File;
import java.io.IOException;

@UtilityClass
public class SpellReader {
    static final XML xmlHelper = new XML();

    public static SpellBookXML readFile(String path) throws IOException {
        try {
            return xmlHelper.read(new File(path));
        } catch (JsonParseException e) {
            throw new IOException("Ошибка: пустой файл для чтения");
        } catch (JsonMappingException e) {
            throw new IOException("Произошла ошибка при чтении/записи файла");
        }
    }
}
