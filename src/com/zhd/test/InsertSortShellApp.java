package com.zhd.test;

//shell 排序
public class InsertSortShellApp {

	public static void main(String[] args) {
		int[] test = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		showArray(test);
		doSort(test);
        showArray(test);
        System.exit(0);
	}

	//最好，最坏情况下，效率相差不大
	static void doSort(int[] arr) {
		int h = 1;
		while(h <= arr.length/3) h = h*3+1;
		
		while(h>0) {
			for(int out = h; out < arr.length; out++) {
				/*
				int tmp = arr[out], in = out;
				while(in > h-1 && arr[in-h] >= tmp) {
					arr[in] = arr[in-h];
					in -= h;
				}
				arr[in] = tmp;
				*/
				int tmp = arr[out], in = out;
				for(; in > h-1 && arr[in-h] >= tmp; in -= h) {
					arr[in] = arr[in-h];
				}
				arr[in] = tmp;
				
				System.out.println("out=" + out + " h=" + h);showArray(arr);
			}
			h = (h-1)/3;
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
