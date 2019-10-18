/*
子域名访问计数

一个网站域名，如"discuss.leetcode.com"，包含了多个子域名。作为顶级域名，
常用的有"com"，下一级则有"leetcode.com"，最低的一级为"discuss.leetcode.com"。
当我们访问域名"discuss.leetcode.com"时，也同时访问了其父域名"leetcode.com"以及顶级域名 "com"。

给定一个带访问次数和域名的组合，要求分别计算每个域名被访问的次数。
其格式为访问次数+空格+地址，例如："9001 discuss.leetcode.com"。

接下来会给出一组访问次数和域名组合的列表cpdomains 。
要求解析出所有域名的访问次数，输出格式和输入格式相同，不限定先后顺序。
 */
import java.util.*;

public class StringDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        for (String cpdomain : cpdomains) {
            String[] a = cpdomain.split(" ");
            int n = Integer.valueOf(a[0]);
            String domain = a[1];

            String[] b = domain.split("\\.");
            for (int i = 0; i < b.length; i++) {
                String[] c = Arrays.copyOfRange(b, i, b.length);
                String subdomain = String.join(".", c);
                int oldCount = map.getOrDefault(subdomain, 0);
                map.put(subdomain, oldCount + n);
            }
        }
        List<String> ret = new ArrayList<>();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            String domain = e.getKey();
            int n = e.getValue();
            String s = String.format("%d %s", n, domain);
            ret.add(s);
        }
        System.out.println(ret);
    }
}
