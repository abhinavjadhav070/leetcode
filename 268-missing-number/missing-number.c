int missingNumber(int* nums, int numsSize) {
   int exp=numsSize*(numsSize+1)/2;
   int act=0;
   for(int i=0;i<numsSize;i++){
    act+=nums[i];
   }
  return exp-act;
}