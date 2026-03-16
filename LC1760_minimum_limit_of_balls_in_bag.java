Problem: Minimum Limit of Balls in a Bag (LeetCode 1760)

We are given several bags of balls. The array nums represents the number of balls in each bag.

We are allowed to perform at most maxOperations operations.
In one operation, we can split a bag into two bags.

Goal:
Minimize the maximum number of balls in any bag after performing at most maxOperations splits.

Idea:
We use Binary Search on the possible maximum bag size.

Possible range:
Minimum possible size = 1
Maximum possible size = maximum value in nums

Steps:

1. Start Binary Search between 1 and the maximum number of balls in any bag.

2. Pick the middle value (mid).
   This mid represents the maximum number of balls allowed in a bag.

3. Check how many operations are required to make sure every bag
   has at most mid balls.

   For each bag:
   operations needed = (balls - 1) / mid

4. If total operations ≤ maxOperations:
   This size is possible, so we try a smaller size.

5. If total operations > maxOperations:
   This size is too small, so we increase the size.

We continue until we find the minimum possible maximum bag size.

Finally, return that value.

Time Complexity: O(n log m)
n = number of bags
m = maximum number of balls in a bag
CODE:
class Solution {
    boolean satisfies(int[] nums,int maxOperations,int val){
        long operations=0;

        for(int i=0;i<nums.length;i++){
            operations+=(nums[i]-1)/val;
        }

        return operations<=maxOperations;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int st=1;
        int end=nums[0];

        for(int i=0;i<nums.length;i++){
            end=Math.max(end,nums[i]);
        }

        int ans=0;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(satisfies(nums,maxOperations,mid)){
                ans=mid;
                end=mid-1;
            }else{
                st=mid+1;
            }
        }

        return ans;
    }
}

Space Complexity: O(1)
*/
