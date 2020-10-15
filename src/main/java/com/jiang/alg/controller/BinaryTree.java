package com.jiang.alg.controller;

import java.util.*;

public class BinaryTree {

    private static int maxT = 0;
    private static String res = "";

    public static void main(String[] args) {

//        最大子串和问题
//        https://blog.csdn.net/qq_36186690/article/details/80990479
//        maxSubArrSum();
//        maxHuiWen("sgquqepohvljeqbuergthqewjbvwerghqfalsdfhbqv");
//        System.out.println(maxHuiWen2("sgquqepohvljeqbuergthqewjbvwerghqfalsdfhbqv"));

//        int[] nums1 = {14, 2, 4, 2, 8, 32, 4, 12, 3, 21, 5, 23, 5, 1, 34, 135, 23, 4, 63, 23, 4, 62, 3, 45, 23, 4, 12, 34, 54, 5, 24, 63, 65, 4, 62, 34, 52, 6, 23, 48, 46, 2};
        int[] nums = {4, 1, 6, 0, 9};
//        moveLeft(nums1, 10);

//        addSum(999);

//        getSub(nums1, 4);
//        getSubByMap(nums1, 4);

//        int[] arr = {1, 2, 3, 4};
//        getMulti(arr);

//        System.out.println(isContinuous(nums));
//        getMaxMinus();

//        getRainSum1();
//        getRainSum2();
//        getRainSum3();
//        getRainSum4();
//        getRainSum5();

        // 递归深度最大值
//        testDiGui(1);

        // ================================================================================================
        // 初始化二叉树
        BinaryTreeNode a = new BinaryTreeNode(1);
        BinaryTreeNode b = new BinaryTreeNode(2);
        BinaryTreeNode c = new BinaryTreeNode(3);
        BinaryTreeNode d = new BinaryTreeNode(4);
        BinaryTreeNode e = new BinaryTreeNode(5);
        BinaryTreeNode f = new BinaryTreeNode(6);
        BinaryTreeNode g = new BinaryTreeNode(7);
        a.left = b;
        a.right = c;
        b.right = d;
        c.left = e;
        c.right = f;
        f.left = g;
        // 前序遍历  递归
        left1(a);
        // 前序遍历  非递归
        left2(a);
        // 中序遍历  递归
        center1(a);
        // 中序遍历  非递归
        center2(a);
        // 前序遍历  递归
        // 后序遍历  递归
        right1(a);
        // 后序遍历  非递归
//        right2(a);

        // 层序遍历  非递归
        level(a);


        // 求二叉树最大深度
        System.out.println(maxDepth(a));

        // 求二叉树最小深度
        System.out.println(minDepth(a));

        // 求二叉树节点数
        System.out.println(nodeCount(a));

        // 求二叉树叶子节点数
        System.out.println(leafNodeCount(a));

        // 求k层二叉树叶子节点数
        System.out.println(kLevelCount(a, 1));
        System.out.println(kLevelCount(a, 2));
        System.out.println(kLevelCount(a, 3));
        System.out.println(kLevelCount(a, 4));

        // 求k层二叉树叶子节点数
        System.out.println(kLevelCount(a, 1));

        // 是否是平衡二叉树
        System.out.println(isBalancedTree(a));

        // 是否是完全二叉树
        System.out.println(isCompleteTree(a));
        System.out.println("=============================");

        // 两个树是否完全相等
        System.out.println(isSameTree(a, a));
        System.out.println("=============================");

        // 是否镜像
        System.out.println(isMirror(a, a));
        System.out.println("=============================");

        // 翻转或镜像二叉树
        BinaryTreeNode binaryTreeNode = mirrorTree(a);
        System.out.println("=============================");
    }

