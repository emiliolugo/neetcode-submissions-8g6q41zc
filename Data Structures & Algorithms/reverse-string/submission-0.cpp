class Solution {
public:
    void reverseString(vector<char>& s) {
        int mid = s.size() / 2;
        int n = s.size();
        for(int i = 0; i < mid; i++){
            char tmp = s[i];
            s[i] = s[n-1-i];
            s[n-1-i] = tmp;
        }
    }
};