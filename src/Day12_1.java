import java.util.*;
import java.io.*;
public class Day12_1 {
   public static void main(String[] args) throws IOException {
      Scanner f = new Scanner(new File("inputs.txt"));
      List<List<Integer>> connections = new ArrayList<List<Integer>>(7);
      int index = 0;
      while(f.hasNextLine()) {
         StringTokenizer st = new StringTokenizer(f.nextLine());
         st.nextToken();
         st.nextToken();
         connections.add(new ArrayList<Integer>());
         while(st.hasMoreTokens()) {
            String[] k = st.nextToken().split(",");
            String s = k[0];
            connections.get(index).add(Integer.parseInt(s));
         }
         index++;
      }
      List<Integer> visited = new ArrayList<Integer>();
      visited = findPaths(connections,visited,0);
      int count = 1;
      while(visited.size()<2000) {
    	  for(int i = 0; i < 2000; i++) {
    		  if(!visited.contains(i)) {
    			  visited=findPaths(connections,visited,i);
    			  count++;
    		  }
    	  }
      }
      System.out.println(count);
   }
   private static List<Integer> findPaths(List<List<Integer>> connections,List<Integer> visited,int node) {
      visited.add(node);
      boolean hasNew = false;
      for(int a : connections.get(node)) {
         if(!visited.contains(a)) {
            visited=findPaths(connections,visited,a);
            hasNew = true;
         }
      }
      if(!hasNew) {
         return visited;
      }
      return visited;
   }
}
