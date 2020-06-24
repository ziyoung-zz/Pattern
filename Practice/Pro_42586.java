package test;

import java.util.*;
//42586
class Solution {
	 public int[] solution(int[] progresses, int[] speeds) {	        
	        
	        ArrayList<Integer> alist = new ArrayList<>();
	        
	        boolean flag = true;
	        int srt = 0;
	        int end = progresses.length;
	        
	        while(srt != end){
	        	
	        	int i = srt;
	        	int cnt = 0;	       	        	
	        	while(i!=end){
	        		progresses[i] += speeds[i];	        		
	        		if(progresses[i] >100 && i==srt){
	        			cnt++;
	        			srt++;
	        		}
	        		i++;
	        	}
	        	
	        	if(cnt != 0) alist.add(cnt);	        		        	
	        }
	        
	        
	        int[] answer = new int[alist.size()];
	        for(int i=0 ; i <alist.size() ; i++){
	        	answer[i] = alist.get(i);
	        	System.out.print(answer[i] + " ");
	        }
	        
	        
	        return answer;
	    }
}


public class test {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		s.solution(progresses, speeds);
	}	
}