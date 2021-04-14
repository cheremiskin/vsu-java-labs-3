import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        int iterator = 100000;

        scaleList(iterator, arrayList, 1);
        scaleList(iterator, linkedList, 1);

        String[] header = new String[]{"Method", "Num of iterations", "ArrayList time", "LinkedList time"};
        String[][] table = new String[(int) (3 * (Math.log10(iterator) + 1))][4];

        for (Integer i = 1; i <= iterator; i *= 10) {
            table[(int) (3 * Math.log10(i))][0] = "add";
            table[(int) (3 * Math.log10(i))][1] = i.toString();
            table[(int) (3 * Math.log10(i))][2] = String.valueOf(ListTester.testAdd(arrayList, i, 1));
            table[(int) (3 * Math.log10(i))][3] = String.valueOf(ListTester.testAdd(linkedList, i, 1));

            table[(int) (3 * Math.log10(i)) + 1][0] = "delete";
            table[(int) (3 * Math.log10(i)) + 1][1] = i.toString();
            table[(int) (3 * Math.log10(i)) + 1][2] = String.valueOf(ListTester.testDelete(arrayList, i));
            table[(int) (3 * Math.log10(i)) + 1][3] = String.valueOf(ListTester.testDelete(linkedList, i));

            table[(int) (3 * Math.log10(i)) + 2][0] = "get";
            table[(int) (3 * Math.log10(i)) + 2][1] = i.toString();
            table[(int) (3 * Math.log10(i)) + 2][2] = String.valueOf(ListTester.testGet(arrayList, i));
            table[(int) (3 * Math.log10(i)) + 2][3] = String.valueOf(ListTester.testGet(linkedList, i));
        }

        Printer.printTable(table, header, new Integer[] {10, 20, 20, 20});
    }

    public static <T> void scaleList(int newSize, List<T> list, T element) {
        for (int i = list.size(); i < newSize; i++) {
            list.add(element);
        }
    }
}
