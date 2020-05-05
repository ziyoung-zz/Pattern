
import java.util.*;

public class study {

   public static void main(String[] args){
	   solution(3);
   }

   //62049
   public static int[] solution(int n) {
       int[] answer = {};
       
       String temp = "";
       for(int i=1 ; i<n+1 ; i++) {
    	   
    	   temp = dp(i,temp);
       }
       
       answer = new int[temp.length()];
       
       String[] sS = temp.split("");
		
		for ( int i = 0 ; i < answer.length; i ++ ) {
			answer[i] = Integer.valueOf(sS[i]);
		}
    
       return answer;
   }
   
   //String 사용시 시간초과
   private static String dp(int n, String temp) {
	   
	   StringBuilder result = new StringBuilder(temp);
	   
	   if(n ==1) {
			return "0";
	   }else if(n == 2) {
		  return "001";
	   }else {
		   	result.append("0");
			
			String[] splitS = temp.split("");
			
			for ( int j = splitS.length-1; j >= 0 ; j-- ) {
				String appendS = splitS[j].equals("0") ? "1" : "0" ;
				result.append(appendS);				
			}

		   return result.toString();
	   }
	   
   }
   
}
