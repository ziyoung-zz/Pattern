package test;

import java.util.*;

//12981
public class test {

	public static void main(String[] args) {
		
		Solution s = new Solution();
		
		int n = 2;
		//String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		//String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
		String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
				
		s.solution(n, words);
	}
	

}


class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int[] answerCnt = new int[n];
        HashMap<String, Integer> answerMap = new HashMap<>();        
        
        int pos = 0;
        char bfchar = '0';
        
        for(String word : words){
        	
        	if((bfchar !='0' && bfchar != word.charAt(0)) ||  answerMap.containsKey(word)){
        		answer[0] = pos + 1;
        		answer[1] = answerCnt[pos] + 1;
        		break;
        	}
        	
        	answerMap.put(word, 0);
        	answerCnt[pos] +=1;
        	pos+=1;
        	if(pos%n == 0) pos = 0;
        	bfchar = word.charAt(word.length()-1);
        }
        
        //System.out.println(answer[0] + " " + answer[1]);
        return answer;
    }
}