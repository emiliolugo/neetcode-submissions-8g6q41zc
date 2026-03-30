class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        if (n == 1) return nums[0];

        // Using a lambda for the helper
        auto robHelper = [&](int start, int end) {
            int rob1 = 0;
            int rob2 = 0;
            for (int i = start; i < end; i++) {
                int temp = std::max(rob1 + nums[i], rob2);
                rob1 = rob2;
                rob2 = temp;
            }
            return rob2;
        };

        return std::max(robHelper(0, n - 1), robHelper(1, n));
    }
};