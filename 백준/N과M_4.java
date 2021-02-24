/*
 * N과M_4.java 2021. 02. 25
 *
 * Copyright 2021 WorksMobile Corp. All rights Reserved.
 * WorksMobile PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Scanner;

/**
 * @author younan.nam
 */
public class N과M_4 {

    static int N, M;
    static int[] d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        d = new int[M];

        dfs(0, 0);

        scanner.close();
    }

    private static void dfs(int i, int count) {
        if (count == M) {
            for (int ii = 0; ii < M; ii++)
                System.out.print(d[ii] + " ");
            System.out.println();
            return;
        }

        for (int ii = i; ii < N; ii++) {
            d[count] = ii+1;
            dfs(ii, count + 1);
        }
    }
}
