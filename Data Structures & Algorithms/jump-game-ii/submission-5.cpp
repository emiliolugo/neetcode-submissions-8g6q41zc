class Solution {
public:
    int jump(vector<int>& nums) {
        size_t sz = nums.size();
        if(sz < 2){
            return 0;
        }
        int l = 0;

        int jumps = 0;
        while(l < sz){
            if(l + nums[l] >= sz-1){
                return ++jumps;
            }
            int best_idx;
            int best_jump = -1;
            for(int i = l; i < nums[l] + l + 1; ++i){
                if(i + nums[i] > best_jump){
                    best_jump = i + nums[i];
                    best_idx = i;
                }
            }
            l = best_idx;
            ++jumps;

        }

        return jumps;
    }
};
