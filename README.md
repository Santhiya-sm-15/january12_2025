# january12_2025
The problems that I solved today

1.A parentheses string is a non-empty string consisting only of '(' and ')'. It is valid if any of the following conditions is true: It is ().It can be written as AB (A concatenated with B), where A and B are valid parentheses strings. It can be written as (A), where A is a valid parentheses string. You are given a parentheses string s and a string locked, both of length n. locked is a binary string consisting only of '0's and '1's. For each index i of locked, If locked[i] is '1', you cannot change s[i]. But if locked[i] is '0', you can change s[i] to either '(' or ')'. Return true if you can make s a valid parentheses string. Otherwise, return false.

Code:
class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2==1)
            return false;
        int x=0,y=0,i;
        for(i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(' || locked.charAt(i)=='0')
                x++;
            else
                y++;
            if(y>x)
                return false;
        }
        x=0;
        y=0;
        for(i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)==')' || locked.charAt(i)=='0')
                x++;
            else
                y++;
            if(y>x)
                return false;
        }
        return true;
    }
}

2.A permutation of an array of integers is an arrangement of its members into a sequence or linear order. For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1]. The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order). For example, the next permutation of arr = [1,2,3] is [1,3,2]. Similarly, the next permutation of arr = [2,3,1] is [3,1,2]. While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement. Given an array of integers nums, find the next permutation of nums.

Code:
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

3.You are given an array arr of positive integers. Your task is to find all the leaders in the array. An element is considered a leader if it is greater than or equal to all elements to its right. The rightmost element is always a leader.

Code:
class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        int max=Integer.MIN_VALUE;
        int i,n=arr.length;
        ArrayList<Integer> l=new ArrayList<>();
        for(i=n-1;i>=0;i--)
        {
            if(arr[i]>=max)
            {
                l.add(arr[i]);
            }
            max=Math.max(max,arr[i]);
        }
        Collections.reverse(l);
        return l;
    }
}

4.Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence. You must write an algorithm that runs in O(n) time.

Code:
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s=new HashSet<>();
        for(int x:nums)
            s.add(x);
        int max=0,i;
        for(int a:s)
        {
            if(!s.contains(a-1))
            {
                int cnt=1;
                int x=a;
                while(s.contains(x+1))
                {
                    x++;
                    cnt++;
                }
                max=Math.max(max,cnt);
            }
        }
        return max;
    }
}
