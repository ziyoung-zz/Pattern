package alis.uwissu.psnluw.rissrnwl.online.pc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class alTest {

	public static void main(String[] args) {
		//String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		
		solution(tickets);
	}
	
	static boolean[] visit = {};
	static List<String> routList = null;
	
	//프로그래머스 43164	 - 여행경료
	public static String[] solution(String[][] tickets) {
	    
		String[] answer = {};
		visit = new boolean[tickets.length];
		routList = new ArrayList<>();
				
		for(int i=0 ; i<tickets.length ; i++){
			
			String start = tickets[i][0];
			String ends = tickets[i][1];			
			
			if(start.equals("ICN")){
				visit[i] = true;
				dfs(tickets, ends, 1, "ICN");
				visit[i] = false;
			}
		}
		
		Collections.sort(routList);
		
		answer = routList.get(0).split(",");
		
		for(int i=0 ; i< answer.length ; i++){
			System.out.print(answer[i] + " ");
		}
		
		return answer;		
	}

	private static void dfs(String[][] tickets, String arive, int cnt, String route){
		
		route += "," + arive;
		
		if(cnt == tickets.length){
			routList.add(route);
			System.out.println(route);
			
			return;
		}
		
		for(int i=0 ; i< tickets.length ; i++){
			String start = tickets[i][0];
			String ends = tickets[i][1];	
			
			if(!visit[i] && arive.equals(start)){
								
				visit[i] = true;
				dfs(tickets, ends, cnt+1, route);
				visit[i] = false;				

			}
		}
		
	}
}
