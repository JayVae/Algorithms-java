/**
 * @Author: Jay
 * @Date: Created in 19:45 2018/8/11
 * @Modified By:
 */

import java.util.Scanner;

public class A {
    int n, k;
    int a[] = new int[1000005];
    int b[] = new int[100005];
    int dp[] = new int[100005];
    int dp1[] = new int[100005];
    Scanner scanner;

    public void solve() {
        scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = a[i] + dp[i + 1];
            dp1[i] = dp1[i + 1];
            if (b[i] == 1) {
                dp1[i] += a[i];
            }
        }
        int sum = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (b[i] == 1) {
                sum += a[i];
            } else {
                int j = Math.min(i + k - 1, n);
                ans = Math.max(ans, sum + dp[i] - dp[j + 1] + dp1[j + 1]);
            }
        }
        ans = Math.max(ans, sum);
        System.out.println(ans);
    }

    public static void main(String[] args) {
//        new A().solve();
//        new A().test("1");
        // 第一个字符串常量，存储在方法区的字符串常量池中。
        String str1 = "world";

        // 使用 new 关键字创建的字符串对象，存储在堆内存中。
        String str2 = new String("world");

        // 调用 intern() 方法创建字符串常量，存储在运行时常量池中。
        String str3 = str2.intern();

        String str4 = new String("world");
        String str5 = "world";

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println("str1 address: " + System.identityHashCode(str1));
        System.out.println("str2 address: " + System.identityHashCode(str2));
        System.out.println("str3 address: " + System.identityHashCode(str3));
        System.out.println("str3 address: " + System.identityHashCode(str4));
        System.out.println("str3 address: " + System.identityHashCode(str5));
    }

    private void test(String number) {
        test2(1);
        try{
            int ans = 0;
            ans = 10/0;
        }catch (ArithmeticException e){
            throw new ArithmeticException();
        }finally {
            System.out.println(number);
        }
    }

    private void test2(int i) throws ArithmeticException{
            int ans = 0;
            ans = 10/0;
            System.out.println("end");
            System.out.println("test2");
    }
}