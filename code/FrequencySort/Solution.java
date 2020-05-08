class Solution {
    public String frequencySort(String s) {
        return selfFrequencySort(s);
    }

    private String selfFrequencySort(String s) {
        char[] sToA = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for(char c: sToA) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> heap = new PriorityQueue<>((c1, c2) -> map.get(c2) - map.get(c1));
        Set<Character> keyS = map.keySet();
        for (Character c: keyS) {
            heap.add(c);
        }

        StringBuilder builder = new StringBuilder();
        char iter = ' ';
        int count = 0;
        while(!heap.isEmpty()) {
            iter = heap.poll();
            count = map.get(iter);
            while(count-- > 0) {
                builder.append(iter);
            }
        }

        return builder.toString();
    }
}
