package algorithm.swea;

import java.util.Scanner;

public class 햄버거다이어트_5215 {
    public static int T, N, L, result;
    public static int[] point;
    public static int[] calory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        T = scanner.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            result = 0;
            N = scanner.nextInt();
            L = scanner.nextInt();

            point = new int[N];
            calory = new int[N];

            for (int i = 1; i <= N; i++) {
                point[i - 1] = scanner.nextInt();
                calory[i - 1] = scanner.nextInt();
            }

            // dfs.
            for (int i = 0; i < N; i++) {
                dfs(i, 0, 0);
            }

            System.out.println("#" + tc + " " + result);
        }
    }

    private static void dfs(int index, int nowPoint, int nowCalory) {
        nowPoint += point[index];
        nowCalory += calory[index];

        if (nowCalory > L) {
            return;
        }

        result = result < nowPoint ? nowPoint : result;

        for (int i = index + 1; i < N; i++) {
            dfs(i, nowPoint, nowCalory);
        }
    }
}
