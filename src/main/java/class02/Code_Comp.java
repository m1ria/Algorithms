package class02;

import class01.Code03;

/**
 * @className: Code_Comp
 * @description: 对数器
 * @author: m1ria
 * @date: 2022/6/22 2:37
 * @version: 1.0
 */
public class Code_Comp {
    public static void selectSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < N; j++) {
                //  小于改大于 ，使排序报错
                minValueIndex = arr[j] > arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static int[] lenRandomValueRandom(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = (int) (Math.random() * maxValue);
        }
        return ans;
    }

    public static int[] copyArr(int[] arr) {
        int[] a = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = arr[i];
        }
        return a;
    }

    public static boolean isSort(int[] arr) {
        if (arr.length < 2) {
            return true;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max > arr[i]) {
                return false;
            }
            max = Math.max(max, arr[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int maxLen = 9;
        int maxValue = 99;
        int testTime = 1000;

        for (int i = 0; i < testTime; i++) {
            int[] arr = lenRandomValueRandom(maxLen, maxValue);
            int[] tmp = copyArr(arr);
            selectSort(arr);
            if (!isSort(arr)) {
                for (int j = 0; j < tmp.length; j++) {
                    System.out.print(tmp[j]+" ");
                }
                System.out.println("ERROR!");
                break;
            }
        }
    }
}
