import java.util.Scanner;
import java.util.jar.JarEntry;

public class 주사위굴리기_14499 {

    public static int N, M, x, y, K;
    public static int[][] map;
    public static int[] command;
    public static int[][] dir = {{}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public static int[] dice = {0, 0, 0, 0, 0, 0, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        x = scanner.nextInt();
        y = scanner.nextInt();
        K = scanner.nextInt();

        map = new int[N][M];
        command = new int[K];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < K; i++) {
            command[i] = scanner.nextInt();
        }

        for (int i = 0; i < K; i++) {
            int temp = command[i];
            int tempX = x + dir[temp][0];
            int tempY = y + dir[temp][1];

            if (tempX < 0 || tempY < 0 || tempX >= N || tempY >= M) {
                continue;
            }

            x = tempX;
            y = tempY;

            // 주사위 이동.
            moveDice(temp);

            if (map[x][y] == 0) {
                // 주사위의 바닥면에 쓰여 있는 수를 맵에 복사.
                map[x][y] = dice[6];
            } else {
                // 칸에 쓰여 있는 수를 주사위의 바닥면으로 복사.
                dice[6] = map[x][y];
                map[x][y] = 0;
            }

            System.out.println(dice[1]);
        }

        scanner.close();
    }

    private static void moveDice(int temp) {
        int[] tempDice = dice.clone();

        // 동
        if (temp == 1) {
            dice[1] = tempDice[4];
            dice[3] = tempDice[1];
            dice[6] = tempDice[3];
            dice[4] = tempDice[6];
        } else if (temp == 2) { // 서
            dice[1] = tempDice[3];
            dice[3] = tempDice[6];
            dice[6] = tempDice[4];
            dice[4] = tempDice[1];
        } else if (temp == 3) { // 북
            dice[1] = tempDice[5];
            dice[5] = tempDice[6];
            dice[6] = tempDice[2];
            dice[2] = tempDice[1];
        } else if (temp == 4) { // 남
            dice[1] = tempDice[2];
            dice[5] = tempDice[1];
            dice[6] = tempDice[5];
            dice[2] = tempDice[6];
        }
    }
}
