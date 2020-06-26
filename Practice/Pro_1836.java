package test;

import java.util.*;
//1836
class Solution {
	
	char[][] b;
	public String solution(int m, int n, String[] board) {
		StringBuffer answer = new StringBuffer();
		
		b = new char[m][n];
		for(int i=0 ; i<m ; i++){
			b[i] = board[i].toCharArray();
		}
		
		TreeMap<Character,ArrayList<Pos>> map = new TreeMap<>();
		
		for(int i=0 ; i<m ; i++){
			for(int j=0 ; j<n ; j++){
				if(b[i][j] != '.' && b[i][j] != '*'){
					ArrayList<Pos> pList = new ArrayList<>();
					if(map.containsKey(b[i][j])){
						pList = map.get(b[i][j]);
					}
					pList.add(new Pos(i,j));
					map.put(b[i][j], pList);
				}
			}
		}
		
		int aCnt = map.size();
		for(int i=0 ; i<aCnt ; i++){						
			
			ArrayList<Character> rmList = new ArrayList<>();
			
			for(Character key : map.keySet()){
				ArrayList<Pos> pList = map.get(key);
				Pos p1 = pList.get(0);
				Pos p2 = pList.get(1);				
				char c = b[p1.x][p1.y];
			
				//일직선상있을때
				if(p1.x == p2.x){
					if(!findWayY(p1.x,p1.y,p2.y,c)) continue; 
				}else if(p1.y == p2.y){
					if(!findWayX(p1.y,p1.x,p1.x,c)) continue;
				}else{
					//한번꺾을때
					if(findWayY(p1.x,p1.y,p2.y,c) && findWayX(p2.y,p1.x,p2.x,c)){
						
					}else if(findWayY(p2.x,p1.y,p2.y,c) &&findWayX(p1.y,p1.x,p2.x,c)){
						
					}else{
						continue;
					}
					
							
				}
												
				answer.append(c);
				
				b[p1.x][p1.y] = '.';
				b[p2.x][p2.y] = '.';
				rmList.add(key);				
			}
			
			for(Character rm : rmList){
				map.remove(rm);
			}
	
		}
		
		if(answer.length() != aCnt) return "IMPOSSIBLE";
		
		return answer.toString();
	}

	
	
	
	private boolean findWayY(int x, int y1, int y2, char c){
		
		int maxY = Math.max(y1, y2);
		int minY = Math.min(y1, y2);
		for(int i= minY ; i<maxY+1 ; i++){
			if(b[x][i] =='*' || (b[x][i] != '.' && b[x][i] != c)) return false;
		}
		
		return true;
	}
	
	private boolean findWayX(int y, int x1, int x2, char c){
		
		int maxX = Math.max(x1, x2);
		int minX = Math.min(x1, x2);
		
		for(int i=minX ; i<maxX+1 ; i++ ){
			if(b[i][y]=='*' || (b[i][y] != '.' && b[i][y] != c)) return false;
		}
		
		return true;
	}
	
	class Pos{
		int x;
		int y;
		
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}


public class test {

	public static void main(String[] args) {
		Solution s = new Solution();
		
		String[] board2 = {"DBA", "C*A", "CDB"};		
		System.out.println(s.solution(3, 3, board2));
		
		String[] board3 = {"NRYN", 
						   "ARYA"};		
		System.out.println(s.solution(2, 4, board3));				
		
		String[] board = {".ZI.", "M.**", "MZU.", ".IU."};		
		System.out.println(s.solution(4, 4, board));
		
		String[] board4 = {"AB","BA"};		
		System.out.println(s.solution(2,2, board4));
				
		String[] board5 = {"A..","...","..A"};		
		System.out.println(s.solution(3,3, board5));
		
	}	
}