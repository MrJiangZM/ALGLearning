package com.jiang.alg.controller;

import java.util.Arrays;

/**
 * 几种简单的数组排序算法
 * <p>
 * https://www.cnblogs.com/onepixel/articles/7674659.html
 *
 * @author Jiang Zaiming
 * @date 2020/4/16 2:11 下午
 */
public class ArrayBasic {

    public static void main(String[] args) {
//        int[] nums1 = {14, 2, 4};
        int[] nums1 = {14, 2, 4, 2, 8, 32, 4, 12, 3, 21, 5, 23, 5, 1, 34, 135, 23, 4, 63, 23, 4, 62, 3, 45, 23, 4, 12, 34, 54, 5, 24, 63, 65, 4, 62, 34, 52, 6, 23, 48, 46, 2};
        System.out.println(Arrays.toString(nums1));
//        test1(nums1);
//        test2(nums1);
//        test3(nums1);
//        test5(nums1);
//        test6(nums1);
//        test7(nums1, 0, nums1.length - 1);
//        test8(nums1, 0, nums1.length - 1);
        nums1 = test9(nums1, 135);
        System.out.println(Arrays.toString(nums1));

    }

    /**
     * 冒泡排序  11
     * 左右相邻比较然后换位
     * 时间复杂度应该是  n2
     *
     * @param nums
     */
    public static void test1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序  2
     * <p>
     * 第一位和最后那位比较，然后比较第二个
     *
     * @param nums
     */
    public static void test2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[nums.length - 1 - i] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[nums.length - 1 - i];
                    nums[nums.length - 1 - i] = temp;
                }
            }
        }
    }

    /**
     * 选择排序   找出最大值，然后放到最后
     * 然后在剩下的地方再找到最大值
     *
     * @param nums
     */
    public static void test3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int maxIndex = 0;  // 找到最大值得索引
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[maxIndex]) {
                    maxIndex = j;
                }
            }
            int index = nums.length - 1 - i;
            int temp = nums[maxIndex];
            nums[maxIndex] = nums[index];
            nums[index] = temp;
        }
    }

    /**
     * 快速排序
     * <p>
     * 快速排序之所以比较快，是因为相比冒泡排序，每次的交换都是跳跃式的，每次设置一个基准值，
     * 将小于基准值的都交换到左边，大于基准值的都交换到右边，这样不会像冒泡一样每次都只交换相邻的两个数，
     * 因此比较和交换的此数都变少了，速度自然更高。当然，也有可能出现最坏的情况，就是仍可能相邻的两个数进行交换。
     * <p>
     * 快速排序基于分治思想，它的时间平均复杂度很容易计算得到为O(NlogN)。
     *
     * @param nums
     */
    public static void test4(int[] nums) {
        int len;
        if (nums == null
                || (len = nums.length) == 0
                || len == 1) {
            return;
        }
        quickSort(nums, 0, len - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }

    /**
     * 插入排序
     * <p>
     * 一点点往后取数据，然后使用把这条和前面已经拍好的比较排序
     *
     * @param nums
     */
    public static void test5(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }


    /**
     * 希尔排序
     * 快速插入排序
     * https://blog.csdn.net/qq_28081081/article/details/80598960
     *
     * <p>
     * 一点点往后取数据，然后使用把这条和前面已经拍好的比较排序
     *
     * @param nums
     */
    public static void test6(int[] nums) {
        int n = nums.length;
        int gap = n / 2;
        while (gap > 0) {
            for (int j = gap; j < n; j++) {
                int i = j;
                while (i >= gap && nums[i - gap] > nums[i]) {
                    int temp = nums[i - gap] + nums[i];
                    nums[i - gap] = temp - nums[i - gap];
                    nums[i] = temp - nums[i - gap];
                    i -= gap;
                }
            }
            gap = gap / 2;
        }
    }


    /**
     * 归并排序  最好最坏都是 n*log(n)
     * 一点点往后取数据，然后使用把这条和前面已经拍好的比较排序
     * TODO TODO 还没有完全理解
     *
     * @param nums
     */
    public static void test7(int[] nums, int start, int end) {
        if (start < end) {//当子序列中只有一个元素时结束递归
            int mid = (start + end) / 2;//划分子序列
            test7(nums, start, mid);//对左侧子序列进行递归排序
            test7(nums, mid + 1, end);//对右侧子序列进行递归排序
            merge(nums, start, mid, end);//合并
        }
    }

    /**
     * 两路归并算法，两个排好序的子序列合并为一个子序列
     *
     * @param a
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] a, int left, int mid, int right) {
        int[] tmp = new int[a.length];//辅助数组
        int p1 = left, p2 = mid + 1, k = left;//p1、p2是检测指针，k是存放指针

        while (p1 <= mid && p2 <= right) {
            if (a[p1] <= a[p2]) {
                tmp[k++] = a[p1++];
            } else {
                tmp[k++] = a[p2++];
            }
        }

        while (p1 <= mid) {
            tmp[k++] = a[p1++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        }
        while (p2 <= right) {
            tmp[k++] = a[p2++];//同上
        }

        //复制回原素组
        for (int i = left; i <= right; i++) {
            a[i] = tmp[i];
        }
    }


    /**
     * 堆排序
     * <p>
     * TODO
     * 使用到了二叉树的特点
     *
     * @param nums
     */
    public static void test8(int[] nums) {
        int n = nums.length;
        int gap = n / 2;
        while (gap > 0) {
            for (int j = gap; j < n; j++) {
                int i = j;
                while (i >= gap && nums[i - gap] > nums[i]) {
                    int temp = nums[i - gap] + nums[i];
                    nums[i - gap] = temp - nums[i - gap];
                    nums[i] = temp - nums[i - gap];
                    i -= gap;
                }
            }
            gap = gap / 2;
        }
    }


    /**
     * 计数排序 需要知道数据的范围，最好是整数，等步长
     * 主要去取决于数据样式
     * 时间复杂度 O(n+k)
     * 空间复杂度 O(n+k)
     *
     * @param array
     * @param k
     *
     * @return
     */
    public static int[] test9(int[] array, int k) {
        int[] C = new int[k + 1];//构造C数组
        int length = array.length, sum = 0;//获取A数组大小用于构造B数组
        int[] B = new int[length];//构造B数组
        for (int i = 0; i < length; i++) {
            C[array[i]] += 1;// 统计A中各元素个数，存入C数组
        }
        for (int i = 0; i < k + 1; i++)//修改C数组
        {
            sum += C[i];
            C[i] = sum;
        }
        for (int i = length - 1; i >= 0; i--)//遍历A数组，构造B数组
        {

            B[C[array[i]] - 1] = array[i];//将A中该元素放到排序后数组B中指定的位置
            C[array[i]]--;//将C中该元素-1，方便存放下一个同样大小的元素

        }
        return B;//将排序好的数组返回，完成排序
    }

}
