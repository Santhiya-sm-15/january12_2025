class Solution {
    public void nextPermutation(int[] nums) {
        int ind=-1,i,n=nums.length;
        for(i=n-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                ind=i;
                break;
            }
        }
        if(ind==-1)
        {
            reverse(nums,0,n-1);
            return;
        }
        for(i=n-1;i>ind;i--)
        {
            if(nums[i]>nums[ind])
            {
                int t=nums[i];
                nums[i]=nums[ind];
                nums[ind]=t;
                break;
            }
        }
        reverse(nums,ind+1,n-1);
    }
    public void reverse(int[] nums,int l,int r)
    {
        while(l<r)
        {
            int t=nums[l];
            nums[l]=nums[r];
            nums[r]=t;
            l++;
            r--;
        }
    }
}