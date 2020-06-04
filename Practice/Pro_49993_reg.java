package test;

import java.util.*;

public class test {

	public static void main(String[] args) {
		Solution s = new Solution();
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA","CBD"};
		System.out.println(s.solution(skill, skill_trees));
	}	
}

//49993
class Solution {
	
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		int size = skill.length();		
		
		String reg = this.getReg(skill);							
		
		for(String temp : skill_trees){
			temp = temp.replaceAll(reg, "");
			int tempSize = temp.length(); 
			if(tempSize == 0 || skill.substring(0, tempSize).equals(temp)){
				answer+=1;
			}
			
		}
		
		return answer;
	}
	
	private String getReg(String skill){
		
		StringBuilder reg = new StringBuilder();
		for(int i=65 ; i<91 ; i++){
			char alpa = (char)i;						
			if(skill.contains(Character.toString(alpa))) continue;
			if(reg.length() != 0){
				reg.append('|');
			}
			reg.append(alpa);
		}
		
		return reg.toString();
	}
}	
