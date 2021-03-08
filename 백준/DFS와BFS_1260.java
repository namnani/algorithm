/*
 * DFS와BFS_1260.java 2021. 03. 07
 *
 * Copyright 2021 WorksMobile Corp. All rights Reserved.
 * WorksMobile PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author younan.nam
 */
public class DFS와BFS_1260 {
    static int N, M, V;
    static int[][] m;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        V = scanner.nextInt();

        m = new int[N + 1][N + 1];

        // 간선 입력 받기.
        for (int i = 0; i < M; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            m[x][y] = 1;
            m[y][x] = 1;
        }

        visited = new boolean[N + 1];
        dfs(V);

        System.out.println();

        visited = new boolean[N + 1];
        bfs();

        scanner.close();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.offer(V);
        visited[V] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            System.out.print(node + " ");
            for(int i = 1; i<=N; i++) {
                if(m[node][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int i = 1; i <= N; i++) {
            if (m[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}