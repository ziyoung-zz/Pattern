package test;

public class test2 {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] triangle = {{7}, 
							{3, 8}, 
							{8, 1, 0}, 
						   {2, 7, 4, 4}, 
							{4, 5, 2, 6, 5}};
		
		System.out.println(s.solution(triangle));
	}
}

//43105
class Solution {
    public int solution(int[][] triangle) {
    	
        int answer = 0;
        int tHight = triangle.length;
        int tWidth = triangle[tHight-1].length;
        int[][] an = new int[tHight][tWidth];
        
        an[0][0] = triangle[0][0];
        
        for(int i=1 ; i<tHight ; i++){
        	
        	int width = triangle[i].length;        	
        	an[i][0] = an[i-1][0]+triangle[i][0];
        	an[i][width-1] = an[i-1][width-1]+triangle[i][width-1];
        	
        	for(int j=1 ; j<width ; j++){
        		an[i][j] = Math.max(an[i-1][j], an[i-1][j-1]) + triangle[i][j];
        	}
        }
        
        for(int i=0 ; i<tWidth ; i++){
        	if(answer < an[tHight-1][i]) answer = an[tHight-1][i]; 
        }
        
        return answer;
    }
}