package alis.uwissu.psnluw.rissrnwl.online.pc;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		int n = 6;
		int[] times = {7,10};
		System.out.println(solution(n, times));
	}

	//이분탐색
	public static long solution(int n, int[] times) {
		
			Arrays.sort(times);
	        
	        long min = 1;
	        long max = (long)times[times.length-1] * n;
	        long answer = max;
	        long sum = 0;
	        long mid = 0;
	        
	        while(min <= max){
	        	sum = 0;
	        	mid = (min+max)/2;
	        	
	        	for(int time: times){
	        		sum += mid/time;
	        	}
	        	
	        	if(sum>=n){
	        		if(answer > mid) answer = mid;
	        		max = mid-1;
	        	}else{
	        		min = mid +1;
	        	}	        	
	        }	        
	        
	        return answer;
	}
	
	
  //시간초과..
  public static long solution2(int n, int[] times) {
        long answer = 0;
        List<Wait> waitList = new ArrayList<>();        
        for(int i=0 ; i<times.length ; i++){
        	waitList.add(new Wait(0,times[i]));
        }
        
        
        while(n > -1){
        	Collections.sort(waitList);
        	
        	if(waitList.get(0).leftTime == 0){
        		
        		waitList.get(0).leftTime = waitList.get(0).waitTime;
        		n--;
        		
        	}else{
        		
        		for(int i=0 ; i<waitList.size() ; i++){
        			if(waitList.get(i).leftTime != 0)
        				waitList.get(i).leftTime --;
        		}        		
        	}
        	
        	answer++;
        }
        
        return answer;
  }
	
  static class Wait implements Comparable<Wait>{
	  int leftTime;
	  int waitTime;
	  
	  Wait(int leftTime, int waitTime){
		  this.leftTime = leftTime;
		  this.waitTime = waitTime;
	  }

	@Override
	public int compareTo(Wait o) {
				
		if(o.leftTime > this.leftTime){
			return -1;
		}else if(o.leftTime == this.leftTime && o.waitTime > this.waitTime){
			return -1;
		} 
		return 1;
	}
  }
}
