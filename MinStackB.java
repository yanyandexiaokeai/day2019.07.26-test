//最小栈
import java.util.ArrayList;

public class MinStackB {
    private ArrayList<Integer> normal;
    private ArrayList<Integer> min;

    public MinStackB() {
        normal = new ArrayList<>();
        min = new ArrayList<>();
    }

    public void push(int x) {
        normal.add(x);

        if (min.isEmpty()) {
            min.add(x);
        } else if (x <= min.get(min.size() - 1)){
            min.add(x);
        }
    }

    public void pop() {
        int v = normal.remove(normal.size() - 1);
        if (v == min.get(min.size() - 1)) {
            min.remove(min.size() - 1);
        }
    }

    public int top() {

        return normal.get(normal.size() - 1);
    }

    public int getMin() {

        return min.get(min.size() - 1);
    }
}
