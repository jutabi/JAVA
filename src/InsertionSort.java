import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InsertionSort {
    public int[] array_insertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j, value = arr[i];
            for (j = i - 1; j >=0 && arr[j] > value; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = value;
        }
         return arr;
    }

    public void array_print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public List<Integer> list_insertion(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int j, value = list.get(i);
            for (j = i - 1; j >= 0 && value < list.get(j); j--) {
                    list.set(j + 1, list.get(j));
            }
            list.set(j + 1, value);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        InsertionSort insertionSort = new InsertionSort();

        Random random = new Random();
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = random.nextInt(10);
        }
        System.out.print("before: ");
        insertionSort.array_print(arr);

        arr = insertionSort.array_insertion(arr);

        System.out.print("after: ");
        insertionSort.array_print(arr);

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(10));
        }
        System.out.println("before: " + list);

        list = insertionSort.list_insertion(list);
        System.out.println("after: " + list);
    }
}
