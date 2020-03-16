package alis.uwissu.psnluw.rissrnwl.online.pc;

import java.util.PriorityQueue;

public class Test {

	public static void main(String[] args) {
		int n = 4;
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		System.out.println(solution(n, costs));
	}
	 	 
	static PriorityQueue<Node> pq;
	static int[] parent;
	
	  //프로그래머스 42861
	  public static int solution(int n, int[][] costs) {
	        int answer = 0;
	        
	        parent = new int[n];
	        pq = new PriorityQueue<Node>();
	        
	        for(int i=0 ; i< costs.length ; i++){
	        	pq.add(new Node(costs[i][0], costs[i][1], costs[i][2]));
	        }
	        
	        for(int i=0 ; i<n ; i++) parent[i] = i;
	        
	        for(int i=0 ; i< costs.length ; i++){
	        	Node nod = pq.poll();
	        	
	        	int a = find(nod.s);
	        	int b = find(nod.e);
	        	
	        	if(a==b) continue;
	        	union(nod.s, nod.e);
	        	answer += nod.v;
	        }
	        
	        return answer;
	  }
	  
	  private static int find(int loc){
		  
		  if(loc == parent[loc]) return loc;
		  
		  parent[loc] = find(parent[loc]);
		  
		  return parent[loc];
		  
	  }
	  
	  private static void union(int a, int b){
		  int aParent = find(a);
		  int bParent = find(b);
		  
		  if(aParent == bParent){
			  return;
		  }else{
			  parent[aParent] = b;
		  }
	  }
	  
	  static class Node implements Comparable<Node>{

		  int s;
		  int e;
		  int v;
		  
		  public Node(int s, int e, int v){
			  this.s = s;
			  this.e = e;
			  this.v = v;
		  }
		 
		  
		@Override
		public int compareTo(Node n) {
			
			if(n.v >= this.v ) return -1; 
			return 1;
		}
		  
	  }
	
}
