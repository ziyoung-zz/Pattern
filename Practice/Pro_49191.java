package alis.uwissu.psnluw.rissrnwl.online.pc;

import java.util.*;

public class test {
	
	// 프로그래머스 49191
	public static void main(String[] args){
		int[][] rocks = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		//int[][] rocks = {{4,5},{3,4},{2,3},{1,2}};

		System.out.println(solution(5, rocks));
	
	}

	static int[][] score;
	
	public static int solution(int n, int[][] results) {
        int answer = 0;
        
        score = new int[n][n];
        int[] tScore = new int[n];
        
        for(int i=0 ; i<results.length ; i++){
        	
        	int win = results[i][0] - 1;
        	int lose = results[i][1] - 1;
        	
        	score[win][lose] = 1; //승자기록
        	
        	check(win,lose,n);
        }
        
        for(int i=0 ; i<n ; i++){
        	for(int j=0 ; j<n ; j++){
        		
        		if(score[i][j] == 1){
        			tScore[i] +=1;
            		tScore[j] +=1;
        		}
            }
        }
        
        for(int i=0 ; i<n ; i++){
        	if(tScore[i] == n-1) answer++;
        }
        
      
        return answer;
        
    }
	
	static private void check(int win, int lose, int n){
		
		for(int a=0 ; a<n ; a++){
    		
    		if(score[lose][a] == 1 && score[win][a] != 1){
    			score[win][a] = 1;
    			check(win,a,n);
    		}  
    		if(score[a][win] == 1 && score[a][lose] != 1){
    			score[a][lose] = 1;
    			check(a,lose,n);
    		}
    	}
		
	}
}


