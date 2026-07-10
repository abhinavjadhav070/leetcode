/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    // 1. Allocate memory for the 2 indices we need to return
    int* result = (int*)malloc(2 * sizeof(int));
    *returnSize = 2;

    // 2. Use nested loops to check all pairs
    for (int i = 0; i < numsSize; i++) {
        for (int j = i + 1; j < numsSize; j++) {
            if (nums[i] + nums[j] == target) {
                result[0] = i;
                result[1] = j;
                return result; // Return the allocated array
            }
        }
    }

    // Default return if no solution is found (though the problem guarantees one)
    *returnSize = 0;
    return NULL;
}