package alis.uwissu.psnluw.rissrnwl.online.pc;

public class Test {

	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(solution(begin,target,words));
	}
	 
	static int minCnt;
	 
	//프로그래머스 43163
	public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] flag = new boolean[words.length];
        minCnt = words.length;
        
        boolean flg = true;
        for(int i=0 ; i < words.length ; i++){
        	if(words[i].equals(target)) flg = false;
        }
        
        if(flg) return 0;
        
        for(int i=0 ; i<words.length ; i++){
        	int cnt = 0;
        	if(findLoc(begin,words[i])){
        		flag[i] = true;
        		cnt++;
        		dfs(flag, cnt, words[i], target, words);
        		flag[i] = false;
        		cnt--;
        	}
        }
        
        answer = minCnt;
        return answer;
    }
	
	private static void dfs(boolean[] flag, int cnt, String begin, String target,String[] words){
		if(begin.equals(target) && minCnt > cnt){		
			minCnt = cnt;
			return;
		}
		
		for(int i=0 ; i< words.length ; i++){
			if(!flag[i] && findLoc(begin,words[i])){
				flag[i] = true;
        		cnt++;
        		dfs(flag, cnt, words[i], target, words);
        		flag[i] = false;
        		cnt--;
			}
		}
		
	}
	
	private static boolean findLoc(String s1, String s2){
		
		int cnt=1;
		
		for(int i=0 ; i<s1.length() ; i++){
			if(s1.charAt(i) == s2.charAt(i)){
				cnt++;
			}
		}
		
		if(cnt == s1.length()) return true;
		else return false;
		
	}
}
