package test;

import java.util.*;

public class test {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {3,3,3,2,2,2};
		System.out.println(s.solution(nums));
		
	}	
}

//1845
class Solution {
    public int solution(int[] nums) {
    	
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int poketmon : nums){
        	if(!map.containsKey(poketmon)){
        		map.put(poketmon, 0);
        	}
        }
        
        int mapSize = map.size();
        int pokNum = nums.length/2;
        
        if(mapSize <= pokNum){
        	answer = mapSize;
        }else{
        	answer = pokNum;
        }
        
        return answer;
    }
}	
