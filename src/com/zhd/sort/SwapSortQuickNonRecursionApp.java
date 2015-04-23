package com.zhd.sort;

import java.util.LinkedList;



//快速排序(基于交换)
public class SwapSortQuickNonRecursionApp {

	public static void main(String[] args) {
		int[] test = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
		showArray(test);
		doSort(test);
        showArray(test);
	}
	
	//小->大
	static void doSort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
		quickSort2(arr, 0, arr.length-1);
	}
	private static void quickSort(int[] arr, int left, int right) {
		int dp;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		if(left < right) {
			dp = partition(arr, left, right);
			if(left < dp-1) {
				stack.push(left);
				stack.push(dp-1);
			}
			if(right > dp+1) {
				stack.push(dp+1);
				stack.push(right);
			}
		}
		
		while(!stack.isEmpty()) {
			int r = stack.pop();
			int l = stack.pop();
			dp = partition(arr, l, r);
			if(l < dp-1) {
				stack.push(l);
				stack.push(dp-1);
			}
			if(r > dp+1) {
				stack.push(dp+1);
				stack.push(r);
			}			
		}
	}
	private static void quickSort2(int[] arr, int left, int right) {
		if(left > right) return;
		
		int dp;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		do {
            if(!stack.isEmpty()) {
				right = stack.pop();
				left = stack.pop();	
            }
            
			dp = partition(arr, left, right);
			if (left < dp - 1) {
				stack.push(left);
				stack.push(dp - 1);
			}
			if (right > dp + 1) {
				stack.push(dp + 1);
				stack.push(right);
			}
		
		} while(!stack.isEmpty());
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


