package com.zhd.test;

public class MergeSortApp {

	public static void main(String[] args) {

	}
	
	static void doSort(int[] arr) {
		//topDownMergeSort();
	}
	private static void topDownMergeSort(int[] a, int[] b, int n) {
		topDownSplitMerge(a, 0, n, b);
	}
	private static void copyArray(int[] b, int iBegin, int iEnd, int[] a) {
		for(int k = iBegin; k < iEnd; k++)
			a[k] = b[k];
	}
	private static void topDownSplitMerge(int[] a, int iBegin, int iEnd, int[] b) {
		if(iEnd - iBegin < 2) return;
		int iMiddle = (iEnd + iBegin)/2;
		topDownSplitMerge(a, iBegin, iMiddle, b);
		topDownSplitMerge(a, iMiddle, iEnd, b);
		topDownMerge(a, iBegin, iMiddle, iEnd, b);
		copyArray(b, iBegin, iEnd, a);
	}
	private static void topDownMerge(int[] a, int iBegin, int iMiddle, int iEnd, int[] b) {
		int i0 = iBegin, i1 = iMiddle;
		for(int j = iBegin; j < iEnd; j++) {
			if(i0 < iMiddle && (i1 >= iEnd || a[i0] <= b[i1])) {
				b[j] = a[i0];
				i0 = i0 + 1;
			} else {
				b[j] = a[i1];
				i1 = i1 + 1;
			}
		}
	}
	
	private static void showArray(int[] arr) {
		System.out.print("[ ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("]");
	}
}
