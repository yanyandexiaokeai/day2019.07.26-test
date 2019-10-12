 //使用递归方法实现斐波那契数列
public class Fibonacci {
    public static int printFibonacci(int num) {
        if (num == 1 || num == 2) {
            return 1;
        } else {
            return printFibonacci(num - 1) + printFibonacci(num - 2);
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 12; i++) {
            System.out.println("第" + i + "=" + printFibonacci(i));
        }
    }
}
