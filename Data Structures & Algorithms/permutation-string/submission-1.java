class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        if(s1.length() == 0){
            return true;}
        int windowSize = s1.length();
        String s2Sub = s2.substring(0,windowSize);
        Map<Character, Integer> SUB = new HashMap<>();
        Map<Character, Integer> POS = new HashMap<>();
        for (int i = 0; i < s1.length();i++) {
            char s1c = s1.charAt(i);
            char s2c = s2Sub.charAt(i);
            if(SUB.containsKey(s1c)){SUB.put(s1c,SUB.get(s1c)+1);}
            else{SUB.put(s1c,1);}
            if(POS.containsKey(s2c)){POS.put(s2c,POS.get(s2c)+1);}
            else{POS.put(s2c,1);}
        }

        if (POS.equals(SUB)) {
                return true;
            }
            
        for (int i = windowSize; i < s2.length(); i++) {
            char remove = s2.charAt(i - windowSize);
            char add = s2.charAt(i);

            POS.put(remove, POS.get(remove) - 1);
            if (POS.get(remove) == 0) {
                POS.remove(remove);
            }
            POS.put(add, POS.getOrDefault(add, 0) + 1);

            if (POS.equals(SUB)) {
                return true;
            }
        }

        return false;
        
    }
}
