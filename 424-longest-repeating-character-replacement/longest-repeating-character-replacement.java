class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int low = 0, maxCount = 0, maxLength = 0;

        for (int high = 0; high < s.length(); high++) {
            // Update frequency of current character
            count[s.charAt(high) - 'A']++;
            
            // Track maximum frequency in the current window
            maxCount = Math.max(maxCount, count[s.charAt(high) - 'A']);

            // Shrink window if replacements needed exceed k
            while ((high - low + 1) - maxCount > k) {
                count[s.charAt(low) - 'A']--;
                low++;
            }

            maxLength = Math.max(maxLength, high - low + 1);
        }

        return maxLength;
    }
}