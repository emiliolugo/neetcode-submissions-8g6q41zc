class Solution:
    def reverse(self, x: int) -> int:
        ret = 0
        multiplier =  1 if x > 0 else -1
        x = abs(x);

        while x!=0:
            ret*=10
            ret+= x%10
            x = x//10
        return ret * multiplier if -2**31 <= ret < 2**31 else 0
