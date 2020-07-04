import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSort {
    public List<Integer> list_quick(List<Integer> list, int left, int right) {
        int pivot = left;
        int low = left + 1;
        int high = right;

        System.out.println("start");
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
            System.out.println(list);
            System.out.println("end while");
            QuickSort quickSort = new QuickSort();
            list = quickSort.list_quick(list, left, pivot - 1);
            list = quickSort.list_quick(list, pivot + 1, right);
        }
        return list;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        Random random = new Random();
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < 10; i++) {
            list.add(random.nextInt(10));
        }

        System.out.println("before: " + list);

        list = quickSort.list_quick(list, 0, list.size() - 1);
        System.out.println("after: " + list);
    }
}
