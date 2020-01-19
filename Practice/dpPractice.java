public class Main {

	long result[];
	
    public long solution(int N) {
        long answer = 0;
        result = new long[N+1];
        
        for(int i=1 ; i < N+1 ; i++) {
        	dp(i);
        }
        
        answer = (result[N]*2 + result[N-1])*2;
        
        return answer;
    }
    
    private void dp(int N) {
		
		if(N == 1 || N == 2) { 
			result[N] = 1;
		}else {
			result[N] = result[N-1] + result[N -2];
		}
	}
	
}
