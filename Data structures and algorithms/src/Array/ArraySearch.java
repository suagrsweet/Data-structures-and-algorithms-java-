package Array;
/*
 * 线性查找
 */
public class ArraySearch {

	public static void main(String[] args) {
		//目标数组
		int[] arr = new int[] {2,5,1,4,6,3,8};
		//目标元素
		int target = 0;
		//目标元素所在的下标
		int index = -1; //初始值
		// 遍历数组
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == target) {
				index = i;
				break;
			}
		}
		System.out.println(index);
	}

}
