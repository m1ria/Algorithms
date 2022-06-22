package class03;

import java.util.Arrays;

/**
 * @className: Code03_BSNearRight
 * @description: 在有序数组中找到最右端的匹配值
 * @author: m1ria
 * @date: 2022/6/22 18:00
 * @version: 1.0
 */
public class Code03_BSNearRight {
    public static int mostRightNoLessNumIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;//当查找不到时 直接返回-1错误
        while ( R>= L) {
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
        for (int i = arr.length-1; i >0 ; i--) {
            if (arr[i] <= num) {
                System.out.println("test: "+i);
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
        int testTime = 1000;
        int maxSize = 10;
        int maxValue = 99;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random() - (int) (maxValue * Math.random()));
            if (test(arr, value) != mostRightNoLessNumIndex(arr, value)) {
                System.out.println("ERROR!");
                System.out.println(mostRightNoLessNumIndex(arr, value));
                succeed = false;
                break;
            }
        }
        System.out.println(succeed?"ok":"fuck");
    }
}
