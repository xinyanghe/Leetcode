class Solution {
    public int minMeetingRooms(int[][] ints) {
        if (ints == null || ints.length == 0)
            return 0;
        Arrays.sort(ints, (a, b) -> a[0]- b[0]);
        PriorityQueue<Integer> allocator = new PriorityQueue<Integer>();
        allocator.add(ints[0][1]);
        for (int i = 1; i < ints.length; i++) {
            if (ints[i][0] >= allocator.peek())
                allocator.poll();
            allocator.add(ints[i][1]);
        }
        return allocator.size();
    }
}

/*
1.add(e)

2.element()、peek()

element()和peek()的语义完全相同，都是获取但不删除队首元素，也就是队列中权值最小的那个元素，二者唯一的区别是当方法失败时前者抛出异常，后者返回null。
根据小顶堆的性质，堆顶那个元素就是全局最小的那个；由于堆用数组表示，根据下标关系，0下标处的那个元素既是堆顶元素。所以直接返回数组0下标处的那个元素即可。

3.remove()、poll()

remove()和poll()方法的语义也完全相同，都是获取并删除队首元素，区别是当方法失败时前者抛出异常，后者返回null。
由于删除操作会改变队列的结构，为维护小顶堆的性质，需要进行必要的调整。


*/
