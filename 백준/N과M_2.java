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
public class N과M_2 {

    static int N, M;
    static int solve[];
    static boolean visited[];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        solve = new int[M];
        visited = new boolean[N];

        dfs(0, 0);
    }

    private static void dfs(int index, int count) {

        // 출력. & 백트래킹.
        if (count == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(solve[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = index; i < N; i++) {
            if(visited[i] == false) {
                solve[count] = i+1;
                visited[i] = true;
                dfs(i+1, count + 1);
                visited[i] = false;
            }
        }
    }
}