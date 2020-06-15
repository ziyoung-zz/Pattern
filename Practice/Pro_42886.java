package test;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		Solution s = new Solution();
		//[3, 1, 6, 2, 7, 30, 1]	21
		int[] weight = {1,5};
		System.out.println(s.solution(weight));
		
	}	
}

//42886
class Solution {

    public int solution(int[] weight) {
        
        Arrays.sort(weight);
        int answer = weight[0];        
        if(weight[0] != 1) return 1;
        if(weight.length >1 && weight[1] != 2) return 2;
        
        for(int i=1 ; i<weight.length ; i++){
        	answer += weight[i];
        	
        	if(i<weight.length-1 && answer < weight[i+1]) break;
        }
        
        return answer+1;
    }
}