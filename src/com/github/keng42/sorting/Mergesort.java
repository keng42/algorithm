package com.github.keng42.sorting;

import java.util.Random;

public class Mergesort {

	public static void main(String[] args) {
		Random r = new Random();
		int[] nums = new int[20];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = r.nextInt(100);
			System.out.print(nums[i] + " ");
		}

		mergesort(nums, 0, nums.length - 1);

		System.out.println();
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}

	/**
	 * 对数组进行分组然后合并
	 *
	 * @param nums 原始数组
	 * @param p 数组起点
	 * @param r 数组终点
	 */
	public static void mergesort(int[] nums, int p, int r) {
		if (nums != null && p < r) {
			int q = (r + p) / 2;
			mergesort(nums, p, q);
			mergesort(nums, q + 1, r);
			merge(nums, p, q, r);
		}
	}

	/**
	 * 合并两个数组
	 *
	 * @param nums 原始数组
	 * @param p 起点
	 * @param q 第一个数组终点
	 * @param r 终点
	 */
	public static void merge(int[] nums, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] left = new int[n1 + 1];
		int[] right = new int[n2 + 1];
		System.arraycopy(nums, p, left, 0, n1);
		System.arraycopy(nums, q + 1, right, 0, n2);
		left[n1] = Integer.MAX_VALUE;
		right[n2] = Integer.MAX_VALUE;

		int i = 0, j = 0;
		for (int k = p; k <= r; k++) {
			if (left[i] <= right[j]) {
				nums[k] = left[i++];
			} else {
				nums[k] = right[j++];
			}
		}
	}
}
