class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> S = new Stack<>();
        for(String token: tokens){
            if(isOperator(token)){
                int first = S.pop();
                int second = S.pop();
                S.push(doOperation(first,second, token));
            }
            else{
                S.push(Integer.parseInt(token));
            }
        }
        return S.pop();
    }

    private static boolean isOperator(String s){
        return s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-");
    }

    private static int doOperation(int first, int second, String token){
        if(token.equals("*")){
            return second*first;
        }
        else if(token.equals("/")){
            return second/first;
        }
        else if(token.equals("+")){
            return second+first;
        }
        else{
            return second-first;
        }
    }
}
