package Array;

/*
 * 二分法查找，前提是数组必须是有序的
 */
public class ArrayBinarySearch {

	public static void main(String[] args) {
		// 目标数组
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// 目标元素
		int target = 5;
		// 记录开始位置
		int begin = 0;
		// 记录末尾位置
		int end = arr.length - 1;
		// 记录中间位置
		int mid = (begin + end) / 2;
		// 记录目标元素下标
		int index = -1; // 初始值，没有找到返回-1
		// 循环查找
		while (begin < end) {
			// 判断中间元素是不是要查找的元素
			if (arr[mid] == target) {
				index = mid;
				break;
			} else { // 中间这个元素不是要查找的元素
				// 中间元素比目标元素大，末尾位置换成mid-1
				if (arr[mid] > target) {
					end = mid - 1;
					// 中间元素比目标元素小，开始位置换成mid+1
				} else {
					begin = mid + 1;
				}
				mid = (begin + end) / 2;
			}
		}
		System.out.println("index:" + index);
	}

}
