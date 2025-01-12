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