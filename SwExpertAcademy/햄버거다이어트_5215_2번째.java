/*
 * 햄버거다이어트_5215_2번째.java 2021. 02. 21
 *
 * Copyright 2021 WorksMobile Corp. All rights Reserved.
 * WorksMobile PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Scanner;

/**
 * @author younan.nam
 */
public class 햄버거다이어트_5215_2번째 {

    static int T, N, L, result;
    static int[] calory, favor;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        T = scanner.nextInt();

        for (int tc = 1; tc <= T; tc++) {

            N = scanner.nextInt();
            L = scanner.nextInt();

            calory = new int[N];
            favor = new int[N];

            for (int i = 0; i < N; i++) {
                favor[i] = scanner.nextInt();
                calory[i] = scanner.nextInt();
            }

            dfs(0, 0, 0);

            System.out.println("#" + tc + " " + result);
            result = 0;
        }
    }

    private static void dfs(int index, int curCalory, int curFavor) {

        if (curCalory > L) {
            return;
        }

        result = curFavor > result ? curFavor : result;

        for (int i = index; i < N; i++) {
            dfs(i + 1, curCalory + calory[i], curFavor + favor[i]);
        }
    }
}