
import java.util.*;

public class Test {

	//12979
	public static void main(String[] args) {

		int n = 11;
		int[] stations = {4,11};
		int w = 1;

//		int n = 16;
//		int[] stations = {2,7,12,15};
//		int w = 2;
		System.out.println(solution(n, stations, w));
	}
	
	 public static int solution(int n, int[] stations, int w) {
		 int answer = 0;		 
		 ArrayList<Integer> emtyList = new ArrayList<Integer>();
		 
		 int bfPos = 0;
		 for(int pos : stations){
			
			 pos -=1;		 
			 if(bfPos < pos-w){
				 emtyList.add(pos-w - bfPos);
			 }			
			 bfPos = pos+w+1;
		 }
		 
		 int lastStation = stations[stations.length-1]-1;
		 
		 if(lastStation+w+1 < n){
			 emtyList.add(n - (lastStation+w+1));
		 }
		 
		 for(int empty : emtyList){			 
			 
			 int tw = 2*w +1;
			 
			 if(empty <= tw){
				 answer +=1;
			 }else{
				 answer += empty/tw;				 
				 if(empty%tw !=0) answer +=1; 
			 }
			 
			 //math 써도 시간초과;;;
			 // answer += Math.ceil((double)empty/(2*w+1));
		 }
		
		 return answer;
	 }
	
	
	//효율성 실패
	 public static int solution2(int n, int[] stations, int w) {
		  
	        int answer = 0;
	        
	        int[] city = new int[n];
	        for(int pos : stations){
	        	
	        	int i = pos-w -1;
	        	if(i<0) i=0;
	        	
	        	int j = pos+w-1;
	        	if(j>n-1) j=n-1;
	        	
	        	for(;i<=j ; i++){
	        		city[i] = 1;
	        	}	
	        }	
	        int cnt = 0;	        
	        for(int i=0 ; i<n ; i++){
	        	if(cnt==0 && city[i] == 0){
	        		cnt+=1;
	        		answer+=1;
	        	}else if(cnt!=0){
	        		cnt+=1;
	        	}
	        	
	        	if(cnt == 2*w+1){
	        		cnt = 0;
	        	}
	        }

	        return answer;
	    }

}
