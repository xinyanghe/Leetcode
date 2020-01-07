//HashSet O(logn) O(logn)
class Solution {
    private int getNext(int n) {
        int sum = 0;
        while(n != 0) {
            int d = n % 10;
            n = n / 10;
            sum += d * d;
        }
        return sum;
    }
    public boolean isHappy(int n){
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
        
}


//DoublePointer O(logn) O(1)
class Solution {
    private int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            int d = n % 10;
            n = n / 10;
            sum += d * d;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int fast = getNext(n);
        int slow = n;
        while(fast != 1 && fast != slow) {
            fast = getNext(getNext(fast));
            slow = getNext(slow);
        }
        return fast == 1;
    }
}
