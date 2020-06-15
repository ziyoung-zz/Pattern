package test;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		Solution s = new Solution();
		//[1,1,2,3]	3
		int[] cookie = {1,2,4,5};
		System.out.println(s.solution(cookie));
		
	}	
}

//49995
class Solution {
  public int solution(int[] cookie) {
      int answer = 0;
      int size = cookie.length;
      int[] cAdd = new int[size];
      
      cAdd[0] = cookie[0];
      for(int i=1 ; i<size ; i++){
    	  cAdd[i] = cAdd[i-1] + cookie[i];
      }
      
      //1<=l<=m<=r<=n               
      for(int m=0 ; m<size-1 ; m++){
          
    	  int l = 0;
          int r = size -1;
    	  int cookie1 = cAdd[m]; 
    	  int cookie2 = cAdd[r] - cAdd[m];
          
    	  while(l<=r && (cookie1 > answer || cookie2 > answer)){

        	  if(cookie1 < cookie2){
        		  cookie2 -= cookie[r];
        		  r-=1;
        	  }else if(cookie1>cookie2){
        		  cookie1 -= cookie[l];
        		  l+=1;
        	  }else{
        		  if(answer < cookie1) answer = cookie1;
        		  break;
        	  }
        	  
          }
      }
          
      
      return answer;
  }
}