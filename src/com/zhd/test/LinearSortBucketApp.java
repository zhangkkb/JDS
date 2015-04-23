package com.zhd.test;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class LinearSortBucketApp {

	public static void main(String[] args) {
		//int[] test = new int[]{5, 4, 3, 2, 1, 9, 8, 7, 6, 77, -1};
		double[] test = { 0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21, 0.12, 0.23, 0.68 };
		showArray(test);
		doSort(test);
        showArray(test);
	}
	static void doSort(double[] arr) {
		bucketSort(arr);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void bucketSort(double[] arr) {
		int len = arr.length;
		LinkedList[] lls = new LinkedList[len];
		//划分桶并填元素
        for(int i = 0; i < len; i++) {
            int tmp = (int) Math.floor(10 * arr[i]); //0.7到0.79放在第8个桶里,编号7；第一个桶放0到0.09
            if (null == lls[tmp]) lls[tmp] = new LinkedList();
            lls[tmp].add(arr[i]);
        }
        // 对每个桶中的数进行排序
        for(int i = 0; i < len; i++) {
        	if (null != lls[i]) {
        		Collections.sort(lls[i]); //Collections和Arrays里的sort 是调优后的快排
        	}
        }
        //输出类似鸽巢排序
        int count = 0;
        for(int i = 0; i < len; i++) {
            if (null != lls[i]) {
                Iterator iter = lls[i].iterator();
                while (iter.hasNext()) {
                	arr[count++] = (Double)iter.next();
                }
            }
        }
	}
	
//	private static void showArray(int[] arr) {
//		System.out.print("[ ");
//		for(int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println("]");
//	}
	private static void showArray(double[] arr) {
		System.out.print("[ ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("]");
	}
}
