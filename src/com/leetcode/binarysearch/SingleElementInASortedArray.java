package com.leetcode.binarysearch;

public class SingleElementInASortedArray {

    public static void main(String[] args) {

        int[] nums = {1,1,2,3,3,4,4,8,8};
        int[] nums1 = {3,3,7,7,10,11,11};

        System.out.println(singleNonDuplicate(nums));
        System.out.println(singleNonDuplicate(nums1));
    }

    public static int singleNonDuplicate(int[] nums) {
        /*
        *   1. Take left and right pointers .
                left points to start of list. right points to end of the list.
            2. find mid.
                if mid is even, then it's duplicate should be in next index.
                or if mid is odd, then it's duplicate  should be in previous index.
                check these two conditions,
                if any of the conditions is satisfied,
                then pattern is not missed,
                so check in next half of the array. i.e, left = mid + 1
                if condition is not satisfied, then the pattern is missed.
                so, single number must be before mid.
                so, update end to mid.
            3. At last return the nums[left]
        * */
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = (left + right)/2;
            // 满足这个条件，不在前半段
            if( (mid % 2 == 0 && nums[mid] == nums[mid +1]) || (mid %2 == 1 && nums[mid] == nums[mid - 1]) )
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }
}
