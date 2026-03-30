func twoSum(numbers []int, target int) []int {
    ret := make([]int,2)

    l := 0
    r := len(numbers)-1

    for l < r {
        if numbers[r] + numbers[l] == target{
            ret[0] = l + 1
            ret[1] = r + 1
            return ret
        } else if numbers[r] + numbers[l] > target{
            r--
        } else{
            l++
        }
    }

    return ret
}
