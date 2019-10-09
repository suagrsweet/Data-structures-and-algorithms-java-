package Sort;

import java.util.Arrays;

/**
 * 选择排序
 * @author 40832
 *
 */
public class SelectSort {

	public static void main(String[] args) {
	    int[] arr = rand();
		System.out.println(Arrays.toString(arr));
        selectSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 选择排序
	 * 思路：1.遍历数组中的所有数，把当前遍历的数和这个数后边的所有数比较，找出比当前数小而且是最小的数
	 *      2. 记录那个最小的数，一轮循环完后把最小的数和当前遍历的数交换位置
	 *      3. 依次遍历后边的每一位数
	 * @param arr
	 */
	public static void selectSort(int[] arr){
		// 遍历数组中的数
		for (int i = 0; i < arr.length - 1; i++) {
			// 记录最小那个数的下标, 先定义为i，遇到更小的再换成最小数的下标
			int minIndex = i;
			// 将当前数和它后边的数依次比较，找到最小的数并且记录下来，和当前数交换位置
			for (int j = i + 1; j < arr.length; j++){
				// 用arr[minIndex] 和arr[j] 作比较，因为要寻找最小的那个数，在查找过程中遇到比当前数小的数,
				// 记录下来，用这个小的数再和后边的数作比较，直到找到最小的那个数，记录它的下标
				// 如果用arr[i] 比较的话，只会找到最后面比当前数小的那个数，但它并不一定是最小的
				if (arr[j] < arr[minIndex]){
					minIndex = j;
				}
			}
			// 找到那个最小的数之后和当前数交换位置,前提是找到有比当前数小的数，
			// 如果没有找到比当前数还要小的数就不用做后续操作了
			// 用i 和 minIndex 比较，不相等说明有比当前数小的数，相等则不做操作
			if(i != minIndex){
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
	}

	/*
	 * 生成随机数组
	 */
	private static int[] rand() {
		// 随机长度
		int n = (int) (Math.random() * 5) + 6;
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			// 随机值
			arr[i] = (int) (Math.random() * 10);
		}
		return arr;
	}

}

