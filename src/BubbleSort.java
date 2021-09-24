import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BubbleSort {
    public int[] array_bubble(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
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

    public List<Integer> list_bubble(List<Integer> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j + 1);
                    list.set(j + 1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        BubbleSort bubbleSort = new BubbleSort();
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }
        System.out.print("before: ");
        bubbleSort.array_print(arr);

        arr = bubbleSort.array_bubble(arr);
        System.out.print("after: ");
        bubbleSort.array_bubble(arr);
        bubbleSort.array_print(arr);

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(10));
        }

        System.out.println("before: " + list);

        list = bubbleSort.list_bubble(list);
        System.out.println("after: " + list);
    }
}
