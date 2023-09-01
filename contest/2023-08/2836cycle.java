// https://leetcode.com/problems/maximize-value-of-function-in-a-ball-passing-game/
class Solution {
    public long getMaxFunctionValue(List<Integer> receiver, long k) {
        int n = receiver.size();
        HashMap<Integer, Long[]> cycles = new HashMap<>();
        HashMap<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int startCycle = findCycle(visited, receiver, i, 0);
            Long[] arr = new Long[2];
            int depth = visited.get(startCycle);
            arr[0] = (long)(depth);
            long score = 0;
            while(depth > 0) {
                score += startCycle;
                startCycle = receiver.get(startCycle);
                depth--;
            }
            arr[1] = score;
            cycles.put(startCycle, arr);
            visited.clear();
        }
        long res = 0;
        for(int i = 0; i < n; i++) {
            long curScore = getScore(cycles, receiver, i, k, i);
            res = Math.max(res, curScore);
        }
        return res;

    }

    public int findCycle(HashMap<Integer, Integer> visited, List<Integer> receiver, int cur, int depth) {
        if (visited.containsKey(cur)) {
            visited.put(cur, depth - visited.get(cur));
            return cur;
        }
        visited.put(cur, depth);
        return findCycle(visited, receiver, receiver.get(cur), depth + 1);
    }

    public long getScore(HashMap<Integer, Long[]> cycles, List<Integer> receiver, int cur, long steps, long curScore) {
        if (cycles.containsKey(cur)) { 
            curScore += processScore(steps, cycles.get(cur), cur, receiver);
            return curScore;
        } else {
            curScore += cur;
            return getScore(cycles, receiver, receiver.get(cur), steps - 1, curScore);
        }
    }

    public long processScore(long steps, Long[] arr, int cur, List<Integer> receiver) {
        long res = (steps / arr[0]) * arr[1];
        long remainder = steps % arr[0];
        while (remainder > 0) {
            res += receiver.get(cur);
            cur = receiver.get(cur);
            remainder--;
        }
        return res;
    }
}

