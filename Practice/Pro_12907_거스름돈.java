package test;

import java.util.*;
//12907
class Solution {

	final int mod = 1000000007;
	public int solution(int n, int[] money) {
		int[] answer = new int[n+1];
		answer[0] = 1;
		
		for(int i: money){
			for(int j=0 ; j<=n ; j++){
				if(i+j <= n){
					answer[j+i] += answer[j] % mod;
				}
			}
		}

		return answer[n];
	}
}


public class test {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] money = {1,2,5};
		s.solution(5, money);
	}	
}