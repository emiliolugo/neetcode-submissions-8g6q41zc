class Solution {
    public double myPow(double x, int n) {
        int absN = n > 0 ? n : n*-1; 
        double total = 1;
        while(absN!=0){
            total*=x;
            absN-=1;
        }  
        return n>0 ? total: (1/total); 
    }
}
