class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        prevMap = {} # sorted_string : array index
        i = 0
        anagrams = []
        for word in strs:
            sorted_word = "".join(sorted(word))
            if sorted_word in prevMap:
                anagrams[prevMap[sorted_word]].append(word)
            else:
                prevMap[sorted_word] = i
                i += 1
                anagrams.append([word])
        return anagrams
