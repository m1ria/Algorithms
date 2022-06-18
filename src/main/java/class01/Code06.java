package class01;

import java.util.Arrays;

/**
 * @className: Code06
 * @description: 前缀和
 * @author: m1ria
 * @date: 2022/6/19 3:44
 * @version: 1.0
 */
public class Code06 {

    public static class RangeSum2{

        private int[] preSum;

        public RangeSum2(int[] array) {
            int N = array.length;
            preSum = new int[N];
            preSum[0] = array[0];
            for (int i = 1; i < N; i++) {
                preSum[i] = preSum[i - 1] + array[i];
            }
            System.out.println(Arrays.toString(preSum));
        }

        public int rangeSum(int L, int R) {
            return L == 0 ? preSum[R] : preSum[R] - preSum[L - 1];
        }
    }

    public static void main(String[] args) {
        int[] arr = {24, 21, 44, 27, 45, 86, 34};
        System.out.println(Arrays.toString(arr));
        RangeSum2 r = new RangeSum2(arr);
        System.out.println(r.rangeSum(2, 3));
    }
}
