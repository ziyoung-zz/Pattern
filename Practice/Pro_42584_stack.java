package alis.uwissu.psnluw.rissrnwl.online.pc;

import java.util.ArrayList;

public class Test {

	//42584
	public static void main(String[] args){
		
		int[] prices = {5,4,3,4,5};
		int[] result = solution(prices);
		
		for(int i=0 ; i<result.length ; i++){
			System.out.print(result[i]);
		}
	}

	public static int[] solution(int[] prices) {
		 int[] answer = new int[prices.length];
		 ArrayList<Pos> posList = new ArrayList<>();
		 posList.add(new Pos(0,prices[0],0));
		 
		 for(int i=1 ; i<prices.length ; i++){
			 
			 for(int j=0 ; j<posList.size() ; j++){
				 posList.get(j).addTime();
			 }
			 
			 boolean flag = true;
			 while(flag && posList.size() >0){
				 Pos pos = posList.get(posList.size() - 1);
				 if(pos.price > prices[i]){
					 answer[pos.pos] = pos.time;
					 posList.remove(posList.size() - 1);
				 }else{
					 flag = false;
				 }
			 }			
			 posList.add(new Pos(i,prices[i],0));
		 }
		 
		 for(int i=0 ; i<posList.size() ; i++){
			 Pos pos = posList.get(i);
			 answer[pos.pos] = pos.time;
		 }
		 
	     return answer;
    }
	
	static class Pos{
		int pos;
		int price;
		int time;
		Pos(int pos, int price, int time){
			this.pos = pos;
			this.price = price;
			this.time = time;
		}
		
		private void addTime(){
			this.time++;
		}
	}
}
