import java.util.*;

class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] result = new String[words.length];

        for (String word : words) {
            int index = word.charAt(word.length() - 1) - '0' - 1; // position
            result[index] = word.substring(0, word.length() - 1); // remove number
        }

        return String.join(" ", result);
    }
}
