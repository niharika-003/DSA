Problem: First Bad Version (LeetCode 278

We are given versions from 1 to n.
At some point a version becomes bad, and all versions after it are also bad.

Goal:
Find the first bad version.

Idea:
We use Binary Search because the versions follow a pattern:
Good → Good → Good → Bad → Bad → Bad

Steps:

1. Start searching between version 1 and n.
2. Find the middle version.
3. Check if the middle version is bad using isBadVersion(mid).

If mid is bad:

* This could be the first bad version.
* But there might be another bad version before it.
* So we store mid as a possible answer and search on the left side.

If mid is not bad:

* The first bad version must be after mid.
* So we search on the right side.

We keep doing this until the search space is finished.

Finally, we return the stored answer which is the first bad version.

 CODE:
  public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int st=1;
        int end=n;
        int ans=-1;

        while(st<=end){
            int mid=st+(end-st)/2;
            if(isBadVersion(mid)){
                ans=mid;
                end=mid-1;
            }else{
                st=mid+1;
            }
        }

        return ans;
    }
}

Time Complexity: O(log n)
Space Complexity: O(1)
