import java.util.Collections;
import java.util.PriorityQueue;

public class Test {

   //42629
   public static void main(String[] args){
	   
	   int stock = 4;
	   int[] dates = {4,10,15};
	   int[] supplies = {20,5,10};
	   int k = 30;
			   
	   
	   System.out.println(solution2(stock, dates, supplies, k));
	   
   }

   
   
   public static int solution2(int stock, int[] dates, int[] supplies, int k) {
       int answer = 0;
       
       int f = stock;
       int pos = 0;
       
       PriorityQueue<Integer> amounts = new PriorityQueue<Integer>(Collections.reverseOrder());
       
       while(f < k){
    	   
    	   while(pos<dates.length &&dates[pos] <= f){
    		   amounts.add(supplies[pos]);
    		   pos += 1;
    	   }
    	   f += amounts.poll();
    	   answer ++;
       }
       
       return answer;
   }
   
   //처음풀이.. 시간초과
   public static int solution(int stock, int[] dates, int[] supplies, int k) {
       int answer = 0;
       
       int f = stock;
       int pos = 0;
                   
       while(f < k){
    	   
    	   int max = 0;  
    	   while(pos<dates.length &&dates[pos] <= f){
    		   
    		   if(max<supplies[pos]) max = supplies[pos];    		   
    		   pos += 1;
    	   }
    	   f += max;
    	   answer ++;
       }
       
       return answer;
   }
   
}