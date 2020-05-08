class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length() - 10 + 1; i++) {
            //System.out.println(i);
            String temp = s.substring(i, i + 10);
            if (map.containsKey(temp)) {
                if (map.get(temp) == 1) {
                    res.add(temp);
                    map.put(temp, 2);
                }                 
            } else {
                map.put(temp, 1);
            }
        }

        return res;
    }
}
