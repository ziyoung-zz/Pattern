package alis.uwissu.psnluw.rissrnwl.online.pc;

public class test {

	/*
	 * 프로그래머스 42898번문제
	 * 효율성은 못지킴..
	 */
	
	public static void main(String[] args) {
		int[][] puddles = {{2,2},{3,3},{3,2},{2,3}};
		System.out.println(solution(4,4,puddles));
	}

	static int [][] map ; 
	static int PUD = -100;
	
	public static int solution(int m, int n, int[][] puddles){
		
		map = new int[m][n];				
				
		for(int i = 0 ; i < puddles.length ; i++){
			map[puddles[i][0] -1 ][puddles[i][1] -1 ] = PUD; 
		}
		
		boolean flag = false;
		for(int i=0 ; i < map.length ; i++){
			if(map[i][0] == PUD){
				flag = true;
			}
			
			if(flag) map[i][0] = PUD;
		}
		
		flag = false;
		for(int i=0 ; i < map[0].length ; i++){
			if(map[0][i] == PUD){
				flag = true;
			}
			
			if(flag) map[0][i] = PUD;
		}
		
		long answer = dp(m-1,n-1);
		return (int)answer % 1000000007;
	}
	
	public static long dp(int m, int n){
		
		long answer;
		
		if(m == 0 && n == 0 || map[m][n] == PUD){
			answer = 0;
		}else if(m == 0 || n == 0){
			answer =  1;			
		}else{
			answer = dp(m,n-1) + dp(m-1,n);
		}
		
		return answer;
	}
}
