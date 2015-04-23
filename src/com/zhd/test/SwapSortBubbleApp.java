package com.zhd.test;

//Ã°ÅÝÅÅÐò
public class SwapSortBubbleApp {

	public static void main(String[] args) {
		int[] test = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
		showArray(test);
		doSort(test);
        showArray(test);
	}
	
	//Ð¡->´ó
	static void doSort(int[] arr) {
		for(int out = arr.length - 1; out > 0; out--) {
			for(int in = 0; in < out; in++) {
				if(arr[in] > arr[in+1]) swap(in, in+1, arr);
			}
			System.out.println(out);showArray(arr);
		}
	}
	
	private static void swap(int one, int two, int[] arr) {
		int tmp = arr[one];
		arr[one] = arr[two];
		arr[two] = tmp;
	}
	
	private static void showArray(int[] arr) {
		System.out.print("[ ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("]");
	}
}
