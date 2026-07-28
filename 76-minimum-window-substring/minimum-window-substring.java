class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency map for characters in t (covers ASCII uppercase/lowercase)
        int[] tCount = new int[128];
        for (char c : t.toCharArray()) {
            tCount[c]++;
        }

        // Frequency map for current sliding window
        int[] windowCount = new int[128];

        int required = 0; // Number of unique characters in t that need to be satisfied
        for (int count : tCount) {
            if (count > 0) {
                required++;
            }
        }

        int formed = 0; // Unique characters in current window satisfying t's count requirement
        int left = 0, right = 0;

        // Track the best window bounds: {windowLength, startIdx, endIdx}
        int[] ans = {-1, 0, 0};

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCount[c]++;

            // If the current character's count matches its required count in t
            if (tCount[c] > 0 && windowCount[c] == tCount[c]) {
                formed++;
            }

            // Try to shrink the window from the left once all required characters are present
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Update the minimum window if the current one is smaller
                int currentLen = right - left + 1;
                if (ans[0] == -1 || currentLen < ans[0]) {
                    ans[0] = currentLen;
                    ans[1] = left;
                    ans[2] = right;
                }

                // Remove character at left pointer from window
                windowCount[c]--;
                if (tCount[c] > 0 && windowCount[c] < tCount[c]) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}