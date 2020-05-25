package test;

import java.util.*;


public class test {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(8,12));
	}	
}
//62048
class Solution {


	public long solution(int w, int h) {
        long answer = 1;        
        long lw = Long.parseLong(String.valueOf(w));
        long lh = Long.parseLong(String.valueOf(h));        
        long min = 0; //최대공약수
        for(long i=1 ; i<=lw && i<= lh ; i++){
        	if(lw%i==0 && lh%i==0){
        		min=i;         		
        	} 
        }
        
        long cnt = lw + lh - min;
        
        answer = lw*lh - cnt;
        
        return answer;
    }
		
}