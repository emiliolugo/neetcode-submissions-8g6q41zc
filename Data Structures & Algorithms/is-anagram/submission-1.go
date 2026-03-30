func isAnagram(s string, t string) bool {
    first := make(map[rune]int)

    for _, char := range s{
        first[char]+=1
    }

    for _, char:= range t{
        first[char]-=1
    }

    for _, count:= range first{
        if(count != 0){
            return false
        }
    }

    return true

}
