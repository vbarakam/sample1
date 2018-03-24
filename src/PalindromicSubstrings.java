import java.util.ArrayList;
import java.util.List;

public class PalindromicSubstrings {
	int count = 0;

	public int countSubstrings(String s) {
		List<String> result = new ArrayList<>();
		substrings(s, result);
		return count;
	}

	private void substrings(String s, List<String> result) {
		if (s.length() == 0) {
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.substring(0, i));
			if (isPalindrome(s, 0, i)) {
				count++;
				substrings(s.substring(i + 1), result);
			}
		}
	}

	private boolean isPalindrome(String s, int start, int last) {
		if (start == last) {
			return true;
		}

		while (start < last) {
			if (s.charAt(start) != s.charAt(last)) {
				return false;
			}
			start++;
			last--;
		}
		return true;
	}
	
	public static void main(String args[]) {
		String str = "aaa";
		PalindromicSubstrings count = new PalindromicSubstrings();
		count.countSubstrings(str);
	}
}