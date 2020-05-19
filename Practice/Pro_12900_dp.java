package test;

import java.util.*;


public class test {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(4));
	}	
}

//12900
class Solution {

	public int solution(int n) {

		int d = 1000000007;
		int[] dp = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3 ; i<n+1 ; i++){
			dp[i] = (dp[i-1] + dp[i-2]) %d ;
		}
		
		
		return dp[n];
	}

}