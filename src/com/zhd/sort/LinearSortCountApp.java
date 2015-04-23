package com.zhd.sort;

public class LinearSortCountApp {

	public static void main(String[] args) {
		//int[] test = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
		int[] test = new int[]{5, 4, 3, 2, 1, 9, 8, 7, 6, 77, -1};
		showArray(test);
		doSort(test);
        showArray(test);
	}
	static void doSort(int[] arr) {
		countSort(arr);
	}
	
	//计数排序(要求待排数据是整数)
	private static void countSort(int[] arr) { 
		int[] b = new int[arr.length]; 
		int max = 0, min = 0;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > arr[max]) max = i;
			if(arr[i] < arr[min]) min = i;
		}
		
		int k = arr[max] - arr[min] + 1; //这里k的大小是要排序的数组中，元素大小的极值差+1
		int[] c = new int[k]; //优化过的地方，减小了数组c的大小 
        for(int i = 0; i < arr.length; ++i) {
        	c[arr[i]-arr[min]] += 1; 
        }
        for(int i = 1; i < c.length; ++i) {
        	c[i] = c[i] + c[i-1];  
        }
        for(int i = arr.length-1; i >= 0; --i) {
        	b[--c[arr[i]-arr[min]]] = arr[i]; //按存取的方式取出c的元素  
        }
        
        for(int i = arr.length-1; i >= 0; --i) arr[i] = b[i];
	}
	
	private static void showArray(int[] arr) {
		System.out.print("[ ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("]");
	}
}
