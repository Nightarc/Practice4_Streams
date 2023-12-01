package practice;

import static practice.MenuService.*;
/**
 * Консольное приложение по работе с файлами структуры заклинаний.
 */
public class Main {
    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                displayMenu();

                int userInput = handleUserInput() - 1;
                MyStreams.getMethods().get(userInput).invoke(SpellReader.readFile(args[0]), new Object[]{});
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.out.println("Использование: .jar <spellsFileName>");
        }
    }
}
