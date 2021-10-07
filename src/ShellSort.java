import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShellSort {
    public int[] array_selection(int[] arr, int gap, int start_index) {
        for (int i = start_index + gap; i < arr.length; i += gap) {
            int j, value = arr[i];
            for (j = i - gap; j >= start_index && arr[j] > value; j -= gap) {
                arr[j + gap] = arr[j];
            }
            arr[j + gap] = value;
        }

        return arr;
    }

    public int[] array_shell(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            if (gap % 2 == 0) { gap++; }

            for (int i = 0; i < gap; i++) {
                ShellSort shellSort = new ShellSort();
                arr = shellSort.array_selection(arr, gap, i);
            }
        }

        return arr;
    }

    public List<Integer> list_shell(List<Integer> list, int prev_gap) {
        // 이전 gap의 절반을 gap으로 설정, 짝수가 나오면 +1을 하여 홀수로 설정
        int gap = (prev_gap  % 2 == 0) ? prev_gap / 2 + 1 : prev_gap / 2;
        // 0부터 +gap 한 애들 삽입정렬
        // 그렇다면 갭의 크기만큼 반복문이 있겠지?
        for (int i = 0; i < gap; i++) {
            // 리스트의 길이가 10(0~9)이고 갭이 5라면
            // (0, 5), (1, 6), (2, 7), (3, 8), (4, 9) 다섯번 반복하는 삽입정렬
            // ex) 0과 5를 삽입정렬 -> 1과 6을 삽입정렬 -> ...
           for (int j = i + gap; j < list.size(); j += gap) {
               int k, value = list.get(j);
               for (k = j - gap; k >= i && list.get(k) > value; k -= gap) {
                   list.set(k + gap, list.get(k));
               }
               list.set(k + gap, value);
           }
        }
        if (gap != 1) {
            list = list_shell(list, gap);
        }
        return list;
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        ShellSort shellSort = new ShellSort();
        ListAccuracy listAccuracy = new ListAccuracy();

        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }
        System.out.print("before: ");
        listAccuracy.array_print(arr);

        shellSort.array_shell(arr);
        System.out.print("after: ");
        listAccuracy.array_print(arr);

        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(10));
        }
        List<Integer> origin_copy = new ArrayList<Integer>(list);
        System.out.println("before: " + list);

        list = shellSort.list_shell(list, list.size());
        System.out.println("after: " + list);

        // 윈본과 일치율을 확인하는 코드가 작성되어있다.
        // 합병정렬에서 구현한 코드와 동일하다.
        listAccuracy.accuracy_test(origin_copy, list);
    }
}
