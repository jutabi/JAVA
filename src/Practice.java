import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Practice {

    public List<Integer> list_sort(List<Integer> list) {

        return list;
    }

    public static void main(String[] args) {
        Random random = new Random();
        Practice practice = new Practice();

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 11; i++) {
            list.add(random.nextInt(10));
        }
        System.out.println("\nbefore: " + list);

        list = practice.list_sort(list);
        System.out.println("\nafter: " + list);
    }
}
