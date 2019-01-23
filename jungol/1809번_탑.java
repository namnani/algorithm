//2019.01.24.Thursday
//정올 1809번 탑
//백준 2493번 
//created by nani

//하나의 스택으로 2개의 값 저장하는 방법은없을지에 대한 의문.

package stack2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		//탑 높이 저장 스택
		int[] stack = null;
		int top = -1;
		
		//탑 인덱스용 스택(탑의 인덱스는 1부터 시작하는 것으로함)
		int[] stack2 = null;
		int top2 = -1;
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		stack = new int[T];
		stack2 = new int[T];
		
		String[] sa = br.readLine().split(" ");
		
		for(int i = 0; i<T; i++){

			int temp = Integer.parseInt(sa[i]);
			
			//최종적으로 나보다 큰 탑을 못만났네!
			if(top == -1){
				sb.append("0 ");
				stack[++top] = temp;
				stack2[++top2] = i+1;
				continue;
			}
			
			//나보다 큰 탑을 만났네!
			if(stack[top] > temp){
				sb.append(stack2[top2]);
				sb.append(" ");
				stack[++top] = temp;
				stack2[++top2] = i+1;
			} 
			// 나보다 작은높이의탑을 만났네?? 버리고 내가 바디체크해야지!
			else{ 
				top--; //pop해서버리기.
				top2--; //pop해서 버리기.
				i--;
			}	
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
}
