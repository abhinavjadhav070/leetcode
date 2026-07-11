/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* smallerNumbersThanCurrent(int* nums, int numsSize, int* returnSize) {
    // 1. Initialize a frequency array for numbers from 0 to 100
    int count[101] = {0};
    for (int i = 0; i < numsSize; i++) {
        count[nums[i]]++;
    }
    
    // 2. Transform count array to store the number of elements smaller than the current index
    // running_sum tracks how many elements we've seen so far
    int running_sum = 0;
    for (int i = 0; i <= 100; i++) {
        int temp = count[i];
        count[i] = running_sum;
        running_sum += temp;
    }
    
    // 3. Allocate memory for the result array
    int* result = (int*)malloc(numsSize * sizeof(int));
    if (result == NULL) {
        *returnSize = 0;
        return NULL;
    }
    
    // 4. Build the final output array using our precomputed counts
    for (int i = 0; i < numsSize; i++) {
        result[i] = count[nums[i]];
    }
    
    *returnSize = numsSize;
    return result;
}