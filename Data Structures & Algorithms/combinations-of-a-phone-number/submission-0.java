class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        
        Map<Character, List<Character>> map = new HashMap<>();

        ArrayList<String> ls = new ArrayList<>();
        map.put('2', List.of('a','b','c'));
        map.put('3', List.of('d','e','f'));
        map.put('4', List.of('g','h','i'));
        map.put('5', List.of('j','k','l'));
        map.put('6', List.of('m','n','o'));
        map.put('7', List.of('p','q','r','s'));
        map.put('8', List.of('t','u','v'));
        map.put('9', List.of('w','x','y','z'));

        backtrack(ls, digits, map, new StringBuilder(), 0);

        return ls;

    }

    private void backtrack(ArrayList<String> ls, String digits, Map<Character, List<Character>> map, StringBuilder curr, int index){
        if(curr.length() == digits.length()){
            ls.add(curr.toString());
            return;
        }
        else{
            List<Character> currentList = map.get(digits.charAt(index));
            for(char c: currentList){
                curr.append(c);
                backtrack(ls,digits,map,curr, index+1);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }
}