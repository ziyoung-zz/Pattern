package alis.uwissu.psnluw.rissrnwl.online.pc;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		String p = ")("; 
		System.out.println(solution(p));
	}

	// 프로그래머스 60058
	public static String solution(String p) {
		return spliteString(p);
	}	
	
	//u,v로 분리
	private static String spliteString(String p){
	
	   if(p.isEmpty()) return "";
	   if(checkRightString(p)) return p;
	   
	   int pos = checkString(p);	   
       String u = p.substring(0, pos+1);
       String v = p.substring(pos+1,p.length());
       
       if(checkRightString(u)){
    	   return u + spliteString(v);
       }else{
    	   return wrongString(u,spliteString(v));
       }
	}
	
	//올바른문자열아닐때 실행
	private static String wrongString(String u, String v){
		
		String temp = "(" + v + ")";		
		
		for(int i=1 ; i<u.length() -1 ; i++){
			if(u.charAt(i) == '('){
				temp += ")";
			}else{
				temp += "(";
			}
		}
		return temp;
	}
	
	//균형잡힌문자열 판단
	private static int checkString(String p){
		
		if(p.isEmpty()) return -1;
		
		int leftCnt = 0;
		int rightCnt = 0;
		int pos = 0;
		
		for(int i=0 ; i<p.length() ; i++){
			if(p.charAt(i) == '('){
				leftCnt++;
			}else{
				rightCnt++;
			}
			
			if(leftCnt == rightCnt){
				pos = i;
				return pos;
			}
		}		
		return pos;
	}
	
	//올바른문자열 판단
	private static boolean checkRightString(String p){
		
		int cnt = 0;
		
		for(int i=0 ; i<p.length() ; i++){			
			
			if(p.charAt(i) == '('){
				cnt++;
			}else{
				if(cnt < 1) return false;
				cnt--;
			}			
		}
		
		if(cnt != 0) return false;
		
		return true;
	}
	
}
