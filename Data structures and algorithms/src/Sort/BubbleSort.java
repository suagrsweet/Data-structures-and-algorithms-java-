package Sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {2, 1, 3, 1, 2, 5, 6, 6};
		//System.out.println(Arrays.toString(arr));
		bubbleSort(arr);
		//System.out.println(Arrays.toString(arr));
	}

	/*
	 * 冒泡排序
	 * 外层控制循环几轮，最后一个数不用比较，所以是length - 1次
	 * 内层控制循环几次，以前比较过得就不用比较，所以是length - 1 - i
	 * 有的冒泡经过第一轮的交换已经是有序的了，如：2 1 3 4。数据越多的时候越慢，非常不适合大数据的排序
	 * 如果用一个flag来判断一下，当前数组是否已经有序，如果有序就退出循环，这样可以明显的提高冒泡排序的性能。
	 * 
	 */
	private static void bubbleSort(int[] arr) {
		//给内层循环加标志，如果内层循环完毕之后，flag为false，说明本轮循环已经是有序的了，后面的几轮就不需要
		boolean flag;
		// 外层控制循环几轮
		for(int i = 0; i < arr.length - 1; i++) {
			flag = false; //每次内层循环完毕之后falg为true，需重新设置为false
			//内层控制循环次数
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag = true;
				}
			}
			
			if(!flag) {
				break;
			}
			System.out.println(Arrays.toString(arr));
		}
		
	}

	/*
	 * 生成随机数组
	 */
	private static int[] rand() {
		//随机长度
		int n = (int)(Math.random() * 5) + 6;
		int[] arr = new int[n];
		for(int i = 0; i < arr.length; i++) {
			//随机值
			arr[i] = (int)(Math.random() * 10);
		}
		return arr;
	}

}
