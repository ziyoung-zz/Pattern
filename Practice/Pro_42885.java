package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
	
		//���α׷��ӽ� 42885�� ����
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
        answer = midPeopleCnt/2; //�߰�ü���λ��
        
        Collections.reverse(smallPeople);
        Collections.sort(bigPeople);
        
        Iterator smallItr = smallPeople.iterator();
        int bigPeopleCnt=0; //�ǳʰ� ū�����
        
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

        //���� ū������� �ǳʺ�����
        answer += bigPeople.size() - bigPeopleCnt;  
    
        //���� ����������� �ǳʺ�����
        if(smallPeople.size()%2 == 1) answer +=1;
    	answer += smallPeople.size()/2;
        
        return answer;
    }
}





