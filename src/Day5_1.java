import java.util.*;
import java.io.*;
public class Day5_1 {
	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("inputs.txt"));
		List<Integer> input = new ArrayList<Integer>();
		while(f.hasNextLine()) {
			input.add(Integer.parseInt(f.nextLine()));
		}
		int[] in = new int[input.size()];
		for(int i = 0; i < in.length; i++) {
			in[i] = input.get(i);
		}
		int count = 0;
		int start = 0;
		while(!(start<0||start>=in.length)) {
			int k = start+in[start];
			if(in[start]>=3) {
				in[start]--;
			}
			else
				in[start]++;
			count++;
			start = k;
		}
		System.out.println(""+count);
	}
}