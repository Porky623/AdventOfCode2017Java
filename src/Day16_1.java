import java.io.*;
import java.util.*;
public class Day16_1 {
	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("inputs.txt"));
		String input = f.next();
		String[] inputs = input.split(",");
		ArrayList<Character> programs = new ArrayList<Character>();
		List<ArrayList<Character>> seen = new ArrayList<ArrayList<Character>>();
		programs.add('a');
		programs.add('b');
		programs.add('c');
		programs.add('d');
		programs.add('e');
		programs.add('f');
		programs.add('g');
		programs.add('h');
		programs.add('i');
		programs.add('j');
		programs.add('k');
		programs.add('l');
		programs.add('m');
		programs.add('n');
		programs.add('o');
		programs.add('p');
		ArrayList<Character> temporary = new ArrayList<Character>();
		for(int i = 0; i < 16; i++) {
			temporary.add(programs.get(i));
		}
		seen.add(temporary);
		for(long r = 0; r < 40; r++) {
		for(int i = 0; i < inputs.length; i++) {
			if(inputs[i].charAt(0)=='s') {
				int a = Integer.parseInt(inputs[i].substring(1, inputs[i].length()));
				List<Character> newList = new ArrayList<Character>();
				for(int j= a; j > 0; j--) {
					newList.add(programs.get(16-j));
				}
				for(int j = 0; j < a; j++) {
					programs.remove(16-a);
				}
				for(int j = a-1; j >=0; j--) {
					programs.add(0, newList.get(j));
				}
			}
			else if(inputs[i].charAt(0)=='x') {
				String[] indices = inputs[i].substring(1, inputs[i].length()).split("/");
				int a = Integer.parseInt(indices[0]);
				int b = Integer.parseInt(indices[1]);
				char temp = programs.get(a);
				programs.set(a,programs.get(b));
				programs.set(b, temp);
			}
			else if(inputs[i].charAt(0)=='p'){
				char a = inputs[i].charAt(1);
				char b = inputs[i].charAt(3);
				int x = programs.indexOf(a);
				int y = programs.indexOf(b);
				programs.set(x, b);
				programs.set(y, a);
			}
		}
		if(seen.contains(programs)) {
			System.out.println(""+(r+1));
			break;
		}
		ArrayList<Character> temporary2 = new ArrayList<Character>();
		for(int i = 0; i < 16; i++) {
			temporary2.add(programs.get(i));
		}
		seen.add(temporary2);
		}
		for(int i = 0; i < 16; i++) {
			System.out.print(""+programs.get(i));
		}
	}
}
