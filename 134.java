class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0, sumCost = 0, start = 0, tank = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
            // If car starts at A and can not reach B. 
            // Any station between A and B can not reach B.
            // (B is the first station that A can not reach.)
            tank += gas[i] - cost[i];
            if (tank < 0){
                start = i + 1;
                tank = 0;
            }
        }
        // If the total number of gas is bigger than the total number of cost. There must be a solution.
        if (sumGas < sumCost)
            return -1;
        return start;
    }
}
