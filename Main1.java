//输入一个集合，求出该字符串包含的字符集合
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Main1{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            char[] c = in.next().toCharArray();
            StringBuffer sb = new StringBuffer();
            Set<Character> set = new HashSet<Character>();
            for(int i = 0;i<c.length;i++){
                if(set.add(c[i]))
                    sb.append(c[i]);
            }
            System.out.println(sb.toString());
        }
    }
}