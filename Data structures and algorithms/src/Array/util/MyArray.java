package Array.util;

import java.util.Arrays;

/*
 * 数组工具类
 */
public class MyArray {
	// 用于存储数据的数组
	private int[] elements;

	// 调用MyArray类就生成一个数组
	public MyArray() {
		elements = new int[0];
	}

	/*
	 * 获取数组长度
	 */
	public int size() {
		return elements.length;
	}

	/*
	 * 添加一个元素到末尾
	 */
	public void add(int element) {
		// 创建新数组，长度为原数组加1
		int[] newArr = new int[elements.length + 1];
		// 把原数组元素复制到新数组
		for (int i = 0; i < elements.length; i++) {
			newArr[i] = elements[i];
		}
		// 添加新元素到新数组末尾
		newArr[elements.length] = element;
		// 新数组替换原数组,原数组会被垃圾回收器回收掉
		elements = newArr;
	}

	/*
	 * 删除指定元素
	 */
	public void delete(int index) {
		// 判断用户操作正确性
		if (index < 0 || index > elements.length - 1) {
			throw new ArrayIndexOutOfBoundsException("数组下标越界");
		}
		// 创建新数组，长度为原数组减1
		int[] newArr = new int[elements.length - 1];
		// 复制元素到新数组
		for (int i = 0; i < newArr.length; i++) {
			// 复制要删除元素之前的元素
			if (i < index) {
				newArr[i] = elements[i];
				// 复制要删除元素之后的元素
			} else {
				newArr[i] = elements[i + 1];
			}
		}
		// 新数组替换原数组
		elements = newArr;
	}

	/*
	 * 插入一个元素到指定位置
	 */
	public void insert(int index, int element) {
		if (index < 0 || index > elements.length) {
			throw new ArrayIndexOutOfBoundsException("数组下标越界");
		}
		// 创建新数组，长度为原数组加1
		int[] newArr = new int[elements.length + 1];
		// 复制元素,遍历长度小的数组
		for (int i = 0; i < elements.length; i++) {
			// 复制插入元素之前的元素
			if (i < index) {
				newArr[i] = elements[i];
				// 复制插入元素之后的元素
			} else {
				newArr[i + 1] = elements[i];
			}
		}
		// 在指定位置插入元素
		newArr[index] = element;
		// 新数组替换原数组
		elements = newArr;
	}

	/*
	 * 替换指定位置元素
	 */
	public void set(int index, int element) {
		// 判断用户操作正确性
		if (index < 0 || index > elements.length - 1) {
			throw new ArrayIndexOutOfBoundsException("数组下标越界");
		}
		elements[index] = element;
	}

	/*
	 * 取出指定位置的元素
	 */
	public int get(int index) {
		// 判断用户操作正确性
		if (index < 0 || index > elements.length - 1) {
			throw new ArrayIndexOutOfBoundsException("数组下标越界");
		}
		return elements[index];
	}

	/*
	 * 显示数组所有元素
	 */
	public void show() {
		System.out.println(Arrays.toString(elements));
	}
	
	/*
	 * 线性查找
	 */
	public int search(int target) {
		for(int i = 0; i < elements.length; i++) {
			if(elements[i] == target) {
				return i; //找到目标元素返回下标
			}
		}
		return -1; //没有找到返回-1
	}
	
	/*
	 * 二分法查找,前提数组必须是有序的
	 */
	public int binarySearch(int target) {
		// 记录开始位置
		int begin = 0;
		// 记录末尾位置
		int end = elements.length - 1;
		// 记录中间位置
		int mid = (begin + end) / 2;
		// 记录目标元素下标
		int index = -1; // 初始值，没有找到返回-1
		// 循环查找
		while (begin < end) {
			// 判断中间元素是不是要查找的元素
			if (elements[mid] == target) {
				index = mid;
				break;
			} else { // 中间这个元素不是要查找的元素
				// 中间元素比目标元素大，末尾位置换成mid-1
				if (elements[mid] > target) {
					end = mid - 1;
					// 中间元素比目标元素小，开始位置换成mid+1
				} else {
					begin = mid + 1;
				}
				mid = (begin + end) / 2;
			}
		}
		return index;
	}
}
