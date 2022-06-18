package class01;

/**
 * @className: Code04
 * @description: 冒泡排序
 * @author: m1ria
 * @date: 2022/6/18 3:41
 * @version: 1.0
 */
public class Code04 {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int end = N - 1; end >= 0; end--) {

            for (int second = 1; second <= end; second++) {
                if (arr[second - 1] > arr[second]) {
                    swap(arr,second-1,second);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 23, 41, 24, 5, 2, 8, 87, 9, 110};
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }
}
