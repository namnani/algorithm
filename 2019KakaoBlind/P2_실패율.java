//2019. 08. 29. Thursday 13:20
//created by nani

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] notClearStage = new int[N+2];
        int[] totalTryUserPerStage = new int[N+2];
        double[][] failStage = new double[N+1][2];
        
        for(int i : stages){
            notClearStage[i]++;
        }
        
        totalTryUserPerStage[N+1] = notClearStage[N+1];
        for(int i = N; i>0; i--){
          totalTryUserPerStage[i] = totalTryUserPerStage[i+1] + notClearStage[i]; 
        }
        
       for (int i = 1; i <= N; i++) {
          failStage[i][0] = i;
          if(totalTryUserPerStage[i] == 0) {
            failStage[i][1] = 0;
	   } else
	      failStage[i][1] = (double) notClearStage[i] / totalTryUserPerStage[i];
	}
        
       Arrays.sort(failStage, new Comparator<double[]>() {
			@Override
			public int compare(double[] o1, double[] o2) {
				Double d1 = o1[1];
				Double d2 = o2[1];
				
				int temp = d1.compareTo(d2);
				
				if(temp  == 0) {
					return (int)(o2[0]-o1[0]);
				} else 
					return temp;
			}
		});
        
        int[] answer = new int[N];
        int i = 0;
	int j = 0;
	while(i!=N) {
		if(failStage[N-j][0] != 0) {
			answer[i] = (int) failStage[N - j][0];
			i++;
		}
		j++;
	}
        return answer;
    }
}
