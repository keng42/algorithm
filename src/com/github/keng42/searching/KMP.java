package com.github.keng42.searching;

public class KMP {

	public static void main(String[] args) {
		String str = "BBC ABCDAB ABCDABCDABDE";
		String target = "ABCDABD";
		System.out.println(kmp(str, target));
	}

	public static int kmp(String str, String target) {
		int[] table = new int[target.length()];
		createTable(target, table);

		for (int i = 0, j = 0; i < str.length();) {
			if (str.charAt(i) == target.charAt(j)) {
				if (j == target.length() - 1) {
					return i - j;
				}
				j++;
				i++;
			} else {
				i -= table[j];
				j = 0;
			}
		}
		return -1;
	}

	/**
	 * 计算部分匹配值表
	 */
	public static void createTable(String target, int[] table) {
		int tmp = 0;
		table[0] = -1;
		for (int i = 2; i < target.length();) {
			if (target.charAt(i - 1) == target.charAt(tmp)) {
				table[i++] = ++tmp;
			} else if (tmp > 0) {
				tmp = table[tmp];
			} else {
				table[i] = 0;
				i++;
			}
		}
	}
}
