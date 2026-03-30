func isValid(s string) bool {
    word := []rune(s)
    stack := []rune{}
    M := map[rune]rune{'}':'{', ')': '(',']':'['}
    for _, char := range word {
        if char == '(' || char == '{' || char == '['{
            stack = append(stack, char)
        } else{
            if len(stack) == 0 || M[char] != stack[len(stack) - 1]{
                return false
            } else {
                stack = stack[:len(stack)-1]
            } 
        }
    }

    return len(stack) == 0


}
