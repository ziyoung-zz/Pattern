package alis.uwissu.psnluw.rissrnwl.online.pc;


public class test {
	
	public static void main(String[] args){
		int[][] edge = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		//int[][] edge = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};	
		int n = 3;
		int answer = solution(n, edge);
		System.out.println(answer);
	}

	static boolean[][] flag;
	//프로그래머스 43162	 네트워크
	 public static int solution(int n, int[][] computers) {
		 
		 int answer =0;
		 flag = new boolean[n][n]; 
		 
		 for(int i=0 ; i<computers.length ; i++){
			 if(!flag[i][i]){
					
					dfs(i,computers);
					answer++;
				}	
		 }		 
	
		 return answer;
	}
	
	public static void dfs(int v, int[][] computers){
		
		for(int i=0 ; i< computers.length ; i++){
			if(computers[v][i] == 1 && !flag[v][i]){
				flag[v][i] =flag[i][v] = true;
				dfs(i,computers);
			}
		}		
	}
}


