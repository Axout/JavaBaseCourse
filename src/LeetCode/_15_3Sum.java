package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.
Note:
The solution set must not contain duplicate triplets.

Example:
Given array nums = [-1, 0, 1, 2, -1, -4],
A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class _15_3Sum {
    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1,0,1,2,-1,4});
        for (List<Integer> l: lists) {
            System.out.println(l);
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            list.add(nums[i+1]);
            list.add(0);
            System.out.println("Iteration " + i);
            for (int j = i+2; j < nums.length; j++) {
                list.set(2, nums[j]);
                int sum = sum(list);
                System.out.println("sum = " + sum);
                if (sum == 0) {
                    int[] array = new int[list.size()];
                    for(int k = 0; k < list.size(); k++) array[k] = list.get(k);
                    lists.add(Arrays.asList(array[0],array[1],array[2]));
                }
            }
        }
        return lists;
    }
    public static int sum(List<Integer> list) {
        int sum = 0;
        for (Integer l : list)
            sum += l;
        return sum;
    }
}
