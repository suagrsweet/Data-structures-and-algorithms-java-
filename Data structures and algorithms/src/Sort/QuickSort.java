package Sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = rand();
		int start = 0;
		int end = arr.length - 1;
		System.out.println(Arrays.toString(arr));
		quickSort(arr, start, end);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 快速排序
	 * @param arr
	 * @param start
	 * @param end
	 */
	public static void quickSort(int[] arr, int start, int end) {
		if (start < end) {

			// 把数组中第0个数作为标准
			int stand = arr[start];
			// 记录需要排序的下标
			int low = start;
			int high = end;
			// 循环找比标准值大的数和比标准值小的数
			while (low < high) {
				// 右边的数比标准值大
				while (low < high && stand <= arr[high]) {
					high--;
				}
				// 标准值只是作为一个标准，不参加循环，最后将标准值放到中间，左边的数都比标准值小，右边的数都比标准值大
				// 从右往左，遇到比标准值小的数 ,把这个数放到标准值的位置，然后从这个数开始往后循环，与标准值比较，
				// 比标准值大的数放到上一次比标准值小的那个数的位置
				// 此时low的位置就空出来了，把标准值放在此处
				arr[low] = arr[high];
				// 如果左边的数比标准数小
				while (low < high && arr[low] <= stand) {
					low++;
				}
				arr[high] = arr[low];
			}
			// 把标准值赋给low位置的数
			arr[low] = stand;
			// 处理所有小的数字,从开始位置到上次的标准值位置
			quickSort(arr, start, low);
			// 处理所有大的数字，从上次标准值的位置+1到结束位置
			quickSort(arr, low + 1, end);

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
