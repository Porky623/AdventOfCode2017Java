import java.util.*;
import java.io.*;
public class Day6_1 {
	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("inputs.txt"));
		List<Integer> list = new ArrayList<Integer>();
		while(f.hasNextLine()) {
			list.add(Integer.parseInt(f.nextLine()));
		}
		int[] in = new int[list.size()];
		for(int i = 0; i < in.length; i++) {
			in[i] = list.get(i);
		}
		int count = 0;
		int[][] temp = new int[1][in.length];
		for(int i = 0; i < in.length; i++) {
			temp[0][i] = in[i];
		}
		System.out.println(findLoop(in,temp,count));
	}
	private static int findLoop(int[] in,int[][] previous,int count) {
		int index = findMax(in);
		int x = in[index];
		in[index] = 0;
		while(x>0) {
			index++;
			in[index%in.length]++;
			x--;
		}
		if(has(previous,in)!=-1)
			return count+1-has(previous,in);
		int[][] temp = new int[previous.length+1][in.length];
		for(int i = 0; i < previous.length; i++) {
			temp[i] = previous[i];
		}
		for(int i = 0; i < in.length; i++) {
			temp[previous.length][i] = in[i];
		}
		return findLoop(in,temp,count+1);
	}
	private static int findMax(int[] x) {
		int max = 0;
		for(int i = 1; i < x.length; i++) {
			if(x[i]>x[max])
				max = i;
		}
		return max;
	}
	private static int has(int[][] source,int[] value) {
		int has = -1;
		for(int i = 0; i < source.length; i++) {
			boolean same = true;
			for(int j = 0; j < value.length; j++) {
				if(source[i][j]!=value[j])
					same = false;
			}
			if(same)
				has = i;
		}
		return has;
	}
}
