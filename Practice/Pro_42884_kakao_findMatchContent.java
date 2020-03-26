package alis.uwissu.psnluw.rissrnwl.online.pc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	//42884
	public static void main(String[] args) {
		
		String word = "Muzi";
		String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};
		
		System.out.println(solution(word, pages));
	}

	public static int solution(String word, String[] pages) {
	        
	        String url = "";
	        ArrayList<String> linkedPage = null;
	        HashMap<String, Page> map = new HashMap<>();
	        ArrayList<Page> pList = new ArrayList<>();
	        
	        for(int i=0; i<pages.length ; i++){
	        	String page = pages[i];
	        	page = page.toLowerCase();
	        	
	        	Pattern pattern = Pattern.compile("<meta property=\"og:url\" content=\"https://(.+?)\"/>");
	        	Matcher matcher = pattern.matcher(page);
	        	while(matcher.find()){
	        		url = matcher.group(1);
	        	}
	        	
	        	pattern = Pattern.compile("<a href=\"https://(.+?)\">");
	        	matcher = pattern.matcher(page);
	        	String linkpage = "";
	        	linkedPage = new ArrayList<String>();
	        	while(matcher.find()){
	        		linkpage = matcher.group(1);
	        		linkedPage.add(linkpage);
	        	}
	        	
	        	Page p = new Page(url,linkedPage, page,i);
	        	p.findMatches(word);
	        	map.put(p.url, p);
	        	pList.add(p);
	        }
	        
	        //외부링크갯수 합산
	        for(Page p : pList){
	        	p.addLinkedCnt(map);
	        }

	        Collections.sort(pList);
	      
	        return pList.get(0).idx;
	    }
	
	static class Page implements Comparable<Page>{
		
		String url;
		ArrayList<String> linkedPage;
		String contents;
		double mCnt;
		double likCnt;
		int idx;
		
		Page(String url, ArrayList<String> linkedPage, String contents, int idx){
			this.url = url;
			this.linkedPage = linkedPage;
			this.contents = contents;
			this.mCnt = 0;
			this.idx = idx;
		}
		
		public void findMatches(String word){
			
			String match = "[^\uAC00-\uD7A3xfea-zA-Z\\s]";
			contents =contents.replaceAll(match, " "); //특수문자제거
			String[] strList= contents.split("\\s+");// 공백제거
			word = word.toLowerCase();
			
			for(String str:strList){
				if(str.equals(word)){
					this.mCnt++;
				}
			}
		}
		
		public void addLinkedCnt(HashMap<String, Page> map){
			for(String lpage : linkedPage){
				Page p = map.get(lpage);
				if(p != null){
					double cnt =  (double) this.mCnt/this.linkedPage.size();
					p.likCnt += cnt;
				}
			}
		}

		@Override
		public int compareTo(Page o) {
			
			double tCnt = this.mCnt + this.likCnt;
			double oCnt = o.mCnt + o.likCnt;
			
			if(tCnt < oCnt){
				return 1;
			}else if(tCnt == oCnt){
				if(this.idx > o.idx) return 1;
			}
			return -1;
		}
	}
	
	 
}
