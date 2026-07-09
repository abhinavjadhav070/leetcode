/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* findDisappearedNumbers(int* nums, int numsSize, int* returnSize) {
    // 1. First pass: Mark the numbers we see as visited by making 
    // the value at their corresponding index negative.
    for (int i = 0; i < numsSize; i++) {
        // Use abs() because the value at the current index might have already been negated
        int val = abs(nums[i]); 
        int targetIndex = val - 1; // Map 1-indexed number to 0-indexed array position
        
        // If the number at the target index is positive, flip its sign
        if (nums[targetIndex] > 0) {
            nums[targetIndex] = -nums[targetIndex];
        }
    }
    
    // 2. Dynamically allocate memory for our result array
    // In the worst case, all numbers could be missing (though constraints usually prevent this)
    int* result = (int*)malloc(numsSize * sizeof(int));
    int count = 0;
    
    // 3. Second pass: Find indexes that are still positive
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] > 0) {
            // If the element at index i is still positive, the number (i + 1) was never seen
            result[count] = i + 1;
            count++;
        }
    }
    
    // 4. Set the return size pointer and return the dynamically allocated array
    *returnSize = count;
    return result;
}