import java.io.*;
import java.util.*;
public class Day21_1 {
	private static ArrayList<String[]> keys,vals;
	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("inputs.txt"));
		HashMap<Character,Boolean> onOff = new HashMap<Character,Boolean>();
		onOff.put('.', false);
		onOff.put('#',true);
		keys = new ArrayList<String[]>();
		vals = new ArrayList<String[]>();
		while(f.hasNextLine()) {
			String k = f.nextLine();
			String[] at = k.split(" => ");
			String[] a1 = at[0].split("/");
			String[] a2 = at[1].split("/");
			for(int i = 0; i < 4; i++) {
				keys.add(rot(a1,i));
				vals.add(a2);
				keys.add(rot(flip1(a1),i));
				vals.add(a2);
				keys.add(rot(flip2(a1),i));
				vals.add(a2);
			}
		}
		String[] start = new String[] {".#.","..#","###"};
		ArrayList<ArrayList<Integer>> in = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> indices = map(start);
		in.add(indices);
		int count = 0;
		for(int l = 0; l < indices.size(); l++) {
			start=keys.get(indices.get(l));
			start=find(start);
			String[][] temp = new String[4][2];
			temp[0]=new String[] {start[0].substring(0, 2),start[1].substring(0, 2)};
			temp[1]=new String[] {start[2].substring(0, 2),start[3].substring(0, 2)};
			temp[2]=new String[] {start[0].substring(2, 4),start[1].substring(2, 4)};
			temp[3]=new String[] {start[2].substring(2, 4),start[3].substring(2, 4)};
			for(int i = 0; i < 4; i++) {
				temp[i]=find(temp[i]);
			}
			start=new String[] {temp[0][0]+temp[2][0],temp[0][1]+temp[2][1],temp[0][2]+temp[2][2],temp[1][0]+temp[3][0],temp[1][1]+temp[3][1],temp[1][2]+temp[3][2]};
			count+=calc(start);
		}
		System.out.println(count);
	}
	private static ArrayList<Integer> map(String[] start) {
		start=find(start);
		String[][] temp = new String[4][2];
		temp[0]=new String[] {start[0].substring(0, 2),start[1].substring(0, 2)};
		temp[2]=new String[] {start[2].substring(0, 2),start[3].substring(0, 2)};
		temp[1]=new String[] {start[0].substring(2, 4),start[1].substring(2, 4)};
		temp[3]=new String[] {start[2].substring(2, 4),start[3].substring(2, 4)};
		for(int i = 0; i < 4; i++) {
			temp[i]=find(temp[i]);
		}
		start=new String[] {temp[0][0]+temp[2][0],temp[0][1]+temp[2][1],temp[0][2]+temp[2][2],temp[1][0]+temp[3][0],temp[1][1]+temp[3][1],temp[1][2]+temp[3][2]};
		String k = "";
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 6; j++) {
				k+=start[j].substring(2*i, 2*i+2);
			}
		}
		temp=new String[9][2];
		for(int i = 0; i < 9; i++) {
			temp[i]=new String[] {k.substring(4*i,4*i+2),k.substring(4*i+2,4*i+4)};
		}
		for(int i = 0; i < 9; i++) {
			temp[i]=find(temp[i]);
		}
		ArrayList<Integer> indices = new ArrayList<Integer>();
		for(int i = 0; i < 9; i++) {
			int index = 0;
			while(!Arrays.equals(keys.get(index), temp[i])) {
				index++;
			}
			indices.add(index);
		}
		return indices;
	}
	private static int calc(String[] a) {
		int count = 0;
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length(); j++) {
				if(a[i].charAt(j)=='#')
					count++;
			}
		}
		return count;
	}
	private static String[] find(String[] a) {
		for(int i = 0; i < keys.size(); i++) {
			if(Arrays.equals(keys.get(i), a))
				return vals.get(i);
		}
		return null;
	}
	private static String[] flip1(String[] a) {
		String[] temp = new String[a.length];
		for(int i = 0; i < a.length; i++) {
			temp[i]=new StringBuilder(a[i]).reverse().toString();
		}
		return temp;
	}
	private static String[] flip2(String[] a) {
		String[] temp = new String[a.length];
		temp[0]=a[a.length-1];
		temp[temp.length-1]=a[0];
		if(a.length==3)
			temp[1]=a[1];
		return temp;
	}
	private static String[] rot(String[] a,int ti) {
		if(a.length==2) {
			String[] t1 = new String[] {a[0],a[1]};
			for(int i = 0; i < ti; i++) {
				String[] temp = new String[] {t1[0],t1[1]};
				temp[0]=t1[1].charAt(0)+""+t1[0].charAt(0);
				temp[1]=t1[1].charAt(1)+""+t1[0].charAt(1);
				t1=temp;
			}
			return t1;
		}
		String[] t1 = new String[] {a[0],a[1],a[2]};
		for(int i = 0; i < ti; i++)
		{
			String[] temp = new String[] {t1[0],t1[1],t1[2]};
			temp[0]=""+t1[1].charAt(0)+t1[0].charAt(0)+t1[0].charAt(1);
			temp[1]=""+t1[2].charAt(0)+t1[1].charAt(1)+t1[0].charAt(2);
			temp[2]=""+t1[2].charAt(1)+t1[2].charAt(2)+t1[1].charAt(2);
			t1=temp;
		}
		return t1;
		}
}
