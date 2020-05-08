class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        return prefixTreeReplaceWords(dict, sentence);
    }
    private String selfReplaceWords(List<String> dict, String sentence) {
        Set<String> rootSet = new HashSet<>();
        for (String iter: dict) {
            rootSet.add(iter);
        }

        StringBuilder res = new StringBuilder();
        String[] sentences = sentence.split(" ");
        for (String word: sentences) {
            String prefix = "";
            for (int i = 0; i <= word.length(); i++) {
                prefix = word.substring(0, i);
                if (rootSet.contains(prefix)) {
                    break;
                }
            }
            
            if (res.length() > 0) {
                res.append(" ");
            }
            res.append(prefix);
        }

        return res.toString();
    }
    
    //前缀树
    private String prefixTreeReplaceWords(List<String> roots, String sentence) {
        TrieNode trie = new TrieNode();
        for (String root: roots) {
            TrieNode cur = trie;
            for (char letter: root.toCharArray()) {
                if (cur.children[letter - 'a'] == null)
                    cur.children[letter - 'a'] = new TrieNode();
                cur = cur.children[letter - 'a'];
            }
            cur.word = root;
        }

        StringBuilder ans = new StringBuilder();

        for (String word: sentence.split("\\s+")) {
            if (ans.length() > 0)
                ans.append(" ");

            TrieNode cur = trie;
            for (char letter: word.toCharArray()) {
                if (cur.children[letter - 'a'] == null || cur.word != null)
                    break;
                cur = cur.children[letter - 'a'];
            }
            ans.append(cur.word != null ? cur.word : word);
        }
        return ans.toString();
    }
}

class TrieNode {
    TrieNode[] children;
    String word;
    TrieNode() {
        children = new TrieNode[26];
    }
}
