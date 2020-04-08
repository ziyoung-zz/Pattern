
import java.util.ArrayList;


public class Test {

	//12906
	public static void main(String[] args){
		
		int[] arr = {1,1,3,3,0,1,1};
		System.out.println(solution(arr));
	}

	public static int[] solution(int []arr) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int bf = -1;
        for(int i=0 ; i<arr.length ; i++){
        	if(bf != arr[i]){
        		list.add(arr[i]);
        		bf = arr[i];
        	}
        }
        
        int[] answer = new int[list.size()];

        for(int i=0 ; i < answer.length ; i++){
        	answer[i] = list.get(i);
        }
        
        return answer;
	}
}
