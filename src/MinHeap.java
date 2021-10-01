import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MinHeap {
    List<Integer> list = new ArrayList<Integer>();
    public void insert_node(int input) {
        // 마지막 노드에 삽입 후 부모와 비교
        // 부모 = 바닥 함수(현재 위치 / 2)
        list.add(input);
        int child = list.size() - 1;
        while (child >= 1) {
            // 상위 요소의 갯수가 1개 이상 이라면 (부모가 있다면)
            int parent = ((child + 1) / 2) - 1;
            if (list.get(parent) > list.get(child)) {
                int temp = list.get(parent);
                list.set(parent, list.get(child));
                list.set(child, temp);
                child = parent;
            } else {
                child = 0;
            }
        }
    }
    public void delete_root() {
        // 노드가 하나라도 있는지 검사
        if (list.size() > 0) {
            // 있다면 뿌리노드 (인덱스 0) 삭제
            list.remove(0);
            int index = 0;
            // 뿌리 노드를 삭제하고 남은 노드가 2개 이상 (부모1, 자식1)인지 검사
            if (list.size() > 1) {
                // 삭제된 뿌리노드의 자리에 맨 끝 노드 삽입
                list.add(0, list.get(list.size() - 1));
                // 첫번째 자리로 들어간 노드의 기존 값 삭제
                list.remove(list.size() - 1);
                // 최상위 부모의 자리부터 시작하여  자식들과 비교해가며 있어야 할 자리를 찾는다.
                // 첫번째 자식을 구하는 공식 ((index + 1) * 2) - 1
                // 자녀가 있다면 반복문을 계속 진행하고
                // 자녀가 없거나 (마지막 자리) 반복을 통해 root 에 삽입된 노드가 제 위치를 찾았다면 (맨 마지막 line 68 else 문) 반복문을 종료한다.
                while ((((index + 1) * 2) - 1) < list.size()) {
                    // heap 에서 자식 노드 2개를 찾는 공식
                    // 시작 인덱스가 1이라면 *2, *2 + 1 인 2번째, 3번째 노드가 자식 노드이지만
                    // 프로그래밍에서는 인덱스가 0부터 시작함으로 부모 노드의 인덱스 +1하고 계산한 뒤 - 1
                        // root_index * 2 -> ((root_index + 1) * 2) - 1 - > (root_index + 1) * 2 - 1
                        // root_index * 2 + 1 -> (((root_index + 1) * 2) + 1) - 1 - > (root_index + 1) * 2
                    int child1 = ((index + 1) * 2) - 1;
                    int child2 = ((index + 1) * 2);
                    int compare;
                    // 두번째 자식이 리스트의 크기보다 크거나 같으면 = 자식이 한명밖에 없다면
                    // 혹은 첫번째 자식의 값이 두번째 자식의 값보다 작다면
                    if (child2 >= list.size() || list.get(child1) < list.get(child2)) {
                        // 비교할 대상 (자녀 노드)을 첫번째 자식으로 설정한다.
                        compare = child1;
                    } else {
                        // 자녀가 두명이며 두번째 자식의 값이 첫번째 자식의 값보다 작거나 같다면
                        // 비교 대상을 두번째 자식으로 설정한다.
                        compare = child2;
                    }
                    // 현재 부모노드에 있는 (마지막 노드에서 옮겨진)노드가 자식노드보다  작다면
                    if (list.get(compare) < list.get(index)) {
                        // 서로의 값을 교환해준다.
                        int temp = list.get(compare);
                        list.set(compare, list.get(index));
                        list.set(index, temp);
                        index = compare;
                    } else {
                        // 부모 노드가 자식 노드보다 작다면 (위치해야할 곳에 있다면)
                        // 인덱스를 맨 뒤로 옮겨 반복문을 빠져나올 수 있도록 한다.
                        index = list.size() - 1;
                    }
                }
            }
        }
    }
    public void print_list() {
        System.out.println(list);
    }
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            minHeap.insert_node(random.nextInt(10));
        }
        for (int j = 0; j < 6; j++) {
            minHeap.print_list();
            minHeap.delete_root();
        }
    }
}
