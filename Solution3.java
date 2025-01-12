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