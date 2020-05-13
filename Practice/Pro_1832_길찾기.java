package test;


import java.util.*;

public class study {

	 public static void main(String[] args) {
	    
	      int m = 3;
	      int n = 6;
	      int[][] cityMap = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
	      System.out.println( solution(m,n,cityMap));
	     
	   }
	    //프로그래머스 1832
	 static int MOD = 20170805;
	  
	
	  public static int solution(int m, int n, int[][] cityMap) {

	      int[][] right = new int [m][n];
	      int[][] down = new int [m][n];
	      
	      right[0][0] = 1;
	      down[0][0] =  1;
	      for(int i=0 ; i<m ; i++) {
	    	  for(int j=0 ; j<n ; j++) {
	    		  
	    		  int rightVal = 0;
	    		  int downVal = 0;
	    		  
	    		  if(j>0) rightVal =  right[i][j-1];
	    		  if(i>0) downVal = down[i-1][j];
	    		  
	    		  if(cityMap[i][j] == 0) {
	    			  right[i][j] += (rightVal + downVal) % MOD;
	    			  down[i][j] += (rightVal + downVal) % MOD;
	    		  }else if(cityMap[i][j] == 2) {
	    			  right[i][j] = rightVal;
	    			  down[i][j] = downVal;
	    		  }else {
	    			  right[i][j] = 0;
	    			  down[i][j] = 0;
	    		  }
	    		  
	    	  }
	      }
	      
	      return right[m-1][n-1] % MOD;
	  }
	
	  
	  
}
