class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int longest = 0;
        Set<Character> seenChars = new HashSet<>();
        for(int r = 0; r < s.length(); r++){
            String currString = s.substring(l,r);
            
            while(seenChars.contains(s.charAt(r))){
                    seenChars.remove(s.charAt(l));
                    l++;
            }
                seenChars.add(s.charAt(r));
                longest = Math.max(r-l+1,longest);
            
        }
        return longest;

    }
}