import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MergeSort {
    public List<Integer> list_merge(List<Integer> list, int left, int right) {
        // 리스트 를 반으로 쪼갠다.
        // 재귀 함수 발동! (반절의 왼쪽, 반절의 오른쪽)
        // 재귀 함수가 반환하는 두 리스트를 하나씩 비교하여 정렬한다.
//        System.out.println("new!");
        int mid = 0;
        if (left < right) {
            mid = ((right - left) / 2) + left;
//            System.out.println("left: " + left + "\nright: " + right + "\nmid: " + mid);
            list = list_merge(list, left, mid);
            list = list_merge(list, mid + 1, right);

            List<Integer> temp = new ArrayList<Integer>();
            int temp1 = left, temp2 = mid + 1;
            while (temp1 <= mid && temp2 <= right) {
//                System.out.println("index: " + temp1 + " value: " + list.get(temp1));
//                System.out.println("index: " + temp2 + " value: " + list.get(temp2));
                if (list.get(temp1) <= list.get(temp2)) {
                    temp.add(list.get(temp1));
                    temp1++;
                } else if (list.get(temp1) > list.get(temp2)) {
                    temp.add(list.get(temp2));
                    temp2++;
                }
            }
            if (temp1 == mid + 1) {
                for (int i = temp2; i <= right; i++) {
                    temp.add(list.get(i));
                }
            } else if (temp2 == right + 1) {
                for (int i = temp1; i <= mid; i++) {
                    temp.add(list.get(i));
                }
            }
            for (int i = left, temp_cnt = 0;
                 i <= right && temp_cnt < temp.size();
                 i++, temp_cnt++) {
                list.set(i, temp.get(temp_cnt));
            }
        }
//        System.out.println(list + "\n");
        return list;
    }
    public void accuracy_test(List<Integer> origin, List<Integer> sorted) {
        int cnt = 0, temp1 = 0;
        List<Integer> temp = new ArrayList<Integer>(sorted);

        for (int i = temp1; i < origin.size(); i++) {
            for (int j = 0; j < temp.size(); j++) {
                if (temp.get(j).equals(origin.get(i))) {
                    if (i < origin.size() - 1) {
                        temp1++;
                    }
                    temp.remove(j);
                    j = temp.size();
                    cnt++;
                }
            }
        }
        System.out.println("Matching rate: " + (cnt / origin.size()) * 100 + "%");
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        MergeSort mergeSort = new MergeSort();
        Random random = new Random();


        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(10));
        }
        List<Integer> origin_copy = new ArrayList<Integer>(list);
        System.out.println("before: " + origin_copy);

        list = mergeSort.list_merge(list, 0, list.size() - 1);
        System.out.println("after: " + list);

        mergeSort.accuracy_test(origin_copy, list);
    }
}
