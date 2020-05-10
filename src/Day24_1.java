import java.util.*;
import java.io.*;
public class Day24_1 {
	private static int[][] in;
	private static int[] score;
	private static ArrayList<ArrayList<ArrayList<Integer>>> con;
	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("inputs.txt"));
		in = new int[56][2];
		score = new int[56];
		for(int i = 0; i < 56; i++) {
			String k = f.nextLine();
			String[] ina = k.split("/");
			in[i][0]=Integer.parseInt(ina[0]);
			in[i][1]=Integer.parseInt(ina[1]);
			score[i]=in[i][0]+in[i][1];
		}
		con = new ArrayList<ArrayList<ArrayList<Integer>>>();
		for(int i = 0; i < 56; i++) {
			ArrayList<ArrayList<Integer>> t = new ArrayList<ArrayList<Integer>>();
			for(int k = 0; k < 2; k++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int j = 0; j < 56; j++) {
				if(in[i][k]==in[j][0]||in[i][k]==in[j][1])
            if(i!=j)
					temp.add(j);
			}
			t.add(temp);
			}
			con.add(t);
		}
		ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < 56; i++) {
			if(in[i][0]==0) {
			HashSet<Integer>  u = new HashSet<Integer>();
			paths.addAll(fill(u, i,1));
			}
			if(in[i][1]==0) {
				HashSet<Integer> u = new HashSet<Integer>();
				paths.addAll(fill(u,i,0));
			}
		}
		int max = 0;
		for(ArrayList<Integer> i : paths) {
			max=Math.max(max, calc(i));
		}
		System.out.println(max);
	}
	private static int calc(ArrayList<Integer> i) {
		int sc = 0;
		for(int j : i) {
			sc+=score[j];
		}
		return sc;
	}
	private static ArrayList<ArrayList<Integer>> fill(HashSet<Integer> used, int index,int s) {
		boolean done = true;
		for(int i : con.get(index).get(s)) {
			if(!used.contains(i)) {
					done=false;
			}
		}
		if(done) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> t = new ArrayList<Integer>();
			t.add(index);
			temp.add(t);
			return temp;
		}
		ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
		used.add(index);
		for(int i : con.get(index).get(s)) {
			if(!used.contains(i)) {
				if(s==0) {
					if(in[i][0]==in[index][0])
						temp.addAll(fill(used,i,1));
					else
						temp.addAll(fill(used,i,0));
				}
				else {
					if(in[index][1]==in[i][0])
						temp.addAll(fill(used,i,1));
					else
						temp.addAll(fill(used,i,0));
				}
			}
		}
		for(ArrayList<Integer> t : temp) {
			t.add(index);
		}
		return temp;
	}
}