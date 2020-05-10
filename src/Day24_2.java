import java.util.*;
import java.io.*;
public class Day24_2 {
	private static int[][] in;
	private static ArrayList<ArrayList<ArrayList<Integer>>> con;
	private static ArrayList<ArrayList<Integer>> curB;
	private static ArrayList<Integer> strongB;
	private static ArrayList<ArrayList<Integer>> longB;
	private static HashMap<Integer,ArrayList<Integer>> map;
	private static int curP;
	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("inputs.txt"));
		strongB = new ArrayList<Integer>();
		longB=new ArrayList<ArrayList<Integer>>();
		curB=new ArrayList<ArrayList<Integer>>();
		in = new int[56][2];
		map=new HashMap<Integer,ArrayList<Integer>>();
		for(int i = 0; i < 56; i++) {
			String k = f.nextLine();
			String[] inp = k.split("/");
			in[i][0]=Integer.parseInt(inp[0]);
			in[i][1]=Integer.parseInt(inp[1]);
		}
		for(int i = 0; i < 56; i++) {
			for(int j = 0; j < 2; j++) {
				if(!map.containsKey(in[i][j])) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(i);
					map.put(in[i][j], temp);
				}
				else {
					ArrayList<Integer> temp = map.get(in[i][j]);
					temp.add(i);
					map.put(in[i][j],temp);
				}
			}
		}
		con=new ArrayList<ArrayList<ArrayList<Integer>>>();
		for(int i = 0; i < 56; i++) {
			ArrayList<ArrayList<Integer>> t = new ArrayList<ArrayList<Integer>>();
			for(int k= 0; k < 2; k++) {
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
		strongB=new ArrayList<Integer>();
		longB=new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < 56; i++) {
			if(in[i][0]==0||in[i][1]==0) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(i);
		HashSet<Integer> u = new HashSet<Integer>();
		u.add(i);
		makeBridges(a,u);
			}
		}
		System.out.println(score(strongB));
		int max = score(longB.get(0));
		for(int i = 1; i < longB.size(); i++) {
			int x = score(longB.get(i));
			if(x>max)
				max=x;
		}
		System.out.println(max);
	}
	private static void makeBridges(ArrayList<Integer> a,HashSet<Integer> u) {
		int x = nextPort(a);
		if(score(a)>score(strongB))
			strongB=a;
		if(longB.size()>0) {
		if(a.size()>longB.get(0).size()){
			longB.clear();
			longB.add(a);
		}
		else if(a.size()==longB.get(0).size())
			longB.add(a);
		}
		else {
			longB.add(a);
		}
		curB.add(a);
		ArrayList<Integer> t = map.get(x);
		for(int i : t) {
			if(!u.contains(i)) {
				ArrayList<Integer> at = new ArrayList<Integer>();
				at.addAll(a);
				at.add(i);
				HashSet<Integer> ut = new HashSet<Integer>();
				ut.addAll(at);
				makeBridges(at,ut);
			}
		}
	}
	private static int nextPort(ArrayList<Integer> a) {
		if(a.size()==1) {
			if(in[a.get(0)][0]==0)
				return in[a.get(0)][1];
			return in[a.get(0)][0];
		}
		int[] k = in[a.get(a.size()-1)];
		int[] m = in[a.get(a.size()-2)];
		if(k[0]==m[1]||k[0]==m[0])
			return k[1];
		return k[0];
	}
	private static int score(ArrayList<Integer> i) {
		int s = 0;
		for(int k : i) {
			s+=in[k][0]+in[k][1];
		}
		return s;
	}
}
