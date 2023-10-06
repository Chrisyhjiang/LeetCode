class Solution {
    public String minimumString(String a, String b, String c) {
        // brute force question try all possibilities 
        // since string length only 300. 
        Comparator<String> comp = (x, y) -> x.length() == y.length() ? x.compareTo(y) : x.length() - y.length();
        PriorityQueue<String> pq = new PriorityQueue<>(comp);
        pq.add(combine(combine(a, b), c));
        pq.add(combine(combine(a, c), b));
        pq.add(combine(combine(b, a), c));
        pq.add(combine(combine(b, c), a));
        pq.add(combine(combine(c, a), b));
        pq.add(combine(combine(c, b), a));
        return pq.poll();
    }

    public String combine(String s, String t) {
        if (s.indexOf(t) >= 0) {
            return s;
        }
        for (int i = t.length(); i > 0; i--) {
            if (s.endsWith(t.substring(0, i))) {
                return s + t.substring(i);
            }
        }
        return s + t;
    }
}