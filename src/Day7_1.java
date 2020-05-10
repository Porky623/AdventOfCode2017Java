import java.util.*;
import java.io.*;
public class Day7_1 {
	public static void main(String[] args) throws IOException{
		Scanner f= new Scanner(new File("inputs.txt"));
		HashMap<String, String> relations = new HashMap<String, String>();
		HashMap<String, ArrayList<String>> relations2 = new HashMap<String, ArrayList<String>>();
		HashMap<String, Integer> weights = new HashMap<String, Integer>();
		List<String> names = new ArrayList<String>();
		while(f.hasNextLine()) {
			String[] inputs = f.nextLine().split(" ");
			weights.put(inputs[0], Integer.parseInt(inputs[1].substring(1, inputs[1].length()-1)));
			names.add(inputs[0]);
			for(int i = 3; i < inputs.length; i++) {
				if(i==inputs.length-1) {
					relations.put(inputs[i],inputs[0]);
					addValues(inputs[0],inputs[i],relations2);
				}
				else {
					relations.put(inputs[i].substring(0, inputs[i].length()-1),inputs[0]);
					addValues(inputs[0],inputs[i].substring(0, inputs[i].length()-1),relations2);
				}
			}
		}
		String name1 = names.get(0);
		while(relations.containsKey(name1)) {
			name1 = relations.get(name1);
		}
		Node7 bottom = makeTree(null,name1,weights.get(name1),weights,relations,relations2);
		System.out.println(""+-1*sum(bottom,weights,relations));
	}
	private static int sum(Node7 node, HashMap<String,Integer> weights,HashMap<String,String> relations) {
		Node7[] above = node.getabove();
		if(above==null)
			return node.getWeight();
		int sum = 0;
		int[] sums = new int[above.length];
		boolean moreCheck = false;
		for(int i = 0; i < above.length; i++) {
			int x = sum(above[i],weights,relations);
			if(x<-1)
				return x;
			if(x== -1) {
				moreCheck = true;
			}
			sums[i] = x;
			sum+=x;
		}
		if(moreCheck) {
			for(int i = 1; i < sums.length; i++) {
				if(sums[i]!=sums[i-1])
				{
					if(sums.length>2) {
						if(sums[i]!=sums[(i+1)%sums.length]) {
							int x = sums[i-1]-sums[i]+above[i].getWeight();
							return -1*x;
						}
						int x = sums[i]-sums[i-1]+above[i].getWeight();
						return -1*x;
					}
				}
			}
		}
		for(int i = 1; i < sums.length ;i++) {
			if(sums[i]!=sums[i-1]){
				if(sums[i]!=sums[(i+1)%sums.length]) {
					int x = sums[i-1]-sums[i]+above[i].getWeight();
					return -1*x;
				}
				return -1;
			}
		}
		return sum+=node.getWeight();
	}
	private static Node7 makeTree(Node7 node, String name, int w, HashMap<String,Integer> weights,HashMap<String,String> relations,HashMap<String,ArrayList<String>> relations2) {
		ArrayList<String> temp = relations2.get(name);
		if(temp==null) {
			return new Node7(name,weights.get(name),null);
		}
		Node7[] children = new Node7[temp.size()];
		Node7 end = new Node7(name,weights.get(name),children);
		for(int i = 0; i < children.length; i++) {
			children[i] = makeTree(end,temp.get(i),weights.get(temp.get(i)),weights,relations,relations2);
		}
		return end;
	}
	private static void addValues(String key, String value,HashMap<String,ArrayList<String>> hashMap) {
		   ArrayList<String> tempList = null;
		   if (hashMap.containsKey(key)) {
		      tempList = hashMap.get(key);
		      if(tempList == null)
		         tempList = new ArrayList<String>();
		      tempList.add(value);  
		   } else {
		      tempList = new ArrayList<String>();
		      tempList.add(value);               
		   }
		   hashMap.put(key,tempList);
		}
}