public class BinarySearch{
	public static int binarySearch(int[] a, int v){
		int left=0;
		int right=a.length-1;
		
		while(left<=right){
			int mid = (left+right)/2;
			if(v==a[mid]){
				return mid;
			}else if(v<a[mid]){
				right=mid-1;
			}else{
				left=mid+1;
			}
		}
		return -1;
	}
	public static void main(String[] args){
		int[] a={12,4,2,6,8,5};
	    int v=11;
		System.out.println(binarySearch(a,v));
	}
}