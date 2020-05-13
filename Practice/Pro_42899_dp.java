package alis.uwissu.psnluw.rissrnwl.online.pc;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		int K = 1650;
		int[][] travel = {{500, 200, 200, 100}, {800, 370, 300, 120}, {700, 250, 300, 90}};
		
		System.out.println(solution(K,travel));
	}

	static int[][] dp;
	
	// 프로그래머스 42899
	public static int solution(int K, int[][] travel) {
		  
		dp = new int[travel.length+1][K+1];
		
		return dp(travel, 0, 0, K);
	}	

	private static int dp(int[][] travel, int n, int tTime, int K){
		  
		if(n > travel.length -1) return 0;
		if(dp[n][tTime] != 0) return dp[n][tTime];
		
		int wTime = travel[n][0];
		int wVal = travel[n][1];
		int bTime = travel[n][2];
		int bVal = travel[n][3];
		
		int w = 0;
		int b = 0;
		
		if(K >= tTime + wTime)  w = wVal + dp(travel, n+1, tTime+wTime, K);
		if(K >= tTime + bTime)  b = bVal + dp(travel, n+1, tTime+bTime, K);
		  
		if(w>b) return dp[n][tTime] = w;
		else return  dp[n][tTime] = b;
	}
}
