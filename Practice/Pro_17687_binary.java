package test;

import java.util.*;


public class test {

	public static void main(String[] args) {
		
		/*
		2	4	2	1	0111  	
		16	16	2	1	02468ACE11111111
		16	16	2	2	13579BDF01234567 
		 */
		Solution s = new Solution();
		//System.out.println(s.solution(2, 4, 2, 1));
		System.out.println(s.solution(16,16,2,2));
	}	
}


//17687
class Solution {
	
	//n:진법, t:미리구할 숫자의 갯수,m:참가하는인원,p:내순서
	public String solution(int n, int t, int m, int p) {
		StringBuffer answer = new StringBuffer();					
		int turn = 1;//순서
		int totCnt = 0;//구한숫자의개수
		char[] hexchar = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};   
		p = p%m;
		
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(-1);
		boolean flag = true;
		
		while(flag){						
			
			int add = 1;			
			for(int i=0 ; i <arr.size() ; i++){
				
				if(add != 1) break;
				
				int val = arr.get(i);
				val += add;
				
				if(val < n){
					arr.set(i, val);
					add = 0;
				}else{
					arr.set(i, 0);				
				}
			}			
			if(add == 1) arr.add(1);
			
			//System.out.println(arr.toString());
			
			for(int i=arr.size()-1; i>-1 ; i--){
				int val = arr.get(i);
				if(turn%m == p){				
					answer.append(hexchar[val]);
					totCnt+=1;
				}
				turn+=1;			
				if(totCnt == t){
					flag = false;
					break;
				}
			}
			
		}
		
		return answer.toString();
	}	
}