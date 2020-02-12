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
