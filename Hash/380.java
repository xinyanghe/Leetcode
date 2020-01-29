class RandomizedSet {
    Map<Integer, Integer> dict;
    List<Integer> list;
    Random rand = new Random();
    
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        dict = new HashMap();
        list = new ArrayList();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (dict.containsKey(val))
            return false;
        dict.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (! dict.containsKey(val))
            return false;
        int last = list.get(list.size() - 1); //value
        int index = dict.get(val); //index
        list.set(index, last); //switch 
        dict.put(last, index); // 
        list.remove(list.size() - 1); //index
        dict.remove(val); //value
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));//给定一个参数n,nextInt(n)将返回一个大于等于0小于n的随机数
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
