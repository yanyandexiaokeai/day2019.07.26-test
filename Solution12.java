import java.util.ArrayList;
import java.util.List;
//杨辉三角
class Solution12 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return list;
        }
        List<Integer> list1 = null;
        List<Integer> pList = null;
        list1 = new ArrayList<Integer>();
        list1.add(1);
        list.add(list1);
        for (int i = 1; i < numRows; i++) {

            list1 = new ArrayList<Integer>();
            list1.add(1);
            for (int j = 1; j < i; j++) {
                pList = list.get(i-1);
                list1.add(pList.get(j)+pList.get(j-1));
            }
            list1.add(1);
            list.add(list1);
        }
        return list;
    }
}