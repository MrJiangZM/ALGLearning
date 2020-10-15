package com.jiang.alg.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Jiang Zaiming
 * @date 2020/8/10 10:42 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
class ListNode {

    public ListNode next;
    public int data;

    public ListNode(int data) {
        this.data = data;
    }

}

@Data
class DoubleLinked {

    public DoubleLinked head;
    public DoubleLinked next;
    public Object data;

}

/**
 * 链表数据结构算法
 */
@Data
public class LinkedListAlg {

    public static ListNode arrayToListNode(int[] s) {
        ListNode root = new ListNode(s[0]);
        ListNode other = root;
        for (int i = 1; i < s.length; i++) {
            ListNode temp = new ListNode(s[i]);
            other.next = temp;
            other = temp;
        }
        return root;
    }

    public static int getNodeLenght(ListNode node) {
        int l = 0;
        if (node == null) {
            return l;
        }
        while (node != null) {
            l++;
            node = node.next;
        }
        return l;
    }


    private static ListNode getSomeNode(ListNode node, int distance) {
        int i = 0;
        while (i < distance) {
            node = node.next;
            i++;
        }
        return node;
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        System.out.println(getSameNode(null, null));
//        ListNode head = arrayToListNode(new int[]{0, 9, 1, 3, 2, 4});
//        print(head);
//        print(reverseListDiGui(head));
//        print(reverseListTouCha(head));

//        ListNode head1 = arrayToListNode(new int[]{0, 1, 3, 5, 5, 7});
//        ListNode head2 = arrayToListNode(new int[]{2, 4, 5, 7, 8});
//        print(head1);
//        print(head2);
//        print(mergeTwoListsDiGui(head1, head2));
//        print(mergeTwoListsChaRu1(head1, head2));

        // 删除重复复节点
//        ListNode head = arrayToListNode(new int[]{0, 0, 1, 3, 3, 3, 5, 5, 7, 7});
//        print(deleteDuplicates1(head));
//        print(deleteDuplicates2(head));

        // 删除最后的第n个节点
//        ListNode head = arrayToListNode(new int[]{0, 0, 1, 3, 3, 3, 5, 6, 7, 8});
//        print(head);
//        print(deleteNLastNode(head, 3));

        // 翻转相邻的节点
//        ListNode head = arrayToListNode(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
//        print(head);
//        print(reverseNode(head, 3));

        // 链表求和，从后面开始计算
//        ListNode head1 = arrayToListNode(new int[]{0, 1, 2, 10, 10, 10, 10, 10, 10, 10, 10});
//        ListNode head2 = arrayToListNode(new int[]{2, 1, 3, 1, 2, 4});
//        print(head1);
//        print(head2);
//        print(sumNode(head1, head2));

        // 回文链表
//        ListNode head = arrayToListNode(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
//        ListNode head = arrayToListNode(new int[]{0, 1, 2, 3, 3, 2, 1, 0});
//        print(head);
//        System.out.println(huiwenNode(head));

        // 分割链表
//        ListNode head = arrayToListNode(new int[]{0, 1, 2, 3, 3, 2, 1, 0, 3, 2, 5, 6, 2, 4, 6, 4, 2, 1, 5, 4, 6, 2, 2, 3, 4, 5, 2, 2, 1, 4, 4, 6, 3, 2, 2, 6, 2, 2, 6, 7, 3,});
//        print(head);
//        qiegeNode(head, 5);

        // 链表奇偶聚集
        ListNode head = arrayToListNode(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        print(head);
        System.out.println(jiouNode(head));
    }

    /**
     * 链表的奇偶聚集
     * 奇数偶数位置的聚集，不是所有的奇数聚集，和所有的偶数聚集
     *
     * @param head
     *
     * @return
     */
    private static ListNode jiouNode(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    /**
     * 分割单向链表，利用数组接收一下数据
     *
     * @param head
     * @param k
     */
    private static void qiegeNode(ListNode head, int k) {
        int n = 0;
        ListNode current = head;
        //确定链表共有多少个节点
        while (current != null) {
            n++;
            current = current.next;
        }
        /**
         * 分割之后链表的节点个数，前mod个链表的节点个数为size+1，之后的为size
         * 若N<k,则前面每个链表为一个元素，后面的为空
         */
        int mod = n % k;
        int size = n / k;
        ListNode[] result = new ListNode[k];
        current = head;
        //给ListNode[]数组的每个链表元素循环赋值
        for (int i = 0; current != null && i < k; i++) {
            result[i] = current;
            int currentSize = size;
            if (mod > 0) {
                currentSize = currentSize + 1;
                mod--;
            }
            for (int j = 0; j < currentSize - 1; j++) {
                current = current.next;
            }
            //ListNode[]数组里的每个链表元素结尾要指向null;
            ListNode next = current.next;
            current.next = null;
            current = next;
        }
        Arrays.asList(result).forEach(t -> print(t));
    }

    /**
     * 可以先转数组，然后双指针判断，时间复杂度O(n)  空间复杂度O(n)
     * <p>
     * 快慢指针的方法
     *
     * @param head
     *
     * @return
     */
    private static Boolean huiwenNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverseF = reverseListTouCha(slow);
        print(reverseF);
        print(head);
        while (reverseF != null) {
            if (head.data != reverseF.data) {
                return false;
            }
            head = head.next;
            reverseF = reverseF.next;
        }
        return true;
    }

    /**
     * 链表求和
     *
     * @param head1
     * @param head2
     *
     * @return
     */
    private static ListNode sumNode(ListNode head1, ListNode head2) {
        Stack<Integer> h1 = new Stack<>();
        while (head1 != null) {
            h1.push(head1.data);
            head1 = head1.next;
        }
        Stack<Integer> h2 = new Stack<>();
        while (head2 != null) {
            h2.push(head2.data);
            head2 = head2.next;
        }
        ListNode node = new ListNode(-1);
        while (!h1.isEmpty() || !h2.isEmpty()) {
            int x = h1.isEmpty() ? 0 : h1.pop();
            int y = h2.isEmpty() ? 0 : h2.pop();
            int sum = x + y;
            ListNode curr = new ListNode(sum);
            curr.next = node.next;
            node.next = curr;
        }
        return node.next;
    }

    /**
     * 翻转相邻节点
     * 搞出一个虚拟节点，往后遍历，每次翻转后往后走两步
     *
     * @param head
     * @param i
     *
     * @return
     */
    private static ListNode reverseNode(ListNode head, int i) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        while (pre.next != null && pre.next.next != null) {
            ListNode l1 = pre.next, l2 = pre.next.next;
            ListNode next = l2.next;
            l1.next = next;
            l2.next = l1;
            pre.next = l2;

            pre = l1;
        }
        return node.next;
    }

