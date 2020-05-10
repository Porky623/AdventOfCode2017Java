import java.util.*;
import java.io.*;
public class Day23_1 {
	private static HashMap<Character,Integer> registers;
	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("inputs.txt"));
		registers = new HashMap<Character,Integer>();
		registers.put('a', 1);
		registers.put('b', 0);
		registers.put('c', 0);
		registers.put('d', 0);
		registers.put('e', 0);
		registers.put('f', 0);
		registers.put('g', 0);
		registers.put('h', 0);
		ArrayList<ArrayList<String>> inputs = new ArrayList<ArrayList<String>>();
		while(f.hasNextLine()) {
			String k = f.nextLine();
			String[] input = k.split(" ");
			ArrayList<String> n = new ArrayList<String>();
			for(int i = 0; i < 3; i++) {
				n.add(input[i]);
			}
			inputs.add(n);
		}
		int index = 0;
		while(0<=index&&index<inputs.size()) {
			switch(inputs.get(index).get(0)) {
			case "set":
				registers.put(inputs.get(index).get(1).charAt(0),valOf(inputs.get(index).get(2)));
				index++;
				break;
			case "sub":
				registers.put(inputs.get(index).get(1).charAt(0),-valOf(inputs.get(index).get(2))+registers.get(inputs.get(index).get(1).charAt(0)));
			index++;
			break;
			case "mul":
				registers.put(inputs.get(index).get(1).charAt(0),valOf(inputs.get(index).get(2))*registers.get(inputs.get(index).get(1).charAt(0)));
				index++;
				break;
			case "jnz":
				if(valOf(inputs.get(index).get(1))!=0){
					index+=valOf(inputs.get(index).get(2));
				}
				else
					index++;
				break;
			}
		}
		System.out.println(registers.get('h'));
	}
	private static int valOf(String k) {
		if(!Character.isLetter(k.charAt(0))){
			return Integer.parseInt(k);
		}
		return registers.get(k.charAt(0));
	}
}
