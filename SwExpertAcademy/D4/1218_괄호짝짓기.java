package stack1;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

//김한씨 코드
public class Solution1218_괄호짝짓기 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1218.txt"));

		Scanner sc = new Scanner(System.in);
		
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			Stack<Character> stack = new Stack<>();
			sc.next();
			int result = 1;
			String s = sc.next();
//			System.out.println(s);
			for(char c : s.toCharArray()) {
				if(c==')') {
					if(stack.pop()!='(') {
						result = 0;
						break;
					}
				}else if(c==']') {
					if(stack.pop()!='[') {
						result = 0;
						break;
					}
				}else if(c=='>') {
					if(stack.pop()!='<') {
						result = 0;
						break;
					}
				}else if(c=='}') {
					if(stack.pop()!='{') {
						result = 0;
						break;
					}
				} else stack.push(c);
			}
			
			//스택이 비어있나도 체크해야 완벽한 코드.
			if(!stack.isEmpty())
				result = 0;
			
			System.out.println("#" + test_case + " " + result);
		}
		sc.close();
	}
}
