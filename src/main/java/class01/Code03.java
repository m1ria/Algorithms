package class01;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.jar.JarEntry;

/**
 * @className: Code03
 * @description: 选择排序
 * @author: m1ria
 * @date: 2022/6/17 18:15
 * @version: 1.0
 */
public class Code03 {

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < N; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
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
        selectSort(arr);
        printArray(arr);
    }
}
