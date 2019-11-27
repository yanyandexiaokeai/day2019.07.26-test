/*
* 替换空格
* 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
* 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
* */
//1、
/*public class Solution2{
    public String replaceSpace(StringBuffer str) {
        StringBuffer out=new StringBuffer();
        for (int i = 0; i < str.toString().length(); i++) {
            char b=str.charAt(i);
            if(String.valueOf(b).equals(" ")){
                out.append("%20");
            }else{
                out.append(b);
            }
        }
        return out.toString();
    }
}*/

//2、
/*public class Solution2 {
    public String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" " , "%20");
    }
}*/

//3、
public class Solution2{
    public String replaceSpace(StringBuffer str) {
        if (str == null || str.equals("")) {
            return str.toString();
        }
        StringBuffer sb = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            String s = str.substring(i,i+1);
            if (s.equals(" ")) {
                sb.append("%20");
            } else {
                sb.append(s);
            }
        }
        return sb.toString();
    }
}

