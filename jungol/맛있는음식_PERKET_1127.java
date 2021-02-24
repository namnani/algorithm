/*
 * 맛있는음식_PERKET_1127.java 2021. 02. 23
 *
 * Copyright 2021 WorksMobile Corp. All rights Reserved.
 * WorksMobile PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Scanner;

/**
 * @author younan.nam
 */
public class 맛있는음식_PERKET_1127 {
    static int N, result = Integer.MAX_VALUE;
    static int[] S, B;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        S = new int[N];
        B = new int[N];

        for (int i = 0; i < N; i++) {
            S[i] = scanner.nextInt();
            B[i] = scanner.nextInt();
        }

        dfs(0, 1, 0, 0);

        System.out.println(result);

        scanner.close();
    }

    private static void dfs(int index, int totalS, int totalB, int count) {

        if (index == N) {
            if (count == 0)
                return;
            int temp = Math.abs(totalS - totalB);
            result = result > temp ? temp : result;
            return;
        }

        dfs(index + 1, totalS * S[index], totalB + B[index], count + 1);
        dfs(index + 1, totalS, totalB, count);
    }
}