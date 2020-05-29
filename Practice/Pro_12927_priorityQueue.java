package test;

import java.util.*;


public class test {

	public static void main(String[] args) {
		Solution s = new Solution();
		
		int n = 3;
		int[] works = {1,1};
		
		System.out.println(s.solution(n,works)); 
	}	
}

//12927
//우선순위큐로 정렬하는게 훨빠름
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> overtime = new PriorityQueue<>(Collections.reverseOrder());        
        int size = works.length;
        
        for(int i=0 ; i<size ; i++){
        	overtime.add(works[i]);
        }
        
        for(int i=0 ; i<n ; i++){
        	int max = overtime.poll();
        	if(max<=0)break;
        	overtime.add(max-1);
        }
        
        while(!overtime.isEmpty()){
        	answer += Math.pow(overtime.poll(), 2);
        }
        
        return answer;
    }
}