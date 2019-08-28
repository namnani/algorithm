//2019. 08. 29. Thursday 02:09
import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String[]> messageList = new ArrayList<String[]>();
        Map<String, String> map = new HashMap<String, String>();
        
        for(int i = 0; i<record.length; i++){
            String[] temp = record[i].split(" ");
            switch(temp[0]){
                case "Enter":{
                    map.put(temp[1], temp[2]);
                    messageList.add(new String[]{temp[1],"님이 들어왔습니다."});
                    break;
                }
                case "Leave":{
                    messageList.add(new String[]{temp[1], "님이 나갔습니다."});
                    break;
                }
                case "Change":{
                    map.put(temp[1], temp[2]);
                    break;
                }
            }
        }
        
        String[] answer = new String[messageList.size()];
        for(int i = 0; i<messageList.size(); i++){
            String[] temp = messageList.get(i);
            answer[i] = map.get(temp[0])+temp[1];
        }
        return answer;
    }
}
