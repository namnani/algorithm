package stack1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

//최재형씨 코드
public class Solution5432_쇠막대기자르기 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5432.txt"));

		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int Answer = 0;
			Stack<Character> s = new Stack<>();
			char[] ca = sc.next().toCharArray();
			int sum = 0;
			for(int i = 0; i<ca.length; i++) {
				if(ca[i] == '(') {
					s.push(ca[i]); //stack[++top] = ca[i];
				} else {
					s.pop();//type value = stack[top--];
					if(ca[i] != ca[i-1]) {
						sum+=s.size();
					} else {
						sum++;
					}
				}	
			}
			Answer = sum;
			System.out.println("#" + test_case + " " + Answer);
		}
	}
}
