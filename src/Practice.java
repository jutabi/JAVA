import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Practice {

    public List<Integer> list_sort(List<Integer> list) {

        return list;
    }

    public List<Integer> list_sort(List<Integer> list, int left, int right) {
        int pivot = left;
        int low = left + 1;
        int high = right;

        if (left < right) {
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
            if (list.get(high)  <= list.get(pivot)) {
                int temp = list.get(high);
                list.set(high, list.get(pivot));
                list.set(pivot, temp);
                pivot = high;
            }

            Practice practice = new Practice();
            list = practice.list_sort(list, left, pivot - 1);
            list = practice.list_sort(list, pivot + 1, right);
        }
        return list;
    }

    public static void main(String[] args) {
        Random random = new Random();
        Practice practice = new Practice();

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 11; i++) {
            list.add(random.nextInt(10));
        }
        List<Integer> copy_list = new ArrayList<Integer>(list);
        System.out.println("\nbefore: " + list);

        list = practice.list_sort(list, 0, list.size() - 1);
        System.out.println("\nafter: " + list);


        ListAccuracy listAccuracy = new ListAccuracy();
        listAccuracy.accuracy_test(copy_list, list);
    }
}
