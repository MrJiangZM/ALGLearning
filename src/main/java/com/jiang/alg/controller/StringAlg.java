package com.jiang.alg.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiang Zaiming
 * @date 2020/8/21 4:31 下午
 */
public class StringAlg {

    public static void main(String[] args) {

// ==========================================================================================================
        // 字符串循环移位包含
//        String s1 = "AABCD";
//        String s2 = "DAAB";
//        System.out.println(strContain(s1, s2));

// ==========================================================================================================
        // 字符串循环移位
//        String str = "abce123";
//        System.out.println(cycleShift(str));

// ==========================================================================================================
        // 字符串中单词的翻转
//        String str = "status in the sky     haha, what erver you do, you cannot push me";
//        System.out.println(str);
        // 双指针方法
//        System.out.println(reverseDoublePointer(str));
        // 翻转每个单词，然后翻转整体
//        System.out.println(reverseAll(str));

// ==========================================================================================================
        // 两个字符串包含的字符是否完全相同   使用hash的数据结构计算
        // 指的是字符种类和数量都一致
//        String s1 = "qwertrewqe12";
//        String s2 = "qwer1222trweqq111";
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(allContain(s1, s2));
        // 可以变型成包含字符种类
//        System.out.println(allContainCharType(s1, s2));

// ==========================================================================================================
        // 计算一组字符集合可以组成的回文字符串的最大长度
        // 字符出现偶数次数才能组成回文字符串
//        String str = "abccccdd";
//        System.out.println(str);
//        System.out.println(getMaxHuiWen(str));

// ==========================================================================================================
        // 字符串同构   就是说结构是一致的，通过替换字符可以直接获得另一个单词，比如出现的次数，位置，连接等，都一致
        // 思路：如果出现一次的字符没问题，出现多次的字符，如果这个字符上一个出现的位置两个字符串都相同，是没问题的
//        String s1 = "00foo";
//        String s2 = "oof00";
//        System.out.println(isTongGou(s1, s2));


// ==========================================================================================================
        // 回文子字符串个数   从回文字子符的长度，应该是从0 到 l
//        String str = "abaa";
        // 列举所有长度的子串
//        System.out.println(numHuiWen(str));
        // 列举所有长度的子串
//        System.out.println(numHuiWen(str));

// ==========================================================================================================
        // 判断整数是否是回文
//        Integer x = 98289;
//        System.out.println(isHuiWenInt(x));

// ==========================================================================================================
        // 统计二进制字符串中连续 1 和连续 0 数量相同的子字符串个数
        String str = "010101000010101001110011001010101";
        System.out.println(numOfSubs(str));


    }

    private static int numOfSubs(String str) {
        char[] chars = str.toCharArray();
        int[] numArr = new int[str.length()];
        int count = 0;
        char temp = ' ';
        for (char c : chars) {
            temp = c;

        }
        return 0;
    }

    private static boolean isHuiWenInt(Integer x) {
        if (x == 0) {
            return false;
        }
        int legt = x;
        int right = 0;
        while (x > 0) {
            right = right * 10 + x % 10;
            x = x / 10;
        }
        return legt == right;
    }

    private static int numHuiWen(String str) {
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length() - i; j++) {
                String s = str.substring(j, j + i + 1);
                if (isHuiWen(s)) {
                    num++;
                }
            }

        }
        return num;
    }

    private static boolean isHuiWen(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 两个字符串是否同构
     * 字符可以使用hash也可以使用数组，因为使用数据
     *
     * @param s1
     * @param s2
     *
     * @return
     */
    private static boolean isTongGou(String s1, String s2) {
        int[] preIndexOf1 = new int[256];
        int[] preIndexOf2 = new int[256];
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (preIndexOf1[c1] != preIndexOf2[c2]) {
                return false;
            }
            preIndexOf1[c1] = i + 1;
            preIndexOf2[c2] = i + 1;
        }
        return true;
    }

    private static int getMaxHuiWen(String str) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (Character c : str.toCharArray()) {
            Integer count = countMap.get(c);
            if (count == null || count < 1) {
                countMap.put(c, 1);
            } else {
                countMap.put(c, ++count);
            }
        }
        int l = 0;
        int single = 0;
        for (Character c : countMap.keySet()) {
            int num = countMap.get(c) / 2;
            int s = countMap.get(c) % 2;
            if (num > 0) {
                l += num;
            }
            if (s == 1) {
                single = 1;
            }
        }
        return 2 * l + single;
    }

    /**
     * 合理利用哈希表的数据结构，空间换时间
     *
     * @param s1
     * @param s2
     *
     * @return
     */
    private static boolean allContainCharType(String s1, String s2) {
        Map<Character, Integer> sumMap1 = new HashMap<>();
        Map<Character, Integer> sumMap2 = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            sumMap1.put(c, 1);
        }
        for (Character c : s2.toCharArray()) {
            sumMap2.put(c, 1);

        }
        for (Character key : sumMap1.keySet()) {
            Integer count = sumMap2.get(key);
            if (count == null) {
                sumMap2.put(key, -1);
            } else {
                sumMap2.put(key, 0);
            }
        }
        for (Integer count : sumMap2.values()) {
            if (count != 0) return false;
        }
        return true;
    }

    private static boolean allContain(String s1, String s2) {
        Map<Character, Integer> sumMap = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            Integer count = sumMap.get(c);
            if (count == null || count == 0) {
                sumMap.put(c, 1);
            } else {
                sumMap.put(c, count + 1);
            }
        }
        for (Character c : s2.toCharArray()) {
            Integer count = sumMap.get(c);
            if (count == null || count == 0) {
                sumMap.put(c, -1);
            } else {
                sumMap.put(c, count - 1);
            }
        }
        for (Integer v : sumMap.values()) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }

    private static String reverseAll(String str) {
        String[] strList = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strList.length; i++) {
            if (!"".equals(strList[i])) {
                sb.append(revserStr(strList[i]) + " ");
            }
        }
        return revserStr(sb.toString()).trim();
    }

    private static String revserStr(String str) {
        char[] chars = str.toCharArray();
        int l = chars.length;
        for (int i = 0; i < l / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[l - 1 - i];
            chars[l - 1 - i] = temp;
        }
        return new StringBuilder().append(chars).toString();
    }

    /**
     * 利用双指针法遍历字符串每个字符，然后记录并翻转等操作
     *
     * @param str
     *
     * @return
     */
    private static String reverseDoublePointer(String str) {
        str.trim();
        int j = str.length() - 1;
        int i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && str.charAt(i) != ' ') {
                i--; // 搜索首个空格
            }
            res.append(str.substring(i + 1, j + 1) + " "); // 添加单词
            while (i >= 0 && str.charAt(i) == ' ') {
                i--; // 跳过单词间空格
            }
            j = i; // j 指向下个单词的尾字符

        }
        return res.toString().trim();
    }

    /**
     * 字符串的循环移位
     * 类似于数组的循环移位
     * abce123 -> ecba321 -> 123abce
     *
     * @param str
     *
     * @return
     */
    private static String cycleShift(String str) {

        return "";
    }

    /**
     * 字符串循环移位包含
     *
     * @param s1
     * @param s2
     *
     * @return
     */
    private static boolean strContain(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        for (int i = 0; i < l1; i++) {
            int j = 0;
            for (; j < l2; j++) {
                if (s2.charAt(j) != s1.charAt((i + j) % l1)) {
                    break;
                }
            }
            if (j == l2) {
                return true;
            }
        }
        return false;
    }

}
