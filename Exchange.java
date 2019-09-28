public class Exchange {
    public int[] prevPermOpt1(int[] A) {
        /*
        给你一个正整数的数组 A（其中的元素不一定完全不同），
        请你返回可在 一次交换（交换两数字 A[i] 和 A[j] 的位置）后得到的、
        按字典序排列小于 A 的最大可能排列。如果无法这么操作，
        就请返回原数组
         */
        /*
        思路：从后往前遍历，遇到第一个升序，将这个数与后面遍历过的最大的数（但要比交换的数小）交换
        */
        for (int i = A.length-2; i >= 0;i--){
            if(A[i] > A[i+1]){
                int maxIndex = -1;
                int max = Integer.MIN_VALUE;
                for(int j = i+1;j < A.length;j++){
                    if(A[j] <A[i] && A[j] > max){
                        max = A[j];
                        maxIndex = j;
                    }
                }
                int t = A[i];
                A[i] = A[maxIndex];
                A[maxIndex] = t;
                return A;
            }
        }
        return A;
    }
}