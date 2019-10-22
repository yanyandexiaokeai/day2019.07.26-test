/*
题目描述：
牛牛想尝试一些新的料理，每个料理需要一些不同的材料，问完成所有的料理需要准备多少种不同的材料。
输入描述:
每个输入包含 1 个测试用例。每个测试用例的第 i 行，表示完成第 i 件料理需要哪些材料，各个材料用空格隔开，输入只包含大写英文字母和空格，输入文件不超过 50 行，每一行不超过 50 个字符。
输出描述:
输出一行一个数字表示完成所有料理需要多少种不同的材料。
示例1
输入
BUTTER FLOUR
HONEY FLOUR EGG
输出
4
分析：
此题的用意其实就是去重，所以会想使用Set,由于不知道用户输入多少行，
使用的Scanner中的hasNext()方法来判断是否还存在下一行，此方法需要用户手动结束循环，
window环境下使用ctrl+z结束输入循环，linux环境下使用ctrl+d结束输入循环。
 */
import java.util.Scanner;
import java.util.HashSet;
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> hs = new HashSet<String>();
        while(sc.hasNext()){
            String s = sc.next();
            String[] temp = s.split(" ");
            for(int i=0; i<temp.length; i++){
                hs.add(temp[i]);
            }
        }
        System.out.println(hs.size());
    }
}