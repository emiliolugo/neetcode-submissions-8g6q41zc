func twoSum(nums []int, target int) []int {
    seen := make(map[int]int)

    for index, val := range nums{
        other := target - val
        if value, exists := seen[other]; exists{
            return []int{value,index}
        }
        seen[val] = index;
    }

    return []int{};
}
