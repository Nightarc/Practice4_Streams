package practice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;
import static practice.MenuService.*;
class MenuServiceTest {
    private final PrintStream systemErr = System.err;
    private final PrintStream systemOut = System.out;
    private final InputStream systemIn = System.in;
    private ByteArrayOutputStream err;
    private ByteArrayOutputStream out;
    private ByteArrayInputStream in;

    @BeforeEach
    public void setupStreams() {
        err = new ByteArrayOutputStream();
        out = new ByteArrayOutputStream();
        in = new ByteArrayInputStream("\n".getBytes());
        System.setErr(new PrintStream(err));
        System.setOut(new PrintStream(out));
        System.setIn(new BufferedInputStream(in));
    }

    @AfterEach
    public void restoreStreams() {
        System.setErr(systemErr);
        System.setOut(systemOut);
        System.setIn(systemIn);
    }

    @Test
    public void MenuDisplayTest() {
        Main.main(new String[]{"src/test/resources/SpellXML.xml"});
        assertTrue(out.toString().contains("Введите номер команд из доступных"));
    }


    @Test
    public void StringUserInputTest() {
        in = new ByteArrayInputStream("abc\n".getBytes());
        System.setIn(new BufferedInputStream(in));
        assertThrows(InputMismatchException.class, MenuService::handleUserInput);


    }

    @Test
    public void StringWithWhitespacesUserInputTest() {
        in = new ByteArrayInputStream("ab c\n".getBytes());
        System.setIn(new BufferedInputStream(in));
        assertThrows(InputMismatchException.class, MenuService::handleUserInput);
    }

    @Test
    public void CorrectUserInputTest() {
        in = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(new BufferedInputStream(in));
        assertEquals("1", handleUserInput());
    }

    @Test
    public void IndexOutOfBoundsUserInputTest() {
        in = new ByteArrayInputStream("10\n".getBytes());
        System.setIn(new BufferedInputStream(in));
        assertThrows(InputMismatchException.class, MenuService::handleUserInput);
    }
}