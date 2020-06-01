import java.util.*;

class Solution {
public int solution(int[][] jobs) {
		int answer = 0;
		PriorityQueue<Time> q = new PriorityQueue<>();
		int size = jobs.length;
		
		for(int i=0 ; i<size ; i++){
			Time t = new Time(jobs[i][0], jobs[i][1]);
			q.add(t);
		}
		
		ArrayList<Time> tList = new ArrayList<>();
		for(int i=0 ; i<size ; i++){
			tList.add(q.poll());
		}
						
		int time = 0;
		
		while(tList.size() > 0){
			for(int i=0 ; i<tList.size() ; i++){
				
				if(time >= tList.get(i).wait){
					time+= tList.get(i).take;
					answer += time - tList.get(i).wait;
					tList.remove(i);
					break;
				}
				
				if(i == tList.size() -1) time++;
			}
		}

		
		return answer/size;
	}
	
	class Time implements Comparable<Time>{
		int wait;
		int take;
		
		Time(int wait, int take){
			this.wait = wait;
			this.take = take;
		}

		@Override
		public int compareTo(Time t) {
			
			if(this.take < t.take) return -1;
			else if(this.take == t.take){
				if(this.wait < t.wait) return -1;
				else return 1;
			}else return 1;
		}
	}
}