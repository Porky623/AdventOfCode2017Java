import java.util.*;
import java.io.*;
public class Day19_1 {
	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("inputs.txt"));
		char[][] input = new char[200][200];
		int index = 0;
		while(f.hasNext()) {
			String k = f.nextLine();
			for(int i = 1; i < k.length(); i++) {
				input[index][i-1]=k.charAt(i);
			}
			index++;
		}
		int x = 0;
		int y = 0;
		for(int i = 0; i < 200; i++) {
			if(input[0][i]!=' ')
				y=i;
		}
		boolean cont = true;
		String k = "";
		int increase = 0;
		int count = 1;
		loop:
		while(cont) {
			switch(increase) {
			case 0:
					while(x<input.length&&input[x][y]!='+') {
						if(Character.isLetter(input[x][y]))
							k+=(input[x][y]);
						x++;
						count++;
					}
					if(x==input.length) {
						cont=false;
						continue loop;
					}
					if(y<input[0].length-1&&input[x][y+1]!=' '){
						increase=2;
						y++;
						count++;
						continue loop;
					}
					else if(y>0&&input[x][y-1]!=' '){
						increase=3;
						y--;
						count++;
						continue loop;
					}
					else
						cont=false;
			case 1:
					while(x>=0&&input[x][y]!='+') {

						if(input[x][y]=='H') {
							cont = false;
							continue loop;
						}
						if(Character.isLetter(input[x][y]))
							k+=(input[x][y]);
						x--;
						count++;
					}
					if(x<0) {
						cont=false;
						continue loop;
					}
					if(y<input[0].length-1&&input[x][y+1]!=' '){
						increase=2;
						y++;
						count++;
						continue loop;
					}
					else if(y>0&&input[x][y-1]!=' '){
						increase=3;
						y--;
						count++;
						continue loop;
					}
					else
						cont=false;
			case 2:
				while(y<input[0].length&&input[x][y]!='+') {
					if(Character.isLetter(input[x][y]))
						k+=(input[x][y]);
					y++;
					count++;
				}
				if(y==input[0].length) {
					cont=false;
					continue loop;
				}
				if(x<input.length-1&&input[x+1][y]!=' '){
					increase=0;
					x++;
					count++;
					continue loop;
				}
				else if(x>0&&input[x-1][y]!=' '){
					increase=1;
					x--;
					count++;
					continue loop;
				}
				else
					cont=false;
			case 3:
				while(y>=0&&input[x][y]!='+') {
					if(Character.isLetter(input[x][y]))
						k+=(input[x][y]);
					y--;
					count++;
				}
				if(y<0) {
					cont=false;
					continue loop;
				}
				if(x<input.length-1&&input[x+1][y]!=' '){
					increase=0;
					x++;
					count++;
					continue loop;
				}
				else if(x>0&&input[x-1][y]!=' '){
					increase=1;
					x--;
					count++;
					continue loop;
				}
				else
					cont=false;
			}
		}
		System.out.println(count);
	}
}