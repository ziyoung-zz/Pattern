package alis.uwissu.psnluw.rissrnwl.online.pc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class test {
	
	//프로그래머스 42579 - 베스트앨범
	
	 public static void main(String[] args) {
		 
		 String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		 int[] plays = {500, 600, 150, 800, 2500};
		 int[] answer = solution(genres, plays);
		 for(int i=0 ; i< answer.length ; i++){
			 System.out.print(answer[i]);
		 }
		 
	 }
	 
	 public static int[] solution(String[] genres, int[] plays) {
	        
	        Map<String,ArrayList<Info>> map = new HashMap<String, ArrayList<Info>>();
	        Map<String,Integer> mapPlays = new HashMap<String, Integer>();
	        
	        for(int i=0 ; i< genres.length ; i++){
	        	
	        	ArrayList<Info> times = new ArrayList<Info>();
	        	int playTime = 0;	        	
	        	
	        	if(map.containsKey(genres[i])){
	        		times = map.get(genres[i]);
	        		playTime = mapPlays.get(genres[i]);
	        	}
	        	times.add(new Info(i,plays[i]));
	        	playTime += plays[i];
	        	
	        	Collections.sort(times, new Comparator<Info>() {

					@Override
					public int compare(Info o1, Info o2) {
						
						if(o1.time > o2.time){
							return -1;
						}else if(o1.time == o2.time){
							if(o1.pos < o2.pos){
								return -1;
							}
						}						
						return 0;
					}
	        		
				});	        	
	        	
	        	map.put(genres[i], times);
	        	mapPlays.put(genres[i], playTime);
	        }
    
	        ArrayList<Integer> answerList = new ArrayList<>();
	        ArrayList<String> mapKeys = sortByValue(mapPlays);
	        for(String key : mapKeys){
	        	ArrayList<Info> times = map.get(key);
	        	Iterator itr = times.iterator();
	        	int count = 0;
	        	while(itr.hasNext()){
	        		Info in = (Info)itr.next();
	        		answerList.add(in.pos);
	        		count ++;
	        		if(count > 1) break;
	        	}
	        }
	        
	        int[] answer = new int[answerList.size()];
	        for(int i=0 ; i<answerList.size() ; i++){
	        	answer[i] = answerList.get(i);
	        }
	        
	        return answer;
	 }
	 
	 static class Info{
		 int pos;
		 int time;
		 
		 Info(int pos, int time){
			 this.pos = pos;
			 this.time = time;
		 }
	 }
	 
	 public static ArrayList<String> sortByValue(Map<String,Integer> mapPlays){
		 
		 ArrayList<String> mapKeys = new ArrayList<>(mapPlays.keySet());
		
		 Collections.sort(mapKeys, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				int v1 = mapPlays.get(o1);
				int v2 = mapPlays.get(o2);
							
				if(v1 > v2){
					return -1;
				}else if(v1 == v2){
					return 0;
				}else{
					return 1;
				}
			}
		});
		 
		 return mapKeys;		 
	 }
	 
}

