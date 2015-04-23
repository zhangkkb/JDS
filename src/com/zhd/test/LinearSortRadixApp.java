package com.zhd.test;

import java.util.Arrays;

public class LinearSortRadixApp {

	public static void main(String[] args) {
		int[] test = new int[]{5, 4, 3, 2, 1, 9, 8, 7, 6, 77, 890, 222, 64, 89};
		showArray(test);
		doSort(test);
        showArray(test);
	}
	private static void doSort(int[] arr) {
		radixSort(arr);
	}
	
	private static void radixSort(int[] arr) {
		int digit = countDigit(arr); //digit ��������Ԫ�ص�λ����ʵ����������������
		int radix = 10; //radix ���������ʵ�ʾ��Ǽ������֣��Ǿ���10�
		radixSort(arr, radix, digit);
	}
	private static void radixSort(int[] arr, int radix, int digit) {
		int len = arr.length;
		int[] res = new int[len];
		int[] c = new int[radix];
		int divide = 1;
		
		for(int i = 0; i < digit; i++) {
			res = Arrays.copyOf(arr, len);
			Arrays.fill(c, 0);
			
			//���������ȶ���
			for(int j = 0; j < len; j++) {
				int key = (res[j]/divide) % radix;
				c[key]++;
			}
			for(int j = 1; j < radix; j++) {
				c [j] = c[j] + c[j-1];
			}
			for(int j = len - 1; j >= 0; j--) {
				int key = (res[j]/divide) % radix;
				arr[c[key]-1] = res[j];
				c[key]--;
			}
			divide = divide * radix; 
		}
	}
	private static int countDigit(int[] arr) {
		int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int time = 0;
        while (max > 0) {
            max /= 10;
            time++;
        }
		return time;
	}
	
	private static void showArray(int[] arr) {
		System.out.print("[ ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("]");
	}
}
