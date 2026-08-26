class Solution {
    public int maximumSum(int[] arr) {
        int bestending = arr[0];
        int bestwithdeletion = 0; 
        int ans = arr[0];

        for (int i = 1; i < arr.length; i++) {
       
            int v1 = bestending;
            int v2 = bestwithdeletion + arr[i];
            bestwithdeletion = Math.max(v1, v2);

            
            int v3 = arr[i];
            int v4 = arr[i] + bestending;
            bestending = Math.max(v3, v4);

            ans = Math.max(ans, Math.max(bestending, bestwithdeletion));
        }

        return ans;
    }
}