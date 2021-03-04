/*
 * Flatten_1208.java 2021. 03. 04
 *
 * Copyright 2021 WorksMobile Corp. All rights Reserved.
 * WorksMobile PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package d3;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author younan.nam
 */
public class Flatten_1208 {
    public static void main(String args[]) throws Exception {

        System.setIn(new FileInputStream("swexpertacademy_resource/1208/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {

            int[] width = new int[100];

            int count = sc.nextInt();

            for(int i = 0; i < 100; i++){
                width[i] = sc.nextInt();
            }

            for (int i = 0; i < count; i++) {
                Arrays.sort(width);
                if (width[99] == width[0]) {
                    break;
                }
                width[99]--;
                width[0]++;
            }

            Arrays.sort(width);
            System.out.println("#" + test_case + " " + (width[99] - width[0]));
        }

        sc.close();
    }
}