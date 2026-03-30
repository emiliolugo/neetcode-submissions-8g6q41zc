class Solution {
    public boolean isPalindrome(String s) {
        return isPalindromeHelper(s.toLowerCase(),0,s.length()-1);
    }

    private static boolean isPalindromeHelper(String s, int l, int r){
        if(l>=r){
            return true;
        }
        if(isValid(s.charAt(l))&& isValid(s.charAt(r))){
            return s.charAt(l)==s.charAt(r) && isPalindromeHelper(s, l+1, r-1);
        }
        if(!isValid(s.charAt(l))){
            l++;
        }
        if(!isValid(s.charAt(r))){
            r--;
        }
        return isPalindromeHelper(s,l,r);
        
    }

    private static boolean isValid(char c){
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
