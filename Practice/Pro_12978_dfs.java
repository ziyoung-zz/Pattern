class Solution {
int answer;
	int[][] map;
	boolean[] flag;
	boolean[] mapflag;
	
	public int solution(int N, int[][] road, int K) {
		
		answer = 0;
		map = new int[N+1][N+1];
		mapflag = new boolean[N+1];
		flag = new boolean[N+1];
		flag[1] = true;
		mapflag[1] = true;
		answer+=1;
		
		for(int i=0 ; i<road.length ; i++){
			int x = road[i][0];
			int y = road[i][1];
			int l = road[i][2];
			
			if(map[x][y] == 0 || map[x][y] > l){
				map[x][y] = l;
				map[y][x] = l;						
			}			
		}
		
		for(int i=2 ; i<N+1 ; i++){
			
			if(map[1][i] !=0 && map[1][i] <=K){
				if(!flag[i]){
					flag[i] = true;
					answer+=1;
				}
				mapflag[i] = true;
				dfs(K,map[1][i],i,N);
				mapflag[i] = false;
			}
		}

		return answer;
	}
	
	private void dfs(int K, int cnt, int next, int N){
		for(int i=1 ; i<N+1 ; i++){
			if(map[next][i] !=0 && map[next][i] + cnt <= K && !mapflag[i]){
				
				if(!flag[i]){
					flag[i] = true;
					answer+=1;
				}
				
				mapflag[i] = true;
				dfs(K,map[next][i] + cnt,i,N);
				mapflag[i] = false;
			}
		}
	}
}