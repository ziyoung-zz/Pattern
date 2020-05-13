package alis.uwissu.psnluw.rissrnwl.online.pc;


public class Test {

	//60059
	public static void main(String[] args){
		
		int[][] key = {{0,0,0},{1,0,0},{0,1,1}};
		int[][] lock = {{1,1,1},{1,1,0},{1,0,1}};
		System.out.println(solution(key,lock));
	}
	
    public static boolean solution(int[][] key, int[][] lock) {
        
        int[][] key1 = rollkey(key);
        int[][] key2 = rollkey(key1);
        int[][] key3 = rollkey(key2);
        
        int[][] map = new int[lock.length*3][lock.length*3];
        for(int i=0 ; i<lock.length ; i++){
        	for(int j=0 ; j<lock.length ; j++){
            	map[i+lock.length][j+lock.length] = lock[i][j];
            }
        }
        
        
        for(int i=0 ; i<lock.length*2 ; i++){
        	for(int j=0 ; j<lock.length*2 ; j++){
        		
        		int[][] temp = copy(map);
        		if(findmatch(temp,key,i,j,lock.length))return true;
        		int[][] temp2 = copy(map);
        		if(findmatch(temp2,key1,i,j,lock.length)) return true;
        		int[][] temp3 = copy(map);
        		if(findmatch(temp3,key2,i,j,lock.length)) return true;
        		int[][] temp4 = copy(map);
        		if(findmatch(temp4,key3,i,j,lock.length)) return true;
        	}
        }
        
        return false;
    }    
    
    private static int[][] copy(int[][] original2) {
        if(original2 == null) return null;
        int[][] result = new int[original2.length][original2[0].length];
         
        for(int i=0; i<original2.length; i++){
            System.arraycopy(original2[i], 0, result[i], 0, original2[0].length);
        }
         
        return result;
    }
    
    private static boolean findmatch(int[][] map, int[][] key, int ki, int kj, int lockSize){
    	
    	for(int i=0 ; i<key.length ; i++){
    		for(int j=0 ; j<key.length ; j++){
        		map[i+ki][j+kj] += key[i][j];
        	}
    	}    
    	
    	 for(int i=0 ; i<lockSize ; i++){
         	for(int j=0 ; j<lockSize ; j++){
             	if(map[i+lockSize][j+lockSize] !=1) return false;
             }
         }
    	
    	return true;
    }
    
    private static int[][] rollkey(int[][] key){
    	
    	int[][] newkey = new int[key.length][key.length];
    	
    	for(int i=0 ; i<key.length ; i++){
    		for(int j=0 ; j<key.length ; j++){
    			newkey[j][key.length-1-i] = key[i][j];
    		}
    	}
    	
    	return newkey;
    }
}
