import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InsertionSort {
    public int[] array_insertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (value < arr[j]) {
                    arr[j + 1] = arr[j];
                    if (j == 0) {
                        arr[0] = value;
                    }
                } else {
                    arr[j + 1] = value;
                    break;
                }
            }
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
            int value = list.get(i);
            for (int j = i - 1; j >= 0; j--) {
                if (value < list.get(j)) {
                    list.set(j + 1, list.get(j));
                    if (j == 0) {
                        list.set(0, value);
                    }
                } else {
                    list.set(j + 1, value);
                    break;
                }
            }
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
