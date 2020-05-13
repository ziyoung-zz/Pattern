package alis.uwissu.psnluw.rissrnwl.online.pc;

public class test {

	public static void main(String[] args) {
		//43165문제
        int[] arr = {1, 1, 1, 1, 1};       
        int a = solution(arr, 3);
        System.out.println(a);
    }
 
    static int solution(int[] numbers, int target) {
    	
    	int sum = 0;
    	int answer = 0;
    	        
        for(int i =0 ; i< numbers.length ; i++){
        	sum += numbers[i];
        }
    	
        for(int i=0; i < 1<<numbers.length; i++) {
        	int temp = 0;
            for(int j=0; j<numbers.length; j++) {
                if((i & 1<<j) != 0){
                	temp += numbers[j];
                }                 	
            }
            if(target == temp -(sum-temp)) answer++;
        }
        return answer;
    }
 
}

