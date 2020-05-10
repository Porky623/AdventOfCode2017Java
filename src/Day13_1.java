import java.util.*;
import java.io.*;
public class Day13_1 {
	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("inputs.txt"));
		int[] sizes = new int[91];
		for(int i = 0; i < 91; i++) {
			sizes[i] = -1;
		}
		int[] periods = new int[91];
		while(f.hasNextLine()) {
			String k = f.nextLine();
			String[] x = k.split(": ");
			int index = Integer.parseInt(x[0]);
			sizes[index] = Integer.parseInt(x[1]);
			if(sizes[index]>0)
			periods[index]=2*sizes[index]-2;
			else
				periods[index]=-1;
		}
		double lcm = 465585120;
		int[] scanners = new int[91];
		for(int i = 0; i < 91; i++) {
			scanners[i] = 0;
		}
		boolean[] up = new boolean[91];
		for(int i = 0; i < 91; i++) {
			up[i]=false;
		}
		List<Integer> original = new ArrayList<Integer>();
		List<Boolean> oUp = new ArrayList<Boolean>();
		List<Integer> nSize = new ArrayList<Integer>();
		for(int i = 0; i < 91; i++) {
			if(sizes[i]>0) {
				original.add(scanners[i]);
				oUp.add(up[i]);
				nSize.add(sizes[i]);
			}
			for(int j = 0; j < 91; j++) {
				move(sizes,scanners,j,up);
			}
		}
		boolean works = false;
		int delay = 0;
		while(!works) {
				for(int i = 0; i < original.size(); i++) {
					for(int j= 0; j < 3946838; j++)
						move(nSize,original,i,oUp);
				}
				if(!original.contains(0))
					works = true;
				delay+=3946838;
		}
		System.out.println(delay);
	}
	private static void move(int[] sizes, int[] scanners, int index, boolean[] up) {
		if(sizes[index]==-1) {
			return;
		}
		if(scanners[index]==sizes[index]-1) {
			up[index]=true;
			scanners[index]--;
		}
		else if(scanners[index]==0) {
			scanners[index]++;
			up[index]=false;
		}
		else if(up[index]) {
			scanners[index]--;
		}
		else {
			scanners[index]++;
		}
	}
	private static void move(List<Integer> sizes, List<Integer> scanners, int index, List<Boolean> up) {
		if(sizes.get(index)==-1) {
			return;
		}
		if(scanners.get(index)==sizes.get(index)-1) {
			up.set(index, true);
			scanners.set(index,scanners.get(index)-1);
		}
		else if(scanners.get(index)==0) {
			scanners.set(index,scanners.get(index)+1);
			up.set(index, false);
		}
		else if(up.get(index)) {
			scanners.set(index,scanners.get(index)-1);
		}
		else {
			scanners.set(index,scanners.get(index)+1);
		}
	}
}
