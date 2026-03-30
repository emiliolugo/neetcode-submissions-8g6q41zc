class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        root.insert(word.toLowerCase(),0);
    }

    public boolean search(String word) {
        return root.search(word.toLowerCase(),0);
    }

    class Node{
        Node[] children;
        boolean isEnd;
        Node(){
            children = new Node[26];
        }

        public void insert(String word, int index){
            if(index == word.length()){
                isEnd = true;
                return;
            }
            int c = word.charAt(index) - 'a';
            if(children[c] == null){
                children[c] = new Node();
            }
            children[c].insert(word,index+1);
        }

        public boolean search(String word, int index){
            if(index == word.length()){
                return isEnd;
            }
            if(word.charAt(index)=='.'){
                for(Node n: children){
                    if(n!=null && n.search(word,index+1)){
                        return true;
                    }
                }
                return false;
            }
            int c = word.charAt(index) - 'a';
            if(children[c]==null){
                return false;
            }
            return children[c].search(word,index+1);

        }


    }
}
