package test;

import java.util.*;

//12938
class Solution {
	
	public int[] solution(int n, int s) {
		int[] answer = new int[n];
		
		int x = s/n;
		int y = s%n;
		
		if(x==0){
			int[] temp = {-1};
			return temp;
		}
		
		for(int i=0 ; i<n-y ; i++){
			answer[i] = x;
		}
		
		for(int i=n-y ; i<n ; i++){
			answer[i] = x+1;
		}
		
		Arrays.sort(answer);
		
		
		return answer;
	}

}


public class test {

	public static void main(String[] args) {	
		//2 9		
		Solution s = new Solution();
		s.solution(2, 9);
	}	
}