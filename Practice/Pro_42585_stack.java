package test;

import java.util.*;

public class test {

	public static void main(String[] args) {
		Solution s = new Solution();
		String str = "()(((()())(())()))(())";
		System.out.println(s.solution(str));
	}	
}

//42585
class Solution {
    public int solution(String arr) {
    	
    	ArrayList<Integer> stack = new ArrayList<>();
    	int signal=0;
        int answer = 0;
        
    	for(int i=0 ; i<arr.length() ; i++){
    		if(arr.charAt(i) == '('){
    			signal = 1;	//막대기시작
    		}else{
    			if(signal == 1) signal = 3; //레이저	
    			else signal = 2; //막대기끝
    		}
    		
    		if(signal == 1){
    			stack.add(1);
    		}else{
    			int size = stack.size();
    			if(size == 0) continue;
    			int cnt = stack.get(size-1);
    			stack.remove(size-1);  
    			
    			if(signal == 3){
    				stack = this.addAll(stack);
    			}else{
    				answer += cnt;
    			}
    		}
    	}
    	    	
        return answer;
    }
    
    private ArrayList<Integer> addAll(ArrayList<Integer> stack){
    	
    	for(int i=0 ; i<stack.size() ; i++){
    		int cnt = stack.get(i) +1;
    		stack.set(i, cnt);
    	}
    	return stack;
    }
}	