    /**
     * 删除倒数第n个节点
     * 双指针的节点，等步长往前挪动
     *
     * @param head
     * @param n
     *
     * @return
     */
    private static ListNode deleteNLastNode(ListNode head, int n) {
        ListNode fast = head;
        while (n > 0) {
            System.out.println(n);
            fast = fast.next;
            n--;
        }
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    /**
     * 直接法，类似于指针
     *
     * @param head
     *
     * @return
     */
    private static ListNode deleteDuplicates2(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    /**
     * 递归方式去掉单向链表的重复节点
     *
     * @param head
     *
     * @return
     */
    private static ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates1(head.next);
        return head.data == head.next.data ? head.next : head;
    }

    /**
     * 递归合并两个有序单向链表
     *
     * @param l1
     * @param l2
     *
     * @return
     */
    private static ListNode mergeTwoListsChaRu(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    /**
     * 递归合并两个有序单向链表
     *
     * @param l1
     * @param l2
     *
     * @return
     */
    private static ListNode mergeTwoListsChaRu1(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cur.next = l2;
                break;
            }
            if (l2 == null) {
                cur.next = l1;
                break;
            }
            if (l1.data < l2.data) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }


    /**
     * 递归合并两个有序单向链表
     *
     * @param l1
     * @param l2
     *
     * @return
     */
    private static ListNode mergeTwoListsDiGui(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.data < l2.data) {
            l1.next = mergeTwoListsDiGui(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsDiGui(l1, l2.next);
            return l2;
        }
    }

    /**
     * 获取两个单项链表的第一个公共节点
     */
    public static ListNode getSameNode(ListNode node1, ListNode node2) {
        node1 = new ListNode(0);
        ListNode s2 = new ListNode(9);
        ListNode s3 = new ListNode(1);
        ListNode s4 = new ListNode(2);
        ListNode s5 = new ListNode(4);
        node1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
        node2 = new ListNode(3);
        node2.next = s5;

        int l1 = getNodeLenght(node1);
        int l2 = getNodeLenght(node2);
        int distance = l1 - l2;
        ListNode nodeT = getSomeNode(node1, distance);
        System.out.println(nodeT.data);
        while (node2 != nodeT) {
            node2 = node2.next;
            nodeT = nodeT.next;
        }
        return nodeT;
    }

    /**
     * 递归方式翻转列表
     *
     * @param head
     *
     * @return
     */
    public static ListNode reverseListDiGui(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseListDiGui(next);
        next.next = head;
        return newHead;
    }

    /**
     * 头插法翻转链表
     * 翻转的思想，谨记，使用了一个中转节点
     *
     * @param head
     *
     * @return
     */
    public static ListNode reverseListTouCha(ListNode head) {
        ListNode newHead = null;
        ListNode node = null;
        while (head != null) {
            // 1 之前链表进行删除
            node = head;
            head = head.next;

            // 2 对新链表增
            node.next = newHead;
            newHead = node;

        }
        return newHead;
    }

}
