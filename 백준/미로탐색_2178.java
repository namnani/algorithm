package 백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색_2178 {

    public static int N, M;
    public static int result = Integer.MAX_VALUE;
    public static int[][] map;
    // 상하좌우.
    public static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static Queue<int[]> q = new LinkedList<>();

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

        int[][] v = new int[N][M];
        v[0][0] = 1;
        q.offer(new int[]{0, 0, 1});
        bfs(v);

        System.out.println(result);

        // 입력받은 map 확인.
//        for (int[] temp : map) {
//            for (int i : temp) {
//                System.out.print(i);
//            }
//            System.out.println();
//        }
    }

    private static void bfs(int[][] v) {
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int x = node[0];
            int y = node[1];
            int count = node[2];

            // 종료조건.
            if (x == N - 1 && y == M - 1) {
              result = count;
              return;
            }

            for (int i = 0; i < dir.length; i++) {
                int xx = x + dir[i][0];
                int yy = y + dir[i][1];

                // 맵을 벗어났으면.
                if (xx < 0 || yy < 0 || xx >= N || yy >= M) {
                    continue;
                }

                if (v[xx][yy] == 0 && map[xx][yy] == 1) {
                    v[xx][yy] = 1;
                    q.offer(new int[]{xx, yy, count + 1});
                }
            }
        }
    }
}
