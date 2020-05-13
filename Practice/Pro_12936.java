package test;

import java.util.*;


public class test {

	public static void main(String[] args) {
		
		solution(3,5);
	}
	
	static int pos = 0;
	static int[] answer;
	
	//12936
	public static int[] solution(int n, long k) {
        answer = new int[n];
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1 ; i<n+1 ; i++){
        	arr.add(i);
        }
        findLine(n,k-1,arr);
        
        for(int i=0 ; i<answer.length ;i++){
        	System.out.print(answer[i]);
        }
        
        return answer;
    }	
	
	private static void findLine(int n, long k, ArrayList<Integer> arr){
		
		long totCnt = 1;
		for(int i=1 ; i<n ; i++){
			totCnt *= i;
		}
		int rmCnt = (int) (k/totCnt);
		answer[pos] = arr.get(rmCnt);
		arr.remove(rmCnt);
		pos++;
		
		if(arr.size() == 0) return;
		
		k -= rmCnt * totCnt;
		findLine(n-1,k,arr);
		
	}
	
    //순열 효율성	
//    private static void permutation(int n, int r, LinkedList<Integer> perArr, int[] perCheck,long k) {
//        if(perArr.size() == r){        	
//        	cnt+=1;        	
//        	if(cnt == k){
//                for(int i=0 ; i<r ; i++){
//                	answer[i] = perArr.get(i) + 1;                
//                }
//        	}        	
//            return;
//        }
//         
//        for(int i=0; i<n; i++){
//            if(perCheck[i] == 0){
//                perArr.add(i);
//                perCheck[i] = 1;
//                permutation(n, r, perArr, perCheck,k);
//                perCheck[i] = 0;
//                perArr.removeLast();
//            }
//        }
//         
//    }
}
