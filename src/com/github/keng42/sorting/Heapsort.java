package com.github.keng42.sorting;

import java.util.Random;

public class Heapsort {

	public static void main(String[] args) {
		Random r = new Random();
		int[] nums = new int[20];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = r.nextInt(100);
			System.out.print(nums[i] + " ");
		}

		heapsort(nums);

		System.out.println();
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}

	/**
	 * ������ʹ�ö������������
	 *
	 * @param nums ����������
	 */
	public static void heapsort(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}
		int len = nums.length;
		buildMaxHeap(nums, len);
		for (int i = len - 1; i > 0; i--) {
			swap(nums, 0, i);
			maxHeapify(nums, 0, --len);
		}
	}

	/**
	 * �����ʼ��
	 */
	public static void buildMaxHeap(int[] nums, int len) {
		if (nums == null || len <= 1) {
			return;
		}
		for (int i = parent(len - 1); i >= 0; i--) {
			maxHeapify(nums, i, len);
		}
	}

	/**
	 * ����󶥶�
	 * 
	 * @param nums ԭʼ����
	 * @param index ���ڵ��±�
	 * @param len ���������鳤��
	 */
	public static void maxHeapify(int[] nums, int index, int len) {
		int l = left(index);
		int r = right(index);
		int largest;
		if (l < len && nums[l] > nums[index]) {
			largest = l;
		} else {
			largest = index;
		}
		if (r < len && nums[r] > nums[largest]) {
			largest = r;
		}
		if (largest != index) {
			swap(nums, largest, index);
			maxHeapify(nums, largest, len);
		}
	}

	public static int left(int index) {
		return 2 * index + 1;
	}

	public static int parent(int index) {
		return (index - 1) / 2;
	}

	public static int right(int index) {
		return 2 * (index + 1);
	}

	public static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
