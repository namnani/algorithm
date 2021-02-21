/*
 * N과M_3.java 2021. 02. 20
 *
 * Copyright 2021 WorksMobile Corp. All rights Reserved.
 * WorksMobile PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @author younan.nam
 */
public class N과M_3 {
    public static int N, M;
    public static int[] num;
    public static BufferedWriter bufferedWriter;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = sc.nextInt();
        M = sc.nextInt();

        num = new int[M];

        dfs(0);

        sc.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static void dfs(int count) throws IOException {
        if (count == M) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < num.length; i++) {
                stringBuilder.append(num[i] + " ");
            }

            bufferedWriter.write(stringBuilder.toString() + "\n");

            return;
        }
        for (int i = 0; i < N; i++) {
            num[count] = i + 1;
            dfs(count + 1);
        }
    }
}