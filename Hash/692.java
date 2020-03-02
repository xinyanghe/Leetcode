class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String w : words) {
            count.put(w, count.getOrDefault(w, 0) + 1);
        }
        List<String> candidates = new ArrayList(count.keySet());
        //Lambda表达式
        Collections.sort(candidates,(w1, w2) -> count.get(w1).equals(count.get(w2)) ? w1.compareTo(w2) : count.get(w2) - count.get(w1));
        return candidates.subList(0, k);
    }
}


class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        List<String>[] bucket = new List[words.length + 1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }
        
        for (String key : map.keySet()) {
            bucket[map.get(key)].add(key);
        }
        
        List<String> res = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0; i--) {
            Collections.sort(bucket[i], (b1, b2) -> b1.compareTo(b2));
            res.addAll(bucket[i]);
            if (res.size() > k) {
                for (int j = res.size() - 1; j >= k; j --) {
                    res.remove(j);
                }
            }
            if (res.size() == k) break;
        }
        return res;
    }
}
