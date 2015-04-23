package com.zhd.test;

//ºÚµ•—°‘Ò≈≈–Ú
public class SelectSortDoubleApp {

	public static void main(String[] args) {
		int[] test = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
		showArray(test);
		doSort(test);
        showArray(test);
	}

	static void doSort(int[] arr) {
		for(int out = 0; out < arr.length; out++) {
			int min = out;
			//int max = out;
			for(int in = out + 1; in < arr.length; in++) {
				if(arr[in] < arr[min]) min = in;
				//if(arr[in] > arr[max]) max = in;
			}
			swap(out, min, arr);
			//swap(out, max, arr);
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
