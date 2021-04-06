package com.ke.algorithm;

/**
 * @author zxg_QAQ
 * @date 2021/4/3下午10:05
 */
public class TwoSumDemo {

    public static void main(String[] args) {
        int [] numbers01 = new int[]{2,7,11,15};
        int target = 22;
        int [] numbers02 = twoSum1(numbers01,target);
        for (int i=0;i<numbers02.length;i++) {
            System.out.println(numbers02[i]);
        }
    }

    public static int[] twoSum1(int[] nums,int target) {
        for (int i = 0;i < nums.length;i++) {
            for (int j = i+1; j < nums.length;j++) {
                if (target - nums[i] == nums[j]) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
