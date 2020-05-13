package alis.uwissu.psnluw.rissrnwl.online.pc;

import java.util.*;

public class Test {

	//42884
	public static void main(String[] args) {
		int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
		System.out.println(solution(routes));
	}

	  public static int solution(int[][] routes) {
	        int answer = 0;
	        int camera = -1000000;
	        ArrayList<Roots> list = new ArrayList<>();
	        for(int i=0 ; i<routes.length ; i++){
	        	list.add(new Roots(routes[i][0],routes[i][1]));
	        }
	        Collections.sort(list);
	        
	        for(Roots rt : list){
	        	if(camera <rt.srt){
	        		camera = rt.end;
	        		answer++;
	        	}
	        }
	        
	        return answer;
	    }
	  
	  static class Roots implements Comparable<Roots>{
		  int srt;
		  int end;
		  
		  Roots(int srt, int end){
			  this.srt = srt;
			  this.end = end; 
		  }

		@Override
		public int compareTo(Roots o) {

			if(o.end < this.end) return 1;
			
			return -1;
		}
	  }
}
