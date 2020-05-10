import java.io.*;
import java.util.*;
public class Day18_3 {
   private static String[][] in;
   public static void main(String[] args) throws IOException {
      Scanner f = new Scanner(new File("inputs.txt"));
      in=new String[41][3];
      int ind = 0;
      while(f.hasNextLine()) {
         String k = f.nextLine();
         in[ind]=k.split(" ");
         ind++;
      }
      Program p1 = new Program(in,null,0);
      Program p2 = new Program(in,p1,1);
      p1.setOth(p2);
      int count = 0;
      int count2 = 0;
      while(p1.hasNext()||p2.hasNext()) {
         if(p1.hasNext()) {
            if(p1.next()) {
               count++;
            }
         }
         if(p2.hasNext()) {
        	 if(p2.next())
        		 count2++;
         }
      }
      System.out.println(count);
      System.out.println(count2);
   }
}
class Program{
   private String[][] in;
   private HashMap<Character,Long> map;
   private ArrayList<Long> queue;
   private int index;
   private Program other;
   public Program(String[][] x,Program oth, int y) {
      map=new HashMap<Character,Long>();
      queue=new ArrayList<Long>();
      in=x;
      index = 0;
      other=oth;
      map.put('p', (long)y);
   }
   public boolean next() {
      if(!map.containsKey(in[index][1].charAt(0))) {
         map.put(in[index][1].charAt(0), (long)0);
      }
      switch(in[index][0]) {
         case "set":
            map.put(in[index][1].charAt(0), valOf(in[index][2]));
            index++;
            return false;
         case "add":
            map.put(in[index][1].charAt(0), valOf(in[index][2])+valOf(in[index][1]));
            index++;
            return false;
         case "mul":
            map.put(in[index][1].charAt(0), valOf(in[index][2])*valOf(in[index][1]));
            index++;
            return false;
         case "mod":
            map.put(in[index][1].charAt(0), valOf(in[index][1])%valOf(in[index][2]));
            index++;
            return false;
         case "jgz":
            long k = valOf(in[index][1]);
            if(k>0)
               index+=valOf(in[index][2]);
            else
               index++;
            return false;
         case "snd":
            other.addQ(valOf(in[index][1]));
            index++;
            return true;
         case "rcv":
            map.put(in[index][1].charAt(0), queue.get(queue.size()-1));
            queue.remove(queue.size()-1);
            index++;
            return false;
      }
      return false;
   }
   public void addQ(long x) {
      queue.add(0,x);
   }
   public void setOth(Program oth) {
      other=oth;
   }
   public boolean hasNext() {
      if(index<0||index>40)
         return false;
      if(!in[index][0].equals("rcv"))
         return true;
      if(queue.size()>0)
         return true;
      return false;
   }
   private long valOf(String k) {
      if(!Character.isLetter(k.charAt(0))){
         return Long.parseLong(k);
      }
      return map.get(k.charAt(0));
   }
}