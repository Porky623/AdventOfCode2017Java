import java.util.*;
import java.io.*;
public class Day18_1 {
   public static void main(String[] args) throws IOException{
      Scanner f = new Scanner(new File("inputs.txt"));
      String[][] inputs = new String[7][3];
      for(int i = 0; i < 7; i++) {
         StringTokenizer j = new StringTokenizer(f.nextLine());
         inputs[i][0]=j.nextToken();
         inputs[i][1]=j.nextToken();
         if(!(inputs[i][0].equals("snd")||inputs[i][0].equals("rcv")))
            inputs[i][2]=j.nextToken();
      }
      HashMap<Character,Double> registers1 = new HashMap<Character,Double>();
      registers1.put('p',(double)0);
      HashMap<Character,Double> registers2 = new HashMap<Character,Double>();
      registers2.put('p',(double)1);
      ArrayList<Double> queue2 = new ArrayList<Double>();
      ArrayList<Double> queue1 = new ArrayList<Double>();
      int[] indices = new int[] {0,0};
      int[] count = new int[] {0};
      run1(registers1,registers2,indices,inputs,queue1,queue2,count);
      run2(registers1,registers2,indices,inputs,queue1,queue2);
      int count2 = 1;
      for(int i = 2; i < 58; i++) {
          run1(registers1,registers2,indices,inputs,queue1,queue2,count);
          run2(registers1,registers2,indices,inputs,queue1,queue2);
          count2++;
      }
      run1(registers1,registers2,indices,inputs,queue1,queue2,count);
      System.out.println(count[0]);
      System.out.println(count2);
   }
   private static int run2(HashMap<Character,Double> registers1, HashMap<Character,Double> registers2,int[] indices,String[][] inputs, ArrayList<Double> queue1,ArrayList<Double>queue2) {
      int term2 = 0;
      loop2:
      while(true) {
         if(indices[1]<0||indices[1]>40) {
            term2=-1;
            break loop2;
         }
         if(!registers2.containsKey(inputs[indices[1]][1].charAt(0))&&Character.isLetter(inputs[indices[1]][1].charAt(0))) {
            registers2.put(inputs[indices[1]][1].charAt(0), (double)0);
         }
         switch(inputs[indices[1]][0]) {
            case "snd":
               if(Character.isLetter(inputs[indices[1]][1].charAt(0)))
                  queue1.add(registers2.get(inputs[indices[1]][1].charAt(0)));
               else
                  queue1.add(Double.parseDouble(inputs[indices[1]][1]));
               indices[1]++;
               break;
            case "set":
               if(Character.isLetter(inputs[indices[1]][2].charAt(0)))
                  registers2.put(inputs[indices[1]][1].charAt(0), registers2.get(inputs[indices[1]][2].charAt(0)));
               else
                  registers2.put(inputs[indices[1]][1].charAt(0), Double.parseDouble(inputs[indices[1]][2]));
               indices[1]++;
               break;
            case "add":
               if(Character.isLetter(inputs[indices[1]][2].charAt(0)))
                  registers2.put(inputs[indices[1]][1].charAt(0), registers2.get(inputs[indices[1]][2].charAt(0))+(registers2.get(inputs[indices[1]][1].charAt(0))));
               else
                  registers2.put(inputs[indices[1]][1].charAt(0), registers2.get(inputs[indices[1]][1].charAt(0))+Double.parseDouble(inputs[indices[1]][2]));
               indices[1]++;
               break;
            case "mul":
               if(Character.isLetter(inputs[indices[1]][2].charAt(0)))
                  registers2.put(inputs[indices[1]][1].charAt(0), registers2.get(inputs[indices[1]][2].charAt(0))*(registers2.get(inputs[indices[1]][1].charAt(0))));
               else
                  registers2.put(inputs[indices[1]][1].charAt(0), registers2.get(inputs[indices[1]][1].charAt(0))*(Double.parseDouble(inputs[indices[1]][2])));
               indices[1]++;
               break;
            case "mod":
               if(Character.isLetter(inputs[indices[1]][2].charAt(0)))
                  registers2.put(inputs[indices[1]][1].charAt(0), registers2.get(inputs[indices[1]][1].charAt(0))%(registers2.get(inputs[indices[1]][2].charAt(0))));
               else
                  registers2.put(inputs[indices[1]][1].charAt(0), registers2.get(inputs[indices[1]][1].charAt(0))%Double.parseDouble(inputs[indices[1]][2]));
               indices[1]++;
               break;
            case "rcv":
               if(queue2.size()>0) {
                  registers2.put(inputs[indices[1]][1].charAt(0), queue2.get(0));
                  queue2.remove(0);
               }
               else{
                  return 1;
               }
               indices[1]++;
               break;
            case "jgz":
               if(inputs[indices[1]][1].equals("1")){
                  indices[1]+=3;
               }
               else if(registers2.get(inputs[indices[1]][1].charAt(0))>0&&Character.isLetter(inputs[indices[1]][2].charAt(0))) {
                   indices[1]+=registers2.get(inputs[indices[1]][2].charAt(0)).intValue();
               }
               else if(registers2.get(inputs[indices[1]][1].charAt(0))>0)
                   indices[1]+=Long.parseLong(inputs[indices[1]][2]);
               else
                  indices[1]++;
               break;
         }
      }
      return term2;
   }
   private static int run1(HashMap<Character,Double> registers1, HashMap<Character,Double> registers2,int[] indices, String[][] inputs, ArrayList<Double> queue1,ArrayList<Double> queue2, int[] count) {
	   int term2 = 0;
	      loop2:
	      while(true) {
	         if(indices[0]<0||indices[0]>40) {
	            return -1;
	         }
	         if(!registers1.containsKey(inputs[indices[0]][1].charAt(0))&&Character.isLetter(inputs[indices[0]][1].charAt(0))) {
	            registers1.put(inputs[indices[0]][1].charAt(0), (double)0);
	         }	         switch(inputs[indices[0]][0]) {
	            case "snd":
	            	count[0]++;
	            	queue2.add(registers1.get(inputs[indices[0]][1].charAt(0)));
	               indices[0]++;
	               break;
	            case "set":
	               if(Character.isLetter(inputs[indices[0]][2].charAt(0)))
	                  registers1.put(inputs[indices[0]][1].charAt(0), registers1.get(inputs[indices[0]][2].charAt(0)));
	               else
	                  registers1.put(inputs[indices[0]][1].charAt(0), Double.parseDouble(inputs[indices[0]][2]));
	               indices[0]++;
	               break;
	            case "add":
	               if(Character.isLetter(inputs[indices[0]][2].charAt(0)))
	                  registers1.put(inputs[indices[0]][1].charAt(0), registers1.get(inputs[indices[0]][2].charAt(0))+(registers1.get(inputs[indices[0]][1].charAt(0))));
	               else
	                  registers1.put(inputs[indices[0]][1].charAt(0), registers1.get(inputs[indices[0]][1].charAt(0))+(Double.parseDouble(inputs[indices[0]][2])));
	               indices[0]++;
	               break;
	            case "mul":
	               if(Character.isLetter(inputs[indices[0]][2].charAt(0)))
	                  registers1.put(inputs[indices[0]][1].charAt(0), registers1.get(inputs[indices[0]][2].charAt(0))*(registers1.get(inputs[indices[0]][1].charAt(0))));
	               else
	                  registers1.put(inputs[indices[0]][1].charAt(0), registers1.get(inputs[indices[0]][1].charAt(0))*(Double.parseDouble(inputs[indices[0]][2])));
	               indices[0]++;
	               break;
	            case "mod":
	               if(Character.isLetter(inputs[indices[0]][2].charAt(0)))
	                  registers1.put(inputs[indices[0]][1].charAt(0), registers1.get(inputs[indices[0]][1].charAt(0))%(registers1.get(inputs[indices[0]][2].charAt(0))));
	               else
	                  registers1.put(inputs[indices[0]][1].charAt(0), registers1.get(inputs[indices[0]][1].charAt(0))%(Double.parseDouble(inputs[indices[0]][2])));
	               indices[0]++;
	               break;
	            case "rcv":
	               if(queue1.size()>0) {
	                  registers1.put(inputs[indices[0]][1].charAt(0), queue1.get(0));
	                  queue1.remove(0);
	               }
	               else{
	                  return 1;
	               }
	               indices[0]++;
	               break;
	            case "jgz":
	               if(inputs[indices[0]][1].equals("1")){
	                  indices[0]+=3;
	               }
	               else if(registers1.get(inputs[indices[0]][1].charAt(0))>0&&Character.isLetter(inputs[indices[0]][2].charAt(0))) {
		                  indices[0]+=registers1.get(inputs[indices[0]][2].charAt(0)).intValue();
	               }
	               else if(registers1.get(inputs[indices[0]][1].charAt(0))>0)
		                  indices[0]+=Long.parseLong(inputs[indices[0]][2]);
	               else
	                  indices[0]++;
	               break;
	         }
	      }
   }
}