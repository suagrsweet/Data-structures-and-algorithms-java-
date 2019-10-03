package Array;

import java.util.Arrays;

/*
 * 数组删除元素
 * 1.创建新数组，长度是原数组长度减1
 * 2.复制除了要删除的元素到新数组
 * 3.分别对目标元素之前和之后的元素操作
 * 4.新数组替换原数组
 */
public class ArrayDelete {

	public static void main(String[] args) {
		// 目标数组
		int[] arr = new int[] { 9, 8, 7, 6, 5, 4 };
		System.out.println(Arrays.toString(arr));
		// 目标元素下标
		int targetEle = 0;
		// 新数组
		int[] newArr = new int[arr.length - 1];
		// 复制元素到新数组,遍历新数组，方便赋值
		for (int i = 0; i < newArr.length; i++) {
			// 要删除元素之前的元素
			if (i < targetEle) {
				newArr[i] = arr[i];
			} else { // 要删除元素之后的元素
				newArr[i] = arr[i + 1];
			}
		}
		// 新数组替换原数组
		arr = newArr;
		System.out.println(Arrays.toString(arr));
	}
}
