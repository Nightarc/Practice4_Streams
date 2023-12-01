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
        System.out.println("Введите номер команд из доступных:");

        List<Method> spellsMethods = MyStreams.getMethods();

        for (int i = 0; i < spellsMethods.size(); i++)
            System.out.printf("%d. %s%n", i+1, spellsMethods.get(i).getName());
    }

    /**
     * Метод, вызывающий метод из класса {@link MyStreams} на основе ввода пользователя
     */
    public int handleUserInput()
    {
        Scanner scanner = new Scanner(System.in);
        try {
            int userInput = scanner.nextInt();
            if(userInput < 1 || userInput > MyStreams.getMethods().size()) throw new InputMismatchException();
            return userInput;
        }
        catch(InputMismatchException e)
        {
           throw new InputMismatchException("Некорректный номер операции. Номер был введен неправильно или операции под этим номером не существует");
        }
    }

}
