class RandomizedSet {

    private ArrayList<Integer> dArray;
    private HashMap<Integer, Integer> arrayIndex;
    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        dArray = new ArrayList<>();
        arrayIndex = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (dArray.contains(val)) {
            return false;
        }
        dArray.add(val);
        arrayIndex.put(val, dArray.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (arrayIndex.containsKey(val)) {
            //和最后一个元素交换
            int tempIndex = arrayIndex.get(val);

            //交换数组内容
            int temp = dArray.get(tempIndex);
            dArray.set(tempIndex, dArray.get(dArray.size() - 1));
            dArray.set(dArray.size() - 1, temp);
            
            //更改map索引
            arrayIndex.put(dArray.get(tempIndex), tempIndex);

            arrayIndex.remove(dArray.get(dArray.size() - 1));
            dArray.remove(dArray.size() - 1);
            return true;
        }

        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return dArray.get(rand.nextInt(dArray.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
