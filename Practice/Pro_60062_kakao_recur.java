package alis.uwissu.psnluw.rissrnwl.online.pc;

import java.util.LinkedList;

public class Test {

	//60062	
	static int[][] weakList;
	static int answer = 10000;
	
	public static void main(String[] args){
		int n = 12;
		int[] weak = {1, 5, 6, 10};
		int[] dist = {1, 2, 3, 4};
		System.out.println(solution(n,weak,dist));
	}

    public static int solution(int n, int[] weak, int[] dist) {
        
    	weakList = new int[weak.length][weak.length];
    	for(int i=0 ; i<weak.length ; i++){
    		rotate(weak,i,n);
    	}
 
		for(int i=1 ; i<dist.length+1 ; i++){
			LinkedList<Integer> perArr = new LinkedList<Integer>(); 
			int[] perCheck = new int[dist.length];
			permutation(i,perArr,perCheck,dist);
		}
        
		if(answer == 10000) answer = -1;
		
        return answer;
    }
    
    private static void rotate(int[] weak, int i, int n){
    	
    	int pos = i; 	
    	boolean flag = false;
    	for(int j=0 ; j<weak.length ; j++){
    		weakList[i][j] = weak[pos];
    		if(flag) weakList[i][j] += n;
    		
    		pos++;    		
    		if(pos == weak.length){
    			pos =0;
    			flag = true;
    		}
    	}
    }
    
    private static void permutation(int r, LinkedList<Integer> perArr, int[] perCheck,int[] dist) {
        if(perArr.size() == r){
        	findWeak(perArr, dist);
            return;
        }
         
        for(int i=0; i<perCheck.length; i++){
            if(perCheck[i] == 0){
                perArr.add(i);
                perCheck[i] = 1;
                permutation(r, perArr, perCheck,dist);
                perCheck[i] = 0;
                perArr.removeLast();
            }
        }
         
    }
    
    private static void findWeak(LinkedList<Integer> perArr,int[] dist){
    	
    	for(int[] weak: weakList){
    		
    		int pos = 0;
    		int pre = 0;
    		boolean flag = false;
    		for(int i=0 ; i<perArr.size() ; i++){
    			
    			pre = weak[pos] + dist[perArr.get(i)];
    		
    			while(pre >= weak[pos]){
    				pos++;
    				if(pos >= weak.length){
    					flag = true;
    					if(answer > i+1) answer = i+1;
    					break;
    				}
    			}
    			
    			if(flag) break;
    		}    	
    	}
    }
}
