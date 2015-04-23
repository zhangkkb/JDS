package com.zhd.sort;

public class MergeSortApp {

	public static void main(String[] args) {
		//int[] test = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
		int[] test = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 8, 7, 6, 5, 4, 3, 2, 1, 8, 7, 6, 5, 4, 3, 2, 1, 8, 7, 6, 5, 4, 3, 2, 1};
		showArray(test);
		doSort(test);
        showArray(test);
        System.exit(0);
	}
	
	static void doSort(int[] arr) {
		mergeSort(arr, 0, arr.length-1);
	}
	
    private static void mergeSort(int[] array, int left, int right) {
        if (left >= right)
            return;
        int center = (left + right) / 2;// 找出中间索引
        mergeSort(array, left, center);// 对左边数组进行递归
        mergeSort(array, center + 1, right);// 对右边数组进行递归
        merge(array, left, center, right);// 合并
        //showArray(array);
    }
    private static void merge(int[] array, int left, int center, int right) {
        int[] tmpArr = new int[array.length];
        int mid = center + 1;
        int third = left;
        int tmp = left;
        while (left <= center && mid <= right) {
            if (array[left] <= array[mid]) {
                tmpArr[third++] = array[left++];
            } else {
                tmpArr[third++] = array[mid++];
            }
        }
        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
        while (mid <= right) {
            tmpArr[third++] = array[mid++];
        }
        while (left <= center) {
            tmpArr[third++] = array[left++];
        }
        // 将临时数组中的内容拷贝回原数组中 （原left-right范围的内容被复制回原数组）
        while (tmp <= right) {
            array[tmp] = tmpArr[tmp++];
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
