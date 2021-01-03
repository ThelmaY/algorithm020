class Trie {

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] wordArray = word.toCharArray();
        TrieNode currentNode = root;
        for (int i = 0;i<wordArray.length;i++){
            if (!currentNode.containsKey(wordArray[i])){
                TrieNode newNode = new TrieNode();
                currentNode.set(newNode, wordArray[i]);
                currentNode = newNode;
            }else{
                currentNode = currentNode.get(wordArray[i]);
            }
            
        }
        currentNode.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] wordArray = word.toCharArray();
        TrieNode currentNode = root;

        for(int i = 0;i<wordArray.length;i++){
            if (!currentNode.containsKey(wordArray[i]))
                return false;
            else
                currentNode = currentNode.get(wordArray[i]);
        }
        if (currentNode.isEnd())
            return true;
        else
            return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] wordArray = prefix.toCharArray();
        TrieNode currentNode = root;

        for(int i = 0;i<wordArray.length;i++){
            if (!currentNode.containsKey(wordArray[i]))
                return false;
            else
                currentNode = currentNode.get(wordArray[i]);
        }
        return true;
    }
}

class TrieNode {
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode(){
        links = new TrieNode[R];
    }

    public TrieNode get(char ch){
        return links[ch-'a'];
    }

    public void set(TrieNode node, char ch){
        links[ch-'a'] = node;
    }

    public boolean containsKey(char ch){
        return links[ch-'a'] != null;
    }

    public boolean isEnd(){
        return isEnd;
    }

    public void setEnd(){
        isEnd = true;
    }
}
