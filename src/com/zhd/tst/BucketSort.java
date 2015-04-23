package com.zhd.tst;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class BucketSort {

    public static void bucketSort(double array[]) {
        int length = array.length;
        ArrayList arrList[] = new ArrayList[length];
        /*
         *  ÿ��Ͱ��һ��list��������ڴ�Ͱ�ϵ�Ԫ��
         *  �ϴεĻ��������Ҳ��õ��Ǽ�������ʵ�ֵģ���ʵҲ����������ķ���������Ȥ�Ķ��߲���һ��(����Ϊ̫����)
         *  ����Ч�ʹ��Ʋ���(�����˶�̬����)
         */
        //����Ͱ����Ԫ��
        for (int i = 0; i < length; i++) {
            //0.7��0.79���ڵ�8��Ͱ��,���7����һ��Ͱ��0��0.09
            int temp = (int) Math.floor(10 * array[i]);
            if (null == arrList[temp])
                arrList[temp] = new ArrayList();
            arrList[temp].add(array[i]);
        }
        // ��ÿ��Ͱ�е������в�������
        for (int i = 0; i < length; i++) {
            if (null != arrList[i]) {
                //�˴����򷽷�����������Խ��Խ�ã������������������⣬��û��Collections
                //��Arrays���sort�ã���Ϊ���ǵ��ź�Ŀ���
                //Arrays��Ҳ�У��ڻ����������ù�copyOf��fill����
                Collections.sort(arrList[i]);
            }
                
        }
        //������Ƹ볲����
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (null != arrList[i]) {
                Iterator iter = arrList[i].iterator();
                while (iter.hasNext()) {
                    Double d = (Double) iter.next();
                    array[count] = d;
                    count++;
                }
            }
        }
    }

    /*
     * ÿ��Ԫ������0<=array[i]<1,ò�ƻ�Ҫ������ͬ��
     * ������ͬС��λ(digit)������԰�С����Ϊ����������ٳ���10^digit
     *  ����Random.nextInt(101)/100
     */
    public static void main(String[] args) {
        double array[] = { 0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21, 0.12,
                0.23, 0.68 };
        bucketSort(array);
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}