```
package stack2;

import java.util.Arrays;

public class QuickSort {
	//저 중요한 한줄을 빼내면, 중복된값을 집어넣거나, 밑의걸로하면 중복이 제대로 안된다.
//	public static int[] a = {69,19,40,2,16,8,31,22};
	public static int[] a = {69,10,30,2,16,8,31,22};
	
	public static int partition(int begin, int end) {
		int p = (begin+end)/2;
		int L = begin;
		int R = end;
		while(L<R) {
			while(a[L] < a[p] && L < R) L++;
			while(a[R]>=a[p] && L<R) R--;
			System.out.println(Arrays.toString(a) + "	1 p="+p+" a["+p+"]="+a[p]+" begin="+begin+" end="+end);
			if(L<R) {
				if(L==p) p = R; //이 한줄이 아주 중요한 역할을 한다고하네! 피봇과 L이 만나면, L이 더이상 움직이지 않는 문제가 생기기 때문에, 오른쪽 값을 피봇에 넣어야지만, L이 정렬된다!
				//왜냐하면 항상 우리는 이 코드에서는 Left를 먼저이동시켜서 정렬의 위치를 잡을 것이기 때문에.
				int T = a[R]; a[R] = a[L]; a[L] = T;
				System.out.println(Arrays.toString(a) + "	2 p="+p+" a["+p+"]="+a[p]+" begin="+begin+" end="+end);
			}
		}
		int T = a[R]; a[R] = a[p]; a[p] = T;
		System.out.println(Arrays.toString(a) + "	3 p="+p+" a["+p+"]="+a[p]+" begin="+begin+" end="+end);
		return R;
	}
	
	public static void quick(int begin, int end) {
		if(begin < end) {
			int p = partition(begin,end);
			System.out.println(Arrays.toString(a) + "	  p="+p+" a["+p+"]="+a[p]+" begin="+begin+" end="+end);
			quick(begin, p-1);
			quick(p+1, end);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(a));
		quick(0, a.length-1);
		System.out.println(Arrays.toString(a));
	}
}
```
