class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs.length == 0) return new ArrayList();
        
        Map<String, List> map = new HashMap<>();

        for (String s: strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if (!map.containsKey(key)) {
                map.put(key, new LinkedList());
                
            } 
            List temp = map.get(key);
            temp.add(s);
         }

        return new ArrayList(map.values());
    }
}
