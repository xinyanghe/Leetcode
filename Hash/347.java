class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums){
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];//bucket的index从1开始所以要多一位
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }
        for (int key : count.keySet()){
            bucket[count.get(key)].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0; i--) {
            res.addAll(bucket[i]);
            if(res.size() >= k) break;//无法解决频次相同，输出比k多的问题
        }
        return res;
    }
}
