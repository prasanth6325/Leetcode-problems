class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.isEmpty()) return false;

        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExp = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
                // sign must be at start or right after exponent
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == '.') {
                // dot cannot appear after exponent or appear twice
                if (seenDot || seenExp) return false;
                seenDot = true;
            } else if (c == 'e' || c == 'E') {
                // exponent must appear once and only after a digit
                if (seenExp || !seenDigit) return false;
                seenExp = true;
                seenDigit = false; // reset, must see digit after exponent
            } else {
                return false;
            }
        }
        return seenDigit;
    }
}
