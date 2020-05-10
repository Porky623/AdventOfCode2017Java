import java.util.*;
import java.io.*;
public class Day14_1 {
	public static void main(String[] args) throws IOException {
	      String st = "jzgqcdpd";
	      String[] ends = new String[128];
	      for(int qwer = 0; qwer < 128; qwer++) {
	      String input = st+"-"+qwer;
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
	      ends[qwer]=end;
		   }
	      HashMap<Character,boolean[]> h2b = new HashMap<Character,boolean[]>();
	      h2b.put('1',new boolean[]{false,false,false,true});
	      h2b.put('2',new boolean[] {false,false,true,false});
	      h2b.put('3',new boolean[] {false,false,true,true});
	      h2b.put('4', new boolean[] {false,true,false,false});
	      h2b.put('5',new boolean[] {false,true,false,true});
	      h2b.put('6',new boolean[] {false,true,true,false});
	      h2b.put('7',new boolean[] {false,true,true,true,});
	      h2b.put('8',new boolean[]{true,false,false,false});
	      h2b.put('9',new boolean[] {true,false,false,true});
	      h2b.put('a',new boolean[] {true,false,true,false});
	      h2b.put('b', new boolean[] {true,false,true,true});
	      h2b.put('c',new boolean[] {true,true,false,false});
	      h2b.put('d',new boolean[] {true,true,false,true});
	      h2b.put('e',new boolean[] {true,true,true,false});
	      h2b.put('f',new boolean[] {true,true,true,true});
	      h2b.put('0',new boolean[] {false,false,false,false,});
	      boolean[][] grid = new boolean[128][128];
	      int ones = 0;
	      for(int i = 0; i < 128; i++) {
	    	  String g = ends[i];
	    	  for(int j = 0; j < 32; j++) {
	    		  char c = g.charAt(j);
	    		  boolean[] ref = h2b.get(c);
	    		  for(int k = 0; k < 4; k++) {
	    			  if(ref[k])
	    				  ones++;
	    			  grid[i][4*j+k]=ref[k];
	    		  }
	    	  }
	      }
	      boolean[][] visited = new boolean[128][128];
	      for(int i = 0; i < 128; i++) {
	    	  for(int j = 0; j < 128; j++) {
	    		  visited[i][j]=false;
	    	  }
	      }
	      int count = 0;
	      for(int i = 0; i < 128; i++) {
	    	  for(int j = 0; j < 128; j++) {
	    			  int filled = fill(grid,visited,i,j);
	    			  ones-=filled;
	    			  if(filled>0)
	    				  count++;
	    	  }
	      }
	      System.out.println(count+" "+ones);
	}
	private static int fill(boolean[][] grid,boolean[][] visited,int i, int j) {
		if(i<0||j<0||i>127||j>127||visited[i][j]||!grid[i][j]) {
			return 0;
		}
		  visited[i][j]=true;
		  int fill = 1;
		  fill+=fill(grid,visited,i+1,j);
		  fill+=fill(grid,visited,i-1,j);
		  fill+=fill(grid,visited,i,j+1);
		  fill+=fill(grid,visited,i,j-1);
		  return fill;
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