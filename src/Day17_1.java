import java.io.*;
public class Day17_1 {
	public static void main(String[] args) throws IOException{
		//part 2:
//	      int N = 303;
//	      long afHead = 1;
//	      long cur = 1;
//	      for(long i = 2; i <= 50000000; i++) {
//	         if((cur+N)%(i)==0){
//	            afHead=i;
//	         }
//	         cur=(cur+N)%(i)+1;
//	      }
//	      System.out.println(afHead);
		//part 1:
		int N = 303;
		Node17 head = new Node17(0,null);
		head.setNext(head);
		Node17 temp = head;
		for(int i = 1; i < 2018; i++) {
			for(int j = 0; j < N; j++) {
				temp=temp.getNext();
			}
			temp.setNext(new Node17(i,temp.getNext()));
			temp=temp.getNext();
		}
		System.out.print(temp.getNext().getValue());
	}
}
class Node17{
	private int value;
	private Node17 next;
	public Node17(int v, Node17 n) {
		value = v;
		next = n;
	}
	public int getValue() {
		return value;
	}
	public Node17 getNext() {
		return next;
	}
	public void setValue(int v) {
		value = v;
	}
	public void setNext(Node17 n) {
		next = n;
	}
}
