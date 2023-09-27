class Solution {
    long ans = 0;
    List<Integer>[] graph;
    public long countPaths(int n, int[][] edges) {
        ans = 0L;
         graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] arr: edges) {
            graph[arr[0]].add(arr[1]);
            graph[arr[1]].add(arr[0]);
        }
        
        dfs(1, -1);
        return ans;
    }

    public long[] dfs(int cur, int parent)  {
       boolean p = isPrime(cur);
       long pc = 0;
       long npc = 0;

       for (int child: graph[cur]) {
           if (child == parent) {
               continue;
           }
           long[] next = dfs(child, cur);
           if (!p) {
               ans += pc * next[0];
               ans += npc * next[1];
           } else {
               ans += npc * next[0];
           }
           npc += next[0];
           pc += next[1];
       }
       long[] res = new long[2];
       if (p) {
           ans += npc;
           res[1] = npc + 1;
       } else {
           ans += pc;
           res[1] = pc;
           res[0] = npc + 1;
       }
       return res;
    }

    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}


// 1 2
// 1 3
// 1 4
// 2 4
// 
