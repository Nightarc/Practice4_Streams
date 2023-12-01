# README
## Practice4_Streams
### Practice4_Streams - это учебное консольное приложение для демонстрации работы с методами StreamAPI. 
### Особенности:
- Работает с файлами формата XML определенной структуры.
- Для чтения XML используется библиотека Jackson.
- Поддерживает:
  - вывод названий объектов в файле
  - выборка объектов по определенному свойству
  - сортировка объектов по числовой характеристике
  - вычисление среднего числовой характеристики у объектов, у которых она есть
  - генерацию хешей для объектов
#### Начало работы:

1. **Клонирование репозитория**:
    ```bash
    git clone https://github.com/Nightarc/Practice4_Streams
    ```

2. **Запуск программы**:
   Для запуска программы, используйте вашу IDE или командную строку.

#### Структура проекта:

- `src`: Исходный код проекта.
    - `main`: Основной код приложения.
        - `java`: Исходные файлы Java.    
    - `test`: Модульные и интеграционные тесты для приложения.
      - `resources`: Ресурсы программы (например, примеры XML и JSON файлов).

#### Входные и выходные файлы:

- Программа работает с XML, которые имеют структуру "заклинание".

#### Пример использования:

- Для открытия файла программой, используйте:
  ```
  java -jar MyStreams.jar
  ```