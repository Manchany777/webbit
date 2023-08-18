package html5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        
        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s, ",");
            
            while (st.hasMoreTokens()) {
                String sr = st.nextToken();
                System.out.println(sr);
                // token을 가지고 필요한 작업 수행
            }
        }
        // 정상
        br.close();
	}
}
// 아래처럼 하면 안 된다.
// String s = br.readLine();
// while(s != null) {
