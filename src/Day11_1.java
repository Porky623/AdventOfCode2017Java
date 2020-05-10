import java.util.*;
import java.io.*;
public class Day11_1 {
	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("inputs.txt"));
		int max = 0;
		String input = f.nextLine();
		String[] inputs = input.split(",");
		int[] directions = new int[] {0,0,0,0,0,0};
		for(String k : inputs) {
			switch(k) {
			case "n":
				directions[0]++;
				break;
			case "ne":
				directions[1]++;
				break;
			case "se":
				directions[2]++;
				break;
			case "s":
				directions[3]++;
				break;
			case "sw":
				directions[4]++;
				break;
			case "nw":
				directions[5]++;
				break;
			}
			for(int i = 0; i < 3; i++) {
				int chop = Math.min(directions[i], directions[i+3]);
				directions[i]-=chop;
				directions[i+3]-=chop;
			}
			int a =directions[0]-directions[3];
			int b = directions[1]-directions[4];
			int c = directions[5]-directions[2];
			int d = Math.min(c, b);
			int total = a+b+c-d;
			if(total>max)
				max=total;
		}
		System.out.println(""+max);
		}
}
