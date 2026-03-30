class Solution {
    public int reverse(int x) {
        int ret = 0;
        while(x != 0){
            int prevRet = ret;
            ret *= 10;
            int digit = x%10;
            ret += digit;
            x/=10;
            if((ret - digit) / 10 != prevRet) return 0;
        }
        return ret;
    }
}
