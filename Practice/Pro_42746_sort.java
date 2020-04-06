package alis.uwissu.psnluw.rissrnwl.online.pc;

import java.util.Arrays;
import java.util.Comparator;


public class Test {

	//42746
	public static void main(String[] args){
		
		int[] numbers = {3, 30, 34, 5, 9};
		System.out.println(solution(numbers));
	}

	public static String solution(int[] numbers) {
       
    	String[] strList = new String[numbers.length];
    	for(int i=0 ; i< numbers.length ; i++){
    		strList[i] = Integer.toString(numbers[i]);
    	};
    	
	  Comparator<String> com = new Comparator<String>() {
          @Override
          public int compare(String o1, String o2) {
             String str1 = o1+o2;
             String str2 = o2+o1;
             return -str1.compareTo(str2);
          }
      	};

      	Arrays.sort(strList,com);
      	
      	String answer = "";
      	
      	for(int i=0; i< strList.length ; i++){
      		answer += strList[i];
      	} 
        return answer;
    }
    
	
}
