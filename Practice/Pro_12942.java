package test;

import java.util.ArrayList;
import java.util.HashMap;

public class study {

   ////12942
   public static void main(String[] args){
      
      int[][]matrix_sizes = {{4,10},{10,3},{3,4},{4,11}};  //270
      System.out.println(solution(matrix_sizes));
   }

 
   static int[][] m ;
   
    public static int solution(int[][] matrix_sizes) {
    	
    	 HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    	
    	for(int i=0 ; i<matrix_sizes.length ; i++) {
    		
    		if(map.containsKey(matrix_sizes[i][0])) {
    			map.get(matrix_sizes[i][0]).add(matrix_sizes[i][1]);
    		}else {
    			ArrayList<Integer> arr = new ArrayList<>();
    			arr.add(matrix_sizes[i][1]);
    			map.put(matrix_sizes[i][0], arr);
    		}
    	}
    	
    	int answer = -1;
    	
		for(int i=0 ; i<matrix_sizes.length ; i++) {
			m = new int[matrix_sizes.length][2];
	    	if(dfs(matrix_sizes[i][0],0,map)) {
	    		int temp = dp(m.length,m,0,2);
	    		if(answer==-1 || answer > temp) answer = temp;
	    	}
		}

        return answer;
     }

    
    private static boolean dfs(int key, int i, HashMap<Integer, ArrayList<Integer>> map) {
    	
       	if(i == m.length) return true;
    	if(!map.containsKey(key)) return false;
    	
    	ArrayList<Integer> arr = map.get(key);
    	
    	for(int a=0 ; a < arr.size() ; a++) {
    		int temp = arr.get(a);
    		m[i][0] = key;
    		m[i][1] = temp; 
    		arr.remove(a);
    		if(arr.size() == 0) {
    			map.remove(key);
    		}else {
    			map.put(key,arr);
    		}
    		if(dfs(temp,i+1,map)) return true;
    		
    		arr.add(temp);
    		map.put(key,arr);
    	}
    	
    	return false;
    }
    
    private static int dp(int n, int[][] m, int srt, int end){
       
       if(n == 2){
          return m[srt][0] * m[srt][1] * m[end][1];
       }else{
          
          return Math.min(dp(n-1,m,srt,end-1)+m[srt][0]*m[end][0]*m[end][1],dp(n-1,m,srt+1,end)+ m[srt][0]*m[srt][1]*m[end][1]);          
       }      
    }   
}
