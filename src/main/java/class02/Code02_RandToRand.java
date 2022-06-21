package class02;

/**
 * @className: RandToRand
 * @description: 随机函数
 *                 从1-5随机到1-7随机
 *                 从a-b随机到 c-d随机
 *                 01不等概率随机到01等概率随机
 * @author: m1ria
 * @date: 2022/6/20 4:23
 * @version: 1.0
 */
public class Code02_RandToRand {
    public static void main(String[] args) {
        int time = 10000000;
        int count = 0;
        for (int i = 0; i < time; i++) {
            if (Math.random() < 0.77) {
                count++;
            }
        }
        System.out.println("求0-x的概率： "+(double) count / (double) time);
        int count1 = 0;
        for (int i = 0; i < time; i++) {
            if (Math.random() * 8 < 4) {
                count1++;
            }
        }
        System.out.println("求0-x一半的概率： "+(double) count1 / (double) time);

        int k = 9;
        int[] counts = new int[9];
        for (int i = 0; i < time; i++) {
            int a = (int) (Math.random() * k);
            counts[a]++;
        }
        for (int i = 0; i < k; i++) {
            System.out.println("求0-x等概率： "+i + "---" + counts[i] + "次，占 " + (double) counts[i] / time);
        }

        int j = 0;
        for (int i = 0; i < time; i++) {
            if (xToxMax() < 0.77) {
                j++;
            }
        }
        System.out.println("求x的平方的概率： "+(double) j / (double) time);
        System.out.println(Math.pow(0.77,2));
        int h = 0;
        for (int i = 0; i < time; i++) {
            if (xToxMin() < 0.77) {
                h++;
            }
        }
        System.out.println("求min： "+(double) h / (double) time);
        System.out.println(1-Math.pow(1-0.77,2));

        int count2 = 0;
        for (int i = 0; i < time; i++) {
            if (f2() == 1) {
                count2++;
            }
        }
        System.out.println("等概率01发生器： "+(double) count2 / (double) time);
        int[] counts1 = new int[8];
        for (int i = 0; i < time; i++) {
            int a = f4();
            counts1[a]++;
        }
        for (int i = 0; i < 8; i++) {
            System.out.println("求0-7等概率： "+i + "---" + counts1[i] + "次，占 " + (double) counts1[i] / time);
        }
        int[] counts2 = new int[8];
        for (int i = 0; i < time; i++) {
            int a = g();
            counts2[a]++;
        }
        for (int i = 0; i < 8; i++) {
            System.out.println("求0-7等概率： "+i + "---" + counts2[i] + "次，占 " + (double) counts2[i] / time);
        }
    }

    //满足两次随机的最大值在0-x的范围内，必须满足每次随机的值在0-x内，即x概率的平方
    public static double xToxMax() {
        return Math.max(Math.random(),Math.random());
    }
    //满足两次随机的最小值在0-x的范围内，即两次随机的概率不在0-x，即1-x。最小值在0-x上，即1-（1-x）^2
    public static double xToxMin() {
        return Math.min(Math.random(),Math.random());
    }
    //返回1-5的等概率随机
    public static int f1() {
        return (int)(Math.random() * 5 + 1);
    }
    //借用f1得到1-7的等概率随机
    public static int f2() {
        int a = 0;
        do {
            a = f1();
        } while (a == 3);
        return a < 3 ? 0 : 1;
    }
    //通过二进制得到0-6的等概率
    public static int f3() {
        return (f2() << 2) + (f2() << 1) + (f2() << 0);
    }
    //得到0-6的等概率
    public static int f4() {
        int a = 0;
        do {
            a = f3();
        } while (a == 7);
        return a;
    }
    //得到1-7的等概率
    public static int g() {
        return f4() + 1;
    }
    // x以固定的不等概率返回0和1
    public static int x() {
        return Math.random() < 0.53 ? 0 : 1;
    }
    // y随机一次x，当结果与第二次随机相同，重新随机
    public static int y() {
        int a = 0;
        do {
            a = x();
        } while (a == x());
        return a;
    }
}
