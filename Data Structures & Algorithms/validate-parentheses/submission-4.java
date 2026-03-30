class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        Stack<Character> S = new Stack<>();

        for(char c: s.toCharArray()){
            if(c == '(' || c == '[' || c=='{'){
                S.push(c);
            }
            else{
                if(S.isEmpty()) return false;
                if(S.peek() == '(' && c != ')') return false;
                if(S.peek() == '[' && c != ']') return false;
                if(S.peek() == '{' && c != '}') return false;
                S.pop();
            }
        }

        return S.isEmpty();
    }
}
