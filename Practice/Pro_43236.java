package test;


import java.util.*;

public class study {

	 public static void main(String[] args) {
	    
	      int[] rocks = {2, 14, 11, 21, 17};
	      System.out.println( solution(5,rocks,2));
	     
	   }
	   //프로그래머스 43236
	      public static int solution(int distance, int[] rocks, int n) {
	    	  
	    	  int answer = 0;
	          Arrays.sort(rocks);
	          int left=1;
	          int right=distance;
	          int remove=0;
	          int mid;
	          int lastRock=0;
	          
	          while(left<=right){
	              mid=(left+right)/2;
	              for(int i=0;i<rocks.length;i++){
	                  if(mid>rocks[i]-lastRock) remove++;
	                  else lastRock=rocks[i];
	              }
	              if(distance-lastRock<mid) remove++;

	              if(remove>n) right=mid-1;
	              else{
	                  answer=Math.max(answer, mid);
	                  left=mid+1;
	              }
	              remove=0;
	              lastRock=0;
	          }
	          return answer;
	      }
	      
}
