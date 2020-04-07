package alis.uwissu.psnluw.rissrnwl.online.pc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class Test {

	//42588
	public static void main(String[] args){
		
		int[] heights = {1,5,3,6,7,6,5};
		System.out.println(solution(heights));
	}

	public static int[] solution(int[] heights) {

	    HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
	    
		for(int i=0; i<heights.length ; i++){
			ArrayList<Integer> temp = new ArrayList<>();
			map.put(i, temp);
		}
		
		ArrayList<Integer> q = new ArrayList<>();
		q.add(heights.length-1);
		
		for(int i=heights.length-2 ; i>-1 ; i--){
			
			ArrayList<Integer> temp = map.get(i);

			Iterator<Integer> itr = q.iterator();
			while(itr.hasNext()){
				int pos = itr.next();
				if(heights[i] > heights[pos]){
					temp.add(pos);
					itr.remove();
				}
			}

			q.add(i);
			map.put(i,temp);
		}
		
		int[] answer = new int[heights.length];
		for(int i=0 ; i<heights.length ; i++){
			ArrayList<Integer> temp = map.get(i);
			for(int j=0 ; j<temp.size() ; j++){
				answer[temp.get(j)] = i+1;
			}
		}

	    return answer;
	}

}
