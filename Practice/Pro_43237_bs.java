package alis.uwissu.psnluw.rissrnwl.online.pc;

import java.util.ArrayList;
import java.util.Collections;

public class Test {

	//43237
	public static void main(String[] args){
		
		int[] budgets = {120,110,140,150};
		int M = 485;

		System.out.println(solution(budgets,M));
	}
	
	 public static int solution(int[] budgets, int M) {
	        
		 ArrayList<Integer> bugList = new ArrayList<>();
		 for(int i=0 ; i<budgets.length ; i++){
			 bugList.add(budgets[i]);
		 }
		 
		 Collections.sort(bugList);

		 if(M/budgets.length >= bugList.get(bugList.size()-1)) return bugList.get(bugList.size()-1);
	
		 int answer = 0;
		 int sum = 0;
		 int min = 0;
		 int max = bugList.get(bugList.size()-1);
		 int mid=0;
	     int preMid=0;
		  while(true){
	            sum=0;
	            mid=(min+max)/2;
	            if(preMid==mid){
	                answer=mid;
	                break;
	            }
	            for(int bgt:budgets){
	                if(bgt>mid) sum+=mid;
	                else sum+=bgt;
	            }
	            if(sum>M) max=mid;
	            else min=mid;
	            preMid=mid;
	        }
		
		  return answer;
	 }    
    
    
}
