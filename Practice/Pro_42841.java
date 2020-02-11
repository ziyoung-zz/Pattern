package alis.uwissu.psnluw.rissrnwl.online.pc;

public class test {
	
	//프로그래머스 42841 - 야구게임	
	 public static void main(String[] args) {
		 
		 int[][] baseball = { {123, 1, 1},{356, 1, 0},{327, 2, 0},{489, 0, 1}
				 
		 };
		 
		 System.out.println(solution(baseball));
		 
	 }
	 
	 public static int solution(int[][] baseball) {
	     
		 int answer = 0;
		 	     
		 for(int i=123 ; i<988 ; i++){
			
			 boolean flag = true;			 
			 String num = Integer.toString(i);
			 if(num.charAt(0) == '0' || num.charAt(1) == '0' || num.charAt(2) == '0')
				 continue;
			 if(num.charAt(0) == num.charAt(1) || num.charAt(1)==num.charAt(2) || num.charAt(0)==num.charAt(2))
				 continue;			 			 
			 
			 for(int a =0 ; a < baseball.length ; a++){
				 String temp = Integer.toString(baseball[a][0]);
				 int strike = 0;
				 int ball = 0;		
				 
				 for(int b=0 ; b<3 ; b++){
					 if(num.charAt(b) == temp.charAt(b)) strike++;
					 
					 for(int c=0 ; c<3 ; c++){
						 if(b==c) continue;
						 if(num.charAt(b) == temp.charAt(c)) ball++;
					 }					 					 
				 }					 
				 if(baseball[a][1] != strike || baseball[a][2] != ball) flag = false;				 
			 }
			 
			 if(flag) answer++;
		 } 		 
		 return answer;
	 }
	 
	
}


