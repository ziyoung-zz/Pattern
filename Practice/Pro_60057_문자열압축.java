package alis.uwissu.psnluw.rissrnwl.online.pc;

public class Test {

	public static void main(String[] args) {
		System.out.println(solution("zababc"));
	}
	 
	
	//프로그래머스 60057
    public static int solution(String s) {
        int answer = s.length();
        int size = s.length();
        
        for(int i= size/2 ; i>0 ; i--){
        	
        	int cnt = 1;
        	int strCnt = 0;
        	
        	StringBuffer str = new StringBuffer(s);
        	int sPos = 0;
        	int nPosSrt = sPos + i;
        	int nPosEnd = nPosSrt + i;
        	
        	while(sPos<s.length() && nPosEnd < str.length()+1){
        		
        		String sStr = str.substring(sPos, nPosSrt);	
        		String nStr = str.substring(nPosSrt,nPosEnd);
        			
            	if(sStr.equals(nStr)){
            		str.delete(nPosSrt, nPosEnd);
            		cnt ++;
            	}else{
            		
            		sPos = nPosSrt;
            		nPosSrt = sPos + i; 
            		nPosEnd = nPosSrt + i;
            		
            		if(cnt > 1){
            			strCnt += Integer.toString(cnt).length();
            			cnt = 1;
            		}
            	}            	
        	}
      
        	if(cnt > 1){
    			strCnt += Integer.toString(cnt).length();
    			cnt = 1;
    		}
        	
        	strCnt += str.length();
        	if(answer > strCnt) answer = strCnt;
        }
        
        return answer;
    }
}
