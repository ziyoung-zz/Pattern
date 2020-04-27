
import java.util.ArrayList;
import java.util.Collections;

public class Test {

   //42748
   public static void main(String[] args){
	   int[] array = {1, 5, 2, 6, 3, 7, 4};
	   int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
	   solution(array,commands);
	   
   }

   public static int[] solution(int[] array, int[][] commands) {
       int[] answer = new int[commands.length];
       
       for(int a=0 ; a<commands.length ; a++){
    	   
    	   int i = commands[a][0];
    	   int j = commands[a][1];
    	   int k = commands[a][2];
    	   
    	   ArrayList<Integer> arr = new ArrayList<>();
    	   for(int b=i-1 ; b<j ; b++){
    		   arr.add(array[b]);
    	   }
    	   Collections.sort(arr);
    	   answer[a] = arr.get(k-1);    	  
       }
//       
//       for(int i=0 ; i<answer.length ; i++){
//    	   System.out.print(answer[i] + " ");
//       }
       
       return answer;
   } 
    
}