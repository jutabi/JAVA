import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    List<Integer> list = new ArrayList<Integer>();
    public void insert_node(int input) {
        // 마지막 노드에 삽입 후 부모와 비교
        // 부모 = 바닥 함수(현재 위치 / 2)
        list.add(input);
        int child = list.size() - 1;
        while (child >= 1) {
            // 상위 요소의 갯수가 2개 이상 이라면 (부모가 있다면)
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
        if (list.size() > 0) {
            list.remove(0);
            int index = 0;
            if (list.size() > 1) {
                list.add(0, list.get(list.size() - 1));
                list.remove(list.size() - 1);
                while ((((index + 1) * 2) - 1) < list.size()) {
                    int child1 = ((index + 1) * 2) - 1;
                    int child2 = ((index + 1) * 2);
                    int compare;
                    if (child2 >= list.size() || list.get(child1) < list.get(child2)) {
                        compare = child1;
                    } else {
                        compare = child2;
                    }
                    if (list.get(compare) < list.get(index)) {
                        int temp = list.get(compare);
                        list.set(compare, list.get(index));
                        list.set(index, temp);
                        index = compare;
                    } else {
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
        minHeap.insert_node(2);
        minHeap.insert_node(3);
        minHeap.insert_node(5);
        minHeap.insert_node(1);
        minHeap.insert_node(7);
        minHeap.insert_node(6);
        minHeap.print_list();
        minHeap.delete_root();
        minHeap.print_list();
        minHeap.delete_root();
        minHeap.print_list();
    }
}
