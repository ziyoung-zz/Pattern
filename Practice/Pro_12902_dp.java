package test;

import java.util.*;


public class test {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(4990));
	}	
}
//12902
class Solution {

	public int solution(int n) {
			
		if(n%2 == 1) return 0;
		int mod = 1000000007;
		long[] dp = new long[n/2];
		
		dp[0] = 3;
		long sum = 2;		
		
		for(int i=1; i<n/2 ; i++){
			dp[i] = dp[i-1]*3 + sum;
			sum += dp[i-1]*2;
			dp[i] = dp[i]%mod;
		}
		
		
		return (int)dp[n/2-1];
	}
		
}