
public class Test {

	//42897
	public static void main(String[] args){
		
		int[] money = {1,2,3,3,2};
		System.out.println(solution(money));
	}

	 public static int solution(int[] money) {
	
	        int[] dp = new int[money.length-1];
	        int[] dp2 = new int[money.length];
	        
	        dp[0] = money[0];
	        dp[1] = money[0];
	        
	        for(int i=2 ; i<dp.length ; i++){
	        	dp[i] = Math.max(dp[i-2]+money[i], dp[i-1]);
	        }
	        
	        dp2[0] = 0;
	        dp2[1] = money[1];
	        for(int i=2 ; i<dp.length ; i++){
	        	dp2[i] = Math.max(dp2[i-2]+money[i], dp2[i-1]);	        	
	        }
	        
	        return Math.max(dp[dp.length -1], dp2[dp2.length -1]);
	 }    
}
