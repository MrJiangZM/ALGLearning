package com.jiang.alg.controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 队列和栈相关算法题
 * 简单版
 *
 * @author Jiang Zaiming
 * @date 2020/8/20 8:22 下午
 */
public class QueueStackAlg {

    public static void main(String[] args) {
        // 使用栈实现队列
        // MyQueue

        // 使用队列实现栈
        // MyStack

        // 最小值栈
        // MinStack

        // 用栈实现括号匹配 (){}[]
//        System.out.println(isValid("(()){()}([][]())"));

        // 数组中元素与下一个比它大的元素之间的距离   用栈考虑比较牛逼了
        // https://leetcode-cn.com/problems/daily-temperatures/solution/java-by-sdwwld/
//        int[] arr = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(dailyTemperatures(arr)));

        // 循环数组中比当前元素大的下一个元素
        // https://leetcode-cn.com/problems/next-greater-element-ii/solution/xia-yi-ge-geng-da-yuan-su-ii-by-leetcode/
        int[] arr = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(nextGreaterElements(arr)));

    }

    /**
     * 使用单调栈
     *
     * @param nums
     *
     * @return
     */
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] next = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> pre = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!pre.isEmpty() && nums[pre.peek()] < num) {
                next[pre.pop()] = num;
            }
            if (i < n) {
                pre.push(i);
            }
        }
        return next;
    }

    /**
     * @param temperatures
     *
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] dist = new int[n];
        Stack<Integer> indexs = new Stack<>();
        for (int curIndex = 0; curIndex < n; curIndex++) {
            while (!indexs.isEmpty() && temperatures[curIndex] > temperatures[indexs.peek()]) {
                int preIndex = indexs.pop();
                dist[preIndex] = curIndex - preIndex;
            }
            indexs.add(curIndex);
        }
        return dist;
    }

    /**
     * 用栈实现字符串中括号的匹配
     * 必须有一个限定是必须全都是 ()[]{} 这六种字符的其中一种
     *
     * @param s
     *
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char cStack = stack.pop();
                boolean b1 = c == ')' && cStack != '(';
                boolean b2 = c == ']' && cStack != '[';
                boolean b3 = c == '}' && cStack != '{';
                if (b1 || b2 || b3) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 最小值栈的实现
     * 可以用这个来获取最小值
     * 空间复杂度是 O(N) 时间复杂度是O(1)
     * 只能获取到最小值
     */
    public class MinStack {
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;
        private int min;

        public MinStack() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            dataStack.add(x);
            min = Math.min(min, x);
            minStack.add(min);
        }

        public void pop() {
            dataStack.pop();
            minStack.pop();
            min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    /**
     * 用栈实现队列
     */
    public class MyStack {

        private Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.add(x);
            int cnt = queue.size();
            while (cnt-- > 1) {
                queue.add(queue.poll());
            }
        }

        public int pop() {
            return queue.remove();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }

    }

    /**
     * 用栈实现队列
     * offer peek poll
     */
    public class MyQueue {
        private Stack<Integer> in = new Stack<>();
        private Stack<Integer> out = new Stack<>();

        public Boolean offer(Integer ele) {
            Integer push = in.push(ele);
            return true;
        }

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            in2out();
            return out.pop();
        }

        public int peek() {
            in2out();
            return out.peek();
        }

        private void in2out() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
        }


    }
}
