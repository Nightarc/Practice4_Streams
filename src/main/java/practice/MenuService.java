package practice;

import lombok.experimental.UtilityClass;

import java.lang.reflect.Method;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@UtilityClass
public final class MenuService {
    public void displayMenu()
    {
        System.out.println("Введите номер команд из доступных или пустую строку для вывода заклинаний в файле:");

        List<Method> spellsMethods = MyStreams.getMethods();

        for (int i = 0; i < spellsMethods.size(); i++)
            System.out.printf("%d. %s%n", i+1, spellsMethods.get(i).getName());
    }

    /**
     * Метод, вызывающий метод из класса {@link MyStreams} на основе ввода пользователя
     */
    public String handleUserInput()
    {
        Scanner scanner = new Scanner(System.in);
        try {
            String userInput = scanner.nextLine();
            if(userInput.equals("")) return userInput;
            int userInputNumber = Integer.parseInt(userInput);
            if(userInputNumber < 1 || userInputNumber > MyStreams.getMethods().size()) throw new InputMismatchException();
            return userInput;
        }
        catch(Exception e)
        {
           throw new InputMismatchException("Некорректный номер операции. Номер был введен неправильно или операции под этим номером не существует");
        }
    }

}
