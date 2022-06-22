package class03;

import java.util.Arrays;

/**
 * @className: BSNearLeft
 * @description: 在有序数组中找到最左端的匹配值
 * @author: m1ria
 * @date: 2022/6/22 17:42
 * @version: 1.0
 */
public class Code02_BSNearLeft {

    public static int mostLeftNoLessNumIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;//当查找不到时 直接返回-1错误
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] >= num) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    public static int test(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= num) {
                return i;
            }
        }
        return -1;
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
            if (test(arr, value) != mostLeftNoLessNumIndex(arr, value)) {
                System.out.println("ERROR!");
                System.out.println(mostLeftNoLessNumIndex(arr, value));
                succeed = false;
                break;
            }
        }
        System.out.println(succeed?"ok":"fuck");
    }
}