    /**
     * 二叉树最大深度
     *
     * @param root
     *
     * @return
     */
    private static int maxDepth(BinaryTreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.getLeft());
        int right = maxDepth(root.getRight());
        return Math.max(left, right) + 1;
    }

    private static int minDepth(BinaryTreeNode root) {
        if (root == null) return 0;
        if (root.getLeft() == null && root.getRight() == null) return 1;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left == null || root.right == null) return Math.max(left, right) + 1;
        return Math.min(left, right) + 1;
    }

    /**
     * 3.求二叉树中节点的个数
     */
    public static int nodeCount(BinaryTreeNode root) {
        if (root == null) return 0;
        int left = nodeCount(root.left);
        int right = nodeCount(root.right);
        return left + right + 1;
    }

    /**
     * 求二叉树中叶子节点的个数
     */
    public static int leafNodeCount(BinaryTreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = leafNodeCount(root.left);
        int right = leafNodeCount(root.right);
        return left + right;
    }

    /**
     * 求二叉树中叶子节点的个数
     */
    public static int kLevelCount(BinaryTreeNode root, int k) {
        if (root == null || k < 1) return 0;
        if (k == 1) return 1;  //K=1的那一层总是我们想找的那一层
        int left = kLevelCount(root.left, k - 1);
        int right = kLevelCount(root.right, k - 1);
        return left + right;      //或者可以用层次遍历的方法
    }

    /**
     * 是否是平衡二叉树
     *
     * @param root
     *
     * @return
     */
    public static boolean isBalancedTree(BinaryTreeNode root) {
        if (root == null) return false;
        return isBalancedhelper(root) != -1;
    }

    public static int isBalancedhelper(BinaryTreeNode root) {
        if (root == null) return 0;
        int left = isBalancedhelper(root.left);
        int right = isBalancedhelper(root.right);
        if (Math.abs(left - right) > 1) return -1;   //返回-1说明不平衡
        return Math.max(left, right) + 1;
    }

    /**
     * 是否是完全二叉树
     *
     * @param root
     *
     * @return
     */
    public static boolean isCompleteTree(BinaryTreeNode root) {
        if (root == null) return false;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean res = true;
        boolean hasNoChild = false;
        while (!queue.isEmpty()) {
            BinaryTreeNode tmp = queue.remove();
            if (hasNoChild) {    //hasNoChild=true说明在tmp节点之前有无右孩子的节点，这时tmp只能为叶子节点
                if (tmp.left != null || tmp.right != null) return false;
            } else {
                if (tmp.left != null && tmp.right != null) {
                    queue.add(tmp.left);
                    queue.add(tmp.right);
                } else if (tmp.left != null && tmp.right == null) {
                    queue.add(tmp.left);
                    hasNoChild = true;
                } else if (tmp.left == null && tmp.right != null) return false;
                else hasNoChild = true;
            }
        }
        return res;
    }

    /**
     * 两个二叉树是否完全相等
     *
     * @param root1
     * @param root2
     *
     * @return
     */
    public static boolean isSameTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null) return root2 == null;
        if (root2 == null) return false;
        if (root1.data != root2.data) return false;
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }

    /**
     * 两个二叉树是否镜像
     *
     * @param root1
     * @param root2
     *
     * @return
     */
    private static boolean isMirror(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null) return root2 == null;   //如果是判断某棵树是不是镜像的，令root2=root1即可
        if (root2 == null) return false;
        if (root1.data != root2.data) return false;
        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }

    /**
     * 翻转或者镜像一个二叉树
     *
     * @param root
     *
     * @return
     */
    private static BinaryTreeNode mirrorTree(BinaryTreeNode root) {
        if (root == null) return root;
        BinaryTreeNode left = mirrorTree(root.left);   //先把左右子树都先翻转
        BinaryTreeNode right = mirrorTree(root.right);
        root.left = right;                  //再把左右孩子节点反转
        root.right = left;
        return root;
    }


    private static void testDiGui(int i) {
        System.out.println("num:" + i);
        i++;
        testDiGui(i);
    }

    private static String maxHuiWen2(String str) {
        if (str.length() == 1) {
            return str;
        }
        for (int i = 0; i < str.length() - 1; i++) {
            checkPalindromeExpand(str, i, i);
            checkPalindromeExpand(str, i, i + 1);
        }
        return res;
    }

    private static void checkPalindromeExpand(String s, int low, int high) {
        while (low >= 0 && high < s.length()) {
            if (s.charAt(low) == s.charAt(high)) {
                if (high - low + 1 > maxT) {
                    maxT = high - low + 1;
                    res = s.substring(low, high + 1);
                }
                low--;
                high++;
            } else {
                return;
            }
        }
    }

    /**
     * 使用hash表记录数据，单链表能够降低时间复杂度
     *
     * @param nums
     * @param target
     *
     * @return
     */
    public int[] getSumNum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
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
     *
     * @param nums
     * @param target
     *
     * @return
     */
    public int[] getSumNum2(int[] nums, int target) {
        int indexArrayMax = 2047; // 位数上诠释1
        int[] indexArrays = new int[indexArrayMax + 1];
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            diff = target - nums[i];
            if (indexArrays[diff & indexArrayMax] != 0) {
                return new int[]{indexArrays[diff & indexArrayMax] - 1, i};
            }
            indexArrays[nums[i] & indexArrayMax] = i + 1;
        }
        return null;
    }

    /**
     * 获取和最大子串
     */
    public static void maxSubArrSum() {
        int[] nums = {1, 2, -1, -3, 3, 7, -2, 4, -3};
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }


    public static void getMaxMinus() {
        int[] array = {2, 4, 1, 16, 7, 5, 11, 9};

        int diff;
        int last_max = array[0];
        int max_diff = array[0] - array[1];

        for (int i = 2; i < array.length; i++) {

            last_max = Math.max(last_max, array[i - 1]);

            diff = last_max - array[i];

            if (diff > max_diff) {
                max_diff = diff;
            }
        }
        System.out.println(max_diff);
    }

    /**
     * 最大回文串 暴力解法
     */
    public static void maxHuiWen(String str) {
        int length = 1;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 2; j < str.length(); j++) {
                String subStr = str.substring(i, j);
                int count = 0;//计数，用来判断是否对称
                for (int k = 0; k < subStr.length() / 2; k++) {
                    if (subStr.charAt(k) == subStr.charAt(subStr.length() - k - 1)) {
                        count++;
                    }
                }
                if (count == subStr.length() / 2) {
                    System.out.println(subStr);
                }
            }
        }
    }

    /**
     * 最大回文串
     */
    public static Boolean isHuiWen(String str) {
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.toCharArray()[i] != str.toCharArray()[length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 扑克牌顺子问题
     */
    public static Boolean isContinuous(int[] nums) {
        if (nums == null || nums.length < 5) {
            return false;
        }
        Arrays.sort(nums);
        int zeroNum = 0;
        int gtZeroNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                gtZeroNum = i;
                break;
            }
            if (nums[i] == 0) {
                zeroNum++;
            }
        }
        int gtZeroCount = nums.length - 1 - gtZeroNum;
        int max = nums[nums.length - 1] - nums[gtZeroNum];
        int num = max - nums.length;
        for (int i = zeroNum + 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return false;
            }
        }
        if (zeroNum == 0) {
            if (max == 4) {
                return true;
            } else {
                return false;
            }
        }
        if (num <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 子数组换位问题
     * 设a[0:n-1]是一个有n个元素的数组，k(0<=k<=n-1)是一个非负整数。 试设计一个算法将子数组a[0:k]与a[k+1,n-1]换位。
     * PS：要求算法在最坏情况下耗时O(n)，且只用到O(1)的辅助空间。
     * <p>
     * 需要利用分治法的思想   TODO    这个翻转和跑圈是一致的
     */
    public static void subNumChange1(int[] nums, int k) {
        changeSub(nums, k, 0, nums.length - 1);
    }

    /**
     * TODO 跑圈
     *
     * @param nums
     * @param k
     */
    public static void subNumChange2(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int tempIndex = nums.length - k;
            int temp = nums[i];
            if (tempIndex < 0) {
                tempIndex += nums.length;
            }
            nums[i] = nums[tempIndex];
            nums[tempIndex] = temp;
        }
    }

    private static void changeSub(int[] nums, int k, int low, int high) {
        if (low < high) {
            if ((k - low + 1) == (high - k)) {
                swap(nums, low, k, k + 1, high);

            } else if ((k - low + 1) < (high - k)) {
                swap(nums, low, k, low + high - k, high);
                changeSub(nums, low, k, low + high - k - 1);

            } else {
                swap(nums, low, high + low - k - 1, k + 1, high);
                changeSub(nums, high + low - k, k, high);
            }
        }
    }

    private static void swap(int[] nums, int l1, int h1, int l2, int h2) {
        int temp;

        while (l1 <= h1) {

            temp = nums[l1];
            nums[l1] = nums[l2];
            nums[l2] = temp;

            l1++;
            l2++;
        }
    }

    /**
     * 数组循环左移右移问题
     * 先逆序前k个，再逆序后其他，再整体逆序
     */
    public static void moveLeft(int[] arr, int n) {
        int l = arr.length;
        n = n % l;
        reverse(arr, 0, n - 1);
        reverse(arr, n, l - 1);
        reverse(arr, 0, l - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int[] arr, int l, int n) {
        while (l < n) {
            int temp = arr[l];
            arr[l] = arr[n];
            arr[n] = temp;
            l++;
            n--;
        }
    }

    /**
     * 输入一个大于100的三位数，求出满足某些条件的和
     */
    public static void addSum(int num) {
        int sum = 0;
        if (num <= 100 || num >= 1000) {
            System.out.println("输入数据错误");
        } else {
            for (int i = 0; i <= num; i++) {
                int l1 = num / 100 % 10;    // 百位
                int l2 = num / 10 % 10;    // 十位
                int l3 = num % 10;          // 个位
                if (l1 != 3 && l2 != 5 && l3 != 7) {
                    sum += i;
                }
            }
        }
        System.out.println("sum = " + sum);
    }

    /**
     * 和为定制的两个数字
     * <p>
     * 普通的解法
     */
    public static void getSub(int[] arr, int sum) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] + arr[j]) == sum) {
                    System.out.println(arr[i] + " === " + arr[j]);
                }
            }
        }
    }

    /**
     * 和为定制的两个数字
     * <p>
     * 数组可以转map 等key value的形式，用于简化查找逻辑
     * <p>
     * 使用map的一些方式
     */
    public static void getSubByMap(int[] arr, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(sum - arr[i])) {
                System.out.println(map.get(sum - arr[i]) + "===" + i);
//                return;
            }
            map.put(arr[i], i);
        }
    }

    /*
    给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
    示例:
    输入: [1,2,3,4]
    输出: [24,12,8,6]
    提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
    说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
    进阶：
    你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/product-of-array-except-self
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    左右的乘机使用 然后利用结果的那个数据用来存储中间数组
     */
    public static void getMulti(int[] arr) {
        // 暴力解法 时间复杂度 O(n*n-1)   不可取
        int left = 1;
        int right = 1;
        int[] outputF = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
//            outputF[i] = left;
//            left = arr[i] * left;

            outputF[arr.length - 1 - i] = right;
            right = arr[arr.length - 1 - i] * right;
        }
        System.out.println(Arrays.toString(outputF));
