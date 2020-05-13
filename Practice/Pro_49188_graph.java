import java.util.ArrayList;

public class Test {

	//49188
	//무향 그래프는 (엣지 개수) >= (노드 개수)면 무조건 사이틀 있음
	public static void main(String[] args){
		
		int n= 8;
		int[][] edges = {
				{1,2},{1,3},{2,3},{2,4},{3,4}
				//{1,2},{2,3},{3,4},{4,5},{5,6},{6,7},{7,8},{8,1},{2,7},{3,6}
		};
		System.out.println(solution(n,edges));
	}

	static ArrayList<Integer> arr[];
	static boolean[] visited;
	
	public static int solution(int n, int[][] edges) {
        int answer = 0;    
        
        arr = new ArrayList[n];
        
        for(int i=0 ; i<n ; i++){
        	arr[i] = new ArrayList<>();
        }
  
        for(int i=0 ; i<edges.length ; i++){
        	int a = edges[i][0];
        	int b = edges[i][1];
        	arr[a-1].add(b-1);
        	arr[b-1].add(a-1);
        }        
        
        long totNode = edges.length;
        
        for(int i=0 ; i<n ; i++){
        	
        	boolean flag = false;
        	if(n <= totNode - arr[i].size()){
        		continue;
        	}
        	        	
        	for(int j=0 ; j<n ; j++){
        		if(i==j) continue;
        		
        		visited = new boolean[n];        		
        		if(dfs(i,j,-1)){
        			flag = true;
        			break;
            	}
        	}
        	if(!flag) answer += i+1;
        }
        
        return answer;
    }
	
	private static boolean dfs(int x, int cur, int first){

		visited[cur] = true;
		for(int next : arr[cur]){
			
			if(next == x) continue;	
			
			if(!visited[next]){						
				if(dfs(x,next,cur)) {					
					return true;
				}
			}else if(next != first){
				return true;
			}			
		}				
		return false;		
	}
	
}
