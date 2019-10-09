package Sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = rand();
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        //遍历所有步长
        for (int d = arr.length / 2; d > 0; d /= 2){
            //遍历所有元素
            for(int i = d; i < arr.length; i++){
                //遍历本组中所有元素
                for(int j = i - d; j >= 0; j -= d){
                    //如果当前元素大于加上步长后的那个元素
                    if(arr[j] > arr[j+d]){
                        int temp = arr[j];
                        arr[j] = arr[j + d];
                        arr[j + d] = temp;
                    }
                }
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
