/*
 * 스택_10828.java 2021. 03. 07
 *
 * Copyright 2021 WorksMobile Corp. All rights Reserved.
 * WorksMobile PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Scanner;

/**
 * @author younan.nam
 */
public class 스택_10828 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] stack = new int[N];
        int size = 0;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String command = scanner.next();

            switch (command) {
                case "push": {
                    int value = scanner.nextInt();
                    stack[size++] = value;
                    break;
                }
                case "pop": {
                    if (size == 0) {
                        stringBuilder.append(-1 + "\n");
                    } else {
                        int value = stack[--size];
                        stringBuilder.append(value + "\n");
                    }
                    break;
                }
                case "size":
                    stringBuilder.append(size + "\n");
                    break;
                case "empty":
                    if (size == 0)
                        stringBuilder.append(1 + "\n");
                    else
                        stringBuilder.append(0 + "\n");
                    break;
                case "top":
                    if (size == 0)
                        stringBuilder.append(-1 + "\n");
                    else
                        stringBuilder.append(stack[size - 1] + "\n");
                    break;
            }
        }

        System.out.println(stringBuilder.toString());

        scanner.close();
    }
}