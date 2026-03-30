class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        carry = 0
        digits[-1] +=1
        for i in range(len(digits)-1, -1, -1):
            curr = (digits[i] + carry) % 10
            carry = (digits[i] + carry) // 10
            digits[i] = curr
        if carry > 0:
            digits.insert(0,carry)
        return digits
        