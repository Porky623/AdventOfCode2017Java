import java.io.*;
import java.util.*;
public class Day23_2 {
	//Just use Mathematica: # of non-primes from 106700 to 123700 by 17, inclusive
	public static void main(String[] args) {
		int count = 0;
		for(int b = 106700; b <= 123700; b+=17) {
			if(!isPrime(b))
				count++;
		}
		System.out.println(count);
	}
	private static boolean isPrime(int x) {
		if(x%2==0||x%3==0)
			return false;
		int k = (int)Math.pow(x, 1/2);
		for(int i = 6; i <=k+1; i+=6) {
			if(x%(i+1)==0||x%(i-1)==0)
					return false;
		}
		return true;
	}
}
