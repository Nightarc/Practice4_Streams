package practice;

import static practice.MenuService.*;
/**
 * Консольное приложение по работе с файлами структуры заклинаний.
 */
public class Main {
    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                MyStreams spells = new MyStreams(SpellReader.readFile(args[0]));

                displayMenu();
                String userInput = handleUserInput();

                if(userInput.equals("")) // Автоматический режим работы
                {
                    spells.names();
                }
                else MyStreams.getMethods().get(Integer.parseInt(userInput) - 1)
                        .invoke(spells, new Object[]{});
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.err.println("Использование: .jar <spellsFileName>");
        }
    }
}
