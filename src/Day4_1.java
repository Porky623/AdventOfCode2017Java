import java.util.*;
import java.io.*;
public class Day4_1 {
	private static HashMap<Character,Integer> letters;
	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("inputs.txt"));
		int count = 0;
		letters = new HashMap<Character,Integer>()
				{{
					put('a',1);
					put('b',2);
					put('c',3);
					put('d',4);
					put('e',5);
					put('f',6);
					put('g',7);
					put('h',8);
					put('i',9);
					put('j',10);
					put('k',11);
					put('l',12);
					put('m',13);
					put('n',14);
					put('o',15);
					put('p',16);
					put('q',17);
					put('r',18);
					put('s',19);
					put('t',20);
					put('u',21);
					put('v',22);
					put('w',23);
					put('x',24);
					put('y',25);
					put('z',26);
				}};
		while(f.hasNextLine()) {
			String s = f.nextLine();
			String[] input = s.split(" ");
			int[][] x = new int[input.length][26];
			boolean is = true;
			for(int i = 0; i < input.length; i++) {
				int[] a = findArray(input[i]);
				if(contains(x,a))
					is = false;
				x[i] = a;
			}
			if(is)
				count++;
		}
		System.out.println(""+count);
	}
	public static int[] findArray(String s) {
		int[] temp = new int[26];
		for(int i = 0; i < 26; i++) {
			temp[i] = 0;
		}
		for(int i = 0; i < s.length(); i++) {
			temp[letters.get(s.charAt(i))-1]++;
		}
		return temp;
	}
	public static boolean contains(int[][] x,int[] a) {
		for(int i = 0; i < x.length; i++) {
			boolean equal = true;
			check:
			for(int j = 0; j < 26; j++) {
				if(x[i][j]!=a[j])
				{
					equal = false;
					break check;
				}
			}
			if(equal)
				return true;
		}
		return false;
	}
}
