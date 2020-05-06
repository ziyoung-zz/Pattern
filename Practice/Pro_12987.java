import java.util.Arrays;

public class Test {

	//12987
	public static void main(String[] args) {

		//[5,1,3,7]	[2,2,6,8]	3
		//[2,2,2,2]	[1,1,1,1]	0
		int[] a = {2,2,2,2};
		int[] b = {1,1,1,1};
		System.out.println(solution(a,b));
	}
	
	public static int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);

        int j=B.length-1;
        for(int i= A.length-1 ; i>-1 ; i--){
        	if(B[j] > A[i]){
        		answer++;
        		j-=1;
        	}
        	
        	if(j<0) break;
        }
        
        return answer;
    }

}
