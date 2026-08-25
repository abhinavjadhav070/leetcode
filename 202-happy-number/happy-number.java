class Solution {
    int fun(int n){
        int sum = 0;
        while(n > 0){
        int d = n%10;
         n = n/10;
        sum +=d*d;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow = n;
        int fast = fun(n);
        while(fast!=1 && slow!=fast){
            slow = fun(slow);
            fast = fun(fun(fast));
            }
        if(slow == fast && slow!=1){
            return false;
        }
        return fast == 1;
        }
}