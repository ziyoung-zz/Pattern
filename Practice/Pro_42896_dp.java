public class Test {

	//42896
	public static void main(String[] args){
		
		int[] left = {3,2,5};
		int[] right = {2,4,1};
		System.out.println(solution(left,right));
	}

	public static int solution(int[] left, int[] right) {        
        
		int[][] dparr = new int[left.length][right.length];
		for(int i=0 ; i<left.length ; i++){
			for(int j=0 ; j<right.length ; j++){
				dparr[i][j] = -1;
			}
		}
				
        return dp(0,0,left,right, dparr);
    }

	
	private static int dp(int l, int r, int[] left, int[] right, int[][] dparr){
		
		if(l == left.length || r == right.length) return 0;
		if(dparr[l][r] != -1) return dparr[l][r];
		
		int cnt = 0;
		if(left[l] > right[r]){
			
			cnt = right[r] + dp(l,r+1,left,right,dparr);			
			
		}else{
			cnt =  Math.max(dp(l+1,r,left,right,dparr),dp(l+1,r+1,left,right,dparr));
		}	
		
		dparr[l][r] = cnt;
		
		return cnt;
	}

//시간초과	
//	private static int dp(int l, int r, int[] left, int[] right){
//		
//		if(l == left.length || r == right.length) return 0;
//		
//		if(left[l] > right[r]){
//			return right[r] + dp(l,r+1,left,right);
//		}else{
//			return Math.max(dp(l+1,r,left,right),dp(l+1,r+1,left,right));
//		}		
//		
//	}
	
	
}
