func maxArea(heights []int) int {
    l := 0
    r := len(heights) - 1
    maxArea := 0
    for l < r {
        currArea := (r-l) * min(heights[r],heights[l])
        maxArea = max(currArea,maxArea)

        if heights[l] < heights[r] {
            l++
        } else {
            r--
        }
    }
    return maxArea
}

func max(x int, y int) int{
    if x > y {
        return x
    } else{
        return y
    }
}

func min(x int, y int) int{
    if x < y{
        return x
    } else {
        return y
    }
}
