// 只出现一次的数字
/*
给定一个非空整数数组，
除了某个元素只出现一次以外，
其余每个元素均出现两次。
找出那个只出现了一次的元素。
 */
import java.util.Map;
import java.util.TreeMap;

public class CalcCount {
    public static Map<Integer, Integer> calcCount(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        // [ 2 2 1 3 2 1 4]

        for (int n : nums) {
            int c = map.getOrDefault(n, 0);
            map.put(n, c + 1);
            /*
            Integer c = map.get(n);
            if (c == null) {
                map.put(n, 1);
            } else {
                map.put(n, c + 1);
            }
             */
        }
        return map;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 1, 2, 3, 9, 1, 3, 9, 2, 8 };
        Map<Integer, Integer> map = calcCount(nums);
        System.out.println(map);
    }
}


/*
import java.util.Map;
import java.util.TreeMap;

public class CalcCount {
    public static int calcCount(int[] nums){
        Map<Integer, Integer> map = new TreeMap<>();

        for(int n : nums){
            int c = map.getOrDefault(n,0);
            map.put(n, c+1);
        }

        for(Map.Entry<Integer, Integer>e:map.entrySet()){
            int n = e.getKey();
            int c = e.getValue();
            if (c == 1){
                return n;
            }
        }
        return -1;
    }
}
