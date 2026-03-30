class Solution {
    public boolean isHappy(int n) {
       return isHappyHelper(n, Set.of()); 
    }

    public boolean isHappyHelper(int n, Set<Integer> seen){
        if(n==1){
            return true;
        }
        else{
            int newN = 0;
            while(n!=0){
                int lastD = n%10;
                newN+= lastD*lastD;
                n/=10;
            }
            Set<Integer> tmp = new HashSet<>(seen);
            int currSize = tmp.size();
            tmp.add(newN);
            if(currSize==tmp.size()){
                return false;
            }
            else{
                return isHappyHelper(newN, tmp);
            }
        }
    }
}
