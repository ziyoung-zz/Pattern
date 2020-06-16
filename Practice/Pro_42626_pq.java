package test;

import java.util.PriorityQueue;

public class test {

	public static void main(String[] args) {
		Solution s = new Solution();
		//[1, 2, 3, 9, 10, 12]	7	2
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 1000;
		System.out.println(s.solution(scoville, K));
		
	}	
}

//42626
class Solution {
	public int solution(int[] scoville, int K) {
		int answer = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0 ; i<scoville.length ; i++){
			pq.add(scoville[i]);
		}
		
		int p = pq.peek();
		while(p<K && pq.size() > 1){			
			pq.poll();
			int p2 = pq.poll();							
			int temp = p + p2*2;
			pq.add(temp);
			answer++;			
			p = pq.peek();
		}		
		if(pq.peek() < K) answer = -1;

		return answer;
	}

}