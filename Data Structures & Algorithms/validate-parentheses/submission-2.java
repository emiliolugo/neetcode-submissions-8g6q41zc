class Solution {
    public boolean isValid(String s) {
        Stack<Character> S = new Stack<>();
        for(int i=0; i < s.length();i++){
            char c = s.charAt(i);
            if(c=='('||c=='{'||c=='['){
                S.push(c);
            }
            else{
                if(c == ')'){
                    if(S.isEmpty() || S.pop() != '('){return false;}
                }
                else if(c == '}'){
                    if(S.isEmpty() || S.pop() != '{'){return false;}
                }
                else if(c == ']'){
                    if(S.isEmpty() || S.pop() != '['){return false;}
                }
                else{
                    return false;
                }
            }
        }
        return S.isEmpty();
    }
}
