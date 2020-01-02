package study.Algorithm;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
// 两数之和
//        int nums [] = new int[]{3,2,4,10,20};
//        int target = 24;
//        System.out.println(Arrays.toString(twoSum2(nums, target)));

//      两数相加
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(7);
        ListNode l3 = addTwoNumbers(l1, l2);

        System.out.print(l3);

    }

    public static int[] twoSum(int[] nums, int target) { // 解法一 暴力
        int index[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int k = 0; k < nums.length; k++) {
                if (nums[i] + nums[k] == target && i != k) {
                    index = new int[]{i, k};
                    return index;
                }
            }
        }
        return index;
    }

    public static int[] twoSum2(int[] nums, int target) { // 解法2 hashMap
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                int index[] = new int[]{hashMap.get(target - nums[i]), i};
                return index;
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) { // 因为是基于l1来做加法的，所以如果l1没有了，就把l2剩余的加在l1的后面
            return l2;
        }
        if (l2 == null) {//如果 l2 为空了 l1的末尾大于10就必须做个进位使l2不为空放个0，才可以执行判断体下面的函数
            if (l1.val >= 10) {
                l2 = new ListNode(0);
                l2.next = null;
            } else {
                return l1;
            }
        }
        int x = l1.val + l2.val;
        l1.val = x % 10;
        if (x >= 10) {
            if (l1.next == null) {
                l1.next = new ListNode(1);

            } else {
                l1.next.val++;
            }
        }
        l1.next = addTwoNumbers(l1.next, l2.next); //重要部分 递归 用于重新连接携带着新的值的l1节点
        return l1;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        String str = String.valueOf(val);
        ListNode temp = next;
        while (temp != null) {
            str += "->" + String.valueOf(temp.val);
            temp = temp.next;
        }
        return str;
    }
}

