import java.util.*;
import java.io.*;
public class Day1_1 {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("inputs.txt"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		String s = st.nextToken();
		int x = s.length();
		int[] a = new int[2*x];
		for(int i = 0; i < x; i++) {
			a[i] = Integer.parseInt(s.substring(i,i+1));
			a[i+x] = a[i];
		}
		int sum = 0;
		for(int i = 0; i < x; i++) {
			if(a[i]==a[i+x/2])
				sum+=a[i];
		}
		System.out.println(""+sum);
	}
}
