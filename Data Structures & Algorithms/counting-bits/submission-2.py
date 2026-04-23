class Solution:
    def countBits(self, n: int) -> List[int]:
        bit_map = {}
        bit_map[0] = 0
        bit_map[1] = 1
        bit_map[2] = 1
        bit_map[3] = 2
        
        ret = []
        for i in range(n+1):
            sm = 0
            for j in range(16):
                sm += bit_map[(i >> 2 * j) & 0x3]
            
            ret.append(sm)
        return ret
            
        