package com.ke.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zxg_QAQ
 * @date 2021/4/3下午10:05
 */
public class TwoSumDemo {

    public static void main(String[] args) {
        int [] numbers01 = new int[]{2,7,11,15};
        int target = 9;
        int [] numbers02 = twoSum1(numbers01,target);
        for (int i=0;i<numbers02.length;i++) {
            System.out.println(numbers02[i]);
        }
        int [] numbers03 = twoSum2(numbers01,target);
        for (int i=0;i<numbers03.length;i++) {
            System.out.println(numbers03[i]);
        }
    }

    private static int[] twoSum1(int[] numbers,int target) {
        for (int i = 0;i < numbers.length;i++) {
            for (int j = i+1; j < numbers.length;j++) {
                if (target - numbers[i] == numbers[j]) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    private static int[] twoSum2(int[] numbers,int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<numbers.length;i++) {
            int partnerNumber = target - numbers[i];
            if (map.containsKey(partnerNumber)) {
                return new int[] {map.get(partnerNumber),i};
            }
            map.put(numbers[i],i);
        }
        return null;
    }
}
