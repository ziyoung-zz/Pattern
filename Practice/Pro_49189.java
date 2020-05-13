package alis.uwissu.psnluw.rissrnwl.online.pc;


import java.util.*;



public class test {
	
	public static void main(String[] args){
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};		
		int n = 6;
		int answer = solution(n, edge);
		System.out.println(answer);
	}

	//프로그래머스 49189	
	public static int solution(int n, int[][] edge) {
	       int answer = 0;	      
	       ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
	       for(int i=0;i<edge.length;i++){
	           list.add(new ArrayList<Integer>());
	       }	       
	       int[] count = new int[n];
	       boolean[] visit = new boolean[n];
	       Queue<Integer> q = new LinkedList<>();
    
	       for(int i =0 ; i<edge.length ; i++){
	    	   
	    	   int a= edge[i][0] - 1;
	    	   int b= edge[i][1] - 1;
	    	   
	    	   list.get(a).add(b);
	    	   list.get(b).add(a);
	    	   	    	   	    	   
	       }	       	   	       	      
	       
	       q.add(0);
	       visit[0] = true;
	       	       
	       while(!q.isEmpty()){
	    	   
	    	   int v = q.poll();
	    	   for(int i : list.get(v)){
	    		   if(!visit[i]){
	    			   q.add(i);
	    			   count[i] = count[v]+1;
	    			   visit[i] = true;
	    		   }
	    	   }	    	   
	       }
	       int max = 0;
	       for(int i=0 ; i< n ; i++){
	    	   if(max < count[i]){
	    		   max = count[i];
	    		   answer = 1;
	    	   }else if(max == count[i] && count[i] !=0){
	    		   answer ++;
	    	   }
	       }
	       
	       return answer;
	}
	
}


