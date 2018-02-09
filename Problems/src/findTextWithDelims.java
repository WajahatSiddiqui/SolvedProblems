import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class findTextWithDelims {
	
	private static String[] tokens(String str, String delim) {
		char [] c = str.toCharArray();
		char [] d = delim.toCharArray();
		
		int i = 0, j = 0, N = c.length, M = d.length;
		List<String> strs = new ArrayList<String>();
		char []t = new char[N];
		int k = 0;
		while (i < N) {
			if (d[j] == '\\') {
				j++;
			}
			if (c[i] == d[j]) {
				i++;
				j++;
			} else if (j < M) {
				t[k++] = c[i];
				i++;
			} 
			
			if (j == M) {
				strs.add(new String(t, 0, k));
				j = 0;
				k = 0;
				Arrays.fill(t, '\0');
			}
		}
		// store the remaining t if any
		if (k > 0) {
			strs.add(new String(t, 0, k));
		}
		return strs.stream().toArray(String[]::new);
	}
	
	public static void main(String[] args) {
		String str = "abc.egh.ejk";
		String delim = "\\.e";
		
		String []tokens = str.split(delim);
		StringTokenizer st = new StringTokenizer(str, delim);
		
		/*for (String t : tokens) {
			System.out.println(t);
		}*/
		
		/*while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}*/
		
		String [] tokenize = tokens(str, delim);
		for (String t : tokenize) {
			System.out.println(t);
		}
	}

}
