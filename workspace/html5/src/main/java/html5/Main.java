package html5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String str;

		while((str=br.readLine()) != null) {
			st = new StringTokenizer(str, " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(a+b).append("\n");
		}//while
		br.close();
		System.out.print(sb);
		
		// 밑에거 안 됨
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(a+b).append("\n");
			if(st == null) {
				break;
			}
		}
		System.out.print(sb);
		br.close();
	}
}

/*
BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

int T = Integer.parseInt(bf.readLine());
String s;

StringTokenizer st;

for(int i=0; i<T; i++) {
	s = bf.readLine();
	st = new StringTokenizer(s);
	int a = Integer.parseInt(st.nextToken());
	int b = Integer.parseInt(st.nextToken());

	
	int[] arr = new int[T];
	arr[i] = i;
	bw.write("Case #" + (i+1) + ": " + a + " + " + b + " = " + (a+b) + "\n");
	//System.out.println("Case #" + (i+1) + ": " + (a+b));
} // for
bw.flush();
bw.close();
bf.close();
*/