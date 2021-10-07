import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShellSort {
    public List<Integer> list_shell(List<Integer> list, int prev_gap) {
        // 이전 gap의 절반을 gap으로 설정, 짝수가 나오면 +1을 하여 홀수로 설정
        int gap = ((prev_gap / 2) % 2 == 0) ? prev_gap / 2 + 1 : prev_gap / 2;
        // prev_gap이 1일때 위의 gap을 정하는 코드에서 2로 나눈 값이 0이 되는데
        // 0은 짝수임으로 +1이 되어 gap이 다시 1이 된다. 그래서 1이 들어왔을 때 0으로 만들어준다.
        // 아래의 재귀함수 호출에서 작업하거나 여기서에서 작업하면 될 것 같다.
        if (prev_gap == 1) { gap = 0; }
//        System.out.println("gap: " + gap);
        // 0부터 +gap 한 애들 삽입정렬
        // 그렇다면 갭의 크기만큼 반복문이 있겠지?
        if (gap > 0) {
            // 갭이 1이 될 때 까지 (마지막 정렬까지)
            for (int i = 0; i < gap; i++) {
                // 리스트의 길이가 10(0~9)이고 갭이 5라면
                // (0, 5), (1, 6), (2, 7), (3, 8), (4, 9) 다섯번 반복하는 삽입정렬
                // ex) 0과 5를 삽입정렬 -> 1과 6을 삽입정렬 -> ...
                // i가 0부터 4까지 (gap 미만) 가기 때문에 i를 이용해서 계산한다.
                int temp = i;
//                System.out.println("temp: " + temp);
                while (temp + gap < list.size()) {
                    int comp2 = temp + gap;
//                    System.out.println("comp2: " + comp2);
                    temp += gap;
                    while (comp2 - gap >= 0) {
                        int comp1 = comp2 - gap;
//                        System.out.println("comp1: " + comp1 + "\n");
                        if (list.get(comp1) > list.get(comp2)) {
                            int t = list.get(comp1);
                            list.set(comp1, list.get(comp2));
                            list.set(comp2, t);
                            comp2 -= gap;
                        } else {
                            comp2 = 0;
                        }
                    }
                }
            }
            list = list_shell(list, gap);
        }
        return list;
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        ShellSort shellSort = new ShellSort();
        ListAccuracy listAccuracy = new ListAccuracy();

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
