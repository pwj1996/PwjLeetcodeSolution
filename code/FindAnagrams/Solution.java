class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        return windoesFindAnagrams(s, p);
    }

    //滑动窗口
    private List<Integer> windoesFindAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();

        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        char[] sa = s.toCharArray();
        char[] pa = p.toCharArray();

        for (char c: pa) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        System.out.println(sa.length + " " + pa.length);

        int left = 0, right = 0, match = 0;
        while(right < sa.length) {
            if (needs.containsKey(sa[right])) {
                windows.put(sa[right], windows.getOrDefault(sa[right], 0) + 1);
                if (windows.get(sa[right]).equals(needs.get(sa[right]))) {
                    match++;
                }
            }
            right++;
            
            while(match == needs.size()) {
                if (right - left == pa.length) {
                    res.add(left);
                }
                if (needs.containsKey(sa[left])) {
                    windows.put(sa[left], windows.get(sa[left]) - 1);
                    if (windows.get(sa[left]) < needs.get(sa[left])) {
                        match--;
                    }
                }
                left++;
            }
        }

        return res;
    }


    //超时
    private List<Integer> selfFindAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> res = new LinkedList<>();

        char[] sa = s.toCharArray();
        char[] pa = p.toCharArray();
        for (int i = 0; i < sa.length - pa.length + 1; i++) {
            map.clear();
            for (int k = 0; k < pa.length; k++) {
                map.put(pa[k], map.getOrDefault(pa[k], 0) + 1);
            }
            for (int j = i; j < i + pa.length; j++) {
                if (map.containsKey(sa[j])) {
                    map.put(sa[j], map.get(sa[j]) -1);
                    if (map.get(sa[j]) == 0) {
                        map.remove(sa[j]);
                    }
                } else {
                    break;
                }
            }
            if (map.isEmpty()) {
                res.add(i);
            }
        }

        return res;
    }
}
