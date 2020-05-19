package test;

import java.util.*;


public class test {

	public static void main(String[] args) {
		//JEROEN	56
		//JAN	23
		Solution s = new Solution();
		System.out.println(s.solution("ABBAAAABA"));
	}	
}

//42860
class Solution {
	
	public int solution(String name) {
		int answer = 0;
		HashMap<Character, Integer> map = this.setAlpaCnt();
		int chngAlpaCnt = 0;
		boolean backflag = false;
		int length = name.length();
		char[] charArr = name.toCharArray();
		
		for(int i=0 ; i<length ; i++){
			char str = charArr[i];
			if(str != 'A'){
				chngAlpaCnt++;
				if(i >= length/2) backflag = true;
			}
		}
		
		if(chngAlpaCnt == 0) return 0;
		
		int chngCnt = 0;
		char str;
		for(int i=0 ; i<length ; i++){
			str = charArr[i];
			answer += map.get(str); //알파벳조회
			if(str != 'A') chngCnt+=1;
			if(chngCnt == chngAlpaCnt) break;			
			answer +=1;//한칸이동
		}
		
		if(backflag){
			int answer2 = 0;
			chngCnt = 0;
			str = charArr[0];
			if(str != 'A'){
				chngCnt = 1;
				answer2 += map.get(str);			
			}
			answer2+=1;
			
			for(int i= length-1 ; i>0 ; i--){
				str = charArr[i];
				answer2 += map.get(str); //알파벳조회
				if(str != 'A') chngCnt+=1;
				if(chngCnt == chngAlpaCnt) break;			
				answer2 +=1;//한칸이동
			}
			
			if(answer2 < answer) answer = answer2;
		}

		return answer;
	}
	
	private HashMap<Character, Integer> setAlpaCnt(){
		HashMap<Character, Integer> map = new HashMap<>();		
		for(int i=0 ; i<13 ; i++){
			
			int ascint = 65+i;
			int ascint2 = 90-i;			
			
			String str = String.valueOf((char)ascint);
			String str2 = String.valueOf((char)ascint2);
			
			map.put(str.charAt(0), i);
			map.put(str2.charAt(0), i + 1);
		}
		return map;
	}
	
	//참고하여 풀이
	public static int solution2(String name) {
		int answer = 0 ;
		
		//알파벳찾기
		for ( char c : name.toCharArray()) {
			if( c < 78 ) answer+=c%65;
			else answer+=91-c;
		}
		
		int min = name.length()-1;
		
		// A가 연속되는 경우에는 뒤로돌아갔을때 최솟값
		for ( int i = 0; i < name.length(); i ++ ) {
			int index = i;
			
			if( name.charAt(index)=='A' ) {
				while( index < name.length() && name.charAt(index)=='A') {
					index++;
				}				
				int moveCnt = ((i-1)*2) + name.length() - index;
				min = Math.min(min, moveCnt);
			}
		}
		return answer+min;
	}
}