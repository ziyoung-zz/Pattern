import java.util.ArrayList;
import java.util.Iterator;
class Solution {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
	       
	       ArrayList<Truck> waitTruck = new ArrayList<>();
	        ArrayList<Truck> bridgeTruck = new ArrayList<>();
	        
	        for(int i=0 ; i<truck_weights.length ; i++) {
	        	Truck t = new Truck(truck_weights[i], bridge_length);
	        	waitTruck.add(t);
	        }
	        
	        int bridgeWeight = 0; //다리위 트럭무게
	        int answer = 0; //다리건너는 시간
	        int index = 0;
	        
	        
	     	while(true) {
	     		answer++;
	     		
	     		Iterator itr = bridgeTruck.iterator();
        		while(itr.hasNext()) {	 
        			
        			Truck bridge_t = (Truck)itr.next(); 
        			bridge_t.minusPos();
        			
        			if(bridge_t.getPos() == 0) {
        				bridgeWeight -= bridge_t.getWeight();
        				itr.remove();
        				
        				if(bridgeTruck.size() == 0 && index == waitTruck.size())  	
        					return answer;
        			}
        		}
        		
        		if(index == waitTruck.size()) {
        			continue;
        		}
        		
        		Truck t = waitTruck.get(index);
        		if(bridgeWeight + t.getWeight() < weight + 1 && bridgeTruck.size() < bridge_length + 1) {
	        		
	        		bridgeTruck.add(t);
	        		bridgeWeight += t.getWeight();
	        		index++;
	        	}
	
        	}
	     	
	  }
	
	static class Truck {
		 int weight;
		 int pos;
		 
		 Truck(int weight, int pos){
			 this.weight = weight;
			 this.pos = pos;
		 }
		 
		 void minusPos() {
			 this.pos --;
		 }
		 
		 int getWeight() {
			 return this.weight;
		 }
		 
		 int getPos() {
			 return this.pos;
		 }
	 }	
}