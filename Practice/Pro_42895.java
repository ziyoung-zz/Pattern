package alis.uwissu.psnluw.rissrnwl.online.pc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class alTest {

	public static void main(String[] args) {
		int N = 2;
		int number = 11;
		System.out.println(solution(N, number));
	}
	
	//프로그래머스 42895	 - n으로 표현된 숫자
	public static int solution(int N, int number) {
		int answer  = -1;
				
		List<Num> nums = new ArrayList<Num>(8);
		int base = 0;
		for(int i=0 ; i< 8 ; i++){
			base = base*10 + 1;
			Num num = new Num(base*N);
			nums.add(num);
		}
		
		
		for(int i=1 ; i<nums.size() ; i++){			
			
			Num num = nums.get(i);			
			for(int j=0 ; j<i ; j++){
				Num num2 = nums.get(j);					
				Iterator itr = num2.hashSet.iterator();
				
				while(itr.hasNext()){
					Num num3 = nums.get(i-j-1);
					Iterator itr2 = num3.hashSet.iterator();
					int temp = (Integer)itr.next();
					
					while(itr2.hasNext()){
						int temp2 = (Integer)itr2.next();
						num.hashSet.add(temp+temp2);
						num.hashSet.add(temp-temp2);
						num.hashSet.add(temp*temp2);
						if(temp2 != 0) num.hashSet.add(temp/temp2);
					}
				}											
			}			
			if(num.findNum(number)){
				answer = i+1;
				break;
			}
		}
		
		return answer;
	}

	static class Num{
				
		Set<Integer> hashSet= null;
		
		Num(int num){		
			hashSet=new HashSet();
			hashSet.add(num);
		}
		
		public boolean findNum(int num){
			
			Iterator itr = hashSet.iterator();
			while(itr.hasNext()){
				if((Integer)itr.next() == num) return true;
			}
			
			return false;
		}
	}
}
