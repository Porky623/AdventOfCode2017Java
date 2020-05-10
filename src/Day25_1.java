import java.io.*;
import java.util.*;
public class Day25_1 {
	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("inputs.txt"));
		int count = 0;
		int[] mach = new int[100000000];
		for(int i = 0; i < mach.length; i++) {
			mach[i]=0;
		}
		int index = mach.length/2;
		int state = 0;
		for(int i = 0; i < 12523873; i++) {
			switch(state) {
			case 0:
				if(mach[index]==0) {
					count++;
					mach[index]=1;
					index++;
					state=1;
				}
				else {
					index--;
					state=4;
				}
				break;
			case 1:
				if(mach[index]==0) {
					count++;
					mach[index]=1;
					index++;
					state=2;
				}
				else {
					index++;
					state=5;
				}
				break;
			case 2:
				if(mach[index]==0) {
					count++;
					mach[index]=1;
					index--;
					state=3;
				}
				else {
					count--;
					mach[index]=0;
					index++;
					state=1;
				}
				break;
			case 3:
				if(mach[index]==0) {
					count++;
					mach[index]=1;
					index++;
					state=4;
				}
				else {
					count--;
					mach[index]=0;
					index--;
					state=2;
				}
				break;
			case 4:
				if(mach[index]==0) {
					count++;
					mach[index]=1;
					index--;
					state=0;
				}
				else {
					count--;
					mach[index]=0;
					index++;
					state=3;
				}
				break;
			case 5:
				if(mach[index]==0) {
					count++;
					mach[index]=1;
					index++;
					state=0;
				}
				else {
					index++;
					state=2;
				}
				break;
			}
		}
		System.out.println(count);
	}
}
