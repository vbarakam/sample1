package BmStringMatcher;

public class BmStringMatching {
	
	public static void main(String args[]) {

		String pattern = "abbab";
		int m = pattern.length();
		int[] f = new int[m+1];
		int[] s = new int[m+1];
		bmPreprocess1(pattern, f, s);
		System.out.println(" score ");
	}
	
	public static void bmPreprocess1(String pattern, int[] f, int[] s) {
		int m = pattern.length();
		
		
		char p[] = pattern.toCharArray();
		
		int i = m, j = m + 1;
		f[i] = j;
		while (i > 0) {
			while (j <= m && p[i - 1] != p[j - 1]) {
				if (s[j] == 0)
					s[j] = j - i;
				j = f[j];
			}
			i--;
			j--;
			f[i] = j;
		}
	}
}
