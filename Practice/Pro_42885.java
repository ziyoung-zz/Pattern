package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
	
		//프로그래머스 42885번 문제
		//[70, 50, 80, 50]	100	3
		//[70, 80, 50]	100	3
		int[] people = {50,51};
		int a = solution(people, 101);
		System.out.println(a);
	}

	public static int solution(int[] people, int limit) {
        int answer = 0; 
        double mid = limit/(double)2;
        int midPeopleCnt = 0;
        ArrayList<Integer> smallPeople = new ArrayList<>();
        ArrayList<Integer> bigPeople = new ArrayList<>(); 
        Arrays.sort(people);
       
        for(int i=0 ; i< people.length ; i++) {
        	
        	if(mid > people[i]) {
        		smallPeople.add(people[i]);
        	}else if(mid == people[i]){
        		midPeopleCnt++;
        	}else{
    			bigPeople.add(people[i]);
        	} 
        }
        
        if(midPeopleCnt % 2 == 1) bigPeople.add((int)mid);
        answer = midPeopleCnt/2; //중간체급인사람
        
        Collections.reverse(smallPeople);
        Collections.sort(bigPeople);
        
        Iterator smallItr = smallPeople.iterator();
        int bigPeopleCnt=0; //건너간 큰사람수
        
        for(int i=0 ; i< bigPeople.size() ; i++) {
        	
        	while(smallItr.hasNext()) {
              
        		if( (int)smallItr.next() + bigPeople.get(i) < limit+1) {
        			smallItr.remove();
        			answer++;
        			bigPeopleCnt++;
        			break;
        		}
            }
        }

        //남은 큰사람들을 건너보낸다
        answer += bigPeople.size() - bigPeopleCnt;  
    
        //남은 작은사람들을 건너보낸다
        if(smallPeople.size()%2 == 1) answer +=1;
    	answer += smallPeople.size()/2;
        
        return answer;
    }
}





