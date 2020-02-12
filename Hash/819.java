import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));//方法：数组转换arraylist
        Map<String, Integer> count = new HashMap<>();
        String[] words = paragraph.replaceAll("\\W+"," ").toLowerCase().split("\\s+");
        //可改为
        //String[] words = paragraph.toLowerCase().split("\\W+");
        //正则表达式：双引号，‘+’表示匹配多个，‘\’表示转义符，‘\w’表示匹配字符数字下划线，'\W'表示匹配除‘w’之外所有，‘\s’表示匹配空格
        for (String w : words) 
            if (!ban.contains(w))
                count.put(w, count.getOrDefault(w, 0) + 1);//方法：获取不到value就获取默认值
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
        //collections.max方法，按照第二个参数排序（可省略）获取第一个参数集合值，Map.Entry方法遍历所有键值对
    }
}
