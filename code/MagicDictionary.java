class MagicDictionary {

    private Map<Integer, ArrayList<String>> map;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        map = new HashMap<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word: dict) {
            //map.computeIfAbsent(word.length(), x -> new ArrayList()).add(word);
            //如下getOrDefault不可行
            //map.put(word.length(), map.getOrDefault(word.length(), new ArrayList()).add(word));
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if (!map.containsKey(word.length())) {
            return false;
        }

        int matchSize = 0;
        for (String target: map.get(word.length())) {
            matchSize = 0;
            for (int i = 0; i < target.length(); i++) {
                if (word.charAt(i) != target.charAt(i)) {
                    matchSize++;
                }
                if (matchSize > 1) {
                    break;
                }
            }
            if (matchSize == 1) {
                return true;
            }
        }

        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
