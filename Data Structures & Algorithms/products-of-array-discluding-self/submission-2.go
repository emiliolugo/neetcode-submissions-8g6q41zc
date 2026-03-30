func productExceptSelf(nums []int) []int {
    n := len(nums)

    res := make([]int, n)
    pre := make([]int,n)
    post := make([]int, n)

    pre[0], post[n-1] = 1,1

    for i := 1; i < n; i++{
        pre[i] = nums[i-1] * pre[i-1]
    }

    for i:= n -2; i >= 0; i--{
        post[i]= nums[i+1] * post[i+1]
    }

    for i:= 0; i < n; i++{
        res[i] = post[i] * pre[i]
    }

    return res
}
