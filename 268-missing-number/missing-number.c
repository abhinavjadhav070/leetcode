int missingNumber(int* nums, int numsSize) {
    // Gauss' Formula for sum of first n numbers: n * (n + 1) / 2
    int expectedSum = numsSize * (numsSize + 1) / 2;
    int actualSum = 0;
    
    // Calculate the sum of elements present in the array
    for (int i = 0; i < numsSize; i++) {
        actualSum += nums[i];
    }
    
    // The difference is the missing number
    return expectedSum - actualSum;
}