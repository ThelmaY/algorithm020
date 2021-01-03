class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (int i = 0;i<words.length;i++){
            trie.insert(words[i]);
        }

        Set<String> res = new HashSet<String>();
        int count = 0;
        TrieNode root = trie.root;
        for (int i =0;i<board.length;i++){
            for (int j = 0;j<board[i].length;j++){
                if (root.containsKey(board[i][j])){
                    int[][] used = new int[board.length][board[0].length];
                    StringBuilder sb = new StringBuilder();
                    findWord(board, root, i, j, used, sb, res);
                    if (res.size() == words.length){
                        return new LinkedList<String>(res);
                    }
                }
            }
        }
        return new LinkedList<String>(res);
    }

    public void findWord(char[][] board,TrieNode node, int row, int col, int[][] used, StringBuilder sb, Set<String> res){
        if (row<0 || row>board.length-1 || col<0 || col> board[0].length-1 || used[row][col] == 1 || !node.containsKey(board[row][col])){
            return;
        }

    used[row][col] = 1;
    sb.append(board[row][col]);
    node = node.get(board[row][col]);
    if (node.isEnd()) {
        res.add(sb.toString());
    }
    findWord(board, node,row+1, col, used,sb,res);
    findWord(board, node,row-1, col, used,sb,res);
    findWord(board, node,row, col+1, used,sb,res);
    findWord(board, node,row, col-1, used,sb,res);

    used[row][col] = 0;
    sb.delete(sb.length()-1,sb.length());
    return;
}
}


class Trie {

    public TrieNode root;
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
    public boolean search(char[] wordArray) {
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
    public boolean startsWith(char[] wordArray) {
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