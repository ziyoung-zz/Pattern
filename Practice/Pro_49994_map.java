
import java.util.HashMap;

public class Test {

   //49994
   public static void main(String[] args){
	   
	   String dir = "ULURRDLLU";
	   //ULURRDLLU
	   //LULLLLLLU
	   System.out.println(solution(dir));
	   
   }   
   
   public static int solution(String dirs) {
       int answer = 0;
       HashMap<Pos, HashMap<String, Integer>> map = new HashMap<>();               
       int x = 5;
       int y = 5;      
       int ox=0;
	   int oy=0;
       
       for(int i=0 ; i<dirs.length() ; i++){
    	   
    	   String pos = Character.toString(dirs.charAt(i));
    	   ox=x;
    	   oy=y;
    	   String opos = null;
    	   
    	   if("U".equals(pos) && y<10){
    		   y+=1;
    		   opos = "D";
    	   }else if("D".equals(pos) && y>0){
    		   y-=1;
    		   opos = "U"; 
    	   }else if("R".equals(pos) && x<10){
    		   x+=1;
    		   opos = "L";  
    	   }else if("L".equals(pos) && x>0){
    		   x-=1;
    		   opos = "R"; 
    	   }else{
    		   continue;
    	   }    	 
	   
    	   
    	   Pos p = new Pos(x,y);
    	   Pos op = new Pos(ox,oy);
    	   
    	   HashMap<String, Integer> pMap = new HashMap<>();
    	   HashMap<String, Integer> opMap = new HashMap<>();
    	  
    	   if(!map.containsKey(p) && !map.containsKey(op)){
    	   }else{
    		   if(map.containsKey(p)) pMap = map.get(p);
    		   if(map.containsKey(op)) opMap = map.get(op);
    	   }
    	   
    	   if(!pMap.containsKey(pos) && !opMap.containsKey(opos)){
    		   answer++;
    	   }
    	      	   
    	   pMap.put(pos, 1);
    	   opMap.put(opos, 1);
    	   map.put(p, pMap);
    	   map.put(op, opMap);
    	   
       }
  
       return answer;
   }
   
   static class Pos{
	   int x;
	   int y;
	  
	   Pos(int x, int y ){
		   this.x = x;
		   this.y = y;
	   }
	   
	    @Override
	    public boolean equals(Object o) {
	        if(this == o) return true;    
	        if(o == null || getClass() != o.getClass()) return false;
	        
	        Pos other = (Pos)o;
	        
	        return other.x == x && other.y == y;
	    }
	    
	    @Override
	    public int hashCode() {
	        int result = (int)(x ^ (x >>> 32));
	        
	        result = 31 * result + (int)(y ^ (y >>> 32));
	        
	        return result;
	    }
   }
}