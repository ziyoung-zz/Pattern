package alis.uwissu.psnluw.rissrnwl.online.pc;

import java.util.ArrayList;

public class Test {

	//42894
	public static void main(String[] args){
		
		int[][] board = {
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,4,0,0,0},
				{0,0,0,0,0,4,4,0,0,0},
				{0,0,0,0,3,0,4,0,0,0},
				{0,0,0,2,3,0,0,0,5,5},
				{1,2,2,2,3,3,0,0,0,5},
				{1,1,1,0,0,0,0,0,0,5}
			};		
		
		System.out.println(solution(board));
	}

	static int answer=0;
	public static int solution(int[][] board) {
		 	
		 	for(int i=0 ; i<board.length ; i++){
		 		for(int j=0 ; j<board[0].length ; j++){
		 			if(checkbolck(i,j,board.length,board[0].length,board)) j=0;
		 			
			 	}
		 	}
		 
	        return answer;
	  }
	 
	private static boolean checkbolck(int i, int j, int maxi, int maxj, int[][] board){
		
		if(i+2<maxi && j+1<maxj && checkAble(i,j+1,board) && checkAble(i,j,board)){			
			if(board[i][j+1] !=0 ){
				int val = board[i][j+1];
				if( val==board[i+1][j+1] && val==board[i+2][j+1] && val== board[i+2][j]){
					board[i][j+1] = board[i+1][j+1] = board[i+2][j+1]= board[i+2][j] = 0;
					answer++;
					return true;
				}				
			}
			
			if(board[i][j] !=0 ){
				int val = board[i][j];
				if( val==board[i+1][j] && val==board[i+2][j] && val== board[i+2][j+1]){
					board[i+1][j] = board[i+2][j] = board[i+2][j+1]= board[i][j] = 0;
					answer++;
					return true;
				}				
			}
					
		}
		
		if(i+1<maxi && j+2<maxj&& checkAble(i,j+1,board) && checkAble(i,j,board) && checkAble(i,j+2,board)){
			if(board[i][j] !=0){
				int val = board[i][j];
				if(val==board[i+1][j] && val==board[i+1][j+1] && val==board[i+1][j+2]){
					board[i][j] = board[i+1][j] = board[i+1][j+1] = board[i+1][j+2] = 0;
					answer++;
					return true;
				}
			}
			
			if(board[i][j+2]!=0){
				int val = board[i][j+2];
				if(val==board[i+1][j] && val==board[i+1][j+1] && val==board[i+1][j+2]){
					board[i][j] = board[i+1][j] = board[i+1][j+1] = board[i+1][j+2] = 0;
					answer++;
					return true;
				}
			}
			
			if(board[i][j+1]!=0){
				int val = board[i][j+1];
				if(val==board[i+1][j] && val==board[i+1][j+1] && val==board[i+1][j+2]){
					board[i][j] = board[i+1][j] = board[i+1][j+1] = board[i+1][j+2] = 0;
					answer++;
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean checkAble(int i,int j, int[][] board){
		
		for(int a=0 ; a<i ; a++){
			if(board[a][j] !=0) return false;
		}
		
		return true;
	}
	
}
