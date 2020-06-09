package test;


public class test {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(10000000));
	}	
}

//12899
class Solution {
  public String solution(int n) {
      
      String answer = "";

      while(n!=0){
    	  if(n%3 == 0){
    		  answer = '4'+answer;
    		  n = n/3 -1;
    	  }else{
    		  answer = n%3+answer;
    		  n = n/3;
    	  }
      }      
      
      return answer;
  }

}

