
import java.util.Arrays;

public class Test {

	//60060
	//효율성 2개(1,3)통과 못함
	public static void main(String[] args){
		
		String[] words = {"aaa","abd","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab","wef","eeef","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};
		String[] queries = {"aa?","?aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa?"};
		//[3, 2, 4, 1, 0]
		solution(words,queries);
	}

	 public static int[] solution(String[] words, String[] queries) {
		 		 
	        int[] answer = new int[queries.length];	      
	        Arrays.sort(words);
	        	        
	        String[] words2 = new String[words.length];
	        for(int i=0 ; i<words.length ; i++){
	        	words2[i] = reverseWord(words[i]);
	        }
	        Arrays.sort(words2);
	        
	        
	        for(int i=0 ; i<queries.length ; i++){
	        	
	        	int cnt = 0;	        	
	        	
	        	if(queries[i].charAt(0) != '?'){
	        		cnt = findWord(words,queries[i]);
	        	}else{
	        		cnt = findWord(words2,reverseWord(queries[i]));
	        	}	      
	        	answer[i] = cnt;
	        }
	        
	        for(int i=0 ; i<answer.length ; i++){
	        	System.out.print(answer[i] + " ");
	        }
	        System.out.println();
	        
	        return answer;
	 } 
	 
	 private static String reverseWord(String word){
		 char[] c = new char[word.length()];
		 
		 for(int i=0 ; i<word.length() ; i++){
			 c[c.length-1- i] = word.charAt(i);
		 }
		 
		 return new String(c,0,c.length);
	 }
	 
	 private static int findWord(String[] words, String q){
		 
		 int r = 0;
		 int pos=-1;
		 
		 for(int i=0 ; i<q.length() ; i++){
			 if(q.charAt(i) == '?'){
				 pos = i;
				 break;
			 } 
		 }

		 int left = 0;
		 int right = words.length -1;
		 int mid = -1;		
		 String cmp = q.substring(0, pos);

		 boolean flag = false;
		 
		 while(right >= left){
			 
			 mid = (right + left)/2;			
			 
			 if(pos<=words[mid].length() && ( 
					 (mid > 0 && words[mid].substring(0,pos).equals(cmp))
					 || (mid ==0 && words[mid].substring(0,pos).equals(cmp)))){
				 
				 if(mid > 0 &&pos<=words[mid-1].length()){
					 if(!words[mid-1].substring(0,pos).equals(cmp)){
						 flag = true;
						 break;
					 }
				 }else{
					 flag = true;
					 break;
				 }
				 
			 }			 
			 
			 if(cmp.compareTo(words[mid]) < 0){
				 right = mid -1;
			 }else{
				 left = mid +1;
			 }			 		
		 }
		 
		 if(!flag) return 0;
		 
		 for(int i=mid ; i<words.length ; i++){
			 if(words[i].length() != q.length()) continue;
			 if(cmp.equals(words[i].substring(0,pos))){
				 r++; 
			 }else{
				 break;
			 }
		 }		 
		 return r;
	 }	 

}
