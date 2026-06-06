class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        String[] st = {"abc","def", "ghi", "jkl", "mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        backtrack(digits, st, 0, new StringBuilder(), res);
        return res;
    }

    private void backtrack(String digits, String[] st, int index, StringBuilder path, List<String> res) {
        if (index == digits.length()) {
            res.add(path.toString());
            return;
        }
        String letters = st[digits.charAt(index) - '2'];
        for (char c : letters.toCharArray()) {
            path.append(c);
            backtrack(digits, st, index + 1, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}