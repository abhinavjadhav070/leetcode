class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int low = 0 , maxlen = 0;
        Map<Character , Integer> Map = new HashMap<>();
        for(int high = 0; high<n; high++){
            char c =s.charAt(high);
            if(Map.containsKey(c)){
                low  = Math.max(low , Map.get(c)+1);
                }
            Map.put(c, high);
            maxlen = Math.max(maxlen , high - low + 1);    


        }
        
        return maxlen;
        
    }
}