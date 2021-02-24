/*
 * 맛있는음식_PERKET_1127_for문재귀풀이.java 2021. 02. 25
 *
 * Copyright 2021 WorksMobile Corp. All rights Reserved.
 * WorksMobile PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Scanner;

/**
 * @author younan.nam
 */
public class 맛있는음식_PERKET_1127_for문재귀풀이 {
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

        dfs(-1, 1, 0);

        System.out.println(result);

        scanner.close();
    }

    private static void dfs(int index, int totalS, int totalB) {

        if (index != -1) {
            int temp = Math.abs(totalS - totalB);
            if (result > temp) {
                result = temp;
            }
        }

        for (int i = index + 1; i < N; i++) {
            dfs(i, totalS * S[i], totalB + B[i]);
        }
    }
}