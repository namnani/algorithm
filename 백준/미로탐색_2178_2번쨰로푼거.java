/*
 * 미로탐색_2178_2번쨰로푼거.java 2021. 03. 11
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
public class 미로탐색_2178_2번쨰로푼거 {

    static int N, M;
    static int[][] map;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = scanner.next();

            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();

        scanner.close();
    }

    private static void bfs() {
        //동서남북.
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        boolean[][] visited = new boolean[N][M];

        Queue<int[]> queue = new LinkedList<>();

        visited[0][0] = true;
        queue.offer(new int[]{0, 0, 1});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];

            if (x == N - 1 && y == M - 1) {
                System.out.println(count);
                break;
            }

            for (int i = 0; i < dx.length; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];

                if (xx < 0 || yy < 0 || xx >= N || yy >= M) {
                    continue;
                } else if (map[xx][yy] == 1 && visited[xx][yy] == false) {
                    visited[xx][yy] = true;
                    queue.offer(new int[]{xx, yy, count + 1});
                }
            }
        }
    }
}