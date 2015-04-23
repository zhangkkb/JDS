package com.zhd.test;

//改进选择排序（堆排序）
public class SelectSortHeapApp {

	public static void main(String[] args) {
		int[] test = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		showArray(test);
		doSort(test);
        showArray(test);
        System.exit(0);
	}

	static void doSort(int[] arr) {
		buildHeap(arr, arr.length);
		for(int i = arr.length - 1; i > 0; --i) {
			swap(i, 0, arr);
			heapAdjust(arr, 0, i);
		}
	}
	private static void heapAdjust(int[] arr, int s, int len) { //构建大根堆
		int tmp = arr[s], child = 2*s+1;
		while(child < len) {
			if(child+1 < len && arr[child] < arr[child+1])
				++child;
			if(arr[s] < arr[child]) {
				arr[s] = arr[child];
				s = child;
				child = 2*s+1;
			} else {
				break;
			}
			arr[s] = tmp;
		}
	}
	private static void buildHeap(int[] arr, int len) {
		for(int i = (len-1)/2; i > 0; --i) 
			heapAdjust(arr, i, len);
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
