import java.util.*;
import java.io.*;
public class Day15_1 {
	public static void main(String[] args) throws IOException{
		final long MAX=(long)Integer.MAX_VALUE;
		long skipA=16807;
		long skipB=48271;
		long[] num = new long[] {591,393};
		long count = 0;
		for(long i = 0; i < 5000000; i++) {
			num[0]=(num[0]*skipA)%MAX;
			while(num[0]%4!=0) {
			num[0]=(num[0]*skipA)%MAX;
			}
			num[1]=(num[1]*skipB)%MAX;
			while(num[1]%8!=0) {
			num[1]=(num[1]*skipB)%MAX;
			}
			if(compare(toBinary(num[0]),toBinary(num[1]))) {
				count++;
			}
		}
		System.out.println(count);
	}
	private static boolean compare(boolean[] a,boolean[] b) {
		for(int i = 0; i < 16; i++) {
			if(a[i]!=b[i])
				return false;
		}
		return true;
	}
	private static boolean[] toBinary(long x){
		boolean[] end = new boolean[16];
		for(int i = 15; i >=0; i--) {
			if(x%2==1) {
				x--;
				x/=2;
				end[i]=true;
			}
			else {
				x/=2;
				end[i]=false;
			}
		}
		return end;
	}
}
