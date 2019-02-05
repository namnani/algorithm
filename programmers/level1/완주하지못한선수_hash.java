import java.util.*;

class Solution{
    public String solution(String[] participant, String[] completion){
        String answer = "";
        int val = 0;
        
        Map <String, Integer> hm = new HashMap<>();
        
        for(String part : participant){
            if(hm.get(part) == null){
                hm.put(part, 1);
            }
            else{
                val = hm.get(part) + 1;
                hm.put(part, val);
            }
        }
        
        for(String comp : completion){
            val = hm.get(comp) - 1;
            hm.put(comp, val);
        }
        
        for(String key : hm.keySet()){
            if(hm.get(key) == 1){
                answer = key;
                break;
            } 
        }
        return answer;
    }
}

/*
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        loop:for(int i = 0; i<participant.length; i++){
            for(int j = 0; j<completion.length; j++){
                if(participant[i].equals(completion[j])){
                    completion[j] = "";
                    continue loop;
                }
            }
            answer += participant[i];
        }
        return answer;
    }
}
*/
