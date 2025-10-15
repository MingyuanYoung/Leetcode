package grind169;

public class LC14_LongestCommonPrefix {
    public class TrieNode {
        TrieNode[] children;
        int count;

        public TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        TrieNode root = new TrieNode();
        for (String str : strs) {
            if (str.length() == 0)
                return "";
            insert(root, str);
        }
        String first = strs[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < first.length(); i++) {
            int index = first.charAt(i) - 'a';
            if (root.children[index] != null && root.children[index].count == strs.length) {
                sb.append(first.charAt(i));
                root = root.children[index];
            } else {
                return sb.toString();
            }
        }
        return sb.toString();
    }

    private void insert(TrieNode root, String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            if (root.children[index] == null) {
                root.children[index] = new TrieNode();
            }
            root = root.children[index];
            root.count++;
        }
    }

    public static void main(String[] args) {
        LC14_LongestCommonPrefix test = new LC14_LongestCommonPrefix();
        String[] strs = new String[] { "flower", "flow", "flight" };
        String res = test.longestCommonPrefix(strs);
        System.out.println(res);
    }
}