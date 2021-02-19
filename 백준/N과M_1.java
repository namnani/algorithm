/*
 * N과M_1.java 2021. 02. 19
 *
 * Copyright 2021 WorksMobile Corp. All rights Reserved.
 * WorksMobile PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Scanner;

/**
 * @author younan.nam
 */
public class N과M_1 {

    static int N, M;
    static int solve[];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        solve = new int[M];

        dfs(0, 0);
    }

    private static void dfs(int index, int count) {

        // 출력. & 백트래킹.
        if (count == M) {
            for (int i = 0; i < M - 1; i++) {
                for (int j = i + 1; j < M; j++) {
                    if (solve[i] == solve[j])
                        return;
                }
            }
            for (int i = 0; i < M; i++) {
                System.out.print(solve[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            solve[count] = i;
            dfs(i, count + 1);
        }
    }
}