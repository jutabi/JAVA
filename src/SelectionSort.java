import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SelectionSort {
    public int[] array_selection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    arr[i] = arr[i] + arr[j];
                    arr[j] = arr[i] - arr[j];
                    arr[i] = arr[i] - arr[j];
                }
            }
        }
        return arr;
    }

    public List<Integer> list_selection(List<Integer> list) {
        for (int i = 0; i < list.size() -1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        SelectionSort selectionSort = new SelectionSort();

        for (int i = 0; i < arr.length; i ++) {
            arr[i] = random.nextInt(10);
        }

        System.out.print("before: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
        arr = selectionSort.array_selection(arr);

        System.out.print("after: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i ++) {
            list.add(random.nextInt(10));
        }
        System.out.println("\nbefore: " + list);

        list = selectionSort.list_selection(list);
        System.out.println("after: " + list);
    }
}
