//顺序表的 数据类型 int
public class MyArrayList {
	//属性是什么
	private int[] array;    //代表存在数据的数组
	                        //array.length代表的是数组的容量
	private int size;       //记录顺序表的已有数据个数
	
	//构造方法（目的：初始化数组）
	public MyArrayList(){
		//1.申请空间
		array = new int[20];
		//2.初始化数据个数
		size=0;
	}
//增（重点）
	
	//尾插
	public void pushBack(int element){
		ensureCapacity();//解决array数组放不下的问题
		array[size++]=element;
	}
	
	//头插
	public void pushFront(int element){
		ensureCapacity();
		for(int i=size;i>=1;i--){
			//用了空心做参考，且空心在前实心在后
			array[i]=array[i-1];
	}
	array[0]=element;
	size++;
	}
	
	//在指定位置（index）插入数据
	public void insert(int index,int element){
		ensureCapacity();
		if(index<0||index>size){
			System.err.println("下标错误");
			return;
		}
		//用实心做参考
		for(int i=size-1;i>=index;i--){
			array[i+1]=array[i];
		}
		array[index]=element;
		size++;
	}
//删（重点）
	
	//尾删
	public void popBack(){
		if(size<=0){
			System.err.println("顺序表为空");
			return;
		}
		array[--size]=0;
	}
	//头删
	public void popFront(){
		if(size<=0){
			System.err.println("顺序表为空");
			return;
		}
		for(int i=0;i<size-1;i++){
			array[i]=array[i+1];
		}
		size--;
	}
	//删除指定位置的数
	public void earse(int index){
		if(size<=0){
			System.err.println("顺序表为空");
			return;
		}
		if(index<0||index>=size){
			System.err.println("下标错误");
			return;
		}
		for(int i=index+1;i<size;i++){
			array[i-1]=array[i];
		}
		array[--size]=0;
	}
	
	//删除某一个元素，如果出现多次，删除第一次出现的
	public void remove(int element){
		int index=indexOf（element);
		if(index!=-1){
			earse(index);
		}
	}
	
	//所有出现的元素都删除
	public void removeAll(int element){
		/* 时间:O(n^2)	时间：O(1)
		int index;
		while ((index = indexOf(element)) != -1) {
			earse(index);
		}
		*/
		
		/* 时间: O(n)	空间: O(n)
		int[] newArray = new int[array.length];
		int j = 0;
		for (int i = 0; i < size; i++) {
			if (array[i] != element) {
				newArray[j++] = array[i];
			}
		}
		array = newArray;
		size = j;
		*/
		
		// 时间：O(n)	空间：O(1)
		int j = 0;
		for (int i = 0; i < size; i++) {
			if (array[i] != element) {
				array[j++] = array[i];
			}
		}
		size = j;
	}
	
//查
    //返回element在顺序表中的下标，如果出现多次，返回第一次的下标
	public int indexOf(int element){
		for(int i=0;i<size;i++){
			if(array[i]==element){
				return i;
			}
		}
		return -1;
	}

//改
    public int get(int index){
		if(index<0||index>=size){
			System.err.println("下标错误");
			return;
		}
		return array[index];
	}
	
	public void set(int index,int element){
		if(index<0||index>=size){
			System.err.println("下标错误");
			return;
		}
		array[index]=element;
//打印
    public void print(){
		System.out.println("打印顺序表： ");
		for(int i=0;i<size;i++){
		    System.out.print(array[i]+"  ");
	}
	System.out.println();
	}
	
// 保证容量够用，否则进行扩容
	private void ensureCapacity() {
		if (size < array.length) {
			return;
		}
		
		int newCapacity = array.length * 2;
		int[] newArray = new int[newCapacity];
		for (int i = 0; i < size; i++) {
			newArray[i] = array[i];
		}
		array = newArray;
	}
//查看容量
    public int size(){
		return size;
	}
	
//查看顺序表是否为空
    public boolean isEmpty(){
		return size==0;
	}
	
	//检验结果
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		list.print();
		list.pushBack(1);
		list.pushBack(2);
		list.pushBack(3);
		list.print();	// 1 2 3
		list.pushFront(10);
		list.pushFront(20);
		list.pushFront(30);
		list.print();	// 30 20 10 1 2 3
		list.insert(3, 100);
		list.print();	// 30 20 10 100 1 2 3
		list.insert(20, 200);	// 报错
		
		list.earse(2);
		list.earse(2);
		list.print();	// 30 20 1 2 3
		list.popFront();
		list.popFront();
		list.popFront();
		list.print();	// 2 3
		list.popBack();
		list.popBack();
		list.print();	// 空的
		list.popBack();	// 报错
	}
}
