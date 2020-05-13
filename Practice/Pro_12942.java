
public class Test {

   ////12942
   public static void main(String[] args){
      
      int[][]matrix_sizes = {{5,3},{3,10},{10,6}};  //
      System.out.println(solution(matrix_sizes));
   }

 
   static int[][] m ;
   static int[][] dparr;
   public static int solution(int[][] matrix_sizes) {
    	m = matrix_sizes;
        dparr = new int[m.length][m.length];
        return dp(0,m.length-1);
   }
   
   private static int dp(int srt, int end){
	   if(srt == end) return 0;
	   if(dparr[srt][end] !=0 ) return dparr[srt][end];
	   
	   int min = Integer.MAX_VALUE;
	   for(int i=srt ; i<end ; i++){
		   min = Math.min(min, dp(srt,i) + dp(i+1,end) + m[srt][0] * m[i][1] * m[end][1]);
	   }
	   dparr[srt][end] = min;
	   
	   return min;
   }

//처음 잘못생각한거   
//    private static int dp(int n, int[][] m, int srt, int end){
//       
//        if(dparr[srt][end] != -1) return dparr[srt][end];
//    	
//       if(n == 2){
//          return dparr[srt][end] = m[srt][0] * m[srt][1] * m[end][1];
//       }else{
//          
//          return dparr[srt][end] = Math.min(dp(n-1,m,srt,end-1)+m[srt][0]*m[end][0]*m[end][1] , dp(n-1,m,srt+1,end)+ m[srt][0]*m[srt][1]*m[end][1]);          
//       }      
//    } 
    
}