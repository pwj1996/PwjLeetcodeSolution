class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        return selfFindDuplicate(paths);
    }

    private List<List<String>> selfFindDuplicate(String[] paths) {
        
        Map<String, List<String>> map = new HashMap<>();

        for (String path: paths) {
            String[] value = path.split(" ");
            //根据内容建立内容--路径的哈希映射表
            for (int i = 1; i < value.length; i++) {
                String[] keyContent = value[i].split("\\(");
                keyContent[1] = keyContent[1].replace(")", "");
                //value -- path 的哈希表
                List<String> tempList = map.getOrDefault(keyContent[1], new ArrayList<>());
                tempList.add(value[0] + "/" + keyContent[0]);
                map.put(keyContent[1], tempList);        
            }
        }

        List<List<String>> res = new LinkedList<>();
        for(String key: map.keySet()) {
            List<String> iter = map.get(key);
            if (iter.size() > 1) {
                res.add(iter);
            }
        }

        return res;
    }
}
