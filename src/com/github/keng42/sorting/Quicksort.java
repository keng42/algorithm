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
	 * �ݹ���ã����϶�������з���
	 * 
	 * @param nums ����������
	 * @param p ����±�
	 * @param r �յ��±�
	 */
	public static void quicksort(int[] nums, int p, int r) {
		if (p < r) {
			int q = partition(nums, p, r);
			quicksort(nums, p, q - 1);
			quicksort(nums, q + 1, r);
		}
	}

	/**
	 * ��������з���
	 * 
	 * @param nums ԭʼ����
	 * @param p Ŀ����������±�
	 * @param r Ŀ�������յ��±�
	 * @return ��������н��±�
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