//        System.out.println(Arrays.toString(outputR));
        for (int i = 0; i < arr.length; i++) {
            outputF[i] = left * outputF[i];
            left = arr[i] * left;
        }
        System.out.println(Arrays.toString(outputF));
    }

    /*
    获取到储水量的和
    // 按行求数量    这个比较好理解 不过会有点容易想不到
    获取最大储水量
     */
    public static int getRainSum1() {
        // 按行求数量
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        // 找出最大高度
        System.out.println(Arrays.toString(height));
        int max = getMax(height);
        System.out.println(max);
        int sum = 0;
        for (int i = 1; i <= max; i++) {
            boolean start = false;
            int temp_sum = 0;
            for (int j = 1; j < height.length; j++) {
                if (start && height[j] < i) {
                    temp_sum++;
                }
                if (height[j] >= i) {
                    sum = sum + temp_sum;
                    temp_sum = 0;
                    start = true;
                }
            }
        }
        System.out.println(sum);
        return sum;
    }

    /*
     获取到储水量的和
     // 按列求数量   找到当前列的左边最大值和右边最大值，进行操作
     获取最大储水量
    */
    public static int getRainSum2() {
        // 按列求水量
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int sum = 0;
        // 找到左面最高点  右面最高点   就可以求解数量了
        for (int j = 1; j < height.length; j++) {

        }
        return sum;
    }


    private static int getMax(int[] height) {
        int max = height[0];
        for (int i = 1; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }


    public static class BinaryTreeNode {
        private BinaryTreeNode left;
        private BinaryTreeNode right;
        private int data;

        public BinaryTreeNode() {
        }

        public BinaryTreeNode(int data) {
            super();
            this.data = data;
        }

        public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
            super();
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public BinaryTreeNode getLeft() {
            return left;
        }

        public void setLeft(BinaryTreeNode left) {
            this.left = left;
        }

        public BinaryTreeNode getRight() {
            return right;
        }

        public void setRight(BinaryTreeNode right) {
            this.right = right;
        }

    }

    /**
     * ================================================================================================
     * 二叉树的常见算法题，几种遍历方式
     * 前序遍历递归
     */
    public static void left1(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getData());
        left1(root.left);
        left1(root.right);
    }

    /**
     * ================================================================================================
     * 二叉树的常见算法题，几种遍历方式
     * 前序遍历非递归
     */
    public static void left2(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                System.out.println(root.getData());
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            root = root.getRight();
        }
        System.out.println(stack);
    }

    private static void center1(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        center1(root.left);
        System.out.println(root.getData());
        center1(root.right);
    }

    private static void center2(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            System.out.println(root.getData());
            root = root.getRight();
        }
        System.out.println(stack);
    }

    private static void right1(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        right1(root.left);
        right1(root.right);
        System.out.println(root.getData());
    }

    private static void level(BinaryTreeNode root) {
        BinaryTreeNode temp;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            System.out.print(temp.getData() + "\t");
            if (null != temp.getLeft()) {
                queue.offer(temp.getLeft());
            }
            if (null != temp.getRight()) {
                queue.offer(temp.getRight());
            }
        }
    }

}
