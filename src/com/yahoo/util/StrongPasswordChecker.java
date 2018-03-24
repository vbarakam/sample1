package com.yahoo.util;

import java.util.*;

public class StrongPasswordChecker {
	public static void main(String args[]) {
		// String str = "1234567890123456Baaaaa";
		//String str = "1111111111";
		//String str = "abababababababababaaa";
		//String str = "aaa111";
		//String str = "ABABABABABABABABABAB1";
		//String str = "aaaaaaaaaaaaaaaaaaaaa";
		// System.out.println(strongPasswordChecker(str));
		String str = "1234567890123456Baaaaa";
		System.out.println(strongPasswordChecker(str));
	}

	private static List<Integer> generateGroups(String s) {
		List<Integer> groups = new ArrayList<>();
		for (int i = 0; i < s.length();) {
			int j = i;
			while (j < s.length() && s.charAt(j) == s.charAt(i)) {
				j++;
			}
			groups.add(j - i);
			i = j;
		}
		return groups;
	}

	public static int strongPasswordChecker(String s) {
        int minChanges = minChanges(s);
        List<Integer> groups = groupChanges(s);
        int updates = 0;
        int zeros = 0;
        int ones = 0;
        for (int group : groups) {
            updates += group/3;
            if (group/3 > 0 && group % 3 == 0) {
                zeros++;
            } else if (group/3 > 0 && group % 3 == 1) {
                ones++;
            }
        }
        
        if (s.length() < 6) {
            return Math.max(minChanges, 6-s.length());
        } else if (s.length() <= 20) {
            return Math.max(minChanges, updates);    
        } else {
            int del = s.length() - 20;
            if (zeros >= del) {
                updates -= del;
            } else if (2*ones >= del-zeros) {
                updates -= zeros + (del-zeros)/2;
            } else {
                updates -= zeros + ones + (del-zeros-2*ones)/3;
            }
            return del + Math.max(minChanges, updates);
        }
    }
    
    public static List<Integer> groupChanges(String s) {
        List<Integer> group = new ArrayList<>();
        for (int i = 0; i < s.length();) {
            int j = i;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            group.add(j-i);
            i = j;
        }
        return group;
    }
    
    public static int minChanges(String s) {
        int l = 0;
        int u = 0;
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                l++;
            } else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                u++;
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                n++;
            }
        }
        return ((l == 0 ? 1:0) + (u == 0 ? 1 : 0) + (n == 0 ? 1 : 0));
    }

	public static List<Integer> groups(String s) {
		List<Integer> group = new ArrayList<>();
		for (int i = 0; i < s.length();) {
			int j = i;
			while (j < s.length() && s.charAt(i) == s.charAt(j)) {
				j++;
			}
			group.add(j - i);
			i = j;
		}
		return group;
	}

	public static int getMinReplace(String s) {
		int l = 0;
		int u = 0;
		int d = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				l++;
			} else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				u++;
			} else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				d++;
			}

		}
		int updateOrAdd = (l == 0 ? 1 : 0) + (u == 0 ? 1 : 0) + (d == 0 ? 1 : 0);
		return updateOrAdd;
	}

	public static int strongPasswordChecker2(String s) {
		// check length
		int add = 0;
		int delete = 0;
		if (s.length() < 6) {
			add = 6 - s.length();
		} else if (s.length() > 20) {
			delete = s.length() - 20;
		}
		int l = 0;
		int u = 0;
		int d = 0;
		int repeat = 0;
		int lastMatch = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				l++;
			} else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				u++;
			} else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				d++;
			}
			if ((i - lastMatch >= 3) && ((i - 2) >= 0 && s.charAt(i) == s.charAt(i - 2))
					&& ((i - 1) >= 0 && s.charAt(i) == s.charAt(i - 1))) {
				repeat++;
				lastMatch = i;
			}
		}
		int updateOrAdd = (l == 0 ? 1 : 0) + (u == 0 ? 1 : 0) + (d == 0 ? 1 : 0);
		if (add > 0) {
			return Math.max(add, Math.max(repeat, updateOrAdd));
		} else {
			// can delete take care of repeat
			// repeat - updateOrAdd ? delete
			return Math.max(delete + updateOrAdd, repeat);
		}
	}
}
