
import java.util.Arrays;

public class Test {

   //42747
   public static void main(String[] args){
	   
	   int[] citations = {3, 0, 6, 1, 5}; // 
	   
	   System.out.println(solution(citations));
	   
   }

   //어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
   public static int solution(int[] citations) {
       Arrays.sort(citations);

       int pos = citations.length / 2;
       int h = citations[pos];
       
       while(h > 0){
    	   
    	   boolean flag = true;
    	   while(flag){
    		   if(pos ==0 || citations[pos-1] < h){
    			   flag = false;
    		   }else{
    			   pos-=1;
    		   }    		   
    	   }
    	   
    	   if(citations.length - pos >= h && pos <= h){
    		   return h;
    	   }
    	   
    	   h--;
       }
       
       return h;
   }
}