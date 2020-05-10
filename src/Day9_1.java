//import java.io.*;
//public class Day9_1 {
//	public static void main(String[] args) throws IOException{
//		BufferedReader f = new BufferedReader(new FileReader("inputs.txt"));
//		String input = f.readLine();
//		int garbage = 0;
//		int group = 0;
//		int level = 0;
//		Node current = new Node(3);
//		for(int i = 0; i < input.length(); i++) {
//			char c = input.charAt(i);
//			if(current.getCurrent()==4)
//				c='!';
//			Node next = current.getNext(c);
//			switch(next.getCurrent()) {
//			case 0:
//				level++;
//				break;
//			case 1:
//				group+=level--;
//				break;
//			case 2:
//				if(current.getCurrent()==2)
//					garbage++;
//			}
//			current = next;
//		}
////		int garbage = 0;
////		int group = 0;
////		int level = 0;
////		Node current = Node.CHAR;
////		for(int i = 0; i < input.length(); i++) {
////			char c = input.charAt(i);
////			if(current==Node.IGNORE)
////				c='!';
////			Node next = current.getNext(c);
////			switch(next) {
////			case START:
////				level++;
////				break;
////			case END:
////				group+=level--;
////				break;
////			case GARBAGE:
////				if(current == Node.GARBAGE)
////					garbage++;
////			}
////			current = next;
////		}
//		System.out.println(""+group);
//		System.out.println(""+garbage);
//		f.close();
//	}
////	enum Node{
////		START,END,GARBAGE,IGNORE,CHAR;
////		HashMap<Character,Node> changeMap = new HashMap<Character,Node>();
////		static {
////            Node.CHAR.add('{', Node.START);
////            Node.CHAR.add('}', Node.END);
////            Node.CHAR.add('<', Node.GARBAGE);
////            Node.START.add('}', Node.END);
////            Node.START.add('<', Node.GARBAGE);
////            Node.START.add(',', Node.CHAR);
////            Node.END.add('{', Node.START);
////            Node.END.add('<', Node.GARBAGE);
////            Node.END.add(',', Node.CHAR);
////            Node.GARBAGE.add('!', Node.IGNORE);
////            Node.GARBAGE.add('>', Node.CHAR);
////            Node.IGNORE.add('!', Node.GARBAGE);
////		}
////		private void add(char c, Node n) {
////			changeMap.put(c,n);
////		}
////		public Node getNext(char c) {
////			return changeMap.getOrDefault(c,this);
////		}
////	}
//}
///*class Node{
//	public static final int START=0;
//	public static final int END=1;
//	public static final int GARBAGE=2;
//	public static final int CHAR=3;
//	public static final int IGNORE=4;
//	private static int currentInt;
//	public Node(int x) {
//        currentInt = x;
//	}
//	public int getCurrent() {
//		return currentInt;
//	}
//	public Node getNext(char c) {
//		if(currentInt==START) {
//			if(c=='}')
//				return new Node(END);
//			if(c=='<')
//				return new Node(GARBAGE);
//			if(c==',')
//				return new Node(CHAR);
//		}
//		if(currentInt==END) {
//			if(c=='{')
//				return new Node(START);
//			if(c=='<')
//				return new Node(GARBAGE);
//			if(c==',')
//				return new Node(CHAR);
//		}
//		if(currentInt==GARBAGE) {
//			if(c=='!')
//				return new Node(IGNORE);
//			if(c=='>')
//				return new Node(CHAR);
//		}
//		if(currentInt==CHAR) {
//			if(c=='{')
//				return new Node(START);
//			if(c=='}')
//				return new Node(END);
//			if(c=='<')
//				return new Node(GARBAGE);
//		}
//		if(currentInt==IGNORE) {
//			if(c=='!')
//				return new Node(GARBAGE);
//		}
//		return new Node(currentInt);
//	}
//}*/