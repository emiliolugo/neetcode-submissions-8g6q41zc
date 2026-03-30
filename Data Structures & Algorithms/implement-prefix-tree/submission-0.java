class PrefixTree {
    final PrefixTree[] CHILDREN;
    boolean wordEnd = false;
    public PrefixTree() {
         CHILDREN = new PrefixTree[26];
    }

    public void insert(String word) {
        insertHelp(word,0);
    }

    private void insertHelp(String word, int index) {
        if(index == word.length()){
            this.wordEnd = true;
            return;
        }
        else{
            int c = word.toLowerCase().charAt(index) - 'a';
            if(CHILDREN[c] == null){
                this.CHILDREN[c] = new PrefixTree();
            }
            this.CHILDREN[c].insertHelp(word,index+1);
        }
    }

    public boolean search(String word) {
        return searchHelp(word, 0);
    }

    private boolean searchHelp(String word, int index){
        if(index == word.length()){
            return wordEnd;
        }
        int c = word.toLowerCase().charAt(index) - 'a';
        if(this.CHILDREN[c] == null){
            return false;
        }
        return this.CHILDREN[c].searchHelp(word,index+1);

    }

    

    public boolean startsWith(String prefix) {
        return startHelp(prefix, 0);
    }

    private boolean startHelp(String word, int index){
        if(index == word.length()){
            return true;
        }
        int c = word.toLowerCase().charAt(index) - 'a';
        if(this.CHILDREN[c] == null){
            return false;
        }
        return this.CHILDREN[c].startHelp(word,index+1);

    }
}
