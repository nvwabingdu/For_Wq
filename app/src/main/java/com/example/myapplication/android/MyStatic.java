package com.example.myapplication.android;

import android.util.Log;

import java.util.Arrays;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-10-13
 * Time: 11:25
 */
class MyStatic {
    //三元运算符比较大小
    public static int three_math(int a,int b,int c) {
        a=a>b?a:b;
        a=a>c?a:c;
        return a;
    }

    //冒泡排序
    public static  String maoPao(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    //方法一：通用
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    //方法二：换成二进制然后在进行（整型）
//                  arr[j]  = arr[j] ^ arr[j+1];
//                  arr[j+1]= arr[j] ^ arr[j+1];
//                  arr[j]  = arr[j] ^ arr[j+1];
                    //方法三：  数字型
//                  arr[j] = arr[j] + arr[j+1];
//                  arr[j+1] = arr[j] -arr[j+1];
//                  arr[j] = arr[j] -arr[j+1];
                }
            }
        }
        return Arrays.toString(arr);
    }

    //二位数组遍历
    public static void twoforeach(int[][] arr) {
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                Log.d("arr.length",arr.length+"");
                Log.d("arr[].length",arr[i].length+"");
            }
        }
    }

    //二分查找方法
    //方法一：直接调用BinarySearch()二分查找方法
    public static int halfSearch() {
        int[] arr = new int[]{45, 78, 79, 102, 123, 145, 165, 178, 198, 255, 320};
        Log.e("binarySearch", Arrays.binarySearch(arr, 78) + "");
        Log.e("binarySearch", arr[Arrays.binarySearch(arr, 78)] + "");
        return 0;
    };

    //方法二：自己手写
    public static int halfSearsh(int[] arr,int key) {
        int min,max,mid;
        min=0;
        max=arr.length-1;
        mid=(min+max)/2;
        while(arr[mid]!=key){
            if(key>arr[mid]){
                min=mid+1;
            }else {
                max=mid-1;
            }
            mid=(min+max)/2;
            if(min>max){
                return -1;
            }
        }
        return mid;
    }


}
