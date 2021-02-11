/*
 * 요세푸스_1158.java 2021. 02. 11
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
public class 요세푸스_1158 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        // setting.
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(Integer.valueOf(i));
        }

        // delete.
        int order = 0;
        StringBuilder stringBuilder = new StringBuilder("<");
        while (!queue.isEmpty()) {

            order++;

            if (order == K) {
                stringBuilder.append(queue.poll()).append(", ");
                order = 0;
            } else {
                queue.offer(queue.poll());
            }
        }

        stringBuilder.append(">");
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(" "));
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));

        System.out.println(stringBuilder.toString());

        scanner.close();
    }
}