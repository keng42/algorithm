package com.github.keng42.sorting;

import java.util.Random;

public class Quicksort {

	public static void main(String[] args) {
		Random r = new Random();
		int[] nums = new int[20];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = r.nextInt(100);
			System.out.print(nums[i] + " ");
		}

		quicksort(nums, 0, nums.length - 1);

		System.out.println();
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}

	/**
	 * 递归调用，不断对数组进行分区
	 * 
	 * @param nums 待排序数组
	 * @param p 起点下标
	 * @param r 终点下标
	 */
	public static void quicksort(int[] nums, int p, int r) {
		if (p < r) {
			int q = partition(nums, p, r);
			quicksort(nums, p, q - 1);
			quicksort(nums, q + 1, r);
		}
	}

	/**
	 * 对数组进行分区
	 * 
	 * @param nums 原始数组
	 * @param p 目标数组起点下标
	 * @param r 目标数组终点下标
	 * @return 数组分区中界下标
	 */
	public static int partition(int[] nums, int p, int r) {
		int i = p - 1, tmp;
		for (int j = p; j < r; j++) {
			if (nums[j] < nums[r]) {
				tmp = nums[++i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
		}
		tmp = nums[++i];
		nums[i] = nums[r];
		nums[r] = tmp;
		return i;
	}
}
