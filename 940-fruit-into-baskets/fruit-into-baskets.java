import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int left = 0;
        int maxFruits = 0;

        for (int right = 0; right < fruits.length; right++) {
            // Add current fruit to the map
            countMap.put(fruits[right], countMap.getOrDefault(fruits[right], 0) + 1);

            // If we have more than 2 types of fruits, shrink the window from left
            while (countMap.size() > 2) {
                int leftFruit = fruits[left];
                countMap.put(leftFruit, countMap.get(leftFruit) - 1);
                
                if (countMap.get(leftFruit) == 0) {
                    countMap.remove(leftFruit);
                }
                left++;
            }

            // Record maximum fruits collected in a valid window
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}