package com.zhd.tst;
import java.util.Arrays;

public class RadixSort {
    //���ڼ�������Ļ��������㷨
    public static void radixSort(int[] array,int radix, int digit) {
        //arrayΪ����������
        //radix�����������ʵ�ʾ��Ǽ������֣��Ǿ���10�
        //digit��������Ԫ�ص�λ����ʵ����������������
        
        int length = array.length;
        int[] res = new int[length];
        int[] c = new int[radix];//radix����10����Ϊ0��9��10������
        int divide = 1;//����ÿ�ΰ�������С10��
        
        for (int i = 0; i < digit; i++) {
            
            res = Arrays.copyOf(array, length);
            Arrays.fill(c, 0);
            
            for (int j = 0; j < length; j++) {
                int tempKey = (res[j]/divide)%radix;
                c[tempKey]++;
            }
            
            for (int j = 1; j < radix; j++) {
                c [j] = c[j] + c[j-1];
            }
            
            for (int j=length-1; j>=0; j--) {
                int tempKey = (res[j]/divide)%radix;
                array[c[tempKey]-1] = res[j];
                c[tempKey]--;
            }
            divide = divide * radix;                
        }
    }
    
    public static int countDigit(int[] array) {

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        
        int time = 0;
        while (max > 0) {
            max /= 10;
            time++;
        }
        return time;
    }
    
    public static void main(String[] args) {

        int[] array = {3,2,3,2,5,333,45566,2345678,78,990,12,432,56};
        int time = countDigit(array);
        //System.out.println(time);
        radixSort(array,10,time);
        for (int i = 0; i < array.length; i++) {
            System.out.print("  " + array[i]);
        }
    }
}