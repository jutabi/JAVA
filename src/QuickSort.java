import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSort {
    public int[] array_quick(int[] arr, int left, int right) {
        int pivot = left;
        int low = left + 1;
        int high = right;

        if (right > left) {
            while (low < high) {
                while (arr[low] <= arr[pivot] && low < right) {
                    low++;
                }
                while (arr[high] > arr[pivot] && high > left) {
                    high--;
                }
                if (low < high) {
                    int temp = arr[low];
                    arr[low] = arr[high];
                    arr[high] = temp;
                }
            }
            if (arr[high] <= arr[pivot]) {
                int temp = arr[high];
                arr[high] = arr[pivot];
                arr[pivot] = temp;
                pivot = high;
            }
            QuickSort quickSort = new QuickSort();
            quickSort.array_quick(arr, left, pivot - 1);
            quickSort.array_quick(arr, pivot + 1, right);
        }
        return arr;
    }
    public List<Integer> list_quick(List<Integer> list, int left, int right) {
        int pivot = left;
        int low = left + 1;
        int high = right;

        if (right > left) {
            while (low < high) {
                while (list.get(low) <= list.get(pivot) && low < right) {
                    low++;
                }
                while (list.get(high) > list.get(pivot) && high > left) {
                    high--;
                }
                if (low < high) {
                    int temp = list.get(low);
                    list.set(low, list.get(high));
                    list.set(high, temp);
                }
            }
            if (list.get(high) <= list.get(pivot)) {
                int temp = list.get(high);
                list.set(high, list.get(pivot));
                list.set(pivot, temp);
                pivot = high;
            }
            QuickSort quickSort = new QuickSort();
            list = quickSort.list_quick(list, left, pivot - 1);
            list = quickSort.list_quick(list, pivot + 1, right);
        }
        return list;
    }

    public void print_arr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }
        System.out.print("before: ");
        quickSort.print_arr(arr);
        quickSort.array_quick(arr, 0, arr.length - 1);
        System.out.print("after: ");
        quickSort.print_arr(arr);

        List<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < 10; i++) {
            list.add(random.nextInt(10));
        }

        System.out.println("before: " + list);

        list = quickSort.list_quick(list, 0, list.size() - 1);
        System.out.println("after: " + list);
    }
}
