package practice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;
class MainTest {
    private final PrintStream systemErr = System.err;
    private final PrintStream systemOut = System.out;
    private final InputStream systemIn = System.in;
    private ByteArrayOutputStream err;
    private ByteArrayOutputStream out;
    private ByteArrayInputStream in;

    @BeforeEach
    public void setupStreams()
    {
        err = new ByteArrayOutputStream();
        out = new ByteArrayOutputStream();
        in = new ByteArrayInputStream("".getBytes());
        System.setErr(new PrintStream(err));
        System.setOut(new PrintStream(out));
        System.setIn(new BufferedInputStream(in));
    }

    @AfterEach
    public void restoreStreams()
    {
        System.setErr(systemErr);
        System.setOut(systemOut);
        System.setIn(systemIn);
    }
    @Test
    public void MainWithSufficientArguments()
    {
        Main.main(new String[]{"src/test/resources/SpellXML.xml"});
        assertTrue(out.toString().contains("Введите номер команд из доступных"));
    }

    @Test
    public void MainWithNotAOneArgument()
    {
        Main.main(new String[]{});
        assertEquals("Использование: .jar <spellsFileName>", err.toString().trim());
    }

    @Test
    public void MainWithTooManyArguments()
    {
        Main.main(new String[]{"src/test/resources/SpellXML.xml", "src/test/resources/WrongSpellXML.xml"});
        assertEquals("Использование: .jar <spellsFileName>", err.toString().trim());
    }
}