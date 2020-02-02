public class Main {

	public void main() {
	
		String answer = solution("?ab??a");
		System.out.println(answer);
	}
	
    public String solution(String s) {
    	
    	char[] charArray = s.toCharArray();
    	
    	int length = s.length();
    	
    	
    	
    	for(int i=0 ; i < length/2 + 1; i++) {
    		
    		char a = s.charAt(i);
    		char b = s.charAt(length - i);
    		
    		
    		
    		if(a == '?' && b =='?') {
    			a = 'a';
    			b = 'a';
    			
    		}else if(a == '?') {
    			
    			a = b;
    			
    		}else if(b =='?') {
    			
    			b = a;
    			
    		}else if(a == b) {
    			
    		}else {
    			return "NO";
    		}
    		
    		charArray[i] = a;
    		charArray[length-i] = b;
    	}
    	
    	String answer = new String(charArray);
    	
    	return answer;
    	
    }
}
