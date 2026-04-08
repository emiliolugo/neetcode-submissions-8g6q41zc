class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        prefix = []
        postfix = []
        width = [0] * len(heights)
        #prefix
        for i in range(len(heights)):
            while prefix and heights[i] < heights[prefix[-1]]:
                prefix.pop()
            
            width[i] = prefix[-1] if prefix else -1
            prefix.append(i)
        

        for i in range(len(heights)-1,-1,-1):
            while postfix and heights[i] <= heights[postfix[-1]]:
                postfix.pop()
            tmp = postfix[-1] if postfix else len(heights)
            width[i] = tmp - 1 - width[i]
            postfix.append(i)
        
        ret = 0

        for i in range(len(heights)):
            print(heights[i],width[i])
            ret = max(ret,heights[i] * width[i])
        return ret
        

        
            
