import java.util.*;
import java.io.*;
public class Day10_1 {
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("inputs.txt"));
      String input = "jzgqcdpd-0";
      int[] inputs = new int[input.length()+5];
      for(int i = 0; i < input.length(); i++) {
         inputs[i]=(int)input.charAt(i);
      }
      inputs[inputs.length-5]=17;
      inputs[inputs.length-4]=31;
      inputs[inputs.length-3]=73;
      inputs[inputs.length-2]=47;
      inputs[inputs.length-1]=23;
      int curIndex = 0;
      Node head = new Node(0,null);
      head.setNext(head);
      for(int i = 1; i < 256; i++) {
         head.setNext(new Node(i,head.getNext()));
         head = head.getNext();
      }
      head = head.getNext();
      int skip = 0;
      for(int k = 0; k < 64; k++) {
	      for(int i = 0; i < inputs.length; i++) {
	         Node temp = head;
	         for(int j = 1; j < inputs[i]; j++) {
	            temp=temp.getNext();
	         }
	         getLast(head).setNext(null);
	         Node alt = temp.getNext();
	         temp.setNext(null);
	         head=reverse(head);
	         temp = head;
	         while(temp.getNext()!=null)
	            temp=temp.getNext();
	         temp.setNext(alt);
	         if(alt!=null){
	            while(alt.getNext()!=null)
	               alt=alt.getNext();
	            alt.setNext(head);
	         }
	         else{
	            temp.setNext(head);
	         }
	         for(int j = 0; j < inputs[i]+skip; j++)
	            head=head.getNext();
	         curIndex=(curIndex+inputs[i]+skip)%256;
	         skip++;
	      }
      }
      for(int i = 1; i <= 256-curIndex; i++) {
         head=head.getNext();
      }
      int[] denseHash = new int[256];
      for(int i = 0; i < 256; i++) {
    	  denseHash[i]=head.getValue();
    	  head=head.getNext();
      }
      int[] spareHash=findSpare(denseHash);
      String end = "";
      for(int a : spareHash) {
    	  if(a>15)
    	  end+=Integer.toHexString(a);
    	  else
    		  end+="0"+Integer.toHexString(a);
      }
      System.out.println(end);
   }
   private static int[] findSpare(int[] denseHash) {
	   int[] temp = new int[16];
	   int[] end = new int[16];
	   for(int i = 0; i < 16; i++) {
		   for(int j = 0; j < 16; j++) {
			   temp[j]=denseHash[16*i+j];
		   }
		   int cur = temp[0];
		   for(int j = 1; j < 16; j++) {
			   cur=cur^temp[j];
		   }
		   end[i]=cur;
	   }
	   return end;
   }
   private static Node reverse(Node head) {
      if(head.getNext()==null) {
         return head;
      }
      Node temp = reverse(head.getNext());
      head.setNext(null);
      Node alt = temp;
      while(alt.getNext()!=null)
         alt=alt.getNext();
      alt.setNext(head);
      return temp;
   }
   private static Node getLast(Node head) {
      Node temp = head;
      while(temp.getNext()!=head)
         temp=temp.getNext();
      return temp;
   }
}
class Node{
   private int value;
   private Node next;
   public Node(int v, Node n) {
      value = v;
      next = n;
   }
   public void setValue(int v) {
      value = v;
   }
   public void setNext(Node n) {
      next = n;
   }
   public int getValue() {
      return value;
   }
   public Node getNext() {
      return next;
   }
}