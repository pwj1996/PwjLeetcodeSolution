/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        selfFindFrequentTreeSum(root);

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        //这个排序似乎很耗时
        Collections.sort(list,new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        
        List<Integer> resArray = new ArrayList<>();
        int index = 0, preValue = 0, iterValue = 0, iterKey = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            iterValue = entry.getValue();
            iterKey = entry.getKey();
            //System.out.println(iterKey);
            if (index == 0) {
                preValue = iterValue;
                resArray.add(iterKey);
                System.out.println(resArray.indexOf(0));
            } else {
                if (iterValue == preValue) {
                    resArray.add(iterKey);
                } else {
                    //System.out.println("break");
                    break;
                }
            }
            index++;
        }
        
        int[] res = new int[resArray.size()];
        for (int i = 0; i < res.length && i < resArray.size(); i++) {
            res[i] = resArray.get(i);
            System.out.println(resArray.indexOf(i));
        }
        return res;
    }

    TreeMap<Integer, Integer> map = new TreeMap<>();
    private int selfFindFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;

        res = root.val + selfFindFrequentTreeSum(root.left) + selfFindFrequentTreeSum(root.right);
        if (map.containsKey(res)) {
            //System.out.println("yes");
            map.put(res, map.get(res) + 1);
        } else {
            map.put(res, 1);
        }
        //System.out.println(res);
        return res;
    }
}
