package alis.uwissu.psnluw.rissrnwl.online.pc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Test {

	//60061
	public static void main(String[] args){
		
		int[][] build = {
				{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}
		};
		int n = 5;
		solution(n,build);
	}

   public static int[][] solution(int n, int[][] build_frame) {
        
	   	HashMap<Pos,Integer> map = new HashMap<>();
	   
	   	for(int i =0; i<build_frame.length ; i++){
	   		int x = build_frame[i][0];
	   		int y = build_frame[i][1];
	   		int a = build_frame[i][2];
	   		int b = build_frame[i][3];
	   		
	   		Pos pos = new Pos(x,y);
	   		
	   		if(b == 1){ //설치
	   			boolean flag = false;
	   			if(a == 0){ //기둥
		   			
		   			if(y==0) flag =  true; //바닥
		   			
		   			if(y>0){
		   				Pos temp = new Pos(x,y-1);
		   				if(map.containsKey(temp) && (map.get(temp) == 0))
		   					flag = true; //기둥위		   				
		   			}
		   			
		   			if(x>0){
		   				Pos temp = new Pos(x-1,y);
		   				if(map.containsKey(temp) &&  (map.get(temp) == 1))
		   					flag = true; //보위
		   			}

	   			}else{//보
		   			
	   				if(y>0){
	   					Pos temp = new Pos(x,y-1);
		   				if(map.containsKey(temp) && (map.get(temp) == 0))
		   					flag = true; //기둥위		
	   				}
	   				
	   				if(x>0 && x<n-1){
	   					Pos temp = new Pos(x-1,y);
	   					Pos temp2 = new Pos(x+1,y);
	   					if(map.containsKey(temp) &&  (map.get(temp) == 1) 
	   							&& map.containsKey(temp2) &&  (map.get(temp2) == 1))
	   						flag = true; //양끝이 보		
	   				}
	   				
		   		}
	   			if(flag){
	   				map.put(pos, a);
	   			}
	   			
	   		}else{ //삭제
	   			
	   			boolean flag = false;
	   			
	   			if(a == 0){ //기둥
	   				
	   				if(x>0 && x<n-1){
	   					Pos temp = new Pos(x-1,y);
	   					Pos temp2 = new Pos(x+1,y);
	   					if(map.containsKey(temp) &&  (map.get(temp) == 1) 
	   							&& map.containsKey(temp2) &&  (map.get(temp2) == 1))
	   						flag = true; //양끝이 보		
	   				}
	   				
	   			}else{//보
	   				
	   				if(y>0 && x<n-1){
	   					Pos temp = new Pos(x+1,y);
	   					Pos temp2 = new Pos(x+1,y-1);
	   					if(map.containsKey(temp) &&  (map.get(temp) == 1) 
	   							&& map.containsKey(temp2) &&  (map.get(temp2) == 0))
	   						flag = true; //한쪽이보,한쪽이 기둥
	   				}
	   				
	   				if(y>0 && x>0){
	   					Pos temp = new Pos(x-1,y);
	   					Pos temp2 = new Pos(x-1,y-1);
	   					if(map.containsKey(temp) &&  (map.get(temp) == 1) 
	   							&& map.containsKey(temp2) &&  (map.get(temp2) == 0))
	   						flag = true; //한쪽이보,한쪽이 기둥
	   				}
	   			}
	   			
	   			if(flag){
	   				map.remove(pos);
	   			}
	   		}
	   	}
	   	
	   	ArrayList<Pos> posList = new ArrayList<>(map.size());
	   	
	   	for(Pos pos : map.keySet()){
	   		posList.add(pos);
	   	}
	   	
	   	Collections.sort(posList);
	   	int[][] arr = new int[posList.size()][3];
	   	
	   	int i=0;
	   	for(Pos pos: posList){
	   		arr[i][0] = pos.x;
	   		arr[i][1] = pos.y;
	   		arr[i][2] = map.get(pos);
	   		i++;
	   		
	   		System.out.println(pos.x + " " + pos.y + " " + map.get(pos));
	   	}
	   	
        return arr;
   }
   
   static class Pos implements Comparable<Pos>{
	   int x;
	   int y;
	   
	   Pos(int x, int y){
		   this.x = x;
		   this.y = y;
	   }

	    @Override
	    public int compareTo(Pos p) {
	        if(this.x > p.x) {
	            return 1; // x에 대해서는 오름차순
	        }
	        else if(this.x == p.x) {
	            if(this.y < p.y) { // y에 대해서는 내림차순
	                return 1;
	            }
	        }
	        return -1;
	    }
   }
}
