import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class Test {
	public static void main(String args[]) {
		String str = "aaabbdcccccf";
		StringBuilder sb = new StringBuilder();
		int count = 1;
		char old = str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (old != ch) {
				sb.append(ch).append(count);
				count = 1;
				old = ch;
			} else {
				count++;
			}
		}
		sb.append(old).append(count);
		//a3b2d1c5f1
		System.out.println(" spoa " + sb.toString());
		char letters[] = {'c','f','j'};
		char ch = 'a';
		//System.out.println(maximumSwap(9973));;
		List<List<String>> accounts = new ArrayList<>();
		List<String> list1 = new ArrayList<>();
		//"Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"
		list1.add("Alex");
		list1.add("Alex5@m.co");
		list1.add("Alex4@m.co");
		list1.add("Alex0@m.co");
		accounts.add(list1);
		Map<String, String> emailToName = new HashMap();
        Map<String, ArrayList<String>> graph = new HashMap();
        for (List<String> account: accounts) {
            String name = "";
            for (String email: account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                graph.computeIfAbsent(email, x-> new ArrayList<String>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1), x-> new ArrayList<String>()).add(email);
                emailToName.put(email, name);
            }
        }
	}
	
	
	public static int maximumSwap(int num) {
        char str[] = Integer.toString(num).toCharArray();
        return maximumSwap(str, 0);
    }
    
    private static int maximumSwap(char str[], int index) {
        int[] last = new int[10];
        for (int i = 0; i < str.length; i++) {
            last[str[i]-'0'] = i;
        }
        
        boolean flag = true;
        for (int i = 0; i < str.length && flag; i++) {
            for (int j = 9; j > str[i]-'0'; j--) {
                if (last[j] > last[str[i]-'0']) {
                    char temp = str[last[j]];
                    str[last[j]] = str[i];
                    str[i] = temp;
                    flag = false;
                    break;
                }
            }
        }
        return Integer.parseInt(new String(str));
    }
    
    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length-1;
        while (start < end) {
            int mid = (start+end)/2;
            if (letters[mid] > target) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return letters[end];
    }
}