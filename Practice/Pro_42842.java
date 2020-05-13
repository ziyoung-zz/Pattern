package alis.uwissu.psnluw.rissrnwl.online.pc;

public class Test {

	public static void main(String[] args) {
		
		int[] answer = solution(24,24);
	}
	 
	
	//프로그래머스 42842
	 public static int[] solution(int brown, int red) {
	        int[] answer = new int[2];
	        
	        int totCnt = brown + red;
	         
	        for(int i=3 ; i< totCnt/2 ; i++){
	        	
	        	if(totCnt%i == 0){
	        		int w = totCnt/i;       		
	        		if((w >i || w==i)  && brown == ((w+i) * 2 - 4)){
	        			answer[0] = w;
	        			answer[1] = i;
	        			
	        			System.out.println(w + " " + i);
	        		}
	        	}
	        }
	        
	        return answer;
	 }
}
