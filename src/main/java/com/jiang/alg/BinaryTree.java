package com.jiang.alg;

import java.util.HashMap;
import java.util.Map;

public class BinaryTree {

    public static void main(String[] args) {
        // 先练习二叉树相关的算法题 ..222 333；；；；
        // afaf ;;;as
        // 先练习二叉树相关的算法题 ..222 333；；；； 大萨达
        // 先练习二叉树相关的算法题 ..222 333；；；； sada
        // 先练习二叉树相关的算法题 ..222 333；；；；  aaaa   bbb
        // 先练习二叉树相关的算法题 ..222 333；；；；  aaaa vvv
    }

    /**
     * 使用hash表记录数据，单链表能够降低时间复杂度
     * @param nums
     * @param target
     * @return
     */
    public int[] getSumNum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i= 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
    /**
     * 使用位运算，代替hash表记录数据，更加快速，位运算很快
     * 速度最快，且有点很多，但是数组长度有限，西乡很重要，最主要的是
     * 利用了位运算，对计算机比较友好
     * @param nums
     * @param target
     * @return
     */
    public int[] getSumNum2(int[] nums, int target) {
        int indexArrayMax = 2047; // 位数上诠释1
        int[] indexArrays = new int[indexArrayMax + 1];
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            diff = target - nums[i];
            if (indexArrays[diff & indexArrayMax] != 0) {
                return new int[] {indexArrays[diff & indexArrayMax] - 1, i};
            }
            indexArrays[nums[i] & indexArrayMax] = i + 1;
        }
        return null;
    }

    /**
     * 上下翻转二叉树
     *
     *
     * 
     */
    public void reverseBinaryTree(){

    }

}
