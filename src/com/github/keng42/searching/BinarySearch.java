package com.github.keng42.searching;

import java.util.Random;

public class BinarySearch {

	public static void main(String[] args) {
		Random r = new Random();
		int[] nums = new int[20];
		int span = 0;
		for (int i = 0; i < nums.length; i++) {
			span += r.nextInt(3);
			nums[i] = i + span;
			System.out.println(i + " : " + nums[i] + " ");
		}
		System.out.println();
		System.out.println(binarySearch(nums, 10));
	}

	/**
	 * 二分查找
	 *
	 * @param nums 有序数组
	 * @param value 目标元素
	 * @return 元素下标
	 */
	public static int binarySearch(int[] nums, int value) {
		if (nums == null) {
			return -1;
		}
		int max = nums.length;
		int middle = nums.length / 2;
		while (true) {
			if (nums[middle] == value) {
				return middle;
			}
			if (nums[middle] > value) {
				if (middle <= 0) {
					return -1;
				} else {
					max = middle;
					middle = middle / 2;
				}
			} else {
				if (middle >= max - 1) {
					return -1;
				} else {
					middle = (middle + max) / 2;
				}
			}
		}
	}
}
