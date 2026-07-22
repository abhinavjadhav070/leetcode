class Solution {
    public List<List<Integer>> threeSum(int[] n) {
        Arrays.sort(n);
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        for(i = 0;i<n.length-2;i++){
            if(n[i] > 0)break;
        if(i > 0 && n[i] == n[i-1]){
            continue;
        }
         int j = i+1;
        int k = n.length - 1;
         int sum = -1 * n[i];
    while(j < k){
        int s = n[j] + n[k];

        if(s == sum){
            res.add(Arrays.asList(n[i],n[j],n[k]));
            j++;
            k--;
        
        while(j<k && n[j] == n[j-1])
            j++;
        
        while(j < k && n[k] == n[k+1])
            k--;
        
         }else if(sum > s){
            j++;
        }else{
            k--;
        }

    }   

    }
    return res;
}
}