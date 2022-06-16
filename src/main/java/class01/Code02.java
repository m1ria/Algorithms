package class01;

public class Code02 {
    //阶乘
    public static long f2(int N) {
        long ans = 0;
        long cur = 1;
        for (int i = 1; i <= N; i++) {
            cur = cur * i;
            ans += cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        int a = 10;
        System.out.println(f2(a));
    }
}
