```
public static void mergesort(int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			mergesort(left, mid);
			mergesort(mid+1, right);
			merge(left, mid, right);
			System.out.println(Arrays.toString(a));
		}
	}
	public static void merge(int left, int mid, int right) {
		int i = left;
		int j = mid+1;
		int k = left;
		//1
		while(i<=mid && j <= right) {
			if(a[i] <= a[j]) {
				s[k++]=a[i++];
			} else {
				s[k++] = a[j++];
			}
		}
		//2
		if(i>mid) {
			for(int l=j; l<=right; l++) s[k++] = a[l];
		}else {
			for(int l=i; l<=mid; l++) s[k++] = a[l];
		}
		//3 합병
		for(int l = left; l<=right; l++) a[l] = s[l];
	}
  ```
