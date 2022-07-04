package class05;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @className: Code01_BitMap
 * @description: 位图
 * @author: m1ria
 * @date: 2022/7/4 22:01
 * @version: 1.0
 */
public class Code01_BitMap {

    public static class BitMap {
        private long[] bits;

        public BitMap(int max) {
            bits = new long[(max + 64) >> 6];
        }

        public void add(int num) {
            bits[num >> 6] |= (1L << (num & 63));
        }
        public void delete(int num) {
            bits[num >> 6] &= ~(1L << (num & 63));
        }
        public boolean contains(int num) {
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("test start------------");
        int max = 10000;
        BitMap bitMap = new BitMap(max);
        HashSet<Integer> set = new HashSet<>();
        int testTime = 10000;
        for (int i = 0; i < testTime; i++) {
            int num = (int) (Math.random() * (max + 1));
            double decide = Math.random();
            if (decide < 0.33) {
                bitMap.add(num);
                set.add(num);
            } else if (decide < 0.66) {
                bitMap.delete(num);
                set.remove(num);
            } else {
                if (bitMap.contains(num) != set.contains(num)) {
                    System.out.println("ERROR-----------");
                    break;
                }
            }
        }
        System.out.println(set.toString());
        for (int num = 0; num <= max; num++) {
            if (bitMap.contains(num) != set.contains(num)) {
                System.out.println("ERROR-----------");
            }
        }
        System.out.println("test end--------------");
    }

}
