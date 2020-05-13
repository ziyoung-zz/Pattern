package test;

import java.util.*;


public class test {

	public static void main(String[] args) {

		String[]  operations = {"I 7","I 5","I -5","D -1"};
		solution(operations);
	}
	
	//42628
	public static int[] solution(String[] operations) {
		int[] answer = new int[2];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		PriorityQueue<Integer> rvcPq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(String opr : operations){
			String[] srt = opr.split(" ");
			if(srt[0].equals("I")){
				int val = Integer.parseInt(srt[1]);
				pq.add(val);
				rvcPq.add(val);
			}else if(srt[0].equals("D")){
				if(srt[1].equals("-1")){							
					if(!pq.isEmpty()){
						int val = pq.poll();
						rvcPq.remove(val);	
					}															
				}else if(srt[1].equals("1")){
					if(!rvcPq.isEmpty()){
						int val = rvcPq.poll();
						pq.remove(val);
					}					
				}
			}
		}
		
		int max = 0;
		if(!rvcPq.isEmpty()) max = rvcPq.poll();
		int min = 0;
		if(!pq.isEmpty()) min = pq.poll();
		
		//System.out.println(max + " " + min);
		
		answer[0] = max;
		answer[1] = min;
		return answer;
	}	
	
	
}
