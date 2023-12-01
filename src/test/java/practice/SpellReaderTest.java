package practice;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SpellReaderTest {

    @Test
    void FilesNotFoundTest()
    {
        String args = "notfoundFile.xml";
        try{
            assertThrows(IOException.class, () -> SpellReader.readFile(args));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    @Test
    void UnsupportedFiles()
    {
        String args = "src/test/resources/SpellJSON.json";
        try{
            assertThrows(IOException.class, () -> SpellReader.readFile(args));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }


}