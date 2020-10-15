package com.jiang.alg.controller;

import lombok.Data;

import java.io.Serializable;


@Data
class TreeNode implements Serializable {

    public TreeNode left;
    public TreeNode right;
    public int data;

    public TreeNode(int data) {
        this.data = data;
    }

}

/**
 * @author Jiang Zaiming
 * @date 2020/9/1 10:31 上午
 */
public class BinaryTreeAlg {

    public static Boolean balance = false;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        // 求数的最大深度
        System.out.println(maxDepth(root));

        // 判断是否是平衡树
        System.out.println(isPingHeng(root));

    }

    private static boolean isPingHeng(TreeNode root) {
        maxDepthPingHeng(root);
        return balance;
    }

    private static int maxDepthPingHeng(TreeNode root) {
        if (root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (Math.abs(l - r) > 1) balance = false;
        return 1 + Math.max(l, r);
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
