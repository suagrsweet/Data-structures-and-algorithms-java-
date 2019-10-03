package Sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = rand();
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        //从下标为1的位置开始遍历数组
        for (int i = 1; i < arr.length; i++) {
            // 如果当前的数小于前一位数，再将当前数依次和前面所有的数比较一次，直到当前这个数大于要比较的那个数才停止
            // 注意，当前数arr[i] 一定要存到临时变量temp中，因为后续依次和前面的数比较时是用的arr[i]的值，
            //  i每次循环是固定不变的，但是做过一次交换后，arr[i]的值就变了，因为我们依次和前面的数作比较的是最初的arr[i]的值
            // 所以内层循环，也就是依次和前面所有的数比较的这个for循环的条件必须是用temp<arr[j]。
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                int j = 0;
                for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                    //因为要做交换，每个比当前数temp大的数都要向后移一位。
                    arr[j + 1] = arr[j];
                }
                // 每个比temp大的数都向后移动了一位，循环到最后的j，也就是不需要移动的j，它的下一位就空出来了，所以把当前值赋给arr[j+1]
                arr[j + 1] = temp;
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
