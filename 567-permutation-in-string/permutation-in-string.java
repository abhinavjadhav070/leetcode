class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        if (n1 > n2) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Fill initial frequency map for s1 and the first window of s2
        for (int i = 0; i < n1; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        // Slide the window of size n1 across s2
        for (int i = 0; i < n2 - n1; i++) {
            if (matches(count1, count2)) {
                return true;
            }
            // Remove the character going out of the window
            count2[s2.charAt(i) - 'a']--;
            // Add the character coming into the window
            count2[s2.charAt(i + n1) - 'a']++;
        }

        // Check for the last window
        return matches(count1, count2);
    }

    private boolean matches(int[] count1, int[] count2) {
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }
}