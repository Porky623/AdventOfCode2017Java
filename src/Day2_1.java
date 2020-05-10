import java.util.*;
import java.io.*;
public class Day2_1 {
	public static void main(String[] args) throws IOException {
		Scanner f = new Scanner(new File("inputs.txt"));
		List<String> inputs = new ArrayList<String>();
		while(f.hasNext()) {
			inputs.add(f.nextLine());
		}
		List<int[]> list = new ArrayList<int[]>();
		for(int i = 0; i < inputs.size(); i++) {
			String[] a = inputs.get(i).split("\t");
			int[] b = new int[a.length];
			for(int j = 0; j < a.length; j++) {
				b[j] = Integer.parseInt(a[j]);
			}
			list.add(b);
		}
		int[] sum = new int[list.size()];/*
		for(int i = 0; i < list.size(); i++) {
			sum[i] = findMax(list.get(i))-findMin(list.get(i));
		}*/
		for(int i = 0; i < list.size(); i++) {
			sum[i] = divide(list.get(i));
		}
		int add = 0;
		for(int i = 0; i < sum.length; i++) {
			add+=sum[i];
		}
		System.out.println(add+"");
	}
	public static int findMax(int[] x) {
		int max = x[0];
		for(int i = 1; i < 
				x.length; i++) {
			if(x[i]>max)
				max = x[i];
		}
		return max;
	}
	public static int findMin(int[] x) {
		int min = x[0];
		for(int i = 1; i < x.length; i++) {
			if(x[i]<min)
				min = x[i];
		}
		return min;
	}
	public static int divide(int[] x) {
		for(int i = 0; i < x.length; i++) {
			for(int j = i+1; j < x.length; j++) {
				if(x[i]%x[j]==0)
					return x[i]/x[j];
				if(x[j]%x[i]==0)
					return x[j]/x[i];
			}
		}
		return 0;
	}
}