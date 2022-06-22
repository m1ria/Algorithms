package class03;

import java.util.Arrays;

/**
 * @className: Code01_BSexist
 * @description: 二分查找
 * @author: m1ria
 * @date: 2022/6/22 3:59
 * @version: 1.0
 */
public class Code01_BSexist {

    //有序数组
    public static boolean find(int[] arr, int num) {
        if (arr == null || arr.length < 2) {
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                L = mid + 1;
            } else if (arr[mid] > num) {
                R = mid - 1;
            }
        }
        return false;
    }

    public static boolean test(int[] arr, int num) {
        for (int i : arr) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (maxSize * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue+1);
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTime = 5000;
        int maxSize = 100;
        int maxValue = 999;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random() - (int) (maxValue * Math.random()));
            if (test(arr, value) != find(arr, value)) {
                System.out.println("ERROR!");
                succeed = false;
                break;
            }
        }
        System.out.println(succeed?"ok":"fuck");
    }
}
