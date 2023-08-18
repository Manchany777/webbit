package html5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
		
		String s = br.readLine(); // String타입
		int i = Integer.parseInt(br.readLine()); // int타입

		
		// String타입일 경우
		// Read한 데이터는 Line단위로만 나눠지기에 공백단위로 데이터를 가공하려면 따로 작업을 해주어야하는데, 아래의 두가지 방법이 대표적이다.
		    // 첫번째 방법 : StringTokenizer에 nextToken()함수 사용
		StringTokenizer st = new StringTokenizer(s); //StringTokenizer인자값에 입력 문자열 넣음
		int a = Integer.parseInt(st.nextToken()); // 첫번째 호출 (한줄에서 공백 단위로 읽음)
		int b = Integer.parseInt(st.nextToken()); // 두번째 호출
		System.out.println(a + "" + b);
		    // 두번째 방법 : String.split()함수를 활용하여 배열에 공백단위로 끊어서 데이터를 넣고 사용
		String[] array = s.split(" "); //공백마다 데이터 끊어서 배열에 넣음
		// array[0] = "1"; Integer.parseInt(array[0]) => 1
		// array[1] = "2";
		// array[2] = "3";
		// .....
		
		st = new StringTokenizer(br.readLine());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		System.out.println(a + b + e + f);
		
		//-------------------------------------------------------------------
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //할당된 버퍼에 값 넣어주기
		String s2 = "abcdef";   //출력할 문자열
		bw.write(s2 + "\n");  //버퍼에 있는 값 전부 출력 // bw.write에는 System.out.println();과 같이 자동개행기능이 없기때문에 따로 처리해주어야 한다.
		bw.flush();   //남아있는 데이터를 모두 출력시킴
		bw.close();   //스트림을 닫음
		
		// 참고 
		// https://m.blog.naver.com/ka28/221850826909 
		// https://deftkang.tistory.com/215
	}
}
