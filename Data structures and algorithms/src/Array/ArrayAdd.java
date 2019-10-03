package Array;

import java.util.Arrays;

/*
 * 数组添加元素
 * 1.创建新数组（长度为原数组加1）
 * 2.复制元素到新数组
 * 3.新数组添加目标元素
 * 4.新数组替换原数组
 */
public class ArrayAdd {

	public static void main(String[] args) {
		//解决数组长度不可变问题
		int[] arr = new int[] {9,8,7};
		//快速查看数组中的元素
		System.out.println(Arrays.toString(arr));
		//要加入的元素
		int targetEle = 6;
		//创建新数组，长度是原数组加1
		int[] newArr = new int[arr.length + 1];
		//把原数组中的数据复制到新数组
		for(int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		//把目标元素添加到新数组
		newArr[arr.length] = targetEle;
		//新数组替换原数组，arr指向newArr
		arr = newArr;
		System.out.println(Arrays.toString(newArr));
		
	}
}
