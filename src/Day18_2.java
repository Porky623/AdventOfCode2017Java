//import java.util.*;
//import java.io.*;
//public class Day18_2 {
//	private static ArrayList<Integer> q1, q2;
//   public static void main(String[] args) throws IOException{
//      Scanner f = new Scanner(new File("inputs.txt"));
//      String[][] inputs = new String[41][3];
//      for(int i = 0; i < 41; i++) {
//         StringTokenizer j = new StringTokenizer(f.nextLine());
//         inputs[i][0]=j.nextToken();
//         inputs[i][1]=j.nextToken();
//         if(!(inputs[i][0].equals("snd")||inputs[i][0].equals("rcv")))
//            inputs[i][2]=j.nextToken();
//      }
//      q1=new ArrayList<Integer>();
//      q2=new ArrayList<Integer>();
//      /*HashMap<Character,Double> registers2 = new HashMap<Character,Double>();
//      registers2.put('p',(double)0);
//      int index = 0;
//      boolean cont = true;
//      ArrayList<Double> played = new ArrayList<Double>();
//      while(cont) {
//          if(!registers2.containsKey(inputs[index][1].charAt(0))&&Character.isLetter(inputs[index][1].charAt(0))) {
//             registers2.put(inputs[index][1].charAt(0), (double)0);
//          }
//          switch(inputs[index][0]) {
//             case "snd":
//                if(Character.isLetter(inputs[index][1].charAt(0)))
//                   played.add(registers2.get(inputs[index][1].charAt(0)));
//                else
//                   played.add(Double.parseDouble(inputs[index][1]));
//                index++;
//                break;
//             case "set":
//                if(Character.isLetter(inputs[index][2].charAt(0)))
//                   registers2.put(inputs[index][1].charAt(0), registers2.get(inputs[index][2].charAt(0)));
//                else
//                   registers2.put(inputs[index][1].charAt(0), Double.parseDouble(inputs[index][2]));
//                index++;
//                break;
//             case "add":
//                if(Character.isLetter(inputs[index][2].charAt(0)))
//                   registers2.put(inputs[index][1].charAt(0), registers2.get(inputs[index][2].charAt(0))+(registers2.get(inputs[index][1].charAt(0))));
//                else
//                   registers2.put(inputs[index][1].charAt(0), registers2.get(inputs[index][1].charAt(0))+Double.parseDouble(inputs[index][2]));
//                index++;
//                break;
//             case "mul":
//                if(Character.isLetter(inputs[index][2].charAt(0)))
//                   registers2.put(inputs[index][1].charAt(0), registers2.get(inputs[index][2].charAt(0))*(registers2.get(inputs[index][1].charAt(0))));
//                else
//                   registers2.put(inputs[index][1].charAt(0), registers2.get(inputs[index][1].charAt(0))*(Double.parseDouble(inputs[index][2])));
//                index++;
//                break;
//             case "mod":
//                if(Character.isLetter(inputs[index][2].charAt(0)))
//                   registers2.put(inputs[index][1].charAt(0), registers2.get(inputs[index][1].charAt(0))%(registers2.get(inputs[index][2].charAt(0))));
//                else
//                   registers2.put(inputs[index][1].charAt(0), registers2.get(inputs[index][1].charAt(0))%Double.parseDouble(inputs[index][2]));
//                index++;
//                break;
//             case "rcv":
//            	 if(registers2.get(inputs[index][1].charAt(0))!=0)
//            		 cont=false;
//            	 else
//                index++;
//                break;
//             case "jgz":
//                if(inputs[index][1].equals("1")){
//                   index+=3;
//                }
//                else if(registers2.get(inputs[index][1].charAt(0))>0&&Character.isLetter(inputs[index][2].charAt(0))) {
//                    index+=registers2.get(inputs[index][2].charAt(0)).intValue();
//                }
//                else if(registers2.get(inputs[index][1].charAt(0))>0)
//                    index+=Long.parseLong(inputs[index][2]);
//                else
//                   index++;
//                break;
//          }
//       }
//      System.out.println(played);*/
//      
//   }
//   private static void run(HashMap<Character,Double> reg, int[] indices, String[][] in, int qwe) {
//       if(!reg.containsKey(in[indices[1]][1].charAt(0))&&Character.isLetter(in[indices[1]][1].charAt(0))) {
//           reg.put(in[indices[1]][1].charAt(0), (double)0);
//        }
//        switch(in[indices[qwe]][0]) {
//           case "snd":
//        	   if(qwe==0) {
//        		   q1.add(valOf(in[indices[0][1]],0));
//        	   }
//              if(Character.isLetter(in[index][1].charAt(0)))
//                 played.add(reg.get(in[index][1].charAt(0)));
//              else
//                 played.add(Double.parseDouble(in[index][1]));
//              index++;
//              break;
//           case "set":
//              if(Character.isLetter(in[index][2].charAt(0)))
//                 reg.put(in[index][1].charAt(0), reg.get(in[index][2].charAt(0)));
//              else
//                 reg.put(in[index][1].charAt(0), Double.parseDouble(in[index][2]));
//              index++;
//              break;
//           case "add":
//              if(Character.isLetter(in[index][2].charAt(0)))
//                 reg.put(in[index][1].charAt(0), reg.get(in[index][2].charAt(0))+(reg.get(in[index][1].charAt(0))));
//              else
//                 reg.put(in[index][1].charAt(0), reg.get(in[index][1].charAt(0))+Double.parseDouble(in[index][2]));
//              index++;
//              break;
//           case "mul":
//              if(Character.isLetter(in[index][2].charAt(0)))
//                 reg.put(in[index][1].charAt(0), reg.get(in[index][2].charAt(0))*(reg.get(in[index][1].charAt(0))));
//              else
//                 reg.put(in[index][1].charAt(0), reg.get(in[index][1].charAt(0))*(Double.parseDouble(in[index][2])));
//              index++;
//              break;
//           case "mod":
//              if(Character.isLetter(in[index][2].charAt(0)))
//                 reg.put(in[index][1].charAt(0), reg.get(in[index][1].charAt(0))%(reg.get(in[index][2].charAt(0))));
//              else
//                 reg.put(in[index][1].charAt(0), reg.get(in[index][1].charAt(0))%Double.parseDouble(in[index][2]));
//              index++;
//              break;
//           case "rcv":
//          	 if(reg.get(in[index][1].charAt(0))!=0)
//          		 cont=false;
//          	 else
//              index++;
//              break;
//           case "jgz":
//              if(in[index][1].equals("1")){
//                 index+=3;
//              }
//              else if(reg.get(in[index][1].charAt(0))>0&&Character.isLetter(in[index][2].charAt(0))) {
//                  index+=reg.get(in[index][2].charAt(0)).intValue();
//              }
//              else if(reg.get(in[index][1].charAt(0))>0)
//                  index+=Long.parseLong(in[index][2]);
//              else
//                 index++;
//              break;
//        }
//   }
//   private static double valOf(String k,int i) {
//	   if(i==0) {
//		   if(!Character.isLetter(k.charAt(0))) {
//			   return Double.parseDouble(k);
//		   }
//		   else
//			   return r1.get(k.charAt(0));
//	   }
//	   else {
//		   if(!Character.isLetter(k.charAt(0))) {
//			   return Double.parseDouble(k);
//		   }
//		   else
//			   return r2.get(k.charAt(0));
//	   }
//   }
//}
///*
//set i 31
//set a 1
//mul p 17
//jgz p p
//mul a 2
//add i -1
//jgz i -2
//add a -1
//set i 127
//set p 735
//mul p 8505
//mod p a
//mul p 129749
//add p 12345
//mod p a
//set b p
//mod b 10000
//snd b
//add i -1
//jgz i -9
//jgz a 3
//rcv b
//jgz b -1
//set f 0
//set i 126
//rcv a
//rcv b
//set p a
//mul p -1
//add p b
//jgz p 4
//snd a
//set a b
//jgz 1 3
//snd b
//set f 1
//add i -1
//jgz i -11
//snd a
//jgz f -16
//jgz a -19
//*/