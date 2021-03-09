/*
 * 톱니바퀴_14891.java 2021. 03. 08
 *
 * Copyright 2021 WorksMobile Corp. All rights Reserved.
 * WorksMobile PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author younan.nam
 */
public class 톱니바퀴_14891 {
    static int[][] wheel = new int[4][8];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            String s = scanner.next();
            for (int j = 0; j < 8; j++) {
                // N극 0, S극 1
                wheel[i][j] = s.charAt(j)-'0';
            }
        }

        int K = scanner.nextInt();

        for (int i = 0; i < K; i++) {
            int num = scanner.nextInt();
            int direction = scanner.nextInt();

            moveWheel(num - 1, direction);
        }

        int result = 0;
        result += wheel[0][0] == 0 ? 0 : 1;
        result += wheel[1][0] == 0 ? 0 : 2;
        result += wheel[2][0] == 0 ? 0 : 4;
        result += wheel[3][0] == 0 ? 0 : 8;

        System.out.println(result);

        scanner.close();
    }

    private static void moveWheel(int num, int direction) {
        moveLeftWheel(num - 1, direction);
        moveRightWheel(num + 1, direction);

        // direction으로 움직인다.
        move(num, direction);
    }

    private static void move(int num, int direction) {
        int[] copyWheel = new int[8];
        for(int i = 0; i < copyWheel.length; i++) {
            copyWheel[i] = wheel[num][i];
        }

        if(direction == 1) {
            wheel[num][0] = copyWheel[7];
            wheel[num][1] = copyWheel[0];
            wheel[num][2] = copyWheel[1];
            wheel[num][3] = copyWheel[2];
            wheel[num][4] = copyWheel[3];
            wheel[num][5] = copyWheel[4];
            wheel[num][6] = copyWheel[5];
            wheel[num][7] = copyWheel[6];
        } else {
            wheel[num][7] = copyWheel[0];
            wheel[num][6] = copyWheel[7];
            wheel[num][5] = copyWheel[6];
            wheel[num][4] = copyWheel[5];
            wheel[num][3] = copyWheel[4];
            wheel[num][2] = copyWheel[3];
            wheel[num][1] = copyWheel[2];
            wheel[num][0] = copyWheel[1];
        }
    }

    private static void moveRightWheel(int index, int direction) {
        if (index >= 4)
            return;

        if (wheel[index][6] != wheel[index-1][2]) {
            moveRightWheel(index+1, direction*-1);
            move(index, direction*-1);
        }
    }

    private static void moveLeftWheel(int index, int direction) {
        if (index < 0)
            return;

        if (wheel[index][2] != wheel[index+1][6]) {
            moveLeftWheel(index-1, direction*-1);
            move(index, direction*-1);
        }
    }
}