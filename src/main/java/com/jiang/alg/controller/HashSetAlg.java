package com.jiang.alg.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用哈希表
 * 利用好哈希表可以做到空间换时间
 *
 * @author Jiang Zaiming
 * @date 2020/8/21 3:36 下午
 */
public class HashSetAlg {

    public static void main(String[] args) {

        // 最长和谐序列
//        int[] arr = new int[]{1, 3, 2, 2, 5, 2, 3, 7};
//        System.out.println(Arrays.toString(arr));
//        System.out.println(findLHS(arr));

        // 最长连续序列
        int[] arr = new int[]{100, 4, 20, 0, 5, 1, 3, 2};
        System.out.println(Arrays.toString(arr));
        System.out.println(findLLX(arr));

    }

    /**
     * while循环，也可以使用递归的方式
     *
     * @param arr
     *
     * @return
     */
    private static int findLLX(int[] arr) {
        Map<Integer, Integer> intMap = new HashMap<>();
        for (int num : arr) {
            intMap.put(num, 1);
        }
        int l = 1;
        for (int num : arr) {
            // 判断下一个值是否存在
            int next = num;
            int numL = 1;
            if (intMap.containsKey(num)) {
                while (intMap.containsKey(++next)) {
                    numL++;
                }
            }
            l = Math.max(l, numL);
        }
        return l;
    }

    /**
     * 使用哈希表存储数据
     *
     * @param nums
     *
     * @return
     */
    public static int findLHS(int[] nums) {
        Map<Integer, Integer> countForNum = new HashMap<>();
        for (int num : nums) {
            countForNum.put(num, countForNum.getOrDefault(num, 0) + 1);
        }
        int longest = 0;
        for (int num : countForNum.keySet()) {
            if (countForNum.containsKey(num + 1)) {
                longest = Math.max(longest, countForNum.get(num + 1) + countForNum.get(num));
            }
        }
        return longest;
    }

}
