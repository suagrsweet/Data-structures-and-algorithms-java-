package Sort;

import java.util.Arrays;

/**
 * 归并排序
 * 归并排序是将两个有序的数组合成一个有序的数组
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{9,7,5,3,1,10,8,6,4,2};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 要想对一个无序数组进行归并排序，首先得将它分成两个有序的数组
     * 其中中间数是必须确定的，确定了中间数后先处理中间数前面的数组，
     * 使用递归把数组无限从中间分隔，每次将分隔前和分隔后的数组进行归并
     * @param arr
     * @param low
     * @param high
     */
    public static void mergeSort(int[] arr, int low, int high){
        int middle = (high + low) / 2;
        if(low < high){
            mergeSort(arr, low, middle);
            mergeSort(arr, middle + 1, high);
            merge(arr, low, middle, high);
        }
    }

    public static void merge(int[] arr, int low, int middle, int high){
        //定义临时数组用来存储排序后的数据,长度为要比较的数据的长度
        int[] temp = new int[high - low + 1];
        // 记录第一个数组中需要遍历的下标
        int i = low;
        // 记录第二个数组中需要遍历的下标
        int j = middle + 1;
        // 记录临时数组中下标
        int index = 0;
        // 循环遍历两个数组中的数据，第一个数组中的第一个数据和第二个数组中的第一个数据比较，
        // 小的那个数放到临时数组中，大的那个数和另一个数组中的第二个数再比较，小的数放到临时数组中
        while (i <= middle && j <= high){
            // 第一个数组的数据更小,把较小的数据放入临时数组，并且两个下标都向后移
            if (arr[i] <= arr[j]) {
                temp[index] = arr[i];
                i++;
                index++;
            // 第二个数组的数据更小
            } else {
                temp[index] = arr[j];
                j++;
                index++;
            }
        }
        // 处理剩下不需要排序的数据，可能是第一个数组中的数据，也可能是第二个数组中的数据
        while (i <= middle){
            temp[index] = arr[i];
            i++;
            index++;
        }
        while (j <= high){
            temp[index] = arr[j];
            j++;
            index++;
        }
        // 把临时数组中的数据重新放入原数组
        for (int k = 0; k < temp.length; k++) {
            arr[k + low] = temp[k];
        }
    }
}
