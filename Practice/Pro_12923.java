
public class Test {

   //12923
   public static void main(String[] args){
	   
	   solution(999999900,1000000000); //0, 1, 1, 2, 1, 3, 1, 4, 3, 5
   }

   public static int[] solution(long begin, long end) {
	      int[] answer = new int[(int) (end-begin+1)];
	      int a=0 ; 

	      for(long i = begin ; i<=end ; i++) {
	    	
	    	  if(i < 2){
	    		  answer[a] = 0;
	    	  }else{
	    		  boolean flag = true;	    		  
	    		  for(long j = 2 ; j<= (long) Math.sqrt(i) ; j++){
	    			  if(i%j == 0) {	
	    				  
	    				  if((int) ((int)i/j) > 10000000) continue;
	    				  
	    				  answer[a] = (int) ((int)i/j);
	    				  flag = false;
	    				  break;
	    			  }	    			  	    			  
	    		  }
	    		  
	    		  if(flag) answer[a] = 1;
	    	  }
	    	a++;
	      }
	      
	      for(int i=0 ; i<answer.length ; i++){
	    	  System.out.print(answer[i] + " ");
	      }
	      
	      return answer;
	  } 
    
}