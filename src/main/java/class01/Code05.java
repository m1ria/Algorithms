package class01;

/**
 * @className: Code05
 * @description: 插入排序
 * @author: m1ria
 * @date: 2022/6/19 2:14
 * @version: 1.0
 */
public class Code05 {

    public static void insertSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int end = 1; end < N; end++) {
            int newNumIndex = end;
            while (newNumIndex - 1 >= 0 && arr[newNumIndex - 1] > arr[newNumIndex]) {
                swap(arr, newNumIndex - 1, newNumIndex);
                newNumIndex--;
            }
        }
    }

    public static void insertSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int end = 1; end < N; end++) {
            for (int pre = end - 1; pre >= 0 && arr[pre] > arr[pre +1]; pre--) {
                swap(arr, pre, pre + 1);
            }

        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
        printArray(arr);
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
//        insertSort1(arr);
        insertSort2(arr);
        printArray(arr);
    }
}
