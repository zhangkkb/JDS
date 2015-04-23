package com.zhd.sort;

//ºÚµ•—°‘Ò≈≈–Ú
public class SelectSortSimpleApp {

	public static void main(String[] args) {
		//int[] test = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
		int[] test = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 8, 7, 6, 5, 4, 3, 2, 1, 8, 7, 6, 5, 4, 3, 2, 1};
		showArray(test);
		doSort(test);
        showArray(test);
	}

	static void doSort(int[] arr) {
		simpleSelectSort(arr);
	}
	
	private static void simpleSelectSort(int[] arr) {
		for(int out = 0; out < arr.length; out++) {
			int min = out;
			for(int in = out + 1; in < arr.length; in++) 
				if(arr[in] < arr[min]) min = in;
			swap(out, min, arr);
			//System.out.println(out);showArray(arr);
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
