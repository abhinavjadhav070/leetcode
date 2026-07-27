class Solution {
    public int find(int[] a){
        int maxc = -1;
        for(int i = 0 ; i< 256 ; i++){
            maxc = Math.max(maxc , a[i]);
        }
        return maxc;
    }
    public int characterReplacement(String s, int k) {
        int low = 0;
        int n = s.length();
        int res = Integer.MIN_VALUE;
        int[] f = new int[256];

        for(int high = 0 ; high<n; high++){
            f[s.charAt(high)]++;

            int maxcnt = find(f);
            int len = high - low + 1;
            int diff = len - maxcnt;

            while(diff > k){
                f[s.charAt(low)]--;
                low++;
                maxcnt = find(f);
                len = high - low + 1;
                diff = maxcnt - len;
            }

            len = high - low + 1;
            res = Math.max(res , len);
        }

    return res;
        
    }
}