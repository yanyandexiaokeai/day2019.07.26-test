/*
给一个数字N，最小步数使其成为斐波那契数
 */
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int first = 0;
        int second = 1;
        if(n == 1) {
            System.out.println("0");
            return;
        }
        while(true){
            int temp = first;
            first = second;
            second = temp + second;
            if(n > first && n <= second){
                int step = Math.min(n-first,second - n);
                System.out.println(step);
                return;
            }
        }
    }
}