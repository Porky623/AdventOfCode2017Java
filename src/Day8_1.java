import java.util.*;
import java.io.*;
public class Day8_1 {
	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("inputs.txt"));
		HashMap<String,Integer> namesMap = new HashMap<String,Integer>();
		List<String> names = new ArrayList<String>();
		List<String> nameChange = new ArrayList<String>();
		List<Boolean> changes = new ArrayList<Boolean>();
		List<Integer> jumps = new ArrayList<Integer>();
		List<String> compare = new ArrayList<String>();
		List<String> conditions = new ArrayList<String>();
		List<Integer> comparators = new ArrayList<Integer>();
		while(f.hasNextLine()) {
			String[] inputs = f.nextLine().split(" ");
			if(!namesMap.containsKey(inputs[0])) 
			{
				namesMap.put(inputs[0], 0);
				names.add(inputs[0]);
			}
			nameChange.add(inputs[0]);
			if(inputs[1].equals("inc"))
				changes.add(true);
			else
				changes.add(false);
			jumps.add(Integer.parseInt(inputs[2]));
			compare.add(inputs[4]);
			conditions.add(inputs[5]);
			comparators.add(Integer.parseInt(inputs[6]));
		}
		/*int[] values = new int[names.size()];
		for(int i = 0; i < values.length; i++) {
			values[i]=0;
		}*/
		int max = 0;
		for(int i = 0; i < nameChange.size(); i++) {
			if(checkCondition(namesMap,compare.get(i),conditions.get(i),comparators.get(i))) {
			if(changes.get(i)) {
				//values[names.indexOf(nameChange.get(i))] +=jumps.get(i);
				int k = namesMap.get(nameChange.get(i))+jumps.get(i);
				namesMap.put(nameChange.get(i), k);
				if(k>max)
					max = k;
			}
			else {
				//values[names.indexOf(nameChange.get(i))] -=jumps.get(i);
				int k = namesMap.get(nameChange.get(i))-jumps.get(i);
				namesMap.put(nameChange.get(i), k);
				if(k>max)
					max = k;
			}/*
			if(values[names.indexOf(nameChange.get(i))]>max)
				max = values[names.indexOf(nameChange.get(i))];*/
			}
		}
		System.out.println(""+max);
	}
	/*private static int findMax(int[] values) {
		int max = values[0];
		for(int i = 1; i < values.length; i++) {
			if(values[i]>max)
				max = values[i];
		}
		return max;
		}*/
	private static boolean checkCondition(HashMap<String,Integer> namesMap,String name,String condition,int comparator) {
		int k = namesMap.get(name);
		switch(condition) {
		case "<": if(k<comparator)
			return true;
		break;
		case ">": if(k>comparator)
			return true;
		break;
		case "<=": if(k<=comparator)
			return true;
			break;
			case ">=": if(k>=comparator)
				return true;
			break;
			case "==": if(k==comparator)
				return true;
			break;
			case "!=": if(k!=comparator)
				return true;
			break;
			default:
				return false;
		}
		return false;
	}
}
