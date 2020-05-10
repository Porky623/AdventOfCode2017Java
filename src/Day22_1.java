import java.util.*;
import java.io.*;
public class Day22_1 {
   private static boolean[][] grid;
   private static int[][] grid2;
   private static int x,y,dir;
   private static int count1;
   public static void main(String[] args) throws IOException{
      //HashMap<Character,Boolean> onOff = new HashMap<Character,Boolean>();
      //onOff.put('.', false);
      //onOff.put('#',true);
	   HashMap<Character,Integer> toState = new HashMap<Character,Integer>();
	   toState.put('.', 0);
	   toState.put('#',2);
      count1=0;
      /*grid = new boolean[1001][1001];
      for(int i = 0; i < 1001; i++) {
         for(int j = 0; j < 1001; j ++) {
            grid[i][j]=false;
         }
      }*/
      grid2=new int[1001][1001];
      for(int i = 0; i < 1001; i++) {
    	  for(int j = 0; j < 1001; j++) {
    		  grid2[i][j]=0;
    	  }
      }
      Scanner f = new Scanner(new File("inputs.txt"));
      /*for(int i = 0; i < 25; i++) {
         String k = f.nextLine();
         for(int j = 0; j < 25; j++) {
            grid[489+i][489+j]=onOff.get(k.charAt(j));
         }
      }*/
      for(int i = 0; i < 25; i++) {
    	  String k = f.nextLine();
    	  for(int j = 0; j < 25; j++) {
    		  grid2[489+i][489+j]=toState.get(k.charAt(j));
    	  }
      }
      x=y=501;
      dir=0;
      for(int i = 0; i < 10000000; i++) {
    	  burst2();
      }
      /*x=y=501;
      dir=0;
      for(int i = 0; i < 10000; i++) {
         burst();
      }*/
      System.out.println(count1);
   }
   private static void burst2() {
	   if(grid2[x][y]==0) {
		   dir=(dir+3)%4;
	   }
	   else if(grid2[x][y]==1) {
		   count1++;
	   }
	   else if(grid2[x][y]==2) {
		   dir=(dir+1)%4;
	   }
	   else if(grid2[x][y]==3) {
		   dir=(dir+2)%4;
	   }
	   grid2[x][y]=(grid2[x][y]+1)%4;
	   switch(dir){
	   case 0:
		   x--;
		   return;
	   case 1:
		   y++;
		   return;
	   case 2:
		   x++;
		   return;
	   case 3:
		   y--;
		   return;
	   }
   }
   private static void burst() {
      if(grid[x][y]) {
         dir=(dir+1)%4;
      }
      else {
         dir=(dir+4-1)%4;
         count1++;
      }
      grid[x][y]=!grid[x][y];
      switch(dir) {
         case 0:
            x--;
            return;
         case 1:
            y++;
            return;
         case 2:
            x++;
            return;
         case 3:
            y--;
            return;
      }
   }
}
