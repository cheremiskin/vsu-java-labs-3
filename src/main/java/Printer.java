import java.util.Arrays;

public class Printer {
    /**
     * Выводит в консоль таблицу
     * @param rows массив данных для строк
     * @param header массив с данными заголовков
     * @param size размеры колонок
     */
    public static void printTable (String[][] rows, String[] header, Integer[] size) {
        printLine(Arrays.stream(size).reduce((x, y) -> x + y + 3).get() + 8, '*');
        System.out.println();

        printHeader(header, size);

        for(int i = 0; i < rows.length; i++) {
            System.out.print("**  ");
            printRow(rows[i], '|', size);
            System.out.println("  **");
        }

        printLine(Arrays.stream(size).reduce((x, y) -> x + y + 3).get() + 8, '*');
    }

    /**
     * Выводит в консоль строку таблицы
     * @param row массив данных строки
     * @param splitter сивол - разделитель
     * @param size ширина колонок
     */
    public static void printRow (String[] row, Character splitter, Integer[] size) {
        if (row != null) {
            for(int i = 0; i < row.length; i++) {
                System.out.print(row[i]);
                if (size[i] > row[i].length()) {
                    printLine(size[i] - row[i].length(), ' ');
                }
                if (i < row.length - 1) {
                    System.out.print(" " + splitter + " ");
                }
            }
        }
    }

    /**
     * Выводит в консоль строку из символа заданной длины
     * @param size размер строки
     * @param symbol сивол для вывода
     */
    private static void printLine (Integer size, char symbol) {
        for (int i = 0; i < size; i++) {
            System.out.print(symbol);
        }
    }

    /**
     * Выводит в консоль заголовок таблицы
     * @param header массив заголовков колоное
     * @param size массив размеров колонок
     */
    private  static void printHeader (String[] header, Integer[] size) {
        System.out.print("**  ");
        printRow(header, '|', size);
        System.out.println("  **");

        printLine(Arrays.stream(size).reduce((x, y) -> x + y + 3).get() + 8, '*');
        System.out.println();
    }
}
