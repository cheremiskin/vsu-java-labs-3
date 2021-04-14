import java.util.List;
import java.util.function.Consumer;

public class ListTester {
    /**
     *
     * @param list тестируемый лист
     * @param count количество раз, которое выполнится метод
     * @param method тестируемый метод
     * @return время, которое заняло выполнение метода заданое количество раз
     */
    public static <T> long testMethod(List<T> list, int count, Consumer<List<T>> method) {
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            method.accept(list);
        }
        return System.nanoTime() - startTime;
    }

    /**
     *
     * @param list тестируемый лист
     * @param count количество раз, которое выполнится метод
     * @param element элемент для добавления
     * @return время, которое заняло выполнение метода заданое количество раз
     */
    public static <T> long testAdd(List<T> list, int count, T element) {
        return testMethod(list, count, l -> l.add(0, element));
    }

    /**
     *
     * @param list тестируемый лист
     * @param count количество раз, которое выполнится метод
     * @return время, которое заняло выполнение метода заданое количество раз
     */
    public static <T> long testDelete(List<T> list, int count) throws Exception {
        if (list.size() < count) throw new Exception("List size is too small");
        return testMethod(list, count, l -> l.remove(0));
    }

    /**
     *
     * @param list тестируемый лист
     * @param count количество раз, которое выполнится метод
     * @return время, которое заняло выполнение метода заданое количество раз
     */
    public static <T> long testGet(List<T> list, int count) throws Exception {
        if (list.size() < 1) throw new Exception("List size is too small");
        return testMethod(list, count, l -> l.get(0));
    }
}
