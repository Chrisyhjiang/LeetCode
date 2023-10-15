class Solution {
    public String sortVowels(String s) {
        ArrayList<Character> ls = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            Character c = s.charAt(i);
            if (isVowel(c)) {
                ls.add(c);
            }
        }
        Collections.sort(ls);
        int idx = 0;
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < n; i++) {
            if (isVowel(s.charAt(i))) {
                sb.append(ls.get(idx));
                idx++;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public boolean isVowel(Character c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || 
        c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}