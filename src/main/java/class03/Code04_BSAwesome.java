package class03;

/**
 * @className: Code04_
 * @description: 找到一个局部最小，即相邻三个数中最小 相邻两个数不等
 * @author: m1ria
 * @date: 2022/6/22 18:31
 * @version: 1.0
 */
public class Code04_BSAwesome {

    public static int oneMinIndex(int[] arr) {
        int N = arr.length;
        if (arr == null || N == 0) {
            return -1;
        }
        if (N == 1) {
            return 0;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[N - 1] < arr[N - 2]) {
            return N - 1;
        }
        int L = 0;
        int R = N - 1;
        while (L < R-1) {
            int mid = (L + R) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            }else{
                if (arr[mid] > arr[mid - 1]) {
                    R = mid - 1;
                } else {
                    L = mid + 1;
                }
            }
        }
        return arr[L] < arr[R] ? L : R;
    }

    public static int[] randomArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        if (len > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

    public static boolean check(int[] arr, int minIndex) {
        if (arr.length == 0) {
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean legtBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
        boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
        return legtBigger && rightBigger;
    }

    public static void printArry(int[] arr) {
        for (int num : arr) {
            System.out.print(num+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maxLen = 10;
        int maxValue = 100;
        int testTime = 1000;
        System.out.println("------test start------");
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(maxLen, maxValue);
            int ans = oneMinIndex(arr);
            if (!check(arr, ans)) {
                printArry(arr);
                System.out.println("ans = " + ans);
                break;
            }
        }
        System.out.println("------test end------");
    }
}
