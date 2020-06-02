package test;

import java.util.*;

public class test {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] land = {{1, 4, 8, 10}, 
						{5, 5, 5, 5}, 
						{10, 10, 10, 10}, 
						{10, 10, 10, 20}};
		
		int[][] land2 = {{10, 11, 10, 11}, 
						{2, 21, 20, 10}, 
						{1, 20, 21, 11}, 
						{2, 1, 2, 1}};
		
		int height = 1; //15
		System.out.println(s.solution(land2, height));
		
	}	
}

//62050
class Solution {
	
	int[][] gland;
	int[][] connectLand;
	int x;
	int y;
    int[] dirX = new int[]{0,0,1,-1};
    int[] dirY = new int[]{1,-1,0,0};
    int[] root;

	//최소비용신장트리 이용
	public int solution(int[][] land, int height) {
		gland = land;        
        x = land.length;
        y = land[0].length;
        connectLand = new int[x][y];
        int connect = 1;
        int answer = 0;

        //갈수있는 영역별로 나누기
        for(int i=0 ; i<x ; i++){
        	for(int j=0 ; j<y; j++){
        		if(connectLand[i][j] == 0){
        			connectLand[i][j] = connect;
        			findConnect(i,j,height);
        			connect+=1;
        		}
        	}
        } 
 
        for(int i=0 ; i<x ; i++){
        	for(int j=0 ; j<x ; j++){
            	System.out.print(connectLand[i][j] + " ");
            }
        	System.out.println();
        }
        
        //최소비용신장트리(mst)로 최소비용사다리 구함
        ArrayList<Edge> edgeList = new ArrayList<>();
        for(int i=0 ; i<x ; i++){
        	for(int j=0 ; j<y; j++){
        		for(int k=0 ; k<4 ; k++){
        			int newi = dirX[k] + i;
        			int newj = dirY[k] + j;	
        			if(newj<0 || newi<0 || newi>=x || newj >=y) continue;
        			if(connectLand[i][j] == connectLand[newi][newj]) continue;
        			
        			int u = connectLand[i][j];
        			int v = connectLand[newi][newj];
        			int w = Math.abs(gland[i][j]-gland[newi][newj]);
        			edgeList.add(new Edge(u,v,w));
        		}        		        		
        	}
        } 
        
        if(edgeList.size() ==0) return 0;                
        
        root = new int[connect];
        Collections.sort(edgeList, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.w, o2.w);
			}
		});
       
        int cnt = 1;	    
        for(Edge e: edgeList){
        	if(merge(e.u, e.v)){
        		answer+= e.w;
        		cnt+=1;
        		if(cnt == connect-1) break;
        	}
        }
        
        return answer;
    }
	
	private int find(int a){
		if(root[a] == 0) return a;
		return root[a] = find(root[a]);
	}
	
	private boolean merge(int a, int b){
		a = find(a);
		b = find(b);
		if(a == b) return false;
		root[b] = a;
		return true;
	}
	
	private void findConnect(int i, int j, int height){
		
		for(int k=0 ; k<4 ; k++){
			
			int newi = dirX[k] + i;
			int newj = dirY[k] + j;
			
			if(newj<0 || newi<0 || newi>=x || newj >=y) continue;
			if(connectLand[newi][newj]!=0) continue;
			if(Math.abs(gland[i][j]-gland[newi][newj]) > height) continue;
			
			connectLand[newi][newj] = connectLand[i][j];
    		findConnect(newi,newj,height);
			
		}			
	}
	
	class Edge{
		int u,v,w;
		
		public Edge(int u, int v, int w){
			this.u = u;
			this.v = v;
			this.w = w;			
		}
	}
}	
	/*
	 //첫번째풀이 실패
    //최소비용 사다리찾는걸 dfs
	public int solution2(int[][] land, int height) {
		gland = land;        
        x = land.length;
        y = land[0].length;
        connectLand = new int[x][y];
        int connect = 1;

        //갈수있는 영역별로 나누기
        for(int i=0 ; i<x ; i++){
        	for(int j=0 ; j<y; j++){
        		if(connectLand[i][j] == 0){
        			connectLand[i][j] = connect;
        			findConnect(i,j,height);
        			connect+=1;
        		}
        	}
        } 
 
        int cnt = 1;        
        int targetNum = connectLand[0][0];
        int answer = 0;
        
        //사다리로 이을 최소비용찾기
        while(cnt != connect-1){
        
            flag = new boolean[x][y];
            min = Integer.MAX_VALUE;
            findMin(0,0);
            
            for(int i=0 ; i<x ; i++){
            	for(int j=0 ; j<y ; j++){            		
            		if(minConnect == connectLand[i][j]) connectLand[i][j] = targetNum;            		
            	}
            }
            
            answer += min;
        	cnt+=1;
        }        
        
        return answer;
    }
	
	private void findMin(int i, int j){
		
		for(int k=0 ; k<4 ; k++){
			int newi  = i + dirX[k];
			
		}
		
		if(i+1<x && !flag[i+1][j]){
			findMinConnect(i,j,i+1,j);
		}
		
		if(j+1<x && !flag[i][j+1]){
			findMinConnect(i,j,i,j+1);
		}
		
		if(i>0 && !flag[i-1][j]){
			findMinConnect(i,j,i-1,j);
		}
		
		if(j>0 && !flag[i][j-1]){
			findMinConnect(i,j,i,j-1);
		}
		
	}
	
	private void findMinConnect(int i, int j, int a, int b){
		
		flag[a][b] = true;
		if(connectLand[i][j] == connectLand[a][b]){
			findMin(a,b);
		}else{				
			int tmp = Math.abs(gland[i][j] - gland[a][b]);
			if(min > tmp){
				minConnect = connectLand[a][b];
				min = tmp;
			} 
		}		
	}
	*/
