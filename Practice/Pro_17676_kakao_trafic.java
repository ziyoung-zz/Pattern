package alis.uwissu.psnluw.rissrnwl.online.pc;


import java.math.BigDecimal;
import java.util.*;


public class Test {

	//17676
	public static void main(String[] args){
		
		String[] pages = {
				"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s", 
				"2016-09-15 20:59:58.688 1.041s", 
				"2016-09-15 20:59:59.591 1.412s", 
				"2016-09-15 21:00:00.464 1.466s", 
				"2016-09-15 21:00:00.741 1.581s", 
				"2016-09-15 21:00:00.748 2.31s", 
				"2016-09-15 21:00:00.966 0.381s", 
				"2016-09-15 21:00:02.066 2.62s"
			};
		
		String[]  pages2 = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
		
		
		System.out.println(solution(pages));
	}

	 public static int solution(String[] lines){
	      int answer = 0;
	      ArrayList<Log> logList = new ArrayList<>();
	   
	      for(String line : lines){
		      String[] strList= line.split("\\s+");
		      BigDecimal time =  new BigDecimal(strList[2].replaceAll("s", ""));  
		      
		      BigDecimal h = new BigDecimal(strList[1].substring(0,2)).multiply(new BigDecimal(3600));
		      BigDecimal m = new BigDecimal(strList[1].substring(3,5)).multiply(new BigDecimal(60));
		      BigDecimal s = new BigDecimal(strList[1].substring(6,12));
		     
		      BigDecimal end = h.add(m).add(s);
		      BigDecimal srt = end.subtract(time);
		      srt = srt.add(new BigDecimal("0.001"));
		      
		      logList.add(new Log(srt,end,time));
	      }
	      
	      Collections.sort(logList);
	      for(Log log : logList){
	    	  System.out.println(log.srt + " | " + log.end);
	      }
	      
	      for(int i=0 ; i<logList.size() ; i++){
	    	  
	    	  BigDecimal endTime = logList.get(i).end;
	    	  BigDecimal endTime2 = endTime.add(BigDecimal.ONE).subtract(new BigDecimal("0.001"));
	    	  int cnt=1;
	    	  
	    	  for(int j=0 ; j<logList.size(); j++){
	    		  
	    		  if(i!=j && logList.get(j).srt.compareTo(endTime2)<=0 && logList.get(j).end.compareTo(endTime)>=0){
	    			  cnt++;
	    		  }
	    	  }
	    	  
	    	  if(answer < cnt) answer = cnt;
	      }
	      
	      
	      return answer;
	  }
	
	 static class Log implements Comparable<Log>{
		 BigDecimal srt;
		 BigDecimal end;
		 BigDecimal time;
		 
		 Log(BigDecimal srt, BigDecimal end, BigDecimal time){
			 this.srt = srt;
			 this.end = end;
			 this.time = time;
		 }

		@Override
		public int compareTo(Log o) {
			
			if(o.srt.compareTo(this.srt) > 0){
				return 1;
			}else if(o.srt == this.srt){
				if(o.end.compareTo(this.end) > 0){
					return 1;
				}
			}
			
			return 0;
		}
	 }
}
