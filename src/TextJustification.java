import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
        if (maxWidth == 0) {
            return Arrays.asList(words);
        }
        if (words.length == 0 && maxWidth == 0) {
            return new ArrayList<String>();
        }

        List<String> results = new ArrayList<>();
        int i = 0;
        while(i < words.length) {
            int len = 0;
            //"This", "is", "an", "example", "of", "text", "justification."
            List<String> temp = new ArrayList<>();
            while (i < words.length && len < maxWidth) {
                len += words[i].length();
                if (len + temp.size() <= maxWidth) {
                    temp.add(words[i]);
                } else {
                    len -= words[i].length();
                    break;
                }
                i++;
            }
            int rem = maxWidth - len;
            int space = temp.size()-1 > 0 ? rem/(temp.size()-1) : rem;
            int d = temp.size()-1 > 0 ? rem%(temp.size()-1) : 0;
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < temp.size(); k++) {
                sb.append(temp.get(k));
                if (k == temp.size()-1) {
                    
                } else if (k == temp.size()-2) {
                    for (int ii = 0; ii < space+d; ii++) {
                         sb.append(" ");
                    }
                } else {
                    for (int ii = 0; ii < space; ii++) {
                         sb.append(" ");
                    }
                }
            }
            results.add(sb.toString());
        }
        return results;
    }
	
	public static void main(String args[]) {
		String strs[] = {"Listen","to","many,","speak","to","a","few."};
		int num = 6;
		System.out.println(fullJustify2(strs, num));;
	}
	
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % k > 0) {
            return false;
        }
        sum /= k;
        boolean used[] = new boolean[nums.length];
        for (int i = 0; i < k; i++) {
            if (!found(nums, used, sum)) {
                return false;
            }
        }
        boolean cl = true;
        for (boolean u : used) {
            cl = cl && u;
        }

        return cl;
    }
    
    private static boolean found(int[] nums, boolean[] used, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            sum += nums[i];
            if (nums[i] == target) {
                used[i] = true;
                return true;
            } else if (map.containsKey(sum-target)) {
                used[i] = true;
                for (int index : map.get(sum-target)) {
                     used[index] = true;
                }
                return true;
            } else {
                if (!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<Integer>());
                }
                map.get(sum).add(i);
            }
        }
        return false;
    }
	
    public static List<String> fullJustify2(String[] words, int maxWidth) {
        if (maxWidth == 0) {
            return Arrays.asList(words);
        }
        if (words.length == 0 && maxWidth == 0) {
            return new ArrayList<String>();
        }

        List<String> results = new ArrayList<>();
        int i = 0;
        while(i < words.length) {
            int len = 0;
            List<String> temp = new ArrayList<>();
            while (i < words.length && len < maxWidth) {
                len += words[i].length();
                if (len + temp.size() <= maxWidth) {
                    temp.add(words[i]);
                } else {
                    len -= words[i].length();
                    break;
                }
                i++;
            }
            int rem = maxWidth - len;
            // if words count is 1 or two
            if (i == words.length-1 || temp.size() == 1) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < temp.size(); k++) {
                    sb.append(temp.get(k));
                    if (k+1 < temp.size()) {
                        len++;
                        sb.append(" ");
                    }
                }
                for (int ii = len; ii < maxWidth; ii++) {
                    sb.append(" ");
                }
                results.add(sb.toString());
            } else {
                int space = temp.size()-1 > 0 ? rem/(temp.size()-1) : rem;
                int d = temp.size()-1 > 0 ? rem%(temp.size()-1) : 0;
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < temp.size(); k++) {
                    sb.append(temp.get(k));
                    if (k != temp.size()-1) {
                        for (int ii = 0; ii < space; ii++) {
                             sb.append(" ");
                        }
                        if (d > 0) {
                            sb.append(" ");
                            d--;
                        }
                    }
                }
                results.add(sb.toString());
            }
        }
        return results;
    }
	
	public static boolean isNumber(String s) {
        s = s.trim();
        
        boolean numberSeen = false;
        boolean numberSeenAfterE = true;
        boolean seenE = false;
        boolean dotSeen = false;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                numberSeen = true;
                numberSeenAfterE = true;
            } else if (ch == '.') {
                if (seenE || dotSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (ch == 'e') {
                if (dotSeen || !numberSeen) {
                    return false;
                }
                numberSeenAfterE = false;
                seenE = true;
            } else if (ch == '+' || ch == '-') {
                if (i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return numberSeen && numberSeenAfterE;
    }
	
	private static List<String> splits(String left) {
        List<String> leftSplits = new ArrayList<>();
        StringBuilder sp = new StringBuilder();
        for (int i = 0; i < left.length(); i++) {
            if ((left.charAt(i) == '+' || left.charAt(i) == '-') && i == 0) {
                sp.append(left.charAt(i));
                continue;
            }
            if (left.charAt(i) == '-' || left.charAt(i) == '+' || i == left.length()-1) {
                leftSplits.add(sp.toString()); 
                sp = new StringBuilder();
                sp.append(left.charAt(i));
            } else {
                sp.append(left.charAt(i));
            }
        }
        return leftSplits;
    }
}
