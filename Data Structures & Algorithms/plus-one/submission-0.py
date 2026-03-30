class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        num = 0
        for i in digits:
            num= num*10 + i
        num+=1;
        new_list = []
        while num > 0:
            new_list.insert(0,num%10)
            num //= 10
        return new_list
        