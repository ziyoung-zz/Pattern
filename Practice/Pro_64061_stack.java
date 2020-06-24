import java.util.*;
class Solution {
    public static int solution(int[][] board, int[] moves) {
       
	   int answer=0;
	   
       int[] pos = new int[board[0].length];
     
       for(int j=0 ; j<pos.length ; j++) {
    	   pos[j] = -1;
    	   for(int i=0 ; i<board.length ; i++) {
    		   if(board[i][j] != 0) {
    			   pos[j] = i;
    			   break;
    		   } 
    	   }
       }
       
       ArrayList<Integer> doll = new ArrayList<>();
       for(int i: moves) {
    	   if(pos[i-1] == -1) continue;
    	   if(pos[i-1] >= board.length) continue;
    	   
    	   int d = board[pos[i-1]][i-1];
    	   
    	  // System.out.println(doll.toString() + " d:" +d);
    	   
    	   if(doll.size() !=0 && doll.get(doll.size() -1) == d) {
    		   doll.remove(doll.size() -1);
    		   answer++;
    	   }else {
    		   doll.add(d);
    	   }
    	   
    	   pos[i-1] +=1;
       }
       
       return answer * 2;
   }
   
   
}