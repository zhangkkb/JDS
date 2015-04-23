package com.zhd.test;

//快速排序(基于交换)
public class SwapSortQuickApp {

	public static void main(String[] args) {
		int[] test = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
		showArray(test);
		doSort(test);
        showArray(test);
	}
	
	//小->大
	static void doSort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
	}
	private static void quickSort(int[] arr, int left, int right) {
		int dp;
		if(left < right) {
			dp = partition(arr, left, right);
			quickSort(arr, left, dp-1);
			quickSort(arr, dp+1, right);
		}
	}
	private static int partition(int[] n, int left, int right) {
		int pivot = n[left];
		while(left < right) {
			while(left < right && n[right] >= pivot) right--;
			if(left < right) n[left++] = n[right];
			while(left < right && n[left] <= pivot) left++;
			if(left < right) n[right--] = n[left];
		}
		n[left] = pivot;
		return left;
	}
	
	private static void showArray(int[] arr) {
		System.out.print("[ ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("]");
	}
}
