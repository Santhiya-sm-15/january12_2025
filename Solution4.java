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