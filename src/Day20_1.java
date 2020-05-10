import java.util.*;
import java.io.*;
public class Day20_1 {
	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("inputs.txt"));
		ArrayList<Particle> inputs = new ArrayList<Particle>();
		while(f.hasNextLine()) {
			String k = f.nextLine();
			String[] vectors = k.split(", ");
			ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
			for(int i = 0; i < 3; i++) {
				ArrayList<Integer> vec = new ArrayList<Integer>();
				String st = vectors[i].substring(3, vectors[i].length()-1);
				String[] sts = st.split(",");
				for(int j = 0; j < 3; j++) {
					vec.add(Integer.parseInt(sts[j]));
				}
				input.add(vec);
			}
			inputs.add(new Particle(input));
		}
		/*
		 * Part 1 (gives 3 possible indices: check Manhattan velocities and lowest is 166 for index 161)
		int[] AccSize = new int[inputs.size()];
		for(int i = 0; i < inputs.size(); i++) {
			ArrayList<Integer> input = inputs.get(i).get(2);
			AccSize[i]=Math.abs(input.get(0))+Math.abs(input.get(1))+Math.abs(input.get(2));
		}
		ArrayList<Integer> maxIndex = new ArrayList<Integer>();
		maxIndex.add(0);
		for(int i = 1; i < AccSize.length; i++) {
			if(AccSize[i]==AccSize[maxIndex.get(0)]) {
				maxIndex.add(i);
			}
			else if(AccSize[i]<AccSize[maxIndex.get(0)]) {
				maxIndex.clear();
				maxIndex.add(i);
			}
		}
		*/
		int index = 1;
		do {
		for(int i = 0; i < 1000; i++) {
			int j = 0;
			while(j<inputs.size()){
				inputs.get(j).moveParticle();
				j++;
			}
			sort(inputs);
			int k = 0;
			while(k < inputs.size()-1) {
				int s = 1;
				while(inputs.get(k+s-1).compareTo(inputs.get(k+s),0)==0) {
					s++;
				}
				if(s>1) {
					for(int at = 0; at < s; at++) {
						inputs.remove(k);
					}
				}
				else
					k++;
			}
		}
		System.out.println(index);
		System.out.println(inputs.size());
		index++;
		}while(!isSorted(inputs));
	}
	
	private static void sort(ArrayList<Particle> array)
	   {
	      int maxPos;
	      for(int k = 0; k < array.size(); k++)		
	      {
	         maxPos = findMax(array, array.size() - k - 1);
	         swap(array, maxPos, array.size() - k - 1);
	      }
	   }
   private static int findMax(ArrayList<Particle> array, int upper)
   {
      int maxPos = 0;
      for(int j = 1; j <= upper; j++)			{
         if(array.get(j).compareTo(array.get(maxPos),0)>0)	
            maxPos = j;					}
      return maxPos;
   }
   private static void swap(ArrayList<Particle> array, int a, int b)
   {
      Particle temp = array.get(a);				
      array.set(a,array.get(b));
      array.set(b,temp);
   }
   private static boolean isSorted(ArrayList<Particle> k) {
	   for(int i = 0; i < k.size()-1; i++) {
		   if(k.get(i).compareTo(k.get(i+1), 0)>0||k.get(i).compareTo(k.get(i+1), 1)>0||k.get(i).compareTo(k.get(i+1), 2)>0)
			   return false;
	   }
	   return true;
   }
}
class Particle{
	private ArrayList<ArrayList<Integer>> vec;
	public Particle(ArrayList<ArrayList<Integer>> k) {
		vec=k;
	}
	public void moveParticle() {
		vec.get(1).set(0, vec.get(1).get(0)+vec.get(2).get(0));
		vec.get(1).set(1, vec.get(1).get(1)+vec.get(2).get(1));
		vec.get(1).set(2, vec.get(1).get(2)+vec.get(2).get(2));
		vec.get(0).set(0, vec.get(0).get(0)+vec.get(1).get(0));
		vec.get(0).set(1, vec.get(0).get(1)+vec.get(1).get(1));
		vec.get(0).set(2, vec.get(0).get(2)+vec.get(1).get(2));
	}
	public ArrayList<ArrayList<Integer>> getVec(){
		return vec;
	}
	public int compareTo(Particle o, int i) {
		if(vec.get(i).get(0)<o.vec.get(i).get(0)) {
			return -1;
		}
		if(vec.get(i).get(0)>o.vec.get(i).get(0))
			return 1;
		if(vec.get(i).get(1)<o.vec.get(i).get(1))
			return -1;
		if(vec.get(i).get(1)>o.vec.get(i).get(1))
			return 1;
		if(vec.get(i).get(2)<o.vec.get(i).get(2))
			return -1;
		if(vec.get(i).get(2)>o.vec.get(i).get(2))
			return 1;
		return 0;
	}
	public String toString() {
		return vec.toString();
	}
}