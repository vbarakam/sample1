package com.yahoo.util;

public class LongestAbsoluteFilePath {
	public static void main(String args[]) {
		String text = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		String splits[] = text.split("\n");
		int maxLen = 0;
		int [] depth = new int[splits.length + 1];
		for (String slit : splits) {
			int level = slit.lastIndexOf("\t") + 1;
			int currentLevel = depth[level+1] = depth[level] + slit.length() - level + 1;
			System.out.println(currentLevel);
			// end file
			if (slit.contains(".")) {
				maxLen = Math.max(maxLen, currentLevel -1);
			}
		}
		System.out.println(maxLen);
	}
}
