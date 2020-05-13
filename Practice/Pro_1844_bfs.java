package test;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class test {

	public static void main(String[] args) {

		
		//[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]	11
		int[][] maps = {{1,0,1,1,1},
						{1,0,1,0,1},
						{1,0,1,1,1},
						{1,1,1,0,1},
						{0,0,0,0,1}};
		int[][] map2 = {
				{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}
		};
		
		
		System.out.println(solution(map2));
		
	}
	
	
	//1844
	public static int solution(int[][] maps) {
				
		int answer = bfs(maps.length, maps[0].length,maps);
		
		if(answer == 0) answer = -1;
		
		return answer;
	}
	
	public static int bfs(int m, int n, int[][] maps){
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0));

		int[][] flag = new int[m][n];
		flag[0][0] = 1;

		while(!q.isEmpty()){
			Point pos = q.poll();
			int i = pos.x;
			int j = pos.y;					
	
			if(i+1<m && maps[i+1][j] == 1 && flag[i+1][j] ==0){
				flag[i+1][j] = flag[i][j] +1;			
				q.add(new Point(i+1,j));
			}
			if(i-1>=0 && maps[i-1][j] == 1 && flag[i-1][j] ==0){
				flag[i-1][j] = flag[i][j] +1;
				q.add(new Point(i-1,j));
			}
			if(j+1<n &&maps[i][j+1] == 1 && flag[i][j+1] ==0){
				flag[i][j+1] = flag[i][j] +1;
				q.add(new Point(i,j+1));
			}
			if(j-1>=0 &&maps[i][j-1] == 1 && flag[i][j-1] ==0){
				flag[i][j-1] = flag[i][j] +1;
				q.add(new Point(i,j-1));
			}
		}
		
		return flag[m-1][n-1];		
	}
	
	//효율성탈락
	public static void dfs(int i, int j, boolean[][] flag, int m, int n, int cnt,int[][] maps){
	
		if(i==m-1 && j==n-1){
			//if(answer > cnt) answer = cnt;
			return;
		}
			
		cnt+=1;
		if(i+1<m && maps[i+1][j] == 1 && !flag[i+1][j]){
			flag[i+1][j] = true;			
			dfs(i+1,j,flag,m,n,cnt,maps);
		}
		if(i-1>=0 && maps[i-1][j] == 1 && !flag[i-1][j]){
			flag[i-1][j] = true;
			dfs(i-1,j,flag,m,n,cnt,maps);
		}
		if(j+1<n &&maps[i][j+1] == 1 && !flag[i][j+1]){
			flag[i][j+1] = true;
			dfs(i,j+1,flag,m,n,cnt,maps);
		}
		if(j-1>=0 &&maps[i][j-1] == 1 && !flag[i][j-1]){
			flag[i][j-1] = true;
			dfs(i,j-1,flag,m,n,cnt,maps);
		}
		
	}
}
