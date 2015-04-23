package com.zhd.sort;

//直接插入排序
public class InsertSortDirectApp {

	public static void main(String[] args) {
		int[] test = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
		showArray(test);
		doSort(test);
        showArray(test);
	}

	//基本有序下，效率最优O(n); 基本反序，效率最差O(n*n)
	static void doSort(int[] arr) {
		directInsertSort(arr);
	}
	
	private static void directInsertSort(int[] arr) {
		for(int out = 1; out < arr.length; out++) {
			int tmp = arr[out], in = out;
			for(; in > 0 && arr[in-1] >= tmp; --in) 
				arr[in] = arr[in-1];
			arr[in] = tmp;
			//System.out.println(out);showArray(arr);
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
