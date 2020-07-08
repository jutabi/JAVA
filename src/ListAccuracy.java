import java.util.ArrayList;
import java.util.List;

public class ListAccuracy {
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
}
